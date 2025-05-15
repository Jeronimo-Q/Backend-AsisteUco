package co.edu.uco.asistenciauco.application.outputport.entity;

import co.edu.uco.asistenciauco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.asistenciauco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Asistencia")
public final class AsistenciaEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "estudianteGrupo")
    private EstudianteGrupoEntity estudianteGrupo;

    @ManyToOne
    @JoinColumn(name = "sesion")
    private SesionEntity sesion;

    @Column(name = "asistio")
    private boolean asistio;

    public AsistenciaEntity() {
        setDefaultId();
        initializeDefault();
    }

    public AsistenciaEntity(final UUID id) {
        setId(id);
        initializeDefault();
    }

    public AsistenciaEntity(final UUID id, final EstudianteGrupoEntity estudianteGrupo, final SesionEntity sesion, final boolean asistio) {
        setId(id);
        setEstudianteGrupo(estudianteGrupo);
        setSesion(sesion);
        setAsistio(asistio);
    }

    public void initializeDefault(){
        setDefaultEstudianteGrupo();
        setDefaultSesion();
        setDefaultAsistio();
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

    public EstudianteGrupoEntity getEstudianteGrupo() {
        return estudianteGrupo;
    }

    public void setEstudianteGrupo(EstudianteGrupoEntity estudianteGrupo) {
        this.estudianteGrupo = ObjectHelper.getDefault(estudianteGrupo, new EstudianteGrupoEntity());
    }

    private void setDefaultEstudianteGrupo() {
        setEstudianteGrupo(new EstudianteGrupoEntity());
    }

    public SesionEntity getSesion() {
        return sesion;
    }

    public void setSesion(SesionEntity sesion) {
        this.sesion = ObjectHelper.getDefault(sesion, new SesionEntity());
    }

    private void setDefaultSesion() {
        setSesion(new SesionEntity());
    }

    public boolean isAsistio() {
        return asistio;
    }

    public void setAsistio(boolean asistio) {
        this.asistio = asistio;
    }

    private void setDefaultAsistio() {
        setAsistio(false);
    }
}
