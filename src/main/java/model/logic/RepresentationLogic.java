package model.logic;

import model.entity.*;
import model.service.*;
import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;

import javax.swing.text.html.Option;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepresentationLogic {
    public static List<StudentShort> getRepresentation() throws SQLException {
        List<StudentShort> studentShortList = new ArrayList<>();

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
            StudentShort studentShort = new StudentShort();
            studentShort.setBDay(student.getBDay());
            studentShort.setId(student.getId());
            List<String> phone = new ArrayList<>();

            for(Phone phoneCycle : phoneList){
                if(phoneCycle.getIdStudent() == student.getId()){
                    phone.add(phoneCycle.getPhone());
                }
            }
            studentShort.setPhone(phone);

            for(PersonalFile personalFile : personalFileList){
                if(personalFile.getIdStudent() == student.getId()){
                    studentShort.setFileNumber(personalFile.getNumber());
                }
            }

            for(Classes classes : classesList){
                if(classes.getId() == student.getIdClass()){
                    studentShort.setClassNumber(classes.getClasses());
                }
            }

            for(Name name: nameList){
                if(name.getId() == student.getIdName()){
                    studentShort.setSurname(name.getSurname());
                    studentShort.setName(name.getName());
                    studentShort.setFatherName(name.getFatherName());
                }
            }

            studentShortList.add(studentShort);


        }




        return studentShortList;
    }

    public static NewStudentObject allDetailsStudent(int id) throws SQLException {
        NewStudentObject newStudent = new NewStudentObject();
        Student student;
        Optional<Student> studentOptional = new StudentService().get(id);

        if(studentOptional.isPresent()){
            student = studentOptional.get();

            Optional<Address> addressOptional = new AddressService().get(student.getIdAddress());
            if(addressOptional.isPresent()){
                newStudent.setAddress(addressOptional.get());
            }

            Optional<Name> nameOptional = new NameService().get(student.getIdName());
            if(nameOptional.isPresent()){
                newStudent.setName(nameOptional.get());
            }

            Optional<Classes> classesOptional = new ClassesService().get(student.getIdClass());
            if(classesOptional.isPresent()){
                newStudent.setClasses(classesOptional.get());
            }

            List<PersonalFile> personalFileList = new PersonalFileService().getAll();
            for(PersonalFile personalFile : personalFileList){
                if(personalFile.getIdStudent() == student.getId()){
                    newStudent.setPersonalFile(personalFile);
                }
            }

            List<Phone> phoneList = new PhoneService().getAll();
            for(Phone phone : phoneList){
                if(phone.getIdStudent() == student.getId()){
                    newStudent.setPhone(phone);
                }
            }

            newStudent.setId(student.getId());
            newStudent.setBday(student.getBDay());
        }

        return newStudent;
    }
}
