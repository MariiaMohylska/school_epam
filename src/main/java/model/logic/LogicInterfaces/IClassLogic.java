package model.logic.LogicInterfaces;

import model.entity.Classes;
import model.exceptions.DataAlreadyInDB;

import java.sql.SQLException;

public interface IClassLogic {
    void TransferAllClass() throws DataAlreadyInDB;
    Classes newClassAdd (String classNumber) throws SQLException, DataAlreadyInDB;
    Classes searchClassByName(String className) throws SQLException;
    void deleteClass(int id) throws SQLException;

}
