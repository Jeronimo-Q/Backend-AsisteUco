package co.edu.uco.asistenciauco.application.outputport.entity;

import co.edu.uco.asistenciauco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.asistenciauco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Sesion")
public final class SesionEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "grupo")
    private GrupoEntity grupo;

    @Column(name = "fechaHora")
    private LocalDateTime fechaHora;

    public SesionEntity() {
        setDefaultId();
        initializeDefault();
    }

    public SesionEntity(final UUID id) {
        setId(id);
        initializeDefault();
    }

    public SesionEntity(final UUID id, final GrupoEntity grupo, final LocalDateTime fechaHora) {
        setId(id);
        setGrupo(grupo);
        setFechaHora(fechaHora);
    }

    public void initializeDefault(){
        setDefaultGrupo();
        setDefaultFechaHora();
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }

    private void setDefaultId() {
        setId(UUIDHelper.generate());
    }

    public GrupoEntity getGrupo() {
        return grupo;
    }

    public void setGrupo(final GrupoEntity grupo) {
        this.grupo = ObjectHelper.getDefault(grupo, new GrupoEntity());
    }

    private void setDefaultGrupo() {
        setGrupo(new GrupoEntity());
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(final LocalDateTime fechaHora) {
        this.fechaHora = ObjectHelper.getDefault(fechaHora, LocalDateTime.now());
    }

    private void setDefaultFechaHora() {
        setFechaHora(LocalDateTime.now());
    }
}
