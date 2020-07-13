package controller;

import model.entity.Classes;
import model.logic.ClassLogic;
import model.logic.NewStudent;
import model.logic.StudentLogic;
import model.service.ClassesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransferClass extends HttpServlet {

    private final  static String index = "/main.jsp";

    private List<Classes> classesList;

    @Override
    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ClassLogic.TransferAllClass();
        ClassesService classesService = new ClassesService();
        try {
            classesList = classesService.getAll();
        } catch (SQLException e) {
            System.out.println("Problem retrieving data from database");
            e.printStackTrace();
        }
        req.setAttribute("classes", classesList);
        req.getRequestDispatcher(index).forward(req, resp);
    }
}
