package controller;

import model.logic.NewStudent;
import model.logic.StudentLogic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentInClassServlet extends HttpServlet {

    private final  static String index = "/students.jsp";

    private List<NewStudent> studentList;

    @Override
    public void init() throws ServletException {
        try {
            studentList = StudentLogic.getRepresentation();
            for (NewStudent n : studentList){
                System.out.println(n);
            }
        } catch (SQLException e) {
            System.out.println("Problem retrieving data from database");
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        final String classNumber = req.getParameter("class");
        List<NewStudent> newStudentList = new ArrayList<>();
        for(NewStudent student: studentList){
            if(student.getClassNumber().equals(classNumber)){
                newStudentList.add(student);
            }
        }

        req.setAttribute("students", newStudentList);
        req.getRequestDispatcher(index).forward(req, resp);
    }

}
