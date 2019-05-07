package bf.sonabel.models.dtos;

import bf.sonabel.models.Medecin;
import bf.sonabel.models.Patient;

import java.util.List;

public class ModelGeneric {

    private List<Patient> lstPatient;
    private List<Medecin> lstMedecin;

    public List<Patient> getLstPatient() {
        return lstPatient;
    }

    public void setLstPatient(List<Patient> lstPatient) {
        this.lstPatient = lstPatient;
    }

    public List<Medecin> getLstMedecin() {
        return lstMedecin;
    }

    public void setLstMedecin(List<Medecin> lstMedecin) {
        this.lstMedecin = lstMedecin;
    }
}
