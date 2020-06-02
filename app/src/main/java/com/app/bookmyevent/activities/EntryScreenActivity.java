package com.app.bookmyevent.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
import com.app.bookmyevent.ConstantData;
import com.app.bookmyevent.R;
import com.app.bookmyevent.model.parent.ParentModel;
import com.app.bookmyevent.network.GetAllData;
import com.app.bookmyevent.network.RetrofitClient;
import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntryScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_screen);
        getAllData();
    }

    private void getAllData() {

        GetAllData apiCall=
                RetrofitClient.getRetrofitInstance().create(GetAllData.class);

        Call<ParentModel> call=apiCall.getAllData("1","go-out","bangalore");
        call.enqueue(new Callback<ParentModel>() {
            @Override
            public void onResponse(Call<ParentModel> call, Response<ParentModel> response) {
                assert response.body() != null;
                Gson gson= new Gson();

                SharedPreferences sharedPreferences= getSharedPreferences(ConstantData.MY_PREF, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString("response",gson.toJson(response.body()));
                editor.apply();

                Intent intent= new Intent(getApplicationContext(),HomePageActivity.class);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<ParentModel> call, Throwable t) {
                Toast.makeText(EntryScreenActivity.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getAllData();
    }
}
