<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sio.la2028.model.Athlete"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOS ANGELES 2028</title>
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
              crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h2>Athlètes de l'épreuve <%= request.getAttribute("pIdEpreuve") %></h2>
            <a href="../ServletEpreuve/lister">Retour aux épreuves</a>
            <%
                List<Athlete> lesAthletes = (List<Athlete>)request.getAttribute("pLesAthletes");
            %>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>nom</th>
                        <th>prenom</th>
                        <th>place</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Athlete a : lesAthletes)
                        {
                            out.println("<tr><td>" + a.getId() + "</td>");
                            out.println("<td>" + a.getNom() + "</td>");
                            out.println("<td>" + a.getPrenom() + "</td>");
                            out.println("<td>" + a.getLesEpreuveAthletes().get(0).getPlace() + "</td></tr>");
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
