package controllers;

import play.mvc.Result;
import play.mvc.Controller;
import views.html.*;

public class GCM extends Controller {

	public Result index() {
		return ok(gcmindex.render());
	}
	
}
