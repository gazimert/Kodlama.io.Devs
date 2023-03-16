package Kodlama.io.Devs.dataAccess.abstracts;

import Kodlama.io.Devs.entities.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageRepository {
    void addProgrammingLanguage(ProgrammingLanguage programmingLanguage);
    void deleteProgrammingLanguage(int id);
    void updateProgrammingLanguage(int id, ProgrammingLanguage programmingLanguage);
    ProgrammingLanguage getById(int id);
    List<ProgrammingLanguage> getAll();
}
