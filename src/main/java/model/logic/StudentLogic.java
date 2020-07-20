package model.logic;

import model.entity.*;
import model.exceptions.DataAlreadyInDB;
import model.exceptions.IncorrectData;
import model.logic.LogicInterfaces.ILogic;
import model.logic.LogicInterfaces.IStudentLogic;
import model.service.*;

import java.sql.SQLException;
import java.util.*;

public class StudentLogic implements ILogic<NewStudent>, IStudentLogic {

    public void ChangeClass(Student student, String newClass) throws SQLException {
        Classes classes = new ClassLogic().searchClassByName(newClass);
        student.setIdClass(classes.getId());
        new StudentService().update(student);
    }

    @Override
    public Optional<NewStudent> add(NewStudent newStudent)
            throws SQLException, NullPointerException, DataAlreadyInDB, IncorrectData {
        Student student = new Student();
        List<Student> studentList = new StudentService().getAll();
        int studentMaxId = 0;

        for(Student std : studentList){
            studentMaxId = (std.getId()>studentMaxId) ? std.getId() : studentMaxId;
        }
        student.setId(studentMaxId + 1);
        student.setBDay(newStudent.getBday());
        student.setIdClass(Integer.parseInt(newStudent.getClassNumber()));

        try {
            PersonalFile personalFile = new PersonalFile();
            personalFile.setIdStudent(student.getId());
            personalFile.setEntryDate(newStudent.getEntryDate());
            personalFile.setNumber(newStudent.getFileNumber());

            Phone phone = new Phone();
            phone.setIdStudent(student.getId());
            phone.setPhone(newStudent.getPhoneNumber());

            new PersonalFileLogic().add(personalFile);
            new PhoneLogic().add(phone);

            Name name = new Name();
            name.setSurname(newStudent.getSurname());
            name.setName(newStudent.getName());
            name.setFatherName(newStudent.getFatherName());

            student.setIdName(new NameLogic().add(name).get().getId());

            Address address = new Address();

            address.setCity(newStudent.getCity());
            address.setStreet(newStudent.getStreet());
            address.setHouse(newStudent.getHouse());
            address.setFlat(newStudent.getFlat());
            new AddressLogic().add(address);

            student.setIdAddress(new AddressLogic().add(address).get().getId());

            new StudentService().add(student);
        } catch (DataAlreadyInDB e){
            throw  e;
        }
        return Optional.of(newStudent);
    }
}
