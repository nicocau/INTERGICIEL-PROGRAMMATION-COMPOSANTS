package fr.insahautsdefrance.cs1.repository;

import fr.insahautsdefrance.cs1.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepository extends JpaRepository<Country, Integer> {

}
