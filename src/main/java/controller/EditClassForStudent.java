package controller;

import model.entity.Classes;
import model.entity.PersonalFile;
import model.entity.Student;
import model.logic.StudentLogic;
import model.service.ClassesService;
import model.service.PersonalFileService;
import model.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class EditClassForStudent extends HttpServlet {
    private Student student;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            student = new StudentService().get(
                    Integer.parseInt(req.getParameter("studentId"))).get();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        req.getRequestDispatcher("/editClassForStudent.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String classNumber = req.getParameter("classNumber");
        try {
            StudentLogic.ChangeClass(student, classNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect(req.getContextPath() + "/viewDetails?StudentView=" + student.getId());
//        resp.sendRedirect(req.getContextPath() + "/viewDetails?StudentView=" + classes.getIdStudent());

    }
}
