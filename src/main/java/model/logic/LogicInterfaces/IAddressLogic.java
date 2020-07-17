package model.logic.LogicInterfaces;

import model.entity.Address;

import java.sql.SQLException;

public interface IAddressLogic {
    public void AddAdress(Address address) throws SQLException;
    public void EditAddress(Address address) throws SQLException;
}
