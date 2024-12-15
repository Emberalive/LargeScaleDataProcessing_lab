package mvc;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.*;
import mvc.UserBean;
@WebServlet("/usrsrv")
public class UserServlet extends HttpServlet {
  @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
IOException {
// TODO Auto-generated method stub
String email=request.getParameter("email");
String password=request.getParameter("password");

UserBean usrbean = new UserBean();

usrbean.setEmail(email);
usrbean.setPassword(password);

request.setAttribute("mvcbean",usrbean);
RequestDispatcher rd=request.getRequestDispatcher("/mvc/valid_user.jsp");
rd.forward(request, response);
}
}
