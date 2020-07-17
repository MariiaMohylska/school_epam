package controller;

import model.entity.Classes;
import model.logic.ClassLogic;
import model.service.ClassesService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AddClassServlet extends HttpServlet {
    private final static String index = "/addclass.jsp";


    @Override
    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher(index).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        final String classNumber = req.getParameter("classNumber");

        if (!classNumber.equals(null)) {
            try {
                new ClassLogic().newClassAdd(classNumber);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resp.sendRedirect(req.getContextPath() + "/main");
        }
    }
}
