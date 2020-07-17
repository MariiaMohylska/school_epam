package model.logic.LogicInterfaces;

import model.entity.Classes;

import java.sql.SQLException;

public interface IClassLogic {
    public static void TransferAllClass(){};
    public static boolean newClassAdd (String classNumber) throws SQLException{
        return false;
    };
    public Classes searchClassByName(String className) throws SQLException;

}
