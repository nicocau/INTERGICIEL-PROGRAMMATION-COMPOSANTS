package fr.insahautsdefrance.pr3_cs2.repository;

import fr.insahautsdefrance.pr3_cs2.entity.Global;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GlobalRepository extends JpaRepository<Global, Integer> {
    Optional<Global> findFirstByOrderByIdAsc();
}
