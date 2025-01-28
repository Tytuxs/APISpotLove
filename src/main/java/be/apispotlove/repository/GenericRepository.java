package be.apispotlove.repository;

import be.apispotlove.commons.model.BaseEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenericRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

    default T retrieve(Long id) {
        if(id == null) {
            throw new NullPointerException("id == null");
        }

        Optional<T> entity = findById(id);
        if(entity.isPresent()) {
            return entity.get();
        } else {
            throw new EntityNotFoundException("entity does not exist: " + id);
        }
    }
}
