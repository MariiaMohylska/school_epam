package model.logic;

import model.entity.PersonalFile;
import model.service.PersonalFileService;

import java.sql.SQLException;
import java.util.List;

public class PersonalFileLogic {

    public void AddPersonalFile(PersonalFile personalFile) throws SQLException {
        String fileNumber = personalFile.getNumber();
        if(fileNumber.matches("\\d{4}[/]\\d\\b")) {
            List<PersonalFile> personalFileList = new PersonalFileService().getAll();
            int checkPresent = 0;

            for (PersonalFile file : personalFileList){
                if(file.getNumber().equals(fileNumber)){
                    checkPresent = 1;
                }
            }

            if(checkPresent == 0){
                new PersonalFileService().add(personalFile);
            } else{
//                вивід про те що запис існує
            }
        }else{
//            Додати вивід про некоректний номер
        }

    }


}