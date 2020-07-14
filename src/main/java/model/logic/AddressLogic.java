package model.logic;

import model.entity.Address;
import model.service.AddressService;

import java.sql.SQLException;

public class AddressLogic {
    public void AddAdress(Address address) throws SQLException {
        if(address.getCity().matches("^\\D+$")
                && address.getStreet().matches("^\\D+$")
                && address.getHouse().matches("^\\d+\\D*$")
                &&address.getFlat().matches("^\\d+\\D*$")) {

            new AddressService().add(address);

        }else{
//            Додати вивід про некорктне ім'я
        }
    }

}
