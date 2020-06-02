package com.app.bookmyevent.adapter;

import android.content.Context;
import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.app.bookmyevent.R;
import com.app.bookmyevent.listeners.AdapterListeners;
import com.app.bookmyevent.listeners.OnItemClickListener;
import com.app.bookmyevent.listeners.OnItemPopClickListener;
import com.app.bookmyevent.model.parent.ParentModel;
import com.app.bookmyevent.model.parent.popular.Popular;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.MyViewHolder> {

    private Context mContext;
    private List<Popular> mParentMod;
    OnItemPopClickListener<Popular> mListener;

    public PopularAdapter(Context mContext, List<Popular> mParentMod,OnItemPopClickListener<Popular> listener) {
        this.mContext = mContext;
        this.mParentMod = mParentMod;
        this.mListener=listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.featu_view_pag_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Popular model= mParentMod.get(position);
        Picasso.get().load(model.getHorizontalCoverImage())
                .into(holder.mImageView);
        holder.mTitleTv.setText(model.getName());
        holder.mSubTit_one_tv.setText(model.getVenueDateString());
        holder.mSubTit_two_tv.setText(model.getVenueName());
        holder.mRupeeTv.setText("\u20B9"+model.getMinPrice().toString());
        holder.mFeatCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onPopItemClick(view,mParentMod.get(position),position);
            }
        });
//        holder.mRupeeTv.setText(model.getMinPrice());
    }

    @Override
    public int getItemCount() {
        return mParentMod.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private TextView mTitleTv;
        private TextView mSubTit_one_tv;
        private TextView mSubTit_two_tv;
        private TextView mRupeeTv;
        private CardView mFeatCv;

        public MyViewHolder(@NonNull View view) {
            super(view);
            mImageView= view.findViewById(R.id.pop_img_view);
            mTitleTv=view.findViewById(R.id.title_text_view);
            mSubTit_one_tv=view.findViewById(R.id.sub_title_one_tv);
            mSubTit_two_tv=view.findViewById(R.id.sub_title_two_tv);
            mFeatCv=view.findViewById(R.id.feat_cv);
                    mRupeeTv=view.findViewById(R.id.fees_tv);
        }
    }
}
