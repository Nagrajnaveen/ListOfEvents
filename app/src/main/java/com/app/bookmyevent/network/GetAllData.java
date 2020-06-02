package com.app.bookmyevent.network;

import com.app.bookmyevent.model.parent.ParentModel;
import com.app.bookmyevent.model.parent.digitaleventgroups.DigiParent;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetAllData {

    @GET("home")
    Call<ParentModel> getAllData(@Query("norm")String norm, @Query("filterBy") String filter, @Query("city") String city);
    @GET("home")
    Call<DigiParent> getGrpData(@Query("norm")String norm, @Query("filterBy") String filter, @Query("city") String city);

}
