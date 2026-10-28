package sio.la2028.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sio.la2028.database.DaoEpreuveAthlete;
import sio.la2028.model.Athlete;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class ServletEpreuveAthlete extends HttpServlet {
    Connection cnx;

    @Override
    public void init()
    {
        ServletContext servletContext=getServletContext();
        cnx = (Connection)servletContext.getAttribute("connection");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idEpreuve = Integer.parseInt(request.getParameter("idEpreuve"));
        List<Athlete> lesAthletes = DaoEpreuveAthlete.getAthletesByEpreuveId(cnx, idEpreuve);

        request.setAttribute("pLesAthletes", lesAthletes);
        request.setAttribute("pIdEpreuve", idEpreuve);
        getServletContext().getRequestDispatcher("/vues/epreuveAthlete/listerEpreuveAthletes.jsp").forward(request, response);
    }
}
