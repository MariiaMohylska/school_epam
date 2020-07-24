package model.logic;

import model.entity.Classes;
import model.entity.PersonalFile;
import model.entity.Student;
import model.exceptions.DataAlreadyInDB;
import model.exceptions.IncorrectData;
import model.logic.LogicInterfaces.IClassLogic;
import model.service.ClassesService;
import model.service.PersonalFileService;
import model.service.StudentService;
import org.h2.jdbc.JdbcSQLNonTransientException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClassLogic implements IClassLogic {

    public void TransferAllClass() throws DataAlreadyInDB, IncorrectData {

        try {
            List<Student> studentList = new StudentService().getAll();
            List<Classes> classesList = new ClassesService().getAll();
            for(Student student : studentList){
                if(student.getIdClass() != new ClassesService().GRADUATED) {
                    Optional<Classes> optional = new ClassesService().get(student.getIdClass());
                    Classes classes = null;

                    if (optional.isPresent()) {
                        classes = optional.get();
                    }
                    String newClassNumber;
                    String previousClassNumber = classes.getClasses();
                    char[] splitClass = previousClassNumber.toCharArray();
                    int numberClass;
                    if (splitClass.length == 3) {
                        numberClass = Integer.parseInt((char)splitClass[0] + "" + (char) splitClass[1]) + 1;
                        newClassNumber = (char) numberClass + "" + splitClass[2];
                    } else {
                        numberClass = (int) splitClass[0] + 1;
                        newClassNumber = (char) numberClass + "" + splitClass[1];
                    }

                    if (numberClass == 12) {
                        PersonalFile personalFile = new PersonalFileLogic().serchByStudent(student.getId());
                        personalFile.setGradDate(LocalDate.now());
                        new PersonalFileService().update(personalFile);
                        student.setIdClass(new ClassesService().GRADUATED);
                    } else {
                        classes = searchClassByName(newClassNumber);
                        if (classes.getId() == 0) {
                            classes = newClassAdd(newClassNumber);
                        }
                        student.setIdClass(classes.getId());
                    }
                    new StudentService().update(student);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        }



    }


    public Classes newClassAdd (String classNumber) throws SQLException, DataAlreadyInDB {

        Classes classes = new Classes();
        classNumber = classNumber.toUpperCase();
        char[] splitClassNumber = classNumber.toCharArray();
        char numberClass;
        if(splitClassNumber.length ==3){
            numberClass = (char) splitClassNumber[2];
        }else {
           numberClass = (char) splitClassNumber[1];
        }

        if((numberClass>=65)&&(numberClass<=90)) {
            List<Classes> classesList = new ClassesService().getAll();
            int maxId = 0;
            int classPresent = 0;
            for(Classes cls : classesList){
                maxId = (cls.getId()>= maxId) ? cls.getId() : maxId;
                if(cls.getClasses().equals(classNumber))
                {
                    classPresent = 1;
                }
            }

            if(classPresent == 0)
            {
                classes.setId(maxId+1);
                classes.setClasses(classNumber);
                new ClassesService().add(classes);
            } else {
                throw  new DataAlreadyInDB("Class already exists");
            }

        }

        return classes;
    }

    public Classes searchClassByName(String className) throws SQLException, IncorrectData {
        Classes classes = new Classes();
        List<Classes> classesList = new ClassesService().getAll();
        boolean isPresent = false;
        for(Classes cls : classesList){
            if(cls.getClasses().equals(className)){
                classes = cls;
                isPresent = true;
            }
        }
        if(!isPresent){
            throw new IncorrectData("Such a class does not exist");
        }
        return classes;
    }

    public void deleteClass(int id) throws SQLException {
        Classes classes = new Classes();
        classes.setId(id);
        List<Student> studentList = new StudentService().getAll();
        for(Student student : studentList){
            if(student.getIdClass() == id){
                new StudentService().delete(student);
            }
        }
        new ClassesService().delete(classes);

    }


}
