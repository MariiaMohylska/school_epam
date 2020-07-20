package model.logic.LogicInterfaces;

import model.exceptions.DataAlreadyInDB;
import model.exceptions.IncorrectData;

import java.sql.SQLException;
import java.util.Optional;

public interface ILogic<T> {
    Optional<T> add(T t) throws SQLException, DataAlreadyInDB, IncorrectData;
}
