package bf.sonabel.editor;

import bf.sonabel.dao.GenericDAO;
import bf.sonabel.models.Utilisateur;
import bf.sonabel.utils.Mail;
import org.primefaces.component.fileupload.FileUpload;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.Calendar;
import java.util.Date;

@ManagedBean(name = "editor")
public class EditorBean {


	private Date date = new Date();
	private String objet = "";
	private String value = "";

	private UploadedFile fupload;


	public void upload() {
		if(fupload != null) {
			//FacesMessage message = new FacesMessage("Succesful", fupload.getFileName() + " is uploaded.");
			//FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	private UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
	public void handleFileUpload(FileUploadEvent event) {
		System.out.println(file);
		System.out.println(event.getFile().getFileName());
	}

	public void envoyerEmail() {
		if (value != null) {
			GenericDAO<Utilisateur> uDAO = new GenericDAO<>();
			uDAO.setT(new Utilisateur());
			//System.out.println(fupload.getFileName());
			for (Utilisateur u : uDAO.getAll()) {
				Mail.envoyerEmail(u.getEmail(), objet, value.replace("##nom##", u.getNom()).replace("##prenom##",
						u.getPrenom()).replace("##mois##", String.valueOf(Calendar.getInstance().get(Calendar.MONTH))),"");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}



	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UploadedFile getFupload() {
		return fupload;
	}

	public void setFupload(UploadedFile fupload) {
		this.fupload = fupload;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}
}