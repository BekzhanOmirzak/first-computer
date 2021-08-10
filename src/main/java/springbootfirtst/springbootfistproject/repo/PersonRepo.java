package springbootfirtst.springbootfistproject.repo;

import org.springframework.data.repository.CrudRepository;
import springbootfirtst.springbootfistproject.models.Person;

import java.util.UUID;

public interface PersonRepo extends CrudRepository<Person, UUID> {




}
