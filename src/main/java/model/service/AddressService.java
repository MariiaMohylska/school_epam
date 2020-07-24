package model.service;

import model.Util;
import model.dao.Dao;
import model.entity.Address;
import  model.dao.Dao;
import model.exceptions.IncorrectData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressService extends Util implements Dao<Address> {
    Connection connection = getConnection();

    @Override
    public Optional<Address> get(int id) throws SQLException, IncorrectData {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT IDADDRESS, CITY, STREET, HOUSE, FLAT FROM ADDRESS WHERE IDADDRESS=?";
        Address address = new Address();
        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                address.setId(resultSet.getInt("IDADDRESS"));
                address.setCity(resultSet.getString("CITY"));
                address.setStreet(resultSet.getString("STREET"));
                address.setHouse(resultSet.getString("HOUSE"));
                address.setFlat(resultSet.getString("FLAT"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }

        return Optional.ofNullable(address);
    }

    @Override
    public List<Address> getAll() throws SQLException, IncorrectData {
        List<Address> addressList = new ArrayList<>();

        String sql = "SELECT IDADDRESS, CITY, STREET, HOUSE, FLAT FROM ADDRESS";

        Statement statement = null;
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Address address =  new Address();
                address.setId(resultSet.getInt("IDADDRESS"));
                address.setCity(resultSet.getString("CITY"));
                address.setStreet(resultSet.getString("STREET"));
                address.setHouse(resultSet.getString("HOUSE"));
                address.setFlat(resultSet.getString("FLAT"));
                addressList.add(address);
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }

        return addressList;
    }

    @Override
    public void add(Address address) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO ADDRESS (IDADDRESS, CITY, STREET, HOUSE, FLAT) VALUES (?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, address.getId());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getHouse());
            preparedStatement.setString(5, address.getFlat());
            preparedStatement.executeUpdate();



        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void update(Address address) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE ADDRESS SET CITY=?, STREET=?, HOUSE=?, FLAT=? WHERE IDADDRESS=?";
        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, address.getCity());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setString(3, address.getHouse());
            preparedStatement.setString(4, address.getFlat());
            preparedStatement.setInt(5, address.getId());

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void delete(Address address) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM ADDRESS WHERE IDADDRESS=?";

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, address.getId());
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }
}
