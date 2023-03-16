package Kodlama.io.Devs.api;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.entities.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/pl")
@RestController
public class ProgrammingLanguagesController {
    private ProgrammingLanguageService programmingLanguageService;

    @Autowired
    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @PostMapping
    public void addProgrammingLanguage(@RequestBody ProgrammingLanguage programmingLanguage){
        programmingLanguageService.addProgrammingLanguage(programmingLanguage);
    }

    @GetMapping
    public List<ProgrammingLanguage> getAll(){
        return programmingLanguageService.getAll();
    }

    @DeleteMapping(path = "{id}")
    public void deleteProgrammingLanguage(@PathVariable("id") int id){
        programmingLanguageService.deleteProgrammingLanguage(id);
    }

    @PutMapping(path = "{id}")
    public void updateProgrammingLanguage(@PathVariable("id") int id,@RequestBody ProgrammingLanguage programmingLanguage){
        programmingLanguageService.updateProgrammingLanguage(id,programmingLanguage);
    }

    @GetMapping(path = "{id}")
    public ProgrammingLanguage getById(@PathVariable("id") int id){
        return programmingLanguageService.getById(id);
    }
}
