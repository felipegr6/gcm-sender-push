package models;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class PushMessage {

	@SerializedName("collapse_key")
	private String collapseKey;
	@SerializedName("delay_while_idle")
	private Boolean delayWhileIdle;
	@SerializedName("registration_ids")
	private List<String> registrationIds;
	@SerializedName("data")
	private Map<String, String> mapPayload;
	@SerializedName("time_to_live")
	private Integer ttl;

	public PushMessage(String collapseKey, Boolean delayWhileIdle,
			List<String> registrationId, Map<String, String> mapPayload,
			Integer ttl) {

		this.collapseKey = collapseKey;
		this.delayWhileIdle = delayWhileIdle;
		this.registrationIds = registrationId;
		this.mapPayload = mapPayload;
		this.ttl = ttl;

	}

	public String getCollapseKey() {
		return collapseKey;
	}

	public boolean isDelayWhileIdle() {
		return delayWhileIdle;
	}

	public List<String> getRegistrationIds() {
		return registrationIds;
	}

	public int getTtl() {
		return ttl;
	}

}