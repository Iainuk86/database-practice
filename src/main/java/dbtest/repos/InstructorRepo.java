package dbtest.repos;

import dbtest.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepo extends CrudRepository<Instructor, Integer> {
}
