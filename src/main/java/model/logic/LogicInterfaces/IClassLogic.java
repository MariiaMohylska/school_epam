package model.logic.LogicInterfaces;

import model.entity.Classes;
import model.exceptions.DataAlreadyInDB;
import model.exceptions.IncorrectData;

import java.sql.SQLException;

public interface IClassLogic {
    void TransferAllClass() throws DataAlreadyInDB, IncorrectData;
    Classes newClassAdd (String classNumber) throws SQLException, DataAlreadyInDB;
    Classes searchClassByName(String className) throws SQLException, IncorrectData;
    void deleteClass(int id) throws SQLException;

}
