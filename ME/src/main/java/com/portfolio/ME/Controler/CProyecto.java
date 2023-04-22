/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ME.Controler;

import com.portfolio.ME.Dto.dtoProyecto;
import com.portfolio.ME.Entity.Proyecto;
import com.portfolio.ME.Security.Controller.Mensaje;
import com.portfolio.ME.Service.SProyecto;
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

/**
 *
 * @author Milagros
 */
@RestController
@RequestMapping("proylab")
@CrossOrigin(origins = "http://localhost:4200")

public class CProyecto {

    @Autowired

    SProyecto sProyecto;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

  /** PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoproy) {
        if (StringUtils.isBlank(dtoproy.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }**/
    @PreAuthorize("hasRole('ROLE_ADMIN')")
   @PostMapping("/create")
public ResponseEntity<?> create(@RequestBody dtoProyecto dtoproy) {
    if (StringUtils.isBlank(dtoproy.getNombreP())) {
        return new ResponseEntity<>("El nombre es obligatorio", HttpStatus.BAD_REQUEST);
    }
  

        if (sProyecto.existsByNombreP(dtoproy.getNombreP())) {
             return new ResponseEntity<>("Ese nombre de proyecto ya exite", HttpStatus.BAD_REQUEST);
            
        }
        if (StringUtils.isBlank(dtoproy.getDescripcionP())) {
             return new ResponseEntity<>("La descripcion es obligatoria", HttpStatus.BAD_REQUEST);
        }
        
        if (sProyecto.existsByNombreP(dtoproy.getDescripcionP())) {
             return new ResponseEntity<>("Esa descripción proyecto ya exite", HttpStatus.BAD_REQUEST);
          
        }
        if (StringUtils.isBlank(dtoproy.getPeriodoP())) {
             return new ResponseEntity<>("La fecha de realización es obligatoria", HttpStatus.BAD_REQUEST);

        }

        if (sProyecto.existsByNombreP(dtoproy.getImgP())) {
             return new ResponseEntity<>("Ese link ya existe", HttpStatus.BAD_REQUEST);
            
        }
        if (dtoproy.getImgP() == null || dtoproy.getImgP().isEmpty() && (dtoproy.getLinkP() == null || dtoproy.getLinkP().isEmpty())) {
      return new ResponseEntity<>("El link o imagen de certificación es obligatorio", HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = new Proyecto(dtoproy.getNombreP(), dtoproy.getDescripcionP(), dtoproy.getPeriodoP(), dtoproy.getLinkP(),dtoproy.getImgP());
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);
    }
@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoproy) {

        //Validamos si existe el id
        if (!sProyecto.existsById(id)) {
             return new ResponseEntity<>("El ID no existe", HttpStatus.BAD_REQUEST);
        }
  
        //Compara nombre de proyectos
        if (sProyecto.existsByNombreP(dtoproy.getNombreP()) && sProyecto.getByNombreP(dtoproy.getNombreP()).get().getId() != id) {
            return new ResponseEntity<>("Ese proyecto ya existe", HttpStatus.BAD_REQUEST);
        }
        if (sProyecto.existsByNombreP(dtoproy.getDescripcionP()) && sProyecto.getByNombreP(dtoproy.getDescripcionP()).get().getId() != id) {
            return new ResponseEntity<>("Ese proyecto ya existe", HttpStatus.BAD_REQUEST);
        }

        if (sProyecto.existsByNombreP(dtoproy.getImgP()) && sProyecto.getByNombreP(dtoproy.getImgP()).get().getId() != id) {
            return new ResponseEntity<>("Ese proyecto ya existe", HttpStatus.BAD_REQUEST);
        }
        //No puede ser vacio
        if (StringUtils.isBlank(dtoproy.getNombreP())) {
            return new ResponseEntity<>("El nombre es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoproy.getDescripcionP())) {
            return new ResponseEntity<>("La descripcion es obligatoria", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoproy.getPeriodoP())) {
            return new ResponseEntity<>("La fecha de realización es obligatoria", HttpStatus.BAD_REQUEST);
        }
         if (dtoproy.getImgP() == null || dtoproy.getImgP().isEmpty() && (dtoproy.getLinkP() == null || dtoproy.getLinkP().isEmpty())) {
    return new ResponseEntity<>("El link o imagen de certificación es obligatorio", HttpStatus.BAD_REQUEST);
         }
         
        Proyecto proyecto = sProyecto.getOne(id).get();
        proyecto.setNombreP(dtoproy.getNombreP());
        proyecto.setDescripcionP(dtoproy.getDescripcionP());
        proyecto.setPeriodoP(dtoproy.getPeriodoP());
        proyecto.setLinkP(dtoproy.getLinkP());
        proyecto.setImgP(dtoproy.getImgP());

        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
@PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity<>("El ID no existe", HttpStatus.BAD_REQUEST);
        }

        sProyecto.delete(id);

        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
}
