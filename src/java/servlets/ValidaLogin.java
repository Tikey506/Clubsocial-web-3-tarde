package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "ValidaLogin", urlPatterns = {"/valida_login.java"})
public class ValidaLogin extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        String userDb = "narutoninja123@gmail.com";
        String passDb = "naruto1234";
        
        if(user.equals(userDb) && pass.equals(passDb)){
            request.setAttribute("userLogged", user);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.print(
                      "<script>" 
                        +"alert('Acesso negado');"
                        +"window.location.replace('index.html');"
                        +"</script>"
            );
        }
        
         try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet validalogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet validalogin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
