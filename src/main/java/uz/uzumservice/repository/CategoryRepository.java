package uz.uzumservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.uzumservice.model.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByParentId(Integer id);
}
