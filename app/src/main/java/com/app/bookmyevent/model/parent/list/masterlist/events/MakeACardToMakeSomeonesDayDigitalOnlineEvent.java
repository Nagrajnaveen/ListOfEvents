
package com.app.bookmyevent.model.parent.list.masterlist.events;


import com.app.bookmyevent.model.parent.list.masterlist.CategoryId;
import com.app.bookmyevent.model.parent.list.masterlist.FavStats;
import com.app.bookmyevent.model.parent.list.masterlist.GroupId;
import com.app.bookmyevent.model.parent.list.masterlist.VenueGeolocation;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MakeACardToMakeSomeonesDayDigitalOnlineEvent {



    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("min_show_start_time")
    @Expose
    private Integer minShowStartTime;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("horizontal_cover_image")
    @Expose
    private String horizontalCoverImage;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("venue_id")
    @Expose
    private String venueId;
    @SerializedName("venue_name")
    @Expose
    private String venueName;
    @SerializedName("venue_date_string")
    @Expose
    private String venueDateString;
    @SerializedName("venue_geolocation")
    @Expose
    private VenueGeolocation venueGeolocation;
    @SerializedName("is_rsvp")
    @Expose
    private Boolean isRsvp;
    @SerializedName("category_id")
    @Expose
    private CategoryId categoryId;
    @SerializedName("group_id")
    @Expose
    private GroupId groupId;
    @SerializedName("event_state")
    @Expose
    private String eventState;
    @SerializedName("price_display_string")
    @Expose
    private String priceDisplayString;
    @SerializedName("action_button_text")
    @Expose
    private String actionButtonText;
    @SerializedName("communication_strategy")
    @Expose
    private String communicationStrategy;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("applicable_filters")
    @Expose
    private List<String> applicableFilters = null;
    @SerializedName("popularity_score")
    @Expose
    private Double popularityScore;
    @SerializedName("favStats")
    @Expose
    private FavStats favStats;
    @SerializedName("purchase_visibility")
    @Expose
    private String purchaseVisibility;
    @SerializedName("min_price")
    @Expose
    private Integer minPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMinShowStartTime() {
        return minShowStartTime;
    }

    public void setMinShowStartTime(Integer minShowStartTime) {
        this.minShowStartTime = minShowStartTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getHorizontalCoverImage() {
        return horizontalCoverImage;
    }

    public void setHorizontalCoverImage(String horizontalCoverImage) {
        this.horizontalCoverImage = horizontalCoverImage;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueDateString() {
        return venueDateString;
    }

    public void setVenueDateString(String venueDateString) {
        this.venueDateString = venueDateString;
    }

    public VenueGeolocation getVenueGeolocation() {
        return venueGeolocation;
    }

    public void setVenueGeolocation(VenueGeolocation venueGeolocation) {
        this.venueGeolocation = venueGeolocation;
    }

    public Boolean getIsRsvp() {
        return isRsvp;
    }

    public void setIsRsvp(Boolean isRsvp) {
        this.isRsvp = isRsvp;
    }

    public CategoryId getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(CategoryId categoryId) {
        this.categoryId = categoryId;
    }

    public GroupId getGroupId() {
        return groupId;
    }

    public void setGroupId(GroupId groupId) {
        this.groupId = groupId;
    }

    public String getEventState() {
        return eventState;
    }

    public void setEventState(String eventState) {
        this.eventState = eventState;
    }

    public String getPriceDisplayString() {
        return priceDisplayString;
    }

    public void setPriceDisplayString(String priceDisplayString) {
        this.priceDisplayString = priceDisplayString;
    }

    public String getActionButtonText() {
        return actionButtonText;
    }

    public void setActionButtonText(String actionButtonText) {
        this.actionButtonText = actionButtonText;
    }

    public String getCommunicationStrategy() {
        return communicationStrategy;
    }

    public void setCommunicationStrategy(String communicationStrategy) {
        this.communicationStrategy = communicationStrategy;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<String> getApplicableFilters() {
        return applicableFilters;
    }

    public void setApplicableFilters(List<String> applicableFilters) {
        this.applicableFilters = applicableFilters;
    }

    public Double getPopularityScore() {
        return popularityScore;
    }

    public void setPopularityScore(Double popularityScore) {
        this.popularityScore = popularityScore;
    }

    public FavStats getFavStats() {
        return favStats;
    }

    public void setFavStats(FavStats favStats) {
        this.favStats = favStats;
    }

    public String getPurchaseVisibility() {
        return purchaseVisibility;
    }

    public void setPurchaseVisibility(String purchaseVisibility) {
        this.purchaseVisibility = purchaseVisibility;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }
}
