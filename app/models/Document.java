package models;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Document extends Model {

	@Required
	public String title;
	
	@Required
	public String url;
	
	@Required
	public String studentPin;
	
	public static List<Document> findByStudentPin(String student_pin) {
		return Document.find("byStudentPin", student_pin).fetch();
	}

}
