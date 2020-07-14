package controller;

import model.entity.Address;
import model.entity.Name;
import model.entity.Student;
import model.service.AddressService;
import model.service.NameService;
import model.service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteStudent extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//
            Student student = new Student();
            Address address = new Address();
            address.setId(student.getIdAddress());
            Name name = new Name();
            name.setId(student.getIdName());
            student.setId(Integer.parseInt(req.getParameter("StudentForDelete")));
        try {
            new StudentService().delete(student);
            new AddressService().delete(address);
            new NameService().delete(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//
//        req.setAttribute("class",req.getParameter("classN"));
        resp.sendRedirect(req.getContextPath() + "/main");
    }

}