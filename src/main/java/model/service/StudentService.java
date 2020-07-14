package model.service;

import model.entity.Student;
import model.Util;
import model.dao.Dao;
import model.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService extends Util implements Dao<Student> {
    Connection connection = getConnection();

    @Override
    public Optional<Student> get(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT IDSTUDENT, NAME, ADDRESS, CLASS, BDAY FROM STUDENT WHERE IDSTUDENT=?";
        Student student = new Student();
        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            student.setId(resultSet.getInt("IDSTUDENT"));
            student.setIdName(resultSet.getInt("NAME"));
            student.setIdAddress(resultSet.getInt("ADDRESS"));
            student.setIdClass(resultSet.getInt("CLASS"));
            student.setBDay(resultSet.getDate("BDAY").toLocalDate());

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

        return Optional.ofNullable(student);
    }

    @Override
    public List<Student> getAll() throws SQLException {
        List<Student> studentList = new ArrayList<>();

        String sql = "SELECT IDSTUDENT, NAME, ADDRESS, CLASS, BDAY FROM STUDENT";

        Statement statement = null;
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Student student =  new Student();
                student.setId(resultSet.getInt("IDSTUDENT"));
                student.setIdName(resultSet.getInt("NAME"));
                student.setIdAddress(resultSet.getInt("ADDRESS"));
                student.setIdClass(resultSet.getInt("CLASS"));
                student.setBDay(resultSet.getDate("BDAY").toLocalDate());
                studentList.add(student);
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

        return studentList;
    }

    @Override
    public void add(Student student) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO STUDENT (IDSTUDENT, NAME, ADDRESS, CLASS, BDAY) VALUES (?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setInt(2, student.getIdName());
            preparedStatement.setInt(3, student.getIdAddress());
            preparedStatement.setInt(4, student.getIdClass());
            preparedStatement.setDate(5, Date.valueOf(student.getBDay()));
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
    public void update(Student student) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE STUDENT SET NAME=?, ADDRESS=?, CLASS=?, BDAY=? WHERE IDSTUDENT=?";
        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, student.getIdName());
            preparedStatement.setInt(2, student.getIdAddress());
            preparedStatement.setInt(3, student.getIdClass());
            preparedStatement.setDate(4, Date.valueOf( student.getBDay()));
            preparedStatement.setInt(5, student.getId());

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
    public void delete(Student student) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM STUDENT WHERE IDSTUDENT=?";

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, student.getId());
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
