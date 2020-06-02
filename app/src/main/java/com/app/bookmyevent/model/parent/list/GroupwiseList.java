
package com.app.bookmyevent.model.parent.list;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GroupwiseList{

    @SerializedName("Digital Events")
    @Expose
    private List<Object> digitalEvents = null;
    @SerializedName("Theatre")
    @Expose
    private List<String> theatre = null;
    @SerializedName("Events")
    @Expose
    private List<String> events = null;
    @SerializedName("Food")
    @Expose
    private List<Object> food = null;
    @SerializedName("Travel")
    @Expose
    private List<Object> travel = null;
    @SerializedName("Workshops")
    @Expose
    private List<Object> workshops = null;
    @SerializedName("Sports")
    @Expose
    private List<Object> sports = null;

    public List<Object> getDigitalEvents() {
        return digitalEvents;
    }

    public void setDigitalEvents(List<Object> digitalEvents) {
        this.digitalEvents = digitalEvents;
    }

    public List<String> getTheatre() {
        return theatre;
    }

    public void setTheatre(List<String> theatre) {
        this.theatre = theatre;
    }

    public List<String> getEvents() {
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }

    public List<Object> getFood() {
        return food;
    }

    public void setFood(List<Object> food) {
        this.food = food;
    }

    public List<Object> getTravel() {
        return travel;
    }

    public void setTravel(List<Object> travel) {
        this.travel = travel;
    }

    public List<Object> getWorkshops() {
        return workshops;
    }

    public void setWorkshops(List<Object> workshops) {
        this.workshops = workshops;
    }

    public List<Object> getSports() {
        return sports;
    }

    public void setSports(List<Object> sports) {
        this.sports = sports;
    }

}
