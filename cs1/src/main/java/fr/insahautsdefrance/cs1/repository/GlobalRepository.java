package fr.insahautsdefrance.cs1.repository;

import fr.insahautsdefrance.cs1.entity.Global;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalRepository extends JpaRepository<Global, Integer> {

}
