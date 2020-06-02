
package com.app.bookmyevent.model.parent;

import com.app.bookmyevent.model.banners.Banner;
import com.app.bookmyevent.model.parent.featured.Featured;
import com.app.bookmyevent.model.parent.list.List;
import com.app.bookmyevent.model.parent.popular.Popular;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParentModel {

    @SerializedName("tags")
    @Expose
    private java.util.List<Object> tags = null;
    @SerializedName("groups")
    @Expose
    private java.util.List<Object> groups = null;
    @SerializedName("filters")
    @Expose
    private Filters filters;
    @SerializedName("sorters")
    @Expose
    private Sorters sorters;
    @SerializedName("list")
    @Expose
    private List list;
    @SerializedName("picks")
    @Expose
    private Picks picks;
    @SerializedName("popular")
    @Expose
    private java.util.List<Popular> popular = null;
    @SerializedName("text")
    @Expose
    private Text text;
    @SerializedName("featured")
    @Expose
    private java.util.List<Featured> featured = null;
    @SerializedName("dates")
    @Expose
    private Dates dates;
    @SerializedName("banners")
    @Expose
    private java.util.List<Banner> banners = null;
    @SerializedName("digital_event_groups")
    @Expose
    private java.util.List<DigitalEventGroups> digitalEventGroups = null;
    @SerializedName("digital_event_groups_description")
    @Expose
    private String digitalEventGroupsDescription;

    public java.util.List<Object> getTags() {
        return tags;
    }

    public void setTags(java.util.List<Object> tags) {
        this.tags = tags;
    }

    public java.util.List<Object> getGroups() {
        return groups;
    }

    public void setGroups(java.util.List<Object> groups) {
        this.groups = groups;
    }

    public Filters getFilters() {
        return filters;
    }

    public void setFilters(Filters filters) {
        this.filters = filters;
    }

    public Sorters getSorters() {
        return sorters;
    }

    public void setSorters(Sorters sorters) {
        this.sorters = sorters;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Picks getPicks() {
        return picks;
    }

    public void setPicks(Picks picks) {
        this.picks = picks;
    }

    public java.util.List<Popular> getPopular() {
        return popular;
    }

    public void setPopular(java.util.List<Popular> popular) {
        this.popular = popular;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public java.util.List<Featured> getFeatured() {
        return featured;
    }

    public void setFeatured(java.util.List<Featured> featured) {
        this.featured = featured;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public java.util.List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(java.util.List<Banner> banners) {
        this.banners = banners;
    }

    public java.util.List<DigitalEventGroups> getDigitalEventGroups() {
        return digitalEventGroups;
    }

    public void setDigitalEventGroups(java.util.List<DigitalEventGroups> digitalEventGroups) {
        this.digitalEventGroups = digitalEventGroups;
    }

    public String getDigitalEventGroupsDescription() {
        return digitalEventGroupsDescription;
    }

    public void setDigitalEventGroupsDescription(String digitalEventGroupsDescription) {
        this.digitalEventGroupsDescription = digitalEventGroupsDescription;
    }

}
