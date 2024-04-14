package adnavas.fitlux_backend.repository;

import adnavas.fitlux_backend.entity.Deporte;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeporteRepository extends MongoRepository<Deporte, ObjectId> {
    Deporte findBy_id (ObjectId id);
}
