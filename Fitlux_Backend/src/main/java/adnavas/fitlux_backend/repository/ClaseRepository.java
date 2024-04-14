package adnavas.fitlux_backend.repository;

import adnavas.fitlux_backend.entity.Clase;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClaseRepository extends MongoRepository<Clase, ObjectId> {
    Clase findBy_id (ObjectId id);
}
