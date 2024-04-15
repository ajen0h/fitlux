package adnavas.fitlux_backend.service;

import adnavas.fitlux_backend.entity.Aviso;
import adnavas.fitlux_backend.repository.AvisoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvisoServiceImpl implements AvisoService{
    @Autowired
    AvisoRepository avisoRepository;

    @Override
    public List<Aviso> findAll() {
        return avisoRepository.findAll();
    }

    @Override
    public Aviso findById(ObjectId id) {
        return avisoRepository.findBy_id(id);
    }

    @Override
    public Aviso addAviso(Aviso aviso) {
        return avisoRepository.save(aviso);
    }

    @Override
    public Aviso deleteAviso(ObjectId id) {
        Aviso avisoDelete = avisoRepository.findBy_id(id);
        avisoRepository.delete(avisoDelete);
        return avisoDelete;
    }

    @Override
    public Aviso updateAviso(ObjectId id, Aviso aviso) {
        Aviso avisoUpdate = avisoRepository.findBy_id(id);
        avisoUpdate.setUsuario(aviso.getUsuario());
        avisoUpdate.setMensaje(aviso.getMensaje());
        avisoRepository.save(avisoUpdate);
        return avisoUpdate;
    }
}
