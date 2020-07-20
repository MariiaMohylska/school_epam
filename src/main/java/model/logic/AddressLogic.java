package model.logic;

import model.entity.Address;
import model.logic.LogicInterfaces.ILogic;
import model.service.AddressService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AddressLogic implements ILogic<Address> {
    @Override
    public Optional<Address> add(Address address) throws SQLException {
        int addressMaxId = 0;
        List<Address> addressList = new AddressService().getAll();
        for(Address addr : addressList){
            addressMaxId = (addr.getId()>addressMaxId) ? addr.getId() : addressMaxId;
        }

        address.setId(addressMaxId+1);
        new AddressService().add(address);
        return Optional.of(address);
    }
}
