package controllers;

import play.core.PlayVersion;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {

	public Result index() {
		return ok(index.render("Your new application is ready."));
	}

	public Result sobre() {
		return ok(sobre.render("Sobre o site", PlayVersion.current()));
	}

}