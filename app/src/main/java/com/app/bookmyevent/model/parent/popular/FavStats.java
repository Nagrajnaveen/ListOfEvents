
package com.app.bookmyevent.model.parent.popular;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FavStats {

    @SerializedName("target_id")
    @Expose
    private String targetId;
    @SerializedName("actualCount")
    @Expose
    private Integer actualCount;
    @SerializedName("prettyCount")
    @Expose
    private Integer prettyCount;

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public Integer getActualCount() {
        return actualCount;
    }

    public void setActualCount(Integer actualCount) {
        this.actualCount = actualCount;
    }

    public Integer getPrettyCount() {
        return prettyCount;
    }

    public void setPrettyCount(Integer prettyCount) {
        this.prettyCount = prettyCount;
    }

}
