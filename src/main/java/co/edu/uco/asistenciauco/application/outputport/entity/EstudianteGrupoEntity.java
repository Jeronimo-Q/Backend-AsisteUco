package co.edu.uco.asistenciauco.application.outputport.entity;

import co.edu.uco.asistenciauco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.asistenciauco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "EstudianteGrupo")
public final class EstudianteGrupoEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "grupo")
    private GrupoEntity grupo;

    @ManyToOne
    @JoinColumn(name = "estudiante")
    private EstudianteEntity estudiante;

    public EstudianteGrupoEntity() {
        setDefaultId();
        initializeDefault();
    }

    public EstudianteGrupoEntity(final UUID id) {
        setId(id);
        initializeDefault();
    }

    public EstudianteGrupoEntity(final UUID id, final GrupoEntity grupo, final EstudianteEntity estudiante) {
        setId(id);
        setGrupo(grupo);
        setEstudiante(estudiante);
    }

    public void initializeDefault(){
        setDefaultGrupo();
        setDefaultEstudiante();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }

    private void setDefaultId() {
        setId(UUIDHelper.generate());
    }

    public GrupoEntity getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoEntity grupo) {
        this.grupo = ObjectHelper.getDefault(grupo, new GrupoEntity());
    }

    private void setDefaultGrupo() {
        setGrupo(new GrupoEntity());
    }

    public EstudianteEntity getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteEntity estudiante) {
        this.estudiante = ObjectHelper.getDefault(estudiante, new EstudianteEntity());
    }

    private void setDefaultEstudiante() {
        setEstudiante(new EstudianteEntity());
    }
}
