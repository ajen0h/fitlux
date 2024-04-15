package adnavas.fitlux_backend.repository;

import adnavas.fitlux_backend.entity.Usuario;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, ObjectId> {
    Usuario findByUsername(String username);

    Usuario findBy_id (ObjectId id);

    List<Usuario> findBy_idIn(List<ObjectId> userIds);

}