package controllers;

import static play.data.Form.form;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.PushMessage;
import play.Logger;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Constants;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import views.html.*;

public class GCM extends Controller {

	public Result index() {
		return ok(gcmindex.render());
	}

	public Result submit() {

		DynamicForm dynamicForm = form().bindFromRequest();
		List<String> regIds = new ArrayList<>();
		Map<String, String> campos = new HashMap<>();

		regIds.add(dynamicForm.get("reg_id"));

		campos.put(dynamicForm.get("lbl_campo1"), dynamicForm.get("txt_campo1"));
		campos.put(dynamicForm.get("lbl_campo2"), dynamicForm.get("txt_campo2"));
		campos.put(dynamicForm.get("lbl_campo3"), dynamicForm.get("txt_campo3"));

		PushMessage push = new PushMessage(null, null, regIds, campos, null);

		Gson gson = new Gson();

		OkHttpClient client = new OkHttpClient();
		String json = gson.toJson(push, PushMessage.class);
		RequestBody body = RequestBody.create(Constants.JSON, json);

		Logger.debug(json);

		Request requestOkHttp;
		requestOkHttp = new Request.Builder()
				.url(Constants.URL)
				.addHeader("Authorization", "key=" + dynamicForm.get("api_key"))
				.addHeader("Content-Type", "application/json").post(body)
				.build();

		StringBuilder sb = new StringBuilder();

		try {

			Response responseOkHttp = client.newCall(requestOkHttp).execute();

			sb.append("Código: ");
			sb.append(responseOkHttp.code());
			sb.append("<br />");
			sb.append("Status: ");
			sb.append(responseOkHttp.message());
			sb.append("<br />");
			sb.append(responseOkHttp.body().string());

		} catch (IOException ioE) {
			sb.append("Deu algum erro ao montar a mensagem.");
		}

		return ok(sb.toString());

	}

}