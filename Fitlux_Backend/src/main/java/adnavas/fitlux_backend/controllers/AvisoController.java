package adnavas.fitlux_backend.controllers;

import adnavas.fitlux_backend.entity.Aviso;
import adnavas.fitlux_backend.entity.Deporte;
import adnavas.fitlux_backend.service.AvisoService;
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
@RequestMapping("/api/avisos")
public class AvisoController {
    @Autowired
    AvisoService avisoService;

    @Operation(summary = "OBTENER todos los avisos", description = "Esta ruta devuelve todos los avisos de la aplicación")
    @GetMapping
    public List<Aviso> list() {
        return avisoService.findAll();
    }

    @Operation(summary = "OBTENER el aviso a través de su ID", description = "Esta ruta devuelve el aviso de la aplicación cuyo ID le pasamos como parámetro")
    @GetMapping("/{id}")
    public ResponseEntity<Aviso> view(@PathVariable String id){
        ObjectId objectId = new ObjectId(id);
        Aviso avisoFound = avisoService.findById(objectId);
        if(avisoFound != null){
            return ResponseEntity.ok(avisoFound);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "CREAR un aviso", description = "Esta ruta hace que puedas añadir un aviso a la aplicación pasándoselo como parámetro estableciendole lo que desee el administrador")
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Aviso aviso, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(avisoService.addAviso(aviso));
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> errors.put(err.getField(),err.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @Operation(summary = "ACTUALIZAR un aviso", description = "Esta ruta hace que puedas actualizar un aviso de la aplicación pasándole el ID y el objeto nuevo")
    @PutMapping("/{id}")
    public ResponseEntity<Aviso> update(@PathVariable String id, @Valid @RequestBody Aviso aviso){
        ObjectId objectId = new ObjectId(id);
        Aviso avisoUpdate = avisoService.updateAviso(objectId, aviso);
        if(avisoUpdate != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(avisoUpdate);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "BORRAR un aviso", description = "Esta ruta hace que puedas borrar un aviso de la aplicación pasándole su ID como parámetro")
    @DeleteMapping("/{id}")
    public ResponseEntity<Aviso> delete(@PathVariable String id){
        ObjectId objectId = new ObjectId(id);
        Aviso avisoDelete = avisoService.deleteAviso(objectId);
        if(avisoDelete != null){
            return ResponseEntity.ok(avisoDelete);
        }
        return ResponseEntity.notFound().build();
    }
}
