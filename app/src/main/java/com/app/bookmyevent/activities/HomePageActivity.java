package com.app.bookmyevent.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.app.bookmyevent.ConstantData;
import com.app.bookmyevent.R;
import com.app.bookmyevent.adapter.BannerAdapter;
import com.app.bookmyevent.adapter.FeatureAdapter;
import com.app.bookmyevent.adapter.PopularAdapter;
import com.app.bookmyevent.databinding.ActivityHomePageBinding;
import com.app.bookmyevent.listeners.OnItemClickListener;
import com.app.bookmyevent.listeners.OnItemPopClickListener;
import com.app.bookmyevent.model.parent.DigitalEventGroups;
import com.app.bookmyevent.model.parent.ParentModel;
import com.app.bookmyevent.model.parent.featured.Featured;
import com.app.bookmyevent.model.parent.popular.Popular;
import com.app.bookmyevent.network.ConnectionDetector;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import timber.log.Timber;

public class HomePageActivity extends AppCompatActivity implements OnItemClickListener<Featured>, OnItemPopClickListener<Popular> {

    SharedPreferences mPreferences;
    private String mPrefData;
    private RecyclerView mRecyclerView;
    ActivityHomePageBinding mBinding;
    private  ViewPager mBanViewPager;
    private BroadcastReceiver mReceiver;

    final List<String> mBannerImgList =new ArrayList<>();
    private List<Popular> mPopList=new ArrayList<>();
    private List<Featured> mFeatList= new ArrayList<>();
    private List<DigitalEventGroups> mDigiList = new ArrayList<>();

    final long DELAY_MS = 500;
    final long PERIOD_MS = 3000;
    ConnectionDetector mConnectionDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_home_page);
        mConnectionDetector= new ConnectionDetector(getApplicationContext());

        getApplicationContext().registerReceiver(checkConnectivity(mConnectionDetector),
                                new IntentFilter(ConnectivityManager.EXTRA_NO_CONNECTIVITY));
        mPrefData= getPref();
        Gson gson= new Gson();
        ParentModel model=gson.fromJson(mPrefData,ParentModel.class);
        Timber.i(String.valueOf(model.getList().getMasterList()));
        setBanViewPager(model);
        setPopRecyView(model);
        setFeatRecyView(model);

    }

    private void setFeatRecyView(ParentModel model) {
        mFeatList=model.getFeatured();

        mRecyclerView= mBinding.featRv;
        FeatureAdapter mFeatAdapter = new FeatureAdapter(getApplicationContext(), mFeatList, this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mFeatAdapter);

    }

    private void setPopRecyView(ParentModel model) {
        mPopList=model.getPopular();
        mRecyclerView= mBinding.popRv;
        PopularAdapter mPopAdapter = new PopularAdapter(getApplicationContext(), mPopList, this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mPopAdapter);

    }


    private void setBanViewPager(ParentModel model) {

        for (int i=0;i<model.getBanners().size();i++){
            mBannerImgList.add(model.getBanners().get(i).getVerticalCoverImage());
        }
        BannerAdapter mBanAdapter = new BannerAdapter(getApplicationContext(), mBannerImgList);
        mBanViewPager = findViewById(R.id.ban_view_pager);
        mBanViewPager.setAdapter(mBanAdapter);

        slideImage();
    }

    private void slideImage() {
        final Handler handler= new Handler();
        final int[] currentPage = {0};
        final Runnable runnable= new Runnable() {
            @Override
            public void run() {
                if (currentPage[0] ==mBannerImgList.size()-1){
                    currentPage[0] =-1;
                }
                mBanViewPager.setCurrentItem(currentPage[0]++,true);
            }
        };
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        },DELAY_MS,PERIOD_MS);

        mBanViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                timer.cancel();
                return false;
            }
        });
    }

    public String getPref(){
        mPreferences=getSharedPreferences(ConstantData.MY_PREF, Context.MODE_PRIVATE);
        return mPreferences.getString("response",null);
    }

    private boolean flag=false;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        mPreferences= getApplicationContext().getSharedPreferences(ConstantData.MY_PREF,MODE_PRIVATE);
//        SharedPreferences.Editor editor=mPreferences.edit();
//        editor.clear();
//        editor.apply();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);

    }

    @Override
    public void onItemClick(View view, Featured model, int position) {
        Intent intent= new Intent(HomePageActivity.this,DetailsActivity.class);
        intent.putExtras(loadFeatBundle(position));
        startActivity(intent);
    }

    private Bundle loadFeatBundle(int pos) {

        Featured featured=mFeatList.get(pos);
        Bundle bundle = new Bundle();
        bundle.putString("name",featured.getName());
        bundle.putString("imagurl",featured.getHorizontalCoverImage());
        bundle.putString("venu_name",featured.getVenueName());
        bundle.putString("venu_date",featured.getVenueDateString());
        bundle.putString("title_desc",featured.getGroupId().getDisplayDetails().getSeoTitle());
        bundle.putString("desc",featured.getGroupId().getDisplayDetails().getSeoDescription());
        bundle.putString("price",featured.getMinPrice().toString());
        return bundle;

    }

    @Override
    public void onPopItemClick(View view, Popular model, int position) {
        Intent intent= new Intent(HomePageActivity.this,DetailsActivity.class);
        intent.putExtras(loadPopBundle(position));
        startActivity(intent);
    }

    private Bundle loadPopBundle(int pos) {

        Popular popular=mPopList.get(pos);
        Bundle bundle = new Bundle();
        bundle.putString("name",popular.getName());
        bundle.putString("imagurl",popular.getHorizontalCoverImage());
        bundle.putString("venu_name",popular.getVenueName());
        bundle.putString("venu_date",popular.getVenueDateString());
        bundle.putString("title_desc",popular.getGroupId().getDisplayDetails().getSeoTitle());
        bundle.putString("desc",popular.getGroupId().getDisplayDetails().getSeoDescription());
        bundle.putString("price",popular.getMinPrice().toString());
        return bundle;

    }

//    @Override
//    public void onDEGItemClick(View view, DigitalEventGroups model, int position) {
//        Intent intent= new Intent(HomePageActivity.this,DigiEventGrpActivity.class);
//        DigitalEventGroups groups=mDigiList.get(position);
//        intent.putExtra("url",groups.getUrl());
//        intent.putExtra("title",groups.getTitle());
//    }



    @Override
    protected void onResume() {
        super.onResume();
       getApplicationContext().registerReceiver(mReceiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    public BroadcastReceiver checkConnectivity(ConnectionDetector cd){
        mReceiver= new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                if(!cd.isConnected()){
                    showFailDialog();
                }
            }
        };
        return mReceiver;
    }
    public void showFailDialog() {
        final Dialog dialog = new Dialog(HomePageActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_warning);
        dialog.setCancelable(true);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;


        ((AppCompatButton) dialog.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }

}
