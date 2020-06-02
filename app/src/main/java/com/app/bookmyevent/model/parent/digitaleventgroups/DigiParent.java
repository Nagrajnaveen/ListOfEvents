
package com.app.bookmyevent.model.parent.digitaleventgroups;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DigiParent {

    @SerializedName("tags")
    @Expose
    private java.util.List<String> tags = null;
    @SerializedName("groups")
    @Expose
    private java.util.List<String> groups = null;
    @SerializedName("popular")
    @Expose
    private java.util.List<Popular> popular = null;

    public java.util.List<String> getTags() {
        return tags;
    }

    public void setTags(java.util.List<String> tags) {
        this.tags = tags;
    }

    public java.util.List<String> getGroups() {
        return groups;
    }

    public void setGroups(java.util.List<String> groups) {
        this.groups = groups;
    }

    public java.util.List<Popular> getPopular() {
        return popular;
    }

    public void setPopular(java.util.List<Popular> popular) {
        this.popular = popular;
    }


}
