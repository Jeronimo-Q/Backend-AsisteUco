package co.edu.uco.asistenciauco.application.outputport.entity;

import co.edu.uco.asistenciauco.crosscutting.helpers.TextHelper;
import co.edu.uco.asistenciauco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "TipoIdentificacion")
public final class TipoIdentificacionEntity {

    @Id
    //TODO: Cuidado con dejar quemado el literal
    @Column(name = "id")
    private UUID id;
    //TODO: Cuidado con dejar quemado el literal
    @Column(name = "clave")
    private String clave;
    //TODO: Cuidado con dejar quemado el litera
    @Column(name = "nombre")
    private String nombre;

    public TipoIdentificacionEntity() {
        setDefaultId();
        initializeDefault();
    }

    public TipoIdentificacionEntity(final UUID id) {
        setId(id);
        initializeDefault();
    }

    public TipoIdentificacionEntity(final UUID id, final String clave, final String nombre) {
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
        //TODO: obtener valor por defecto
        //TODO: lo mas probable es que este valor este en algun lugar o algun parametro
        setId(UUIDHelper.generate());
    }

    public String getClave() {
        return clave;
    }

    public void setClave(final String clave) {
        //TODO: cuidado con la limpieza de datos para evitar datos nulos
        this.clave = TextHelper.applyTrim(clave);
    }

    private void setDefaultClave() {
        //TODO: obtener valor por defecto
        //TODO: lo mas probable es que este valor este en algun lugar o algun parametro
        //setClave(ApplyTrim.apply(clave));
        var defaultValue = "";
        setClave(defaultValue);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        //TODO: cuidado con la limpieza de datos para evitar datos nulos
        this.nombre = TextHelper.applyTrim(nombre);
    }

    private void setDefaultNombre() {
        //TODO: obtener valor por defecto
        //TODO: lo mas probable es que este valor este en algun lugar o algun parametro
        //setNombre(ApplyTrim.apply(nombre));
        var defaultValue = "";
        setNombre(defaultValue);
    }
}
