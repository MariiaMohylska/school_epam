package model.service;

import model.Util;
import model.dao.Dao;
import model.entity.Subject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SubjectService extends Util implements Dao<Subject> {
    Connection connection = getConnection();

    @Override
    public Optional<Subject> get(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT IDSUBJECT, SUBJECT_NAME FROM SUBJECT WHERE IDSUBJECT=?";
        Subject subject = new Subject();
        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            subject.setId(resultSet.getInt("IDSUBJECT"));
            subject.setSubjName(resultSet.getString("SUBJECT_NAME"));

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

        return Optional.ofNullable(subject);
    }

    @Override
    public List<Subject> getAll() throws SQLException {
        List<Subject> subjectList = new ArrayList<>();

        String sql = "SELECT IDSUBJECT, SUBJECT_NAME FROM SUBJECT";

        Statement statement = null;
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Subject subject =  new Subject();
                subject.setId(resultSet.getInt("IDSUBJECT"));
                subject.setSubjName(resultSet.getString("SUBJECT_NAME"));
                subjectList.add(subject);
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

        return subjectList;
    }

    @Override
    public void add(Subject subject) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO SUBJECT (SUBJECT_NAME) VALUES (?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, subject.getSubjName());
            preparedStatement.executeUpdate();

            sql = "SELECT IDSUBJECT FROM SUBJECT WHERE SUBJECT_NAME=?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, subject.getSubjName());
            ResultSet resultSet = preparedStatement.executeQuery();

            subject.setId(resultSet.getInt("IDSUBJECT"));

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
    public void update(Subject subject) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE SUBJECT SET SUBJECT_NAME=? WHERE IDSUBJECT=?";
        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, subject.getSubjName());
            preparedStatement.setInt(2, subject.getId());

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
    public void delete(Subject subject) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM SUBJECT WHERE IDSUBJECT=?";

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, subject.getId());
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
