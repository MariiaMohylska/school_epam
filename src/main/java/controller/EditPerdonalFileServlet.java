package controller;

import model.entity.PersonalFile;
import model.logic.ClassLogic;
import model.logic.PersonalFileLogic;
import model.service.PersonalFileService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class EditPerdonalFileServlet extends HttpServlet {
    private PersonalFile personalFile;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            personalFile = new PersonalFileService().get(
                    Integer.parseInt(req.getParameter("personalFileID"))).get();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        req.getRequestDispatcher("/editPersonalFile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        final LocalDate gradDate = LocalDate.parse(req.getParameter("gradDate"));
        personalFile.setGradDate(gradDate);
//        req.setAttribute("StudentView", personalFile.getIdStudent());
        try {
            new PersonalFileService().update(personalFile);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        req.getRequestDispatcher("detailstudent.jsp").forward(req, resp);
        resp.sendRedirect(req.getContextPath() + "/viewDetails?StudentView=" + personalFile.getIdStudent());

    }
}