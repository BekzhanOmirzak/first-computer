package springbootfirtst.springbootfistproject.controller;


import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootfirtst.springbootfistproject.models.Person;
import springbootfirtst.springbootfistproject.service.PersonService;

import java.util.UUID;

@RestController
@RequestMapping("api")
public class Maincontroller {


    private final PersonService personService;

    @Autowired
    public Maincontroller(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/main")
    private Iterable<Person> getPerson() {
        return personService.getListPeople();
    }

    @GetMapping(path = "/person/{uuid}")
    private Person getStudentById(@PathVariable("uuid") UUID uuid) throws NotFoundException {
        return personService.findPersonById(uuid).orElse(null);
    }

    @GetMapping("/root")
    private String any() {
        return "<h1>Welcome</h1>";
    }


    @GetMapping("/user")
    private String user() {
        return "<h1>Welcome user</h1>";
    }


    @GetMapping("/admin")
    private String admin() {
        return "<h1>Welcome admin</h1>";
    }




}
