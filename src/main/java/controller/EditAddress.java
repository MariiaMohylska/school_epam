package controller;

import model.entity.Address;
import model.entity.Name;
import model.logic.AddressLogic;
import model.logic.NameLogic;
import model.service.AddressService;
import model.service.NameService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EditAddress extends HttpServlet {
    private Address address;
    private int studentId;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            address = new AddressService().get(
                    Integer.parseInt(req.getParameter("addressID"))).get();
            studentId = Integer.parseInt(req.getParameter("studentID"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        req.setAttribute("address", address);
        req.getRequestDispatcher("/editAddress.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String city = req.getParameter("city");
        String street = req.getParameter("street");
        String house = req.getParameter("house");
        String flat = req.getParameter("flat");
        address.setCity(city);
        address.setStreet(street);
        address.setHouse(house);
        address.setFlat(flat);
        try {
            new AddressLogic().EditAddress(address);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect(req.getContextPath() + "/viewDetails?StudentView=" + studentId);

    }
}
