package springbootfirtst.springbootfistproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import springbootfirtst.springbootfistproject.models.Person;
import springbootfirtst.springbootfistproject.repo.PersonRepo;

import java.util.Optional;
import java.util.UUID;


@Component
public class PersonService {

    private final PersonRepo personRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    public void savePerson(Person person){
        personRepo.save(person);
    }

    public void deletedPersonById(UUID id){
        personRepo.deleteById(id);
    }

    public void updatePersonById(UUID id,Person person){
        personRepo.updatePersonById(id,person.getName());
    }



}
