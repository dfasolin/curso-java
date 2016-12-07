package config;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author dfasolin
 */
@WebServlet("/popularTabela")
public class PopularTabelaServlet extends HttpServlet {

    @Resource(name = "filmes")
    private DataSource filmesDB;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            Connection con = filmesDB.getConnection();
            Statement stmt = con.createStatement();
            
            stmt.executeUpdate("DELETE FROM Filme");
            stmt.executeUpdate("INSERT INTO Filme(id, titulo,diretor,imdb,duracao,ano)"
                                    + "VALUES (1, 'The Arrival', 'Jonh', 'tt2543164', 120, 2016)");
            stmt.executeUpdate("INSERT INTO Filme(id, titulo,diretor,imdb,duracao,ano)"
                                    + "VALUES (2, 'Rogue One: A Star Wars Story', 'Paul', 'tt3748528', 120, 2016)");
            con.close();
            
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Popular Tabela</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Dados Inseridos!</h1>");
                out.println("<br>");
                out.println("<a href=javascript:history.back()>Voltar</a>");
                out.println("</body>");
                out.println("</html>");
            }
        }   catch (SQLException ex) {
            Logger.getLogger(PopularTabelaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
