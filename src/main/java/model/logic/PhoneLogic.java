package model.logic;

import model.entity.Phone;
import model.logic.LogicInterfaces.ILogic;
import model.service.PhoneService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PhoneLogic implements ILogic<Phone> {
    @Override
    public Optional<Phone> add(Phone phone) throws SQLException {
        List<Phone> phoneList = new PhoneService().getAll();
        int phoneMaxId = 0;
        for(Phone ph:phoneList){
            phoneMaxId = (ph.getId()>phoneMaxId) ? ph.getId() : phoneMaxId;
        }
        phone.setId(phoneMaxId+1);
        new PhoneService().add(phone);
        return Optional.of(phone);
    }
}
