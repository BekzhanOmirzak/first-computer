package springbootfirtst.springbootfistproject.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import springbootfirtst.springbootfistproject.models.Person;
import java.util.UUID;

public interface PersonRepo extends CrudRepository<Person, UUID> {


     @Query("update Person set name=:name where id=:id")
     void updatePersonById(UUID id,String name);


}
