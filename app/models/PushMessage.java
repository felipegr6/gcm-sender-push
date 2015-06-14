package models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PushMessage {

    @SerializedName("collapse_key")
    private String collapseKey;
    @SerializedName("delay_while_idle")
    private Boolean delayWhileIdle;
    @SerializedName("registration_ids")
    private List<String> registrationIds;
    @SerializedName("data")
    private Payload payload;
    @SerializedName("time_to_live")
    private Integer ttl;

    public PushMessage(String collapseKey, Boolean delayWhileIdle, List<String> registrationId, Payload payload, Integer ttl) {

        this.collapseKey = collapseKey;
        this.delayWhileIdle = delayWhileIdle;
        this.registrationIds = registrationId;
        this.payload = payload;
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

    public Payload getPayload() {
        return payload;
    }

    public int getTtl() {
        return ttl;
    }

}
