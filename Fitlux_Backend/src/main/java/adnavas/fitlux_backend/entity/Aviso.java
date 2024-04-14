package adnavas.fitlux_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "avisos")
public class Aviso {
    @Id
    private ObjectId _id;
    private Usuario usuario;
    private String mensaje;

    public Aviso(Usuario usuario, String mensaje) {
        this.usuario = usuario;
        this.mensaje = mensaje;
    }
}
