package be.apispotlove.commons.repository;

import be.apispotlove.commons.model.Photo;
import be.apispotlove.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends GenericRepository<Photo> {
}
