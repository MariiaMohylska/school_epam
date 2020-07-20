package controller;

import model.entity.Name;
import model.exceptions.IncorrectData;
import model.logic.NameLogic;
import model.service.NameService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EditName extends HttpServlet {
    private Name nameObj;
    private int studentId;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            nameObj = new NameService().get(
                    Integer.parseInt(req.getParameter("nameID"))).get();
            studentId = Integer.parseInt(req.getParameter("studentID"));
        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().print(e.getMessage());
        } catch (NullPointerException e){
            e.printStackTrace();
            resp.getWriter().print(e.getMessage());
        }

        req.setAttribute("NameObj", nameObj);
        req.getRequestDispatcher("/editName.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String fatherName = req.getParameter("fatherName");

        try {
            nameObj.setSurname(surname);
            nameObj.setName(name);
            nameObj.setFatherName(fatherName);
            new NameService().update(nameObj);
            resp.sendRedirect(req.getContextPath() + "/viewDetails?StudentView=" + studentId);
        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().print(e.getMessage());
        } catch ( IncorrectData e){
            resp.getWriter().print(e.getMessage());
        }


    }
}
