package model.logic.LogicInterfaces;

import model.entity.Student;
import model.logic.NewStudent;

import java.sql.SQLException;

public interface IStudentLogic {
    void ChangeClass(Student student, String newClass) throws SQLException;
}
