package bf.sonabel.beans;


import bf.sonabel.dao.PatientDAO;
import bf.sonabel.models.Patient;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name="patients")
public class PatientsBean {

    private List<Patient> lstPatient;

    //Permet de charger le contenu avant affichage de la page
    @PostConstruct
    public void initialization() {

        PatientDAO pDao = new PatientDAO();
        lstPatient = pDao.getPatientsHibernate();
    }

    public List<Patient> getLstPatient() {
        return lstPatient;
    }

    public void setLstPatient(List<Patient> lstPatient) {
        this.lstPatient = lstPatient;
    }
}
