<<<<<<< HEAD
package com.portfolio.ME.Repository;

import com.portfolio.ME.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer>{
   public Optional<Persona> findByNombre(String nombre);
   public boolean existsByNombre(String nombre);
    
}
=======
package com.portfolio.ME.Repository;

import com.portfolio.ME.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer>{
   public Optional<Persona> findByNombre(String nombre);
   public boolean existsByNombre(String nombre);
    
}
>>>>>>> 51cfe50 (Mi primer commit)
