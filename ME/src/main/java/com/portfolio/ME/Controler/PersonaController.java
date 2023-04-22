package com.portfolio.ME.Controler;

import com.portfolio.ME.Dto.dtoPersona;
import com.portfolio.ME.Entity.Persona;
import com.portfolio.ME.Security.Controller.Mensaje;
import com.portfolio.ME.Service.ImpPersonaService;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
/*Pongo llave {, el del back}*/
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    ImpPersonaService personaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

      
  
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    /*@DeleteMapping("/delete/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") int id){
   if(!personaService.existsById(id)){
   return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
   }
personaService.delete(id);
return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
   }
     @PreAuthorize("hasRole['ADMIN']")
     */
  @PreAuthorize("hasRole('ROLE_ADMIN')")
@PostMapping("/create")
public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona) {
    try {
        Persona persona = new Persona(dtopersona.getNombre(), dtopersona.getApellido(), dtopersona.getTitulo(), dtopersona.getDescripcion(), dtopersona.getImg(), dtopersona.getBanner());
        personaService.save(persona);
         return new ResponseEntity<>("Persona creada", HttpStatus.OK);
    } catch (AccessDeniedException e) {
        return new ResponseEntity<>("No tienes permiso para realizar esta acción", HttpStatus.FORBIDDEN);
    }
}



  @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update-name/{id}")
    public ResponseEntity<?> updateName(@PathVariable("id") int id, @RequestBody Map<String, String> nombres) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        } 
         Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String username = auth.getName();
    boolean isAdmin = auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

    if (!isAdmin) {
         return new ResponseEntity<>("No tienes permiso para realizar esta acción", HttpStatus.FORBIDDEN);
    }

        Persona persona = personaService.getOne(id).get();
        persona.setNombre(nombres.get("nombre"));
        persona.setApellido(nombres.get("apellido"));
        persona.setTitulo(nombres.get("titulo"));
        personaService.save(persona);

       return new ResponseEntity<>("Nombre, Apellido y Titulo actualizados", HttpStatus.OK);
    }

@PreAuthorize("hasRole('ROLE_ADMIN')")
@PutMapping("/update-img/{id}")
public ResponseEntity<?> updateImg(@PathVariable("id") int id, @RequestBody Map<String, String> img) {
    if (!personaService.existsById(id)) {
        return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
    }
    
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String username = auth.getName();
    boolean isAdmin = auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

    if (!isAdmin) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new Mensaje("No tienes permiso para realizar esta acción"));
    }

    Persona persona = personaService.getOne(id).get();
    persona.setImg(img.get("img"));
    personaService.save(persona);

    return new ResponseEntity(new Mensaje("Imagen actualizada"), HttpStatus.OK);
}


  @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update-description/{id}")
    public ResponseEntity<?> updateDescription(@PathVariable("id") int id, @RequestBody Map<String, String> descripcion) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String username = auth.getName();
    boolean isAdmin = auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

    if (!isAdmin) {
         return new ResponseEntity<>("No tienes permiso para realizar esta acción", HttpStatus.FORBIDDEN);
    }
        Persona persona = personaService.getOne(id).get();
        persona.setDescripcion(descripcion.get("descripcion"));
        personaService.save(persona);

        return new ResponseEntity<>("Descripción actualizada", HttpStatus.OK);
    }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update-banner/{id}")
    public ResponseEntity<?> updateBan(@PathVariable("id") int id, @RequestBody Map<String, String> banner) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String username = auth.getName();
    boolean isAdmin = auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

    if (!isAdmin) {
         return new ResponseEntity<>("No tienes permiso para realizar esta acción", HttpStatus.FORBIDDEN);
    }
        Persona persona = personaService.getOne(id).get();
        persona.setBanner(banner.get("banner"));
        personaService.save(persona);

        return new ResponseEntity<>("Banner actualizado", HttpStatus.OK);
    }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String username = auth.getName();
    boolean isAdmin = auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

    if (!isAdmin) {
         return new ResponseEntity<>("No tienes permiso para realizar esta acción", HttpStatus.FORBIDDEN);
    }
        Persona persona = personaService.getOne(id).get();
        persona.setDescripcion(""); // Establece la descripción a null para eliminarla

        personaService.save(persona); // Guarda la persona actualizada en la base de datos

        return new ResponseEntity<>("Se eliminó la descripción de la persona con éxito", HttpStatus.OK);
    }


    /*
   @PutMapping("/update/{id}")
   public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
   if(!personaService.existsById(id))
   {return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
   }
   /*if(personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId() != id)
   {return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
   }
   
   if(StringUtils.isBlank(dtopersona.getNombre())){
   return new ResponseEntity<>("El nombre es obligatorio", HttpStatus.BAD_REQUEST);
   }
    if(StringUtils.isBlank(dtopersona.getApellido())){
   return new ResponseEntity<>("El apellido es obligatorio", HttpStatus.BAD_REQUEST);
   }
     if(StringUtils.isBlank(dtopersona.getTitulo())){
  return new ResponseEntity<>("El titulo es obligatorio", HttpStatus.BAD_REQUEST);
   }
      if(StringUtils.isBlank(dtopersona.getDescripcion())){
  return new ResponseEntity<>("La descripcion no puede ser vacía", HttpStatus.BAD_REQUEST);
   }
       if(StringUtils.isBlank(dtopersona.getImg())){
  return new ResponseEntity<>("La imagen es obligatoria", HttpStatus.BAD_REQUEST);
   }
     
   
   Persona persona= personaService.getOne(id).get();
   persona.setNombre(dtopersona.getNombre());
   persona.setApellido(dtopersona.getApellido());
   persona.setTitulo(dtopersona.getTitulo());
   persona.setDescripcion(dtopersona.getDescripcion());
   persona.setImg(dtopersona.getImg());
   
   personaService.save(persona);
   
   return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
   }
     */
}
