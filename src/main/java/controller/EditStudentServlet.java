package controller;

import model.logic.NewStudent;
import model.logic.StudentLogic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class EditStudentServlet extends HttpServlet {
    private static String classNumber = null;

    private final  static String index = "/editstudent.jsp";

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        classNumber = req.getParameter("classToEdit");
        req.getRequestDispatcher(index).forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        NewStudent newStudent = new NewStudent();
        newStudent.setClassNumber(classNumber);
        newStudent.setId(Integer.parseInt(req.getParameter("id")));
        newStudent.setSurname(req.getParameter("surname"));
        newStudent.setName(req.getParameter("name"));
        newStudent.setFatherName(req.getParameter("fatherName"));
        newStudent.setCity(req.getParameter("city"));
        newStudent.setStreet(req.getParameter("street"));
        newStudent.setHouse(req.getParameter("house"));
        newStudent.setFlat(req.getParameter("flat"));
        newStudent.setFileNumber(req.getParameter("personalFile"));
        newStudent.setEntryDate(LocalDate.parse(req.getParameter("entryDate")));
        newStudent.setGradDate(LocalDate.parse(req.getParameter("gradDate")));
        newStudent.setBday(LocalDate.parse(req.getParameter("bDay")));

        newStudent.setPhoneNumber(req.getParameter("phone"));

        try {
            new StudentLogic().AddStudent(newStudent);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/main");

    }
}