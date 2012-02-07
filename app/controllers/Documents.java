package controllers;

import models.Document;
import play.mvc.Controller;
import java.util.List;

public class Documents extends Controller {

	public static void index() {
		List<Document> documents = Document.findAll();
		render(documents);
	}
	
	public static void create() {
		render();
	}
	
	public static void edit() {}
	
	public static void delete() {}
}
