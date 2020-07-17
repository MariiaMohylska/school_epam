package model.logic;

import model.entity.Address;
import model.logic.LogicInterfaces.IAddressLogic;
import model.service.AddressService;

import java.sql.SQLException;
import java.util.List;

public class AddressLogic implements IAddressLogic {
    public Address AddAdress(Address address) throws SQLException {
        int addressMaxId = 0;
        List<Address> addressList = new AddressService().getAll();
        for(Address addr : addressList){
            addressMaxId = (addr.getId()>addressMaxId) ? addr.getId() : addressMaxId;
        }

        address.setId(addressMaxId+1);
        if(address.getCity().matches("^\\D+$")
                && address.getStreet().matches("^\\D+$")
                && address.getHouse().matches("^\\d+\\D*$")
                &&address.getFlat().matches("^\\d+\\D*$")) {

            new AddressService().add(address);

        }else{
//            Додати вивід про некорктне ім'я
        }
        return address;
    }

    public void EditAddress(Address address) throws SQLException {
        if(address.getCity().matches("^\\D+$")
                && address.getStreet().matches("^\\D+$")
                && address.getHouse().matches("^\\d+\\D*$")
                &&address.getFlat().matches("^\\d+\\D*$")) {

            new AddressService().update(address);

        }else{
//            Додати вивід про некорктне ім'я
        }
    }

}
