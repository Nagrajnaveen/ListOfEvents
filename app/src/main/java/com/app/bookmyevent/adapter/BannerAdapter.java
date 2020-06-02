package com.app.bookmyevent.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.app.bookmyevent.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BannerAdapter extends PagerAdapter {

    private Context mContext;
    private List<String> mImageList;
    private LayoutInflater mInflater;
    private ImageView mImageView;

    public BannerAdapter(Context context, List<String> list){
        this.mImageList=list;
        this.mContext=context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mImageList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        mInflater= (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert mInflater != null;
        View view= mInflater.inflate(R.layout.banner_view_page_item,container,false);
        mImageView= view.findViewById(R.id.ban_Img);
        Picasso.get().load(mImageList.get(position)).
                into(mImageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
