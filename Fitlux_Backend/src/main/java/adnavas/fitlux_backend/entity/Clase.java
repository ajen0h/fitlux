package adnavas.fitlux_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "clases")
public class Clase {
    @Id
    private ObjectId _id;

    private LocalDateTime fechainicio;

    private LocalDateTime fechafin;

    private Usuario profesor;

    private ArrayList<Usuario> usuarios;

    private Deporte deporte;

    private Sala sala;

    private boolean activa;

    public Clase(LocalDateTime fechainicio, LocalDateTime fechafin, Usuario profesor, ArrayList<Usuario> usuarios, Deporte deporte, Sala sala, boolean activa) {
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.profesor = profesor;
        this.usuarios = usuarios;
        this.deporte = deporte;
        this.sala = sala;
        this.activa = activa;
    }
}
