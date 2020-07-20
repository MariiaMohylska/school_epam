package controller;

import jdk.vm.ci.meta.Local;
import model.exceptions.DataAlreadyInDB;
import model.exceptions.IncorrectData;
import model.logic.ClassLogic;
import model.logic.NewStudent;
import model.logic.StudentLogic;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class AddStudentServlet extends HttpServlet {

    private static String classNumber = null;

    private final  static String index = "/addstudent.jsp";

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        classNumber = req.getParameter("classToAdd");
        req.getRequestDispatcher(index).forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        NewStudent newStudent = new NewStudent();
        newStudent.setClassNumber(classNumber);
        newStudent.setSurname(req.getParameter("surname"));
        newStudent.setName(req.getParameter("name"));
        newStudent.setFatherName(req.getParameter("fatherName"));
        newStudent.setCity(req.getParameter("city"));
        newStudent.setStreet(req.getParameter("street"));
        newStudent.setHouse(req.getParameter("house"));
        newStudent.setFlat(req.getParameter("flat"));
        newStudent.setFileNumber(req.getParameter("personalFile"));
            newStudent.setEntryDate(LocalDate.parse(req.getParameter("entryDate")));
            newStudent.setBday(LocalDate.parse(req.getParameter("bDay")));

        newStudent.setPhoneNumber(req.getParameter("phone"));

        try {
            new StudentLogic().add(newStudent);
            resp.sendRedirect(req.getContextPath() + "/main");
        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().print(e.getMessage());
        } catch (NullPointerException e){
            e.printStackTrace();
            resp.getWriter().print(e.getMessage());
        } catch (DataAlreadyInDB e){
            resp.getWriter().print(e.getMessage());
        } catch (IncorrectData e){
            resp.getWriter().print(e.getMessage());
        }

    }

}
