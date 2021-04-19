package edu.hav.labs.repository.library;

import edu.hav.labs.model.Library;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LibraryRepository extends MongoRepository<Library, String> {
}
