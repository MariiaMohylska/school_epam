package model.logic;

import model.entity.Name;
import model.logic.LogicInterfaces.ILogic;
import model.service.NameService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class NameLogic implements ILogic<Name> {

    @Override
    public Optional<Name> add(Name name) throws SQLException {
        List<Name> nameList = new NameService().getAll();
        int nameMaxId = 0;
        for(Name n: nameList){
            nameMaxId = (n.getId()>nameMaxId) ? n.getId() : nameMaxId;
        }
        name.setId(nameMaxId+1);
        new NameService().add(name);
        return Optional.of(name);
    }
}
