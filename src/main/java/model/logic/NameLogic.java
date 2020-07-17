package model.logic;

import model.entity.Name;
import model.entity.PersonalFile;
import model.logic.LogicInterfaces.INameLogic;
import model.service.NameService;
import model.service.PersonalFileService;

import java.sql.SQLException;
import java.util.List;

public class NameLogic implements INameLogic {
    public Name AddName(Name name) throws SQLException {
        List<Name> nameList = new NameService().getAll();
        int nameMaxId = 0;
        for(Name n: nameList){
            nameMaxId = (n.getId()>nameMaxId) ? n.getId() : nameMaxId;
        }
        name.setId(nameMaxId+1);
        if(name.getName().matches("^\\D+$")
                && name.getSurname().matches("^\\D+$")
                && name.getFatherName().matches("^\\D+$")) {

                new NameService().add(name);

        }else{
//            Додати вивід про некорктне ім'я
        }
        return name;
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
