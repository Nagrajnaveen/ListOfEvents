
package com.app.bookmyevent.model.parent.featured;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GroupId {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("icon_img")
    @Expose
    private String iconImg;
    @SerializedName("display_details")
    @Expose
    private DisplayDetails_ displayDetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconImg() {
        return iconImg;
    }

    public void setIconImg(String iconImg) {
        this.iconImg = iconImg;
    }

    public DisplayDetails_ getDisplayDetails() {
        return displayDetails;
    }

    public void setDisplayDetails(DisplayDetails_ displayDetails) {
        this.displayDetails = displayDetails;
    }

}
