package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String mood = request.getParameter("mood");
        String place = request.getParameter("place");

        String message = "Hi " + name + " from " + place + ", you are feeling " + mood;

        try (PrintWriter writer = response.getWriter()) {
            writer.println(message);
        } catch (IOException e) {
            throw new ServletException("Error writing response", e);
        }
    }
}
