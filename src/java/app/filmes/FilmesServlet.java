package app.filmes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dfasolin
 */
@WebServlet("/filmes")
public class FilmesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Cinemateca cinema = new Cinemateca();
        List<Filme> resultado = cinema.getFilmes();
        
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lista de Filmes</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista de Filmes</h1>");
            
            out.println("<table border=1>");
            for(Filme f : resultado) {
                out.println("<tr>");
                out.println("<td>"+ f.getImdb() +"</td>");
                out.println("<td>"+ f.getTitulo() +"</td>");
                out.println("<td>"+ f.getDiretor() +"</td>");
                out.println("<td>"+ f.getAno() +"</td>");
                out.println("<td>"+ f.getDuracao() +"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            
            out.println("<br>");
            out.println("<a href=javascript:history.back()>Voltar</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
