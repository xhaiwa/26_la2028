package sio.la2028.database;

import sio.la2028.model.Athlete;
import sio.la2028.model.Epreuve;
import sio.la2028.model.EpreuveAthlete;
import sio.la2028.model.Pays;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoEpreuveAthlete {

    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;

    public static List<Athlete> getAthletesByEpreuveId(Connection cnx, int id) {
        List<Athlete> lesAthletes = new ArrayList<>();

        String sql = "SELECT a.*, ea.place " +
                "FROM athlete AS a " +
                "INNER JOIN epreuve_athlete AS ea ON a.id = ea.athlete_id " +
                "WHERE ea.epreuve_id = ? " +
                "ORDER BY ea.place, a.id";

        try (PreparedStatement requeteSql = cnx.prepareStatement(sql)) {
            requeteSql.setInt(1, id);

            try (ResultSet resultatRequete = requeteSql.executeQuery()) {
                Epreuve e = new Epreuve();
                e.setId(id);

                while (resultatRequete.next()) {
                    Pays p = new Pays(resultatRequete.getInt("pays_id"));

                    Athlete a = new Athlete();
                    a.setId(resultatRequete.getInt("id"));
                    a.setNom(resultatRequete.getString("nom"));
                    a.setPrenom(resultatRequete.getString("prenom"));
                    a.setPays(p);

                    Date dateSql = resultatRequete.getDate("date_naissance");
                    if (dateSql != null) {
                        a.setDataNaissance(dateSql.toLocalDate().atStartOfDay());
                    }

                    EpreuveAthlete ea = new EpreuveAthlete();
                    ea.setPlace(resultatRequete.getInt("place"));
                    e.addEpreuveAthlete(ea);
                    a.addEpreuveAthlete(ea);

                    lesAthletes.add(a);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requete de getAthletesByEpreuveId a genere une erreur");
        }

        return lesAthletes;
    }
}
