package adnavas.fitlux_backend.controllers;

import adnavas.fitlux_backend.entity.Deporte;
import adnavas.fitlux_backend.entity.Usuario;
import adnavas.fitlux_backend.service.DeporteService;
import adnavas.fitlux_backend.service.UsuarioService;
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
@RequestMapping("/api/deportes")
public class DeporteController {
    @Autowired
    DeporteService deporteService;

    @Operation(summary = "OBTENER todos los deportes", description = "Esta ruta devuelve todos los deportes de la aplicación")
    @GetMapping
    public List<Deporte> list() {
        return deporteService.findAll();
    }

    @Operation(summary = "OBTENER el deporte a través de su ID", description = "Esta ruta devuelve el deporte de la aplicación cuyo ID le pasamos como parámetro")
    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable String id) {
        ObjectId objectId = new ObjectId(id);
        Deporte deporteFound = deporteService.findById(objectId);
        if (deporteFound != null) {
            return ResponseEntity.ok(deporteFound);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deporte no encontrado con ID: " + id);
    }

    @Operation(summary = "CREAR un deporte", description = "Esta ruta hace que puedas añadir un deporte a la aplicación pasándoselo como parámetro estableciendole lo que desee el administrador")
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Deporte deporte, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        Deporte deporteCreate = deporteService.addDeporte(deporte);
        if (deporteCreate != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Deporte creado correctamente");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha podido crear el deporte");
        }
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @Operation(summary = "ACTUALIZAR un deporte", description = "Esta ruta hace que puedas actualizar un deporte de la aplicación pasándole el ID y el objeto nuevo")
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @Valid @RequestBody Deporte deporte) {
        ObjectId objectId = new ObjectId(id);
        Deporte deporteUpdate = deporteService.updateDeporte(objectId, deporte);
        if (deporteUpdate != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Deporte actualizado correctamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha podido encontrar el deporte a actualizar");
    }

    @Operation(summary = "BORRAR un deporte", description = "Esta ruta hace que puedas borrar un deporte de la aplicación pasándole su ID como parámetro")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        ObjectId objectId = new ObjectId(id);
        Deporte deporteDelete = deporteService.deleteDeporte(objectId);
        if (deporteDelete != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Deporte borrado correctamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha podido encontrar el deporte a borrar");

    }
}
