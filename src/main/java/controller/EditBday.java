package controller;

import model.entity.PersonalFile;
import model.entity.Student;
import model.service.PersonalFileService;
import model.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class EditBday extends HttpServlet {
    private Student student;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            student = new StudentService().get(
                    Integer.parseInt(req.getParameter("studentID"))).get();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        req.getRequestDispatcher("/editBday.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

       LocalDate Bday = LocalDate.parse(req.getParameter("Bday"));
       student.setBDay(Bday);
        try {
            new StudentService().update(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/viewDetails?StudentView=" +student.getId());

    }
}
