package uz.uzumservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.uzumservice.model.UserSession;

@Repository
public interface UserSessionRepository extends CrudRepository<UserSession, String> {
}
