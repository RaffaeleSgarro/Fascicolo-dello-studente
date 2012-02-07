package controllers;

import models.Document;
import play.mvc.Controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Documents extends Controller {

	public static void index() {
		List<Document> documents = Document.findAll();
		render(documents);
	}
	
	public static void create(String url, String title, String student_pin) {
		if (url == null || title == null || student_pin == null) {
			render();
		} else {
			Document doc = new Document();
			doc.student_pin = student_pin;
			try {
				doc.url = new URL(url);
			} catch (MalformedURLException e) {
				render();
				return;
			}
			doc.title = title;
			doc.save();
			redirect("Documents.index");
		}
	}
	
	public static void edit() {}
	
	public static void delete(Long id) {
		Document doc = Document.findById(id);
		if (doc != null)
			doc.delete();
		redirect("Documents.index");
	}
}
