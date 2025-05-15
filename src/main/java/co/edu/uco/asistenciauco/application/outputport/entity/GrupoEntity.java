package co.edu.uco.asistenciauco.application.outputport.entity;

import co.edu.uco.asistenciauco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.asistenciauco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Grupo")
public final class GrupoEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "profesor")
    private ProfesorEntity profesor;

    @ManyToOne
    @JoinColumn(name = "materia")
    private MateriaEntity materia;

    @Column(name = "cantidadEstudiantes")
    private int cantidadEstudiantes;

    public GrupoEntity() {
        setDefaultId();
        initializeDefault();
    }

    public GrupoEntity(final UUID id) {
        setId(id);
        initializeDefault();
    }

    public GrupoEntity(final UUID id, final ProfesorEntity profesor, final MateriaEntity materia, final int cantidadEstudiantes) {
        setId(id);
        setProfesor(profesor);
        setMateria(materia);
        setCantidadEstudiantes(cantidadEstudiantes);
    }

    public void initializeDefault(){
        setDefaultProfesor();
        setDefaultMateria();
        setDefaultCantidadEstudiantes();
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

    public ProfesorEntity getProfesor() {
        return profesor;
    }

    public void setProfesor(final ProfesorEntity profesor) {
        this.profesor = ObjectHelper.getDefault(profesor, new ProfesorEntity());
    }

    private void setDefaultProfesor() {
        setProfesor(new ProfesorEntity());
    }

    public MateriaEntity getMateria() {
        return materia;
    }

    public void setMateria(final MateriaEntity materia) {
        this.materia = ObjectHelper.getDefault(materia, new MateriaEntity());
    }

    private void setDefaultMateria() {
        setMateria(new MateriaEntity());
    }

    public int getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }

    public void setCantidadEstudiantes(final int cantidadEstudiantes) {
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

    private void setDefaultCantidadEstudiantes() {
        int defaultValue = 0;
        setCantidadEstudiantes(defaultValue);
    }
}
