package model.logic.LogicInterfaces;

import model.entity.PersonalFile;

import java.sql.SQLException;

public interface IPersonalFileLogic {
    PersonalFile serchByStudent(int idStudent) throws SQLException;
}
