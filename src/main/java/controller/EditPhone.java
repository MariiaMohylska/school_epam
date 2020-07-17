package controller;

import model.entity.Phone;
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
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        req.setAttribute("phone", phone);
        req.getRequestDispatcher("/editPhone.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String phoneNumber = req.getParameter("phoneNumber");
        phone.setPhone(phoneNumber);
        try {
            new PhoneLogic().EditPhone(phone);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/viewDetails?StudentView=" + phone.getIdStudent());

    }
}
