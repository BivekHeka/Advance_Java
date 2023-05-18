import javax.servlet.*;
import javax.servlet.*;
public class LoginServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServlet resp) throws ServletException,IOExcpetion{
        String username =request.getParameter("username");
        string password=request.getParameter("password");
        System.out.println(username);
        System.out.println(password);

        String dburl ="jdbc:mysql://localhost:8000/user_registratrion?useSSL=false";
        String dbusername="root";
        String dbpassword="root";
        response.setStatus(sc:200);
        PrintWriter writer =response.getWriter();
        writer.setContentType("text/html");

    }
}