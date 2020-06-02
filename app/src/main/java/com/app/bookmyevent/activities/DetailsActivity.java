package com.app.bookmyevent.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.app.bookmyevent.R;
import com.app.bookmyevent.databinding.ActivityDetailsBinding;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener{

    private String mName;
    private String mImageUrl;
    private String mVenueName;
    private String mVenue_date;
    private String mTitleDesc;
    private String mDesc;
    private String mPrice;
    ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_details);
        binding.arrowBack.setOnClickListener(this);
        getBundle();
        setData();
    }

    private void setData() {
        binding.titleTv.setText(mName);
        Picasso.get().load(mImageUrl).into(binding.horzCoverImg);
        binding.subTitOneTv.setText(mVenue_date);
        binding.subTitTwo.setText(mVenueName);
        binding.descTitTv.setText(mTitleDesc);
        binding.descTv.setText(mDesc);
        binding.feesTv.setText("\u20B9"+mPrice+" onwards");
    }

    void getBundle(){
        Bundle bundle= getIntent().getExtras();
        assert bundle != null;
        mName=bundle.getString("name",null);
        mImageUrl=bundle.getString("imagurl",null);
        mVenue_date=bundle.getString("venu_date",null);
        mVenueName=bundle.getString("venu_name",null);
        mTitleDesc=bundle.getString("title_desc",null);
        mDesc=bundle.getString("desc",null);
        mPrice=bundle.getString("price",null);

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.arrow_back){
            finish();
        }
    }
}
