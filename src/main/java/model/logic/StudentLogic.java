package model.logic;

import model.entity.*;
import model.service.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentLogic {
    public static List<NewStudent> getRepresentation() throws SQLException {
        List<NewStudent> newStudentList = new ArrayList<>();

        ClassesService classesService = new ClassesService();
        StudentService studentService = new StudentService();
        NameService nameService = new NameService();
        PersonalFileService personalFileService = new PersonalFileService();
        PhoneService phoneService = new PhoneService();

        List<Classes> classesList = classesService.getAll();
        List<Student> studentList = studentService.getAll();
        List<Name> nameList = nameService.getAll();
        List<PersonalFile> personalFileList = personalFileService.getAll();
        List<Phone> phoneList = phoneService.getAll();

        for(Student student : studentList){
            NewStudent newStudent = new NewStudent();
            newStudent.setBDay(student.getBDay());
            List<String> phone = new ArrayList<>();

            for(Phone phoneCycle : phoneList){
                if(phoneCycle.getIdStudent() == student.getId()){
                    phone.add(phoneCycle.getPhone());
                }
            }
            newStudent.setPhone(phone);

            for(PersonalFile personalFile : personalFileList){
                if(personalFile.getIdStudent() == student.getId()){
                    newStudent.setFileNumber(personalFile.getNumber());
                }
            }

            for(Classes classes : classesList){
                if(classes.getId() == student.getIdClass()){
                    newStudent.setClassNumber(classes.getClasses());
                }
            }

            for(Name name: nameList){
                if(name.getId() == student.getIdName()){
                    newStudent.setSurname(name.getSurname());
                    newStudent.setName(name.getName());
                    newStudent.setFatherName(name.getFatherName());
                }
            }

            newStudentList.add(newStudent);


        }




        return newStudentList;
    }
}
