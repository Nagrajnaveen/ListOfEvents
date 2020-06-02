
package com.app.bookmyevent.model.banners;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DisplayDetails {

    @SerializedName("link_type")
    @Expose
    private String linkType;
    @SerializedName("link_slug")
    @Expose
    private String linkSlug;

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public String getLinkSlug() {
        return linkSlug;
    }

    public void setLinkSlug(String linkSlug) {
        this.linkSlug = linkSlug;
    }

}
