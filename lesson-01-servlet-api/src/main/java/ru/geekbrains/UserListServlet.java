package ru.geekbrains;

import ru.geekbrains.persist.User;
import ru.geekbrains.persist.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/users")
public class UserListServlet extends HttpServlet {

    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        this.userRepository = (UserRepository) getServletContext().getAttribute("userRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().println("<title>Данные о пользователях</title>");

        resp.getWriter().println("<table>");

        resp.getWriter().println("<caption>Таблица: Данные о пользователях</caption>\n");
        resp.getWriter().println("<col width=\"150\">");
        resp.getWriter().println("<col width=\"150\">");

        resp.getWriter().println("<tr>");
        resp.getWriter().println("<th>UserId</th>");
        resp.getWriter().println("<th>UserName</th>");
        resp.getWriter().println("</tr>");

        for (User u: userRepository.findAll()) {
            resp.getWriter().println("<tr>");
            resp.getWriter().println("<td>" + u.getId() + "</td>");
            resp.getWriter().println("<td>" + "<a href='/servlet-app/user/" + u.getId() + "' target='_blank'>" + u.getUserName() +"</a></td>");
            resp.getWriter().println("</tr>");
        }

        resp.getWriter().println("</table>");

        System.out.println();
    }


}
