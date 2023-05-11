package uz.uzumservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.uzumservice.model.Authorities;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authorities, Integer> {
    List<Authorities> findAllByUsername(String username);
    boolean existsByUsernameAndAuthority(String username, String authority);
}
