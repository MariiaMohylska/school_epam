package model.service;

import model.Util;
import model.dao.Dao;
import model.entity.Name;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NameService extends Util implements Dao<Name> {
    Connection connection = getConnection();

    @Override
    public Optional<Name> get(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT IDNAME, SURNAME, NAME, FATHERNAME FROM NAME WHERE IDADDRESS=?";
        Name name = new Name();
        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            name.setId(resultSet.getInt("IDNAME"));
            name.setSurname(resultSet.getString("SURNAME"));
            name.setName(resultSet.getString("NAME"));
            name.setFatherName(resultSet.getString("FATHERNAME"));

            preparedStatement.executeUpdate();

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

        return Optional.ofNullable(name);
    }

    @Override
    public List<Name> getAll() throws SQLException {
        List<Name> nameList = new ArrayList<>();

        String sql = "SELECT IDNAME, SURNAME, NAME, FATHERNAME FROM NAME";

        Statement statement = null;
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Name name =  new Name();
                name.setId(resultSet.getInt("IDNAME"));
                name.setSurname(resultSet.getString("SURNAME"));
                name.setName(resultSet.getString("NAME"));
                name.setFatherName(resultSet.getString("FATHERNAME"));
                nameList.add(name);
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

        return nameList;
    }

    @Override
    public void add(Name name) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO NAME (SURNAME, NAME, FATHERNAME) VALUES (?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name.getSurname());
            preparedStatement.setString(2, name.getName());
            preparedStatement.setString(3, name.getFatherName());
            preparedStatement.executeUpdate();

            sql = "SELECT IDADDRESS FROM NAME WHERE SURNAME=? AND NAME=? AND FATHERNAME=?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name.getSurname());
            preparedStatement.setString(2, name.getName());
            preparedStatement.setString(3, name.getFatherName());
            ResultSet resultSet = preparedStatement.executeQuery();

            name.setId(resultSet.getInt("IDNAME"));

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
    public void update(Name name) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE NAME SET SURNAME=?, NAME=?, FATHERNAME=? WHERE IDNAME=?";
        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, name.getSurname());
            preparedStatement.setString(2, name.getName());
            preparedStatement.setString(3, name.getFatherName());
            preparedStatement.setInt(4, name.getId());

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
    public void delete(Name name) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM NAME WHERE IDNAME=?";

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, name.getId());
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
