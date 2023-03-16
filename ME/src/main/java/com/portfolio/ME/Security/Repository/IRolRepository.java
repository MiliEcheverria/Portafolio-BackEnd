<<<<<<< HEAD

package com.portfolio.ME.Security.Repository;

import com.portfolio.ME.Security.Entity.Rol;
import com.portfolio.ME.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
  Optional<Rol> findByRolNombre(RolNombre rolNombre);  
}
=======

package com.portfolio.ME.Security.Repository;

import com.portfolio.ME.Security.Entity.Rol;
import com.portfolio.ME.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
  Optional<Rol> findByRolNombre(RolNombre rolNombre);  
}
>>>>>>> 51cfe50 (Mi primer commit)
