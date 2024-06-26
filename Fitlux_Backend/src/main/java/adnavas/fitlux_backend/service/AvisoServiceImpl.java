package adnavas.fitlux_backend.service;

import adnavas.fitlux_backend.entity.Aviso;
import adnavas.fitlux_backend.entity.Clase;
import adnavas.fitlux_backend.repository.AvisoRepository;
import adnavas.fitlux_backend.repository.UsuarioRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvisoServiceImpl implements AvisoService {
    @Autowired
    AvisoRepository avisoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Aviso> findAll() {
        return avisoRepository.findAll();
    }

    @Override
    public Aviso findById(ObjectId id) {
        return avisoRepository.findBy_id(id);
    }

    @Override
    public Aviso findByUsuario_id(ObjectId userId) {
        return avisoRepository.findByUsuario_id(userId);
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
        avisoUpdate.setUsuario_id(aviso.getUsuario_id());
        avisoUpdate.setMensaje(aviso.getMensaje());
        avisoRepository.save(avisoUpdate);
        return avisoUpdate;
    }

    @Override
    public boolean notificarUsuariosClase(String mensaje, Clase clase) {
        try {
            List<ObjectId> usuariosClase = clase.getUsuarios();
            for (ObjectId idUser : usuariosClase) {
                Aviso aviso = new Aviso(idUser,mensaje);
                avisoRepository.save(aviso);
                //TODO CUANDO SE IMPLEMENTE MANDAR CORREO IRÁ AQUI
            }
            return true;
        } catch (Exception ex) {
            return false;
        }

    }
}
