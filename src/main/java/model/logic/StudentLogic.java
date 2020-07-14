package model.logic;

import model.entity.*;
import model.service.*;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StudentLogic {

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

    public static void AddStudent(NewStudent newStudent) throws SQLException {
        Student student = new Student();
        List<Student> studentList = new StudentService().getAll();
        int studentMaxId = 0;
        for(Student std : studentList){
            studentMaxId = (std.getId()>studentMaxId) ? std.getId() : studentMaxId;
        }
        student.setId(studentMaxId + 1);
        student.setBDay(newStudent.getBday());
        student.setIdClass(Integer.parseInt(newStudent.getClassNumber()));

        PersonalFile personalFile = new PersonalFile();
        List<PersonalFile> personalFileList = new PersonalFileService().getAll();
        int personelFileMaxId = 0;
        for(PersonalFile file : personalFileList){
            personelFileMaxId = (file.getId()>personelFileMaxId) ? file.getId() : personelFileMaxId;
        }

        personalFile.setId(personelFileMaxId + 1);
        personalFile.setIdStudent(student.getId());
        personalFile.setEntryDate(newStudent.getEntryDate());
        personalFile.setNumber(newStudent.getFileNumber());

        Name name = new Name();
        List<Name> nameList = new NameService().getAll();
        int nameMaxId = 0;
        for(Name n: nameList){
            nameMaxId = (n.getId()>nameMaxId) ? n.getId() : nameMaxId;
        }

        name.setId(nameMaxId+1);
        name.setSurname(newStudent.getSurname());
        name.setName(newStudent.getName());
        name.setFatherName(newStudent.getFatherName());

        new NameLogic().AddName(name);

        student.setIdName(name.getId());

        Address address = new Address();
        int addressMaxId = 0;
        List<Address> addressList = new AddressService().getAll();
        for(Address addr : addressList){
            addressMaxId = (addr.getId()>addressMaxId) ? addr.getId() : addressMaxId;
        }

        address.setId(addressMaxId+1);
        address.setCity(newStudent.getCity());
        address.setStreet(newStudent.getStreet());
        address.setHouse(newStudent.getHouse());
        address.setFlat(newStudent.getFlat());

        new AddressLogic().AddAdress(address);

        student.setIdAddress(address.getId());

        Phone phone = new Phone();
        List<Phone> phoneList = new PhoneService().getAll();
        int phoneMaxId = 0;
        for(Phone ph:phoneList){
            phoneMaxId = (ph.getId()>phoneMaxId) ? ph.getId() : phoneMaxId;
        }

        phone.setId(phoneMaxId+1);
        phone.setIdStudent(student.getId());
        phone.setPhone(newStudent.getPhoneNumber());

        new StudentService().add(student);
        new PersonalFileLogic().AddPersonalFile(personalFile);
        new PhoneLogic().AddPhone(phone);

    }
}
