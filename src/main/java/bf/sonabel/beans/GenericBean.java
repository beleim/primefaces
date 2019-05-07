package bf.sonabel.beans;


import bf.sonabel.dao.PatientDAO;
import bf.sonabel.models.Medecin;
import bf.sonabel.models.Patient;
import bf.sonabel.models.dtos.ModelGeneric;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.List;

@ManagedBean(name="generic")
@SessionScoped
public class GenericBean {

    private ModelGeneric modelGeneric;

    private Patient patient;

    //Permet de charger le contenu avant affichage de la page
    @PostConstruct
    public void initialization() {

        rechargement();
        patient = new Patient();
        //modelGeneric.setLstMedecin(pDao.getMedecinHibernate());
    }


    public void ajouterPatient() throws IOException{
        //patient = new Patient();
        //redirection("patientForm");
        modifierPatient(new Patient());
    }
    public void modifierPatient(Patient pat) throws IOException{
        patient = pat;
        redirection("patientForm");
    }

    public void supprimerPatient(Patient pat) throws IOException{
        PatientDAO pDao = new PatientDAO();
        pDao.deletePatientHibernate(pat);
        redirection("patients");
    }


    public void validerPatient() throws IOException{
        PatientDAO pDao = new PatientDAO();
        if(patient.getIdPatient() == null) {
            pDao.savePatientHibernate(patient);
        } else {
            pDao.updatePatientHibernate(patient);
        }
        //retourListPatients();
        redirection("patients");
    }

   /* public void retourListPatients() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("./patients.xhtml");
    }

    public void retourFormulairePatient() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("./patientForm.xhtml");
    }*/

    public void redirection(String page) throws IOException {
        rechargement();
        FacesContext.getCurrentInstance().getExternalContext().redirect("./"+page+".xhtml");
    }

    private void rechargement() {
        PatientDAO pDao = new PatientDAO();
        modelGeneric = new ModelGeneric();
        modelGeneric.setLstPatient(pDao.getPatientsHibernate());
    }


    public ModelGeneric getModelGeneric() {
        return modelGeneric;
    }

    public void setModelGeneric(ModelGeneric modelGeneric) {
        this.modelGeneric = modelGeneric;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
