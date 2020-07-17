package controller;

import model.entity.Address;
import model.entity.Classes;
import model.entity.Name;
import model.entity.Student;
import model.logic.ClassLogic;
import model.logic.NewStudent;
import model.logic.StudentLogic;
import model.service.AddressService;
import model.service.ClassesService;
import model.service.NameService;
import model.service.StudentService;

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

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

            new ClassLogic().TransferAllClass();
            resp.sendRedirect(req.getContextPath() + "/main");

    }
}
