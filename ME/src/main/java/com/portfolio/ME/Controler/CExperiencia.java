
package com.portfolio.ME.Controler;

import com.portfolio.ME.Dto.dtoExperiencia;
import com.portfolio.ME.Entity.Experiencia;
import com.portfolio.ME.Security.Controller.Mensaje;
import com.portfolio.ME.Service.SExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("explab")
@CrossOrigin(origins= "http://localhost:4200")

public class CExperiencia {
@Autowired
SExperiencia sExperiencia;

@GetMapping("/lista")
public ResponseEntity<List<Experiencia>> list(){
List<Experiencia> list= sExperiencia.list();
return new ResponseEntity(list, HttpStatus.OK);
        }

@GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
@PreAuthorize("hasRole('ROLE_ADMIN')")
@PostMapping("/create")
public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){
 if(StringUtils.isBlank(dtoexp.getNombreE()))
     return new ResponseEntity<>("El nombre es obligatorio", HttpStatus.BAD_REQUEST);
if (sExperiencia.existsByNombreE(dtoexp.getNombreE()))
    return new ResponseEntity<>("Esa experiencia exite", HttpStatus.BAD_REQUEST);
if(StringUtils.isBlank(dtoexp.getEmpE()))
     return new ResponseEntity<>("El nombre de la empresa es obligatoria", HttpStatus.BAD_REQUEST);
if(StringUtils.isBlank(dtoexp.getDescripcionE()))
     return new ResponseEntity<>("La descripcion es obligatoria", HttpStatus.BAD_REQUEST);
if (sExperiencia.existsByNombreE(dtoexp.getDescripcionE()))
    return new ResponseEntity<>("Esa experiencia exite", HttpStatus.BAD_REQUEST);

if(StringUtils.isBlank(dtoexp.getPeriodoE()))
     return new ResponseEntity<>("El periodo es obligatorio", HttpStatus.BAD_REQUEST);

Experiencia experiencia = new Experiencia(dtoexp.getNombreE(), dtoexp.getEmpE(),dtoexp.getDescripcionE(), dtoexp.getPeriodoE(), dtoexp.getImgE());
sExperiencia.save(experiencia);

return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
}
@PreAuthorize("hasRole('ROLE_ADMIN')")
@PutMapping("/update/{id}")
public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp){
    
    //Validamos si existe el id
    if(!sExperiencia.existsById(id))
    return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
    //Compara nombre de experiencias
    if(sExperiencia.existsByNombreE(dtoexp.getNombreE()) && sExperiencia.getByNombreE(dtoexp.getNombreE()).get().getId() != id)
        return new ResponseEntity<>("Esa experiencia ya existe", HttpStatus.BAD_REQUEST);
    //No puede ser vacio
    if(StringUtils.isBlank(dtoexp.getNombreE()))
        return new ResponseEntity<>("El nombre es obligatorio", HttpStatus.BAD_REQUEST);
    if(StringUtils.isBlank(dtoexp.getEmpE()))
     return new ResponseEntity<>("El nombre de la empresa es obligatoria", HttpStatus.BAD_REQUEST);
    if(StringUtils.isBlank(dtoexp.getDescripcionE()))
        return new ResponseEntity<>("La descripcion es obligatoria", HttpStatus.BAD_REQUEST);
    if(StringUtils.isBlank(dtoexp.getPeriodoE()))
        return new ResponseEntity<>("El periodo es obligatorio", HttpStatus.BAD_REQUEST);
    
    Experiencia experiencia=sExperiencia.getOne(id).get();
    experiencia.setNombreE(dtoexp.getNombreE());
    experiencia.setEmpE(dtoexp.getEmpE());
    experiencia.setDescripcionE(dtoexp.getDescripcionE());
    experiencia.setPeriodoE(dtoexp.getPeriodoE());
    experiencia.setImgE(dtoexp.getImgE());
    
    
    sExperiencia.save(experiencia);
    return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
}
@PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
    if(!sExperiencia.existsById(id))
    return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
    
    sExperiencia.delete(id);
    
    return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
}