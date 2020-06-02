
package com.app.bookmyevent.model.parent.list;

import com.app.bookmyevent.model.parent.list.masterlist.MasterList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class List {

    @SerializedName("masterList")
    @Expose
    private MasterList masterList;
    @SerializedName("groupwiseList")
    @Expose
    private GroupwiseList groupwiseList;
    @SerializedName("categorywiseList")
    @Expose
    private CategorywiseList categorywiseList;

    public MasterList getMasterList() {
        return masterList;
    }

    public void setMasterList(MasterList masterList) {
        this.masterList = masterList;
    }

    public GroupwiseList getGroupwiseList() {
        return groupwiseList;
    }

    public void setGroupwiseList(GroupwiseList groupwiseList) {
        this.groupwiseList = groupwiseList;
    }

    public CategorywiseList getCategorywiseList() {
        return categorywiseList;
    }

    public void setCategorywiseList(CategorywiseList categorywiseList) {
        this.categorywiseList = categorywiseList;
    }

}
