package bf.sonabel.models;

import javax.persistence.*;
import java.util.List;

/**
 * La classe Medecin
 * créé par : DevSonabel
 * date : 03/05/2019
 **/
@Entity
@Table(name="Medecins")
public class Medecin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedecin;

    private String nomMedecin;

    public Long getIdMedecin() {
        return this.idMedecin;
    }

    public void setIdMedecin(Long idMedecin) {
        this.idMedecin = idMedecin;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        this.nomMedecin = nomMedecin;
    }
}