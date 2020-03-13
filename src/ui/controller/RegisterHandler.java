package ui.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegisterHandler extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String firstName = request.getParameter("firstName");
        if (userid.isEmpty() || firstName.isEmpty()) {
            List<String> errors = new ArrayList<>();
            errors.add("Fill out all fields");
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("signUp.jsp").forward(request, response);
        } else {
            response.sendRedirect("Controller?command=Confirmation&firstName=" + firstName);
        }
    }
}
