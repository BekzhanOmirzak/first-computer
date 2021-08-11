package springbootfirtst.springbootfistproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springbootfirtst.springbootfistproject.models.Person;
import springbootfirtst.springbootfistproject.repo.PersonRepo;

import java.util.Optional;
import java.util.UUID;


@Component
public class PersonService {

    private final PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Iterable<Person> getListPeople() {
        Person person = new Person();
        person.setName("Beksultan");
        personRepo.save(person);
        return personRepo.findAll();
    }

    public Optional<Person> findPersonById(UUID id) {
        return personRepo.findById(id);
    }


}
