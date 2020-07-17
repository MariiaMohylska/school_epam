package model.logic;

import model.entity.Phone;
import model.logic.LogicInterfaces.IPhoneLogic;
import model.service.PhoneService;

import java.sql.SQLException;
import java.util.List;

public class PhoneLogic implements IPhoneLogic {
    public void AddPhone(Phone phone) throws SQLException {

        List<Phone> phoneList = new PhoneService().getAll();
        int phoneMaxId = 0;
        for(Phone ph:phoneList){
            phoneMaxId = (ph.getId()>phoneMaxId) ? ph.getId() : phoneMaxId;
        }

        phone.setId(phoneMaxId+1);

        if(phone.getPhone().matches("[(]{1}\\d{3}[)]{1}\\d{3}[-]{1}\\d{2}[-]{1}\\d{2}")) {

            new PhoneService().add(phone);

        }else{
//            Додати вивід про некорктне ім'я
        }
    }

    public void EditPhone(Phone phone) throws SQLException{
        if(phone.getPhone().matches("[(]{1}\\d{3}[)]{1}\\d{3}[-]{1}\\d{2}[-]{1}\\d{2}")) {

            new PhoneService().update(phone);

        }else{
//            Додати вивід про некорктне ім'я
        }
    }
}
