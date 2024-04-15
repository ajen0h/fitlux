package adnavas.fitlux_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "clases")
public class Clase {
    @Id
    private ObjectId _id;

    private LocalDateTime fechainicio;

    private LocalDateTime fechafin;

    private ObjectId profesor_id;

    private List<ObjectId> usuarios;

    private ObjectId deporte_id;

    private ObjectId sala_id;

    private boolean activa;

    public Clase(LocalDateTime fechainicio, LocalDateTime fechafin, ObjectId profesor_id, List<ObjectId> usuarios, ObjectId deporte_id, ObjectId sala_id, boolean activa) {
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.profesor_id = profesor_id;
        this.usuarios = usuarios;
        this.deporte_id = deporte_id;
        this.sala_id = sala_id;
        this.activa = activa;
    }
}
