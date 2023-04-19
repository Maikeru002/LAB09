package edu.eci.cvds;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    boolean existsById(String propiedadId);
    User findById(String propiedadId);
}