package model.logic;

import model.entity.PersonalFile;
import model.exceptions.DataAlreadyInDB;
import model.exceptions.IncorrectData;
import model.logic.LogicInterfaces.ILogic;
import model.logic.LogicInterfaces.IPersonalFileLogic;
import model.service.PersonalFileService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PersonalFileLogic  implements ILogic<PersonalFile>, IPersonalFileLogic {
    public PersonalFile serchByStudent(int idStudent) throws SQLException, IncorrectData {
            PersonalFile personalFile = null;
            List<PersonalFile> personalFileList = new PersonalFileService().getAll();
            for(PersonalFile file : personalFileList){
                 if(file.getIdStudent() == idStudent){
                     personalFile = file;
                 }
            }

        return  personalFile;
    }

    @Override
    public Optional<PersonalFile> add(PersonalFile personalFile) throws SQLException, DataAlreadyInDB, IncorrectData {
        List<PersonalFile> personalFileList = new PersonalFileService().getAll();
        int personelFileMaxId = 0;
        for(PersonalFile file : personalFileList){
            personelFileMaxId = (file.getId()>personelFileMaxId) ? file.getId() : personelFileMaxId;
        }

        personalFile.setId(personelFileMaxId + 1);
        String fileNumber = personalFile.getNumber();
        int checkPresent = 0;

        for (PersonalFile file : personalFileList){
            if(file.getNumber().equals(fileNumber)){
                checkPresent = 1;
            }
        }

        if(checkPresent == 0){
            new PersonalFileService().add(personalFile);
        } else {
            throw new DataAlreadyInDB("Prsonal File Number already exists");
        }
        return Optional.of(personalFile);
    }
}