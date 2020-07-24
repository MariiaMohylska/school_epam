package model.dao;

import model.exceptions.IncorrectData;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(int id) throws SQLException, IncorrectData;
    List<T> getAll() throws SQLException, IncorrectData;
    void add(T t) throws SQLException;
    void update(T t) throws SQLException;
    void delete(T t) throws SQLException;
}
