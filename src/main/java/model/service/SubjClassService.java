package model.service;

import model.Util;
import model.dao.Dao;
import model.entity.SubjClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SubjClassService extends Util implements Dao<SubjClass> {
    Connection connection = getConnection();

    @Override
    public Optional<SubjClass> get(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT IDSUBJCLASS, SUBJECT, CLASS FROM SUBJ_CLASS WHERE IDSUBJCLASS=?";
        SubjClass subjClass = new SubjClass();
        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            subjClass.setId(resultSet.getInt("IDSUBJCLASS"));
            subjClass.setIdSubject(resultSet.getInt("SUBJECT"));
            subjClass.setIdClass(resultSet.getInt("CLASS"));

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

        return Optional.ofNullable(subjClass);
    }

    @Override
    public List<SubjClass> getAll() throws SQLException {
        List<SubjClass> subjClassList = new ArrayList<>();

        String sql = "SELECT IDSUBJCLASS, SUBJECT, CLASS FROM SUBJ_CLASS";

        Statement statement = null;
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                SubjClass subjClass =  new SubjClass();
                subjClass.setId(resultSet.getInt("IDSUBJCLASS"));
                subjClass.setIdSubject(resultSet.getInt("SUBJECT"));
                subjClass.setIdClass(resultSet.getInt("CLASS"));
                subjClassList.add(subjClass);
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

        return subjClassList;
    }

    @Override
    public void add(SubjClass subjClass) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO SUBJ_CLASS (SUBJECT, CLASS) VALUES (?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, subjClass.getIdSubject());
            preparedStatement.setInt(2, subjClass.getIdClass());
            preparedStatement.executeUpdate();

            sql = "SELECT IDSUBJCLASS FROM SUBJ_CLASS WHERE SUBJECT=? AND CLASS=? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, subjClass.getIdSubject());
            preparedStatement.setInt(2, subjClass.getIdClass());
            ResultSet resultSet = preparedStatement.executeQuery();

            subjClass.setId(resultSet.getInt("IDSUBJCLASS"));

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
    public void update(SubjClass subjClass) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE SUBJ_CLASS SET SUBJECT=?, CLASS=? WHERE IDSUBJCLASS=?";
        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, subjClass.getIdSubject());
            preparedStatement.setInt(2, subjClass.getIdClass());
            preparedStatement.setInt(3, subjClass.getId());

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
    public void delete(SubjClass subjClass) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM SUBJ_CLASS WHERE IDSUBJCLASS=?";

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, subjClass.getId());
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
