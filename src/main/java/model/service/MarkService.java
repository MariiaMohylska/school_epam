package model.service;

import model.Util;
import model.dao.Dao;
import model.entity.Mark;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MarkService extends Util implements Dao<Mark> {
    Connection connection = getConnection();

    @Override
    public Optional<Mark> get(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT IDMARK, SUBJCLASS, STUDENT, MARK FROM MARK WHERE IDMARK=?";
        Mark mark = new Mark();
        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            mark.setId(resultSet.getInt("IDMARK"));
            mark.setIdSubjClass(resultSet.getInt("SUBJCLASS"));
            mark.setIdStudent(resultSet.getInt("STUDENT"));
            mark.setMark(resultSet.getInt("MARK"));

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

        return Optional.ofNullable(mark);
    }

    @Override
    public List<Mark> getAll() throws SQLException {
        List<Mark> markList = new ArrayList<>();

        String sql = "SELECT IDMARK, SUBJCLASS, STUDENT, MARK FROM MARK";

        Statement statement = null;
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Mark mark =  new Mark();
                mark.setId(resultSet.getInt("IDMARK"));
                mark.setIdSubjClass(resultSet.getInt("SUBJCLASS"));
                mark.setIdStudent(resultSet.getInt("STUDENT"));
                mark.setMark(resultSet.getInt("MARK"));
                markList.add(mark);
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

        return markList;
    }

    @Override
    public void add(Mark mark) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO MARK (SUBJCLASS, STUDENT, MARK) VALUES (?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, mark.getIdSubjClass());
            preparedStatement.setInt(2, mark.getIdStudent());
            preparedStatement.setInt(3, mark.getMark());
            preparedStatement.executeUpdate();

            sql = "SELECT IDMARK FROM MARK WHERE SUBJCLASS=? AND STUDENT=? AND MARK=?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, mark.getIdSubjClass());
            preparedStatement.setInt(2, mark.getIdStudent());
            preparedStatement.setInt(3, mark.getMark());
            ResultSet resultSet = preparedStatement.executeQuery();

            mark.setId(resultSet.getInt("IDMARK"));

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
    public void update(Mark mark) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE MARK SET SUBJCLASS=?, STUDENT=?, MARK=? WHERE IDMARK=?";
        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, mark.getIdSubjClass());
            preparedStatement.setInt(2, mark.getIdStudent());
            preparedStatement.setInt(3, mark.getMark());
            preparedStatement.setInt(4, mark.getId());

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
    public void delete(Mark mark) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM MARK WHERE IDMARK=?";

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, mark.getId());
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
