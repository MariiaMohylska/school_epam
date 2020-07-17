package model.logic.LogicInterfaces;

import model.entity.PersonalFile;

import java.sql.SQLException;

public interface IPersonalFileLogic {
    public void AddPersonalFile(PersonalFile personalFile) throws SQLException;
    public void EditPersonalFile(PersonalFile personalFile) throws SQLException;
}
