package controller;

import model.logic.NewStudent;
import model.logic.RepresentationLogic;
import model.logic.StudentLogic;
import model.logic.StudentShort;

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

    private List<StudentShort> studentList;
    static String classNumber;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            studentList = new RepresentationLogic().getRepresentation();

        } catch (SQLException e) {
            System.out.println("Problem retrieving data from database");
            e.printStackTrace();
            resp.getWriter().print(e.getMessage());
        }

        classNumber = req.getParameter("class");
        final String clasId = req.getParameter("classId");
        List<StudentShort> studentShortList = new ArrayList<>();
        for(StudentShort student: studentList){
            if(student.getClassNumber().equals(classNumber)){
                studentShortList.add(student);
            }
        }
        req.setAttribute("classNumber", clasId);
        req.setAttribute("students", studentShortList);
        req.getRequestDispatcher(index).forward(req, resp);
    }

}