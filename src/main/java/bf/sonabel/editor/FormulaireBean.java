package bf.sonabel.editor;


import javax.faces.bean.ManagedBean;
import java.util.Date;

@ManagedBean(name="formulaire")
public class FormulaireBean {


    private String nom;
    private String prenom;
    private Date dateNaissance;


    public void valider() {

        System.out.println(this.nom);
        System.out.println(this.prenom);
        System.out.println(this.dateNaissance);

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
