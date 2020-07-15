package model.service;

import model.Util;
import model.dao.Dao;
import model.entity.Phone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PhoneService extends Util implements Dao<Phone> {
    Connection connection = getConnection();

    @Override
    public Optional<Phone> get(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT IDPHONE, PHONE_NUMBER, STUDENT FROM PHONE WHERE IDPHONE=?";
        Phone phone = new Phone();
        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                phone.setId(resultSet.getInt("IDPHONE"));
                phone.setPhone(resultSet.getString("PHONE_NUMBER"));
                phone.setIdStudent(resultSet.getInt("STUDENT"));
            }
//            preparedStatement.executeUpdate();

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

        return Optional.ofNullable(phone);
    }

    @Override
    public List<Phone> getAll() throws SQLException {
        List<Phone> phoneList = new ArrayList<>();

        String sql = "SELECT IDPHONE, PHONE_NUMBER, STUDENT FROM PHONE";

        Statement statement = null;
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Phone phone =  new Phone();
                phone.setId(resultSet.getInt("IDPHONE"));
                phone.setPhone(resultSet.getString("PHONE_NUMBER"));
                phone.setIdStudent(resultSet.getInt("STUDENT"));
                phoneList.add(phone);
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

        return phoneList;
    }

    @Override
    public void add(Phone phone) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO PHONE (IDPHONE, PHONE_NUMBER, STUDENT) VALUES (?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, phone.getId());
            preparedStatement.setString(2, phone.getPhone());
            preparedStatement.setInt(3, phone.getIdStudent());
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
    public void update(Phone phone) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE PHONE SET PHONE_NUMBER=?, STUDENT=? WHERE IDPHONE=?";
        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, phone.getPhone());
            preparedStatement.setInt(2, phone.getIdStudent());
            preparedStatement.setInt(3, phone.getId());

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
    public void delete(Phone phone) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM ADDRESS WHERE IDPHONE=?";

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, phone.getId());
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
