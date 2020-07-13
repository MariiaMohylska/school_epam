package model.logic;

import model.entity.Classes;
import model.entity.Student;
import model.service.ClassesService;
import model.service.StudentService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClassLogic {

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


}
