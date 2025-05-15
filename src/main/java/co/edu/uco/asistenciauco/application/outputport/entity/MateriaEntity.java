package co.edu.uco.asistenciauco.application.outputport.entity;

import co.edu.uco.asistenciauco.crosscutting.helpers.TextHelper;
import co.edu.uco.asistenciauco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "Materia")
public final class MateriaEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "clave")
    private String clave;

    @Column(name = "nombre")
    private String nombre;

    public MateriaEntity() {
        setDefaultId();
        initializeDefault();
    }

    public MateriaEntity(final UUID id) {
        setId(id);
        initializeDefault();
    }

    public MateriaEntity(final UUID id, final String clave, final String nombre) {
        setId(id);
        setClave(clave);
        setNombre(nombre);
    }

    public void initializeDefault(){
        setDefaultClave();
        setDefaultNombre();
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

    public String getClave() {
        return clave;
    }

    public void setClave(final String clave) {
        this.clave = TextHelper.applyTrim(clave);
    }

    private void setDefaultClave() {
        setClave(TextHelper.EMPTY);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }

    private void setDefaultNombre() {
        setNombre(TextHelper.EMPTY);
    }
}
