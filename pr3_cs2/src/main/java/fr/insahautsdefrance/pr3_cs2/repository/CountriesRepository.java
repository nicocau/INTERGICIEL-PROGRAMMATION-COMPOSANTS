package fr.insahautsdefrance.pr3_cs2.repository;

import fr.insahautsdefrance.pr3_cs2.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepository extends JpaRepository<Countries, Integer> {

}
