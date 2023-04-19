package edu.eci.cvds;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuessRepository extends JpaRepository<Guess, Long>{
    boolean existsById(String propiedadId);
    Guess findById(String propiedadId);
}