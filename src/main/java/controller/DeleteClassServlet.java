package controller;

import model.entity.Classes;
import model.logic.ClassLogic;
import model.service.ClassesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteClassServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            new ClassLogic().deleteClass(Integer.parseInt(req.getParameter("classForDelete")));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect(req.getContextPath() + "/main");
    }

}
