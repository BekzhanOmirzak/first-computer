package springbootfirtst.springbootfistproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootfirtst.springbootfistproject.models.Person;
import springbootfirtst.springbootfistproject.repo.PersonRepo;

@RestController
public class Maincontroller {

    @Autowired
    private PersonRepo personRepo;

    @GetMapping("/main")
    public Iterable<Person> getString() {
        Person person = new Person();
        person.setName("Beksultan");
        personRepo.save(person);
        return personRepo.findAll();
    }


}
