package controller;

import model.entity.Phone;
import model.exceptions.IncorrectData;
import model.logic.PhoneLogic;
import model.service.NameService;
import model.service.PersonalFileService;
import model.service.PhoneService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class EditPhone extends HttpServlet {
    private Phone phone;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            phone = new PhoneService().get(
                    Integer.parseInt(req.getParameter("phoneID"))).get();
        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().print(e.getMessage());
        } catch (NullPointerException e){
            e.printStackTrace();
            resp.getWriter().print(e.getMessage());
        }

        req.setAttribute("phone", phone);
        req.getRequestDispatcher("/editPhone.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String phoneNumber = req.getParameter("phoneNumber");

        try {
            phone.setPhone(phoneNumber);
            new PhoneService().update(phone);
            resp.sendRedirect(req.getContextPath() + "/viewDetails?StudentView=" + phone.getIdStudent());
        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().print(e.getMessage());
        } catch (IncorrectData e){
            resp.getWriter().print(e.getMessage());
        }

    }
}
