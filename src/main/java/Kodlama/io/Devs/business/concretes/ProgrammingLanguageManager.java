package Kodlama.io.Devs.business.concretes;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.entities.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageRepository programmingLanguageRepository;

    @Autowired
    public ProgrammingLanguageManager(@Qualifier("dao") ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public void addProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        programmingLanguageRepository.addProgrammingLanguage(programmingLanguage);
    }

    @Override
    public void deleteProgrammingLanguage(int id) {
        programmingLanguageRepository.deleteProgrammingLanguage(id);
    }

    @Override
    public void updateProgrammingLanguage(int id, ProgrammingLanguage programmingLanguage) {
        programmingLanguageRepository.updateProgrammingLanguage(id,programmingLanguage);
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        return programmingLanguageRepository.getById(id);
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageRepository.getAll();
    }
}
