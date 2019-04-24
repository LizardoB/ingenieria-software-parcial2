package gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "parcial2_cabecera_factura")
public class CabeceraFacturaEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nombre_cliente")
    private String clientName;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "nit")
    private String nit;
    
    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;

    public CabeceraFacturaEntity() {
    }

    public CabeceraFacturaEntity(String clientName, String direccion, String nit, Date date) {
        this.clientName = clientName;
        this.direccion = direccion;
        this.nit = nit;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
