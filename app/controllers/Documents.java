package controllers;

import models.Document;
import play.data.validation.Valid;
import play.mvc.Controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Documents extends Controller {

	public static void index() {
		List<Document> documents = Document.all().fetch(1000);
		render(documents);
	}
	
	public static void findByStudentPin(String student_pin) {
		List<Document> documents = Document.findByStudentPin(student_pin);
		render("@index", documents);
	}
	
	public static void save(@Valid Document document) {
		if (validation.hasErrors()) {
			render("@form", document);
		}
		document.save();
		redirect("Documents.index");
	}
	
	public static void form(Long id) {
		Document document = Document.findById(id);
		render("@form", document);
	}
	
	public static void delete(Long id) {
		Document doc = Document.findById(id);
		if (doc != null)
			doc.delete();
		redirect("Documents.index");
	}
}
