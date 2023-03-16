package Kodlama.io.Devs.business.abstracts;

import Kodlama.io.Devs.entities.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {
    void addProgrammingLanguage(ProgrammingLanguage programmingLanguage);
    void deleteProgrammingLanguage(int id);
    void updateProgrammingLanguage(int id, ProgrammingLanguage programmingLanguage);
    ProgrammingLanguage getById(int id);
    List<ProgrammingLanguage> getAll();
}
