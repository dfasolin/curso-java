package app.datas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dfasolin
 */

@WebServlet("/dataHoje")
public class DataServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            Date data = new Date();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Data</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Data</h1>");
            out.println("<h3>Data de hoje: " + data + "</h3>");
            out.println("<br>");
            out.println("<a href=javascript:history.back()>Voltar</a>");
            out.println("</body>");
            out.println("</html>");
        }
        
    }
    
}
