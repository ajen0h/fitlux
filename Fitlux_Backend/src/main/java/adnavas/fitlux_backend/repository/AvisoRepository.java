package adnavas.fitlux_backend.repository;

import adnavas.fitlux_backend.entity.Aviso;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AvisoRepository extends MongoRepository<Aviso, ObjectId> {
    Aviso findBy_id (ObjectId id);
    @Query("{ 'usuario_id' : ?0 }")
    Aviso findByUsuario_id(ObjectId userId);
}
