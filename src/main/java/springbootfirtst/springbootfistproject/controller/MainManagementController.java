package springbootfirtst.springbootfistproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;
import springbootfirtst.springbootfistproject.models.Person;
import springbootfirtst.springbootfistproject.service.PersonService;

import java.util.UUID;

@RestController
@RequestMapping("management/api/people")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainManagementController {


    @Autowired
    PersonService personService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TRAINEE')")
    public Iterable<Person> getListPeople() {
        return personService.getListPeople();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewPerson(@RequestBody Person person) {
         personService.savePerson(person);
    }


    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletedPersonById(id);
    }


    @PutMapping("{personId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updatePerson(@PathVariable("personId") UUID personId, @RequestBody Person person) {
         personService.updatePersonById(personId,person);
    }


}
