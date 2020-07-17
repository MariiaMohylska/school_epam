package model.logic.LogicInterfaces;

import model.entity.Name;

import java.sql.SQLException;

public interface INameLogic {
    public void AddName(Name name) throws SQLException;
    public void EditName(Name name) throws SQLException;
}