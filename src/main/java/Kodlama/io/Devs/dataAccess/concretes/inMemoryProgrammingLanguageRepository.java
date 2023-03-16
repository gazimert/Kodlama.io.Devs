package Kodlama.io.Devs.dataAccess.concretes;

import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.entities.ProgrammingLanguage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("dao")
public class inMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

    private static List<ProgrammingLanguage> DB;

    public inMemoryProgrammingLanguageRepository(){
        DB = new ArrayList<>();
        DB.add(new ProgrammingLanguage(1,"Java"));
    }

    @Override
    public void addProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        int tempId = programmingLanguage.getId();
        for (int i = 0; i < DB.size(); i++) {
            if (DB.get(i) == null){
                break;
            }
            if (DB.get(i).getName().equalsIgnoreCase(programmingLanguage.getName())){
                throw new IllegalArgumentException("İsimler aynı olamaz.");
            }
            if (DB.get(i).getId() == tempId){
                tempId = (int)(Math.random()*1000);
                programmingLanguage.setId(tempId);
                break;
            }
        }
        if (programmingLanguage.getName().trim().equals("")){
            throw new IllegalArgumentException("Programlama dili boş olamaz.");
        }
        DB.add(programmingLanguage);
    }

    @Override
    public void deleteProgrammingLanguage(int id) {
        for (ProgrammingLanguage p : DB){
            if (p.getId() == id){
                DB.remove(p);
                break;
            }
        }
    }

    @Override
    public void updateProgrammingLanguage(int id, ProgrammingLanguage programmingLanguageUpdate) {
        for (ProgrammingLanguage p : DB){
            if (p.getId() == id){
                int indexOfUpdate = DB.indexOf(p);
                DB.set(indexOfUpdate, new ProgrammingLanguage(id,programmingLanguageUpdate.getName()));
            }
        }
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        for (ProgrammingLanguage p : DB){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return DB;
    }
}
