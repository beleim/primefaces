package bf.sonabel.editor;

import org.primefaces.component.fileupload.FileUpload;

import javax.faces.bean.ManagedBean;
import java.util.Date;

@ManagedBean(name = "editor")
public class EditorBean {


	private Date date = new Date();
	private String value = "This editor is provided by PrimeFaces";

	private FileUpload fupload;
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

	public FileUpload getFupload() {
		return fupload;
	}

	public void setFupload(FileUpload fupload) {
		this.fupload = fupload;
	}
}