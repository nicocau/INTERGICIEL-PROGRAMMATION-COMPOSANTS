package fr.insahautsdefrance.pr3_cs2.repository;

import fr.insahautsdefrance.pr3_cs2.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    List<Country> findByCountry(String country);
}
