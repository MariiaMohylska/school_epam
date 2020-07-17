package model.logic;

import model.entity.*;
import model.logic.LogicInterfaces.IStudentLogic;
import model.service.*;
import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StudentLogic implements IStudentLogic {

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

        new StudentService().add(student);

        Phone phone = new Phone();
        List<Phone> phoneList = new PhoneService().getAll();
        int phoneMaxId = 0;
        for(Phone ph:phoneList){
            phoneMaxId = (ph.getId()>phoneMaxId) ? ph.getId() : phoneMaxId;
        }

        phone.setId(phoneMaxId+1);
        phone.setIdStudent(student.getId());
        phone.setPhone(newStudent.getPhoneNumber());

        new PersonalFileLogic().AddPersonalFile(personalFile);
        new PhoneLogic().AddPhone(phone);

    }

    public static void EditStudent(NewStudent newStudent) throws SQLException {
        Student student = new Student();
        List<Student> studentList = new StudentService().getAll();
        for(Student std : studentList){
            if(newStudent.getId() == std.getId()){
                student = std;
            }
        }

        PersonalFile personalFile = new PersonalFile();
        List<PersonalFile> personalFileList = new PersonalFileService().getAll();
        for(PersonalFile file : personalFileList){
            if(file.getIdStudent() == student.getId()){
                personalFile = file;
            }
        }

        personalFile.setNumber(newStudent.getFileNumber());
        personalFile.setEntryDate(newStudent.getEntryDate());
        personalFile.setGradDate(newStudent.getGradDate());

        Optional<Name> nameOptional = new NameService().get(student.getIdName());
        if(nameOptional.isPresent()){
            Name name = new Name();

            name = nameOptional.get();
            name.setSurname(newStudent.getSurname());
            name.setName(newStudent.getName());
            name.setFatherName(newStudent.getFatherName());
            new NameLogic().EditName(name);
        }



        Optional<Address> addressOptional = new AddressService().get(student.getIdAddress());
        Address address = new Address();
        if(addressOptional.isPresent()){
            address = addressOptional.get();
            address.setCity(newStudent.getCity());
            address.setStreet(newStudent.getStreet());
            address.setHouse(newStudent.getHouse());
            address.setFlat(newStudent.getFlat());

            new AddressLogic().EditAddress(address);
        }


        Phone phone = new Phone();
        List<Phone> phoneList = new PhoneService().getAll();

        for(Phone ph:phoneList){
           if(ph.getIdStudent() == student.getId()){
               phone = ph;
           }
        }

        phone.setPhone(newStudent.getPhoneNumber());

        new PhoneLogic().EditPhone(phone);
        new PersonalFileLogic().EditPersonalFile(personalFile);
//        Personal FIle and Phone Edit
    }

    public static void ChangeClass(Student student, String newClass) throws SQLException {
        Classes classes = new ClassLogic().searchClassByName(newClass);
        student.setIdClass(classes.getId());
        new StudentService().update(student);
    }

}
