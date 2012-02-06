package models;

import java.net.URL;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Document extends Model {

	public String title;
	public URL url;
	public String student_pin;
	
}
