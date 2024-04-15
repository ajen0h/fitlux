package adnavas.fitlux_backend.controllers;

import adnavas.fitlux_backend.entity.Clase;
import adnavas.fitlux_backend.entity.Usuario;
import adnavas.fitlux_backend.service.ClaseService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/clases")
public class ClaseController {
    @Autowired
    ClaseService claseService;

    @Operation(summary = "OBTENER todas las clases", description = "Esta ruta devuelve todas las clases de la aplicación")
    @GetMapping
    public List<Clase> list() {
        return claseService.findAll();
    }

    @Operation(summary = "OBTENER la clase a través de su ID", description = "Esta ruta devuelve la clase de la aplicación cuyo ID le pasamos como parámetro")
    @GetMapping("/{id}")
    public ResponseEntity<Clase> view(@PathVariable String id){
        ObjectId objectId = new ObjectId(id);
        Clase claseFound = claseService.findById(objectId);
        if(claseFound != null){
            return ResponseEntity.ok(claseFound);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "CREAR una clase", description = "Esta ruta hace que puedas añadir una clase a la aplicación pasándosela como parámetro estableciendole lo que desee el administrador")
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Clase clase, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(claseService.addClase(clase));
    }

    @Operation(summary = "REGISTRA un usuario en una clase", description = "Esta ruta hace que puedas añadir un usuario por defecto a la aplicación como parámetro")
    @PostMapping("/register")
    public ResponseEntity<Clase> register(@RequestParam String idClase, @RequestParam String idUser) {
        ObjectId objectIdClase = new ObjectId(idClase);
        ObjectId objectIdUser = new ObjectId(idUser);
        Clase claseFound = claseService.registrarUsuario(objectIdClase,objectIdUser);
        if(claseFound != null){
            return ResponseEntity.ok(claseFound);
        }
        return ResponseEntity.notFound().build();
    }


    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> errors.put(err.getField(),err.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @Operation(summary = "ACTUALIZAR una clase", description = "Esta ruta hace que puedas actualizar una clase de la aplicación pasándole el ID y el objeto nuevo")
    @PutMapping("/{id}")
    public ResponseEntity<Clase> update(@PathVariable String id, @Valid @RequestBody Clase clase){
        ObjectId objectId = new ObjectId(id);
        Clase claseUpdate = claseService.updateClase(objectId, clase);
        if(claseUpdate != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(claseUpdate);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "BORRAR una clase", description = "Esta ruta hace que puedas borrar una clase de la aplicación pasándole su ID como parámetro")
    @DeleteMapping("/{id}")
    public ResponseEntity<Clase> delete(@PathVariable String id){
        ObjectId objectId = new ObjectId(id);
        Clase claseDelete = claseService.deleteClase(objectId);
        if(claseDelete != null){
            return ResponseEntity.ok(claseDelete);
        }
        return ResponseEntity.notFound().build();
    }
}
