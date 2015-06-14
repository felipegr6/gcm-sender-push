package controllers;

import static play.data.Form.form;

import com.google.gson.Gson;

import models.FormGcm;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class GCM extends Controller {

	public Result index() {
		return ok(gcmindex.render());
	}

	public Result submit() {

		DynamicForm dynamicForm = form().bindFromRequest();

		FormGcm gcm = new FormGcm(dynamicForm.get("api_key"),
				dynamicForm.get("reg_id"), dynamicForm.get("titulo"),
				dynamicForm.get("mensagem"));

		return ok(new Gson().toJson(gcm));

	}

}