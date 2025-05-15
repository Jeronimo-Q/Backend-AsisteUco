package co.edu.uco.asistenciauco.application.outputport.entity;

import co.edu.uco.asistenciauco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.asistenciauco.crosscutting.helpers.TextHelper;
import co.edu.uco.asistenciauco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Profesor")
public final class ProfesorEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "tipoIdentificacion")
    private TipoIdentificacionEntity tipoIdentificacion;

    @Column(name = "numeroIdentificacion")
    private String numeroIdentificacion;

    @Column(name = "nombresCompletos")
    private String nombresCompletos;

    public ProfesorEntity() {
        setDefaultId();
        initializeDefault();
    }

    public ProfesorEntity(final UUID id) {
        setId(id);
        initializeDefault();
    }

    public ProfesorEntity(final UUID id, final TipoIdentificacionEntity tipoIdentificacion, final String numeroIdentificacion,
                            final String nombresCompletos) {
        setId(id);
        setTipoIdentificacion(tipoIdentificacion);
        setNumeroIdentificacion(numeroIdentificacion);
        setNombresCompletos(nombresCompletos);
    }

    public void initializeDefault(){
        setDefaultTipoIdentificacion();
        setDefaultNumeroIdentificacion();
        setDefaultNombresCompletos();
    }

    public UUID getId() {
        return id;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }

    public void setDefaultId() {
        setId(UUIDHelper.generate());
    }

    public TipoIdentificacionEntity getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(final TipoIdentificacionEntity tipoIdentificacion) {
        this.tipoIdentificacion = ObjectHelper.getDefault(tipoIdentificacion, new TipoIdentificacionEntity());
    }

    private void setDefaultTipoIdentificacion() {
        setTipoIdentificacion(new TipoIdentificacionEntity());
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(final String numeroIdentificacion) {
        this.numeroIdentificacion = TextHelper.applyTrim(numeroIdentificacion);
    }

    private void setDefaultNumeroIdentificacion() {
        setNumeroIdentificacion(TextHelper.EMPTY);
    }

    public String getNombresCompletos() {
        return nombresCompletos;
    }

    public void setNombresCompletos(final String nombresCompletos) {
        this.nombresCompletos = TextHelper.applyTrim(nombresCompletos);
    }

    private void setDefaultNombresCompletos() {
        setNombresCompletos(TextHelper.EMPTY);
    }
}
