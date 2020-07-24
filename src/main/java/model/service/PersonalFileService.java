package model.service;

import model.entity.PersonalFile;
import model.Util;
import model.dao.Dao;
import model.exceptions.IncorrectData;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonalFileService extends Util implements Dao<PersonalFile> {
    Connection connection = getConnection();

    @Override
    public Optional<PersonalFile> get(int id) throws SQLException, IncorrectData {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT IDFILE, FILE_NUMBER, STUDENT, ENTRY_DATE, GRAD_DATE FROM PERSONAL_FILE WHERE IDFILE=?";
        PersonalFile personalFile = new PersonalFile();
        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                personalFile.setId(resultSet.getInt("IDFILE"));
                personalFile.setNumber(resultSet.getString("FILE_NUMBER"));
                personalFile.setIdStudent(resultSet.getInt("STUDENT"));
                personalFile.setEntryDate(resultSet.getDate("ENTRY_DATE").toLocalDate());
                personalFile.setGradDate(resultSet.getDate("GRAD_DATE").toLocalDate());
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

        return Optional.ofNullable(personalFile);
    }

    @Override
    public List<PersonalFile> getAll() throws SQLException, IncorrectData {
        List<PersonalFile> personalFileList = new ArrayList<>();

        String sql = "SELECT IDFILE, FILE_NUMBER, STUDENT, ENTRY_DATE, GRAD_DATE FROM PERSONAL_FILE";

        Statement statement = null;
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                PersonalFile personalFile =  new PersonalFile();
                personalFile.setId(resultSet.getInt("IDFILE"));
                personalFile.setNumber(resultSet.getString("FILE_NUMBER"));
                personalFile.setIdStudent(resultSet.getInt("STUDENT"));
                personalFile.setEntryDate( resultSet.getDate("ENTRY_DATE").toLocalDate());
                try {
                    personalFile.setGradDate(resultSet.getDate("GRAD_DATE").toLocalDate());
                } catch (NullPointerException e){
                    personalFile.setGradDate(null);
                }
                personalFileList.add(personalFile);
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

        return personalFileList;
    }

    @Override
    public void add(PersonalFile personalFile) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO PERSONAL_FILE (IDFILE, FILE_NUMBER, STUDENT, ENTRY_DATE, GRAD_DATE) VALUES (?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, personalFile.getId());
            preparedStatement.setString(2, personalFile.getNumber());
            preparedStatement.setInt(3, personalFile.getIdStudent());
            preparedStatement.setDate(4, Date.valueOf(personalFile.getEntryDate()));
            if(personalFile.getGradDate() == null) {
                preparedStatement.setDate(5, Date.valueOf(personalFile.getEntryDate()));
            }else{
                preparedStatement.setDate(5, Date.valueOf(personalFile.getGradDate()));
            }
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
    public void update(PersonalFile personalFile) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE PERSONAL_FILE SET FILE_NUMBER=?, STUDENT=?, ENTRY_DATE=?, GRAD_DATE=? WHERE IDFILE=?";
        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, personalFile.getNumber());
            preparedStatement.setInt(2, personalFile.getIdStudent());
            preparedStatement.setDate(3, Date.valueOf(personalFile.getEntryDate()));
            preparedStatement.setDate(4, Date.valueOf(personalFile.getGradDate()));
            preparedStatement.setInt(5, personalFile.getId());

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
    public void delete(PersonalFile personalFile) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM PERSONAL_FILE WHERE IDFILE=?";

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, personalFile.getId());
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
