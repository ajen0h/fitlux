package adnavas.fitlux_backend.controllers;


import adnavas.fitlux_backend.entity.Usuario;
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
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsuarioController {
    @Autowired
    UsuarioService userService;

    @Operation(summary = "OBTENER todos los usuarios", description = "Esta ruta devuelve todos los usuarios de la aplicación")
    @GetMapping
    public List<Usuario> list() {
        return userService.findAll();
    }

    @Operation(summary = "OBTENER el usuario a través de su ID", description = "Esta ruta devuelve el usuario de la aplicación cuyo ID le pasamos como parámetro")
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> view(@PathVariable ObjectId id){
        Usuario usuarioFound = userService.findById(id);
        if(usuarioFound != null){
            return ResponseEntity.ok(usuarioFound);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "CREAR un usuario", description = "Esta ruta hace que puedas añadir un usuario a la aplicación pasándoselo como parámetro estableciendole lo que desee el administrador")
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Usuario user, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUsuario(user));
    }

    @Operation(summary = "REGISTRA un usuario", description = "Esta ruta hace que puedas añadir un usuario por defecto a la aplicación como parámetro")
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody Usuario user, BindingResult result) {

        return create(user, result);
    }


    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @Operation(summary = "ACTUALIZAR un usuario", description = "Esta ruta hace que puedas actualizar un usuario de la aplicación pasándole el ID y el objeto nuevo")
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable String id, @RequestBody Usuario usuario){
        ObjectId objectId = new ObjectId(id);
        Usuario usuarioUpdate = userService.updateUsuario(objectId, usuario);
        if(usuarioUpdate != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioUpdate);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "BORRAR un usuario", description = "Esta ruta hace que puedas borrar un usuario de la aplicación pasándole su ID como parámetro")
    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable String id){
        ObjectId objectId = new ObjectId(id);
        Usuario usuarioDelete = userService.deleteUsuario(objectId);
        if(usuarioDelete != null){
            return ResponseEntity.ok(usuarioDelete);
        }
        return ResponseEntity.notFound().build();
    }
}
