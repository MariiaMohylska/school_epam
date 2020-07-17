package model.service;

import model.Util;
import model.dao.Dao;
import model.entity.Classes;
import org.h2.jdbc.JdbcSQLNonTransientException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClassesService extends Util implements Dao<Classes> {
    Connection connection = getConnection();

    @Override
    public Optional<Classes> get(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT IDCLASS, CLASS FROM CLASS WHERE IDCLASS=?";
        Classes classes = new Classes();
        try {

                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                classes.setId(resultSet.getInt("IDCLASS"));
                classes.setClasses(resultSet.getString("CLASS"));
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

        return Optional.ofNullable(classes);
    }


    @Override
    public List<Classes> getAll() throws SQLException {
        List<Classes> classesList = new ArrayList<>();

        String sql = "SELECT IDCLASS, CLASS FROM CLASS";

        Statement statement = null;
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Classes classes =  new Classes();
                classes.setId(resultSet.getInt("IDCLASS"));
                classes.setClasses(resultSet.getString("CLASS"));
                classesList.add(classes);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace();
        } finally {
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }

        return classesList;
    }

    @Override
    public void add(Classes classes) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO CLASS (IDCLASS,CLASS) VALUES (?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, classes.getId());
            preparedStatement.setString(2, classes.getClasses());
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
    public void update(Classes classes) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE CLASS SET CLASS=? WHERE IDCLASS=?";
        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, classes.getClasses());
            preparedStatement.setInt(2, classes.getId());

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
    public void delete(Classes classes) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM CLASS WHERE IDCLASS=?";

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, classes.getId());
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
