package adnavas.fitlux_backend.service;

import adnavas.fitlux_backend.entity.Clase;
import adnavas.fitlux_backend.entity.Sala;
import adnavas.fitlux_backend.repository.SalaRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SalaServiceImpl implements SalaService {

    @Autowired
    SalaRepository salaRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    @Transactional(readOnly = true)
    public List<Sala> findAll() {
        return salaRepository.findAll();
    }

    @Override
    public Sala findById(ObjectId id) {
        return salaRepository.findBy_id(id);
    }

    @Override
    @Transactional
    public Sala addSala(Sala sala) {
        return salaRepository.save(sala);
    }

    @Override
    public Sala deleteSala(ObjectId id) {
        Sala salaDelete = salaRepository.findBy_id(id);
        salaRepository.delete(salaDelete);

        Query query = new Query(Criteria.where("sala.id").is(id));
        List<Clase> clases = mongoTemplate.find(query, Clase.class);

        for (Clase clase : clases) {
            mongoTemplate.remove(clase); // Borrar la clase que tenia esa sala
        }

        return salaDelete;
    }

    @Override
    public Sala updateSala(ObjectId id, Sala sala) {
        Sala salaUpdate = salaRepository.findBy_id(id);
        salaUpdate.setNombre(sala.getNombre());
        salaUpdate.setAforo(sala.getAforo());

        salaRepository.save(salaUpdate);

        Query query = new Query(Criteria.where("sala.id").is(sala.get_id()));   //TODO probar si funciona con sala.id o sala._id cuando acabe de hacer todos los services y controladores
        List<Clase> clases = mongoTemplate.find(query, Clase.class);

        for (Clase clase : clases) {
            clase.setSala(sala);
            mongoTemplate.save(clase); // Guardar la clase actualizada de nuevo en la base de datos
        }

        return salaUpdate;
    }
}
