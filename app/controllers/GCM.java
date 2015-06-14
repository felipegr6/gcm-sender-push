package controllers;

import static play.data.Form.form;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Payload;
import models.PushMessage;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Constants;
import views.html.*;

public class GCM extends Controller {

	public Result index() {
		return ok(gcmindex.render());
	}

	public Result submit() {

		DynamicForm dynamicForm = form().bindFromRequest();
		List<String> regIds = new ArrayList<>();

		regIds.add(dynamicForm.get("reg_id"));

		Payload payload = new Payload(dynamicForm.get("titulo"),
				dynamicForm.get("mensagem"));
		PushMessage push = new PushMessage(null, null, regIds, payload, null);
		Gson gson = new Gson();

		OkHttpClient client = new OkHttpClient();
		String json = gson.toJson(push, PushMessage.class);
		RequestBody body = RequestBody.create(Constants.JSON, json);

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
			sb.append("Deu algum erro de montar a mensagem.");
		}

		return ok(sb.toString());

	}

}