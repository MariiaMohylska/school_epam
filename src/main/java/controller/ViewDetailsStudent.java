package controller;

import model.entity.*;
import model.exceptions.IncorrectData;
import model.logic.NewStudent;
import model.logic.NewStudentObject;
import model.logic.RepresentationLogic;
import model.service.AddressService;
import model.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ViewDetailsStudent extends HttpServlet {
    private final  static String index = "/detailstudent.jsp";
    private NewStudentObject newStudent;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int idStudent = Integer.parseInt(req.getParameter("StudentView"));
        try {
             newStudent = new RepresentationLogic().allDetailsStudent(idStudent);
            req.setAttribute("students", newStudent);
            req.getRequestDispatcher(index).forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().print(e.getMessage());
        } catch (IncorrectData e) {
            e.printStackTrace();
            resp.getWriter().print(e.getMessage());
        }


    }


}
