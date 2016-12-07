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
@WebServlet("/criarTabela")
public class CriarTabelaServlet extends HttpServlet {

    @Resource(name = "filmes")
    private DataSource filmesDB;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            Connection con = filmesDB.getConnection();
            Statement stmt = con.createStatement();
            stmt.execute("DROP TABLE Filme");
            stmt.execute("CREATE TABLE Filme (id INTEGER PRIMARY KEY, "
                                           + "titulo VARCHAR(64), "
                                           + "diretor VARCHAR(64), "
                                           + "imdb VARCHAR(10), "
                                           + "duracao INTEGER, "
                                           + "ano INTEGER)");
            con.close();
            
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Criar Tabela</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Tabela Criada!!</h1>");
                out.println("<br>");
                out.println("<a href=javascript:history.back()>Voltar</a>");
                out.println("</body>");
                out.println("</html>");
            }
        }   catch (SQLException ex) {
            Logger.getLogger(CriarTabelaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
