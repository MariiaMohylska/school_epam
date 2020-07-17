package model.logic;

import model.entity.Classes;
import model.entity.Student;
import model.logic.LogicInterfaces.IClassLogic;
import model.service.ClassesService;
import model.service.StudentService;
import org.h2.jdbc.JdbcSQLNonTransientException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClassLogic implements IClassLogic {

    public static void TransferAllClass(){
        StudentService studentService = new StudentService();
        ClassesService classesService = new ClassesService();

        try {
            List<Student> studentList = studentService.getAll();
            List<Classes> classesList = classesService.getAll();
            for(Student student : studentList){
                Optional<Classes> optional = classesService.get(student.getIdClass());
                Classes classes = null;

                if(optional.isPresent()){
                    classes = optional.get();
                }

                String previousClassNumber = classes.getClasses();
                char[] splitClass = previousClassNumber.toCharArray();
                int numberClass = (int)splitClass[0] + 1;
                String newClassNumber = numberClass + "" + splitClass[1];
                int idNewClass = 0;
                for(Classes clas :  classesList){
                    if(clas.getClasses() == newClassNumber){
                        idNewClass = clas.getId();
                    }
                }

                if(idNewClass == 0){
                    Classes newClass = new Classes();
                    newClass.setClasses(newClassNumber);
                    idNewClass = newClass.getId();
                }

                student.setIdClass(idNewClass);
                studentService.update(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        }



    }


    public static boolean newClassAdd (String classNumber) throws SQLException {

        boolean status = false;

        classNumber = classNumber.toUpperCase();
        char[] splitClassNumber = classNumber.toCharArray();
        char numberClass = (char)splitClassNumber[1];

        if((numberClass>=65)&&(numberClass<=90)) {
            List<Classes> classesList = new ClassesService().getAll();
            int maxId = 0;
            int classPresent = 0;
            for(Classes classes : classesList){
                maxId = (classes.getId()>= maxId) ? classes.getId() : maxId;
                if(classes.getClasses() == classNumber)
                {
                    classPresent = 1;
                }
            }

            if(classPresent == 0)
            {
                Classes classes = new Classes();
                classes.setId(maxId+1);
                classes.setClasses(classNumber);
                new ClassesService().add(classes);
                status = true;
            }

//
        }

        return status;
    }

    public Classes searchClassByName(String className) throws SQLException{
        Classes classes = new Classes();
        List<Classes> classesList = new ClassesService().getAll();
        for(Classes cls : classesList){
            if(cls.getClasses().equals(className)){
                classes = cls;
            }
        }
        return classes;
    }


}
