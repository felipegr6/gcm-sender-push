package controllers;

import play.Logger;
import play.data.DynamicForm;
import play.mvc.Result;
import play.mvc.Controller;
import views.html.*;
import static play.data.Form.form;

public class GCM extends Controller {

	public Result index() {
		return ok(gcmindex.render());
	}

	public Result submit() {

		DynamicForm dynamicForm = form().bindFromRequest();

		Logger.info(dynamicForm.get("api_key"));

		return ok(dynamicForm.get("api_key"));

	}

}