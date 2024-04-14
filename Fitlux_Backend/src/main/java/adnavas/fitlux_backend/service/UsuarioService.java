package adnavas.fitlux_backend.service;


import adnavas.fitlux_backend.entity.Usuario;
import org.bson.types.ObjectId;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();

    Usuario findById(ObjectId id);
    Usuario findByUsername(String username);
    Usuario addUsuario (Usuario user);

    Usuario deleteUsuario(ObjectId id);

    Usuario updateUsuario(ObjectId id, Usuario usuario);

}
