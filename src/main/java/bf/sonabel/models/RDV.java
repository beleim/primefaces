/**
 * La classe Patient
 * créé par : DevSonabel
 * date : 02/05/2019
 **/
package bf.sonabel.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Rdvs")
public class RDV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRdv;
    private Date dateRDV;

    public Long getIdRdv() {
        return idRdv;
    }

    public void setIdRdv(Long idRdv) {
        this.idRdv = idRdv;
    }

    public Date getDateRDV() {
        return dateRDV;
    }

    public void setDateRDV(Date dateRDV) {
        this.dateRDV = dateRDV;
    }
}