package model.logic.LogicInterfaces;

import model.entity.Phone;

import java.sql.SQLException;

public interface IPhoneLogic {
    public void AddPhone(Phone phone) throws SQLException;
    public void EditPhone(Phone phone) throws SQLException;
}
