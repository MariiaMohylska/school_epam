package model.logic;

import model.entity.Name;
import model.entity.PersonalFile;
import model.service.NameService;
import model.service.PersonalFileService;

import java.sql.SQLException;
import java.util.List;

public class NameLogic {
    public void AddName(Name name) throws SQLException {

        if(name.getName().matches("^\\D+$")
                && name.getSurname().matches("^\\D+$")
                && name.getFatherName().matches("^\\D+$")) {

                new NameService().add(name);

        }else{
//            Додати вивід про некорктне ім'я
        }

    }

    public void EditName(Name name) throws SQLException{

        if(name.getName().matches("^\\D+$")
                && name.getSurname().matches("^\\D+$")
                && name.getFatherName().matches("^\\D+$")) {

            new NameService().update(name);

        }else{
//            Додати вивід про некорктне ім'я
        }
    }
}
