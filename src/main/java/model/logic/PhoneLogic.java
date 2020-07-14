package model.logic;

import model.entity.Phone;
import model.service.PhoneService;

import java.sql.SQLException;

public class PhoneLogic {
    public void AddPhone(Phone phone) throws SQLException {
        if(phone.getPhone().matches("[(]{1}\\d{3}[)]{1}\\d{3}[-]{1}\\d{2}[-]{1}\\d{2}")) {

            new PhoneService().add(phone);

        }else{
//            Додати вивід про некорктне ім'я
        }
    }
}
