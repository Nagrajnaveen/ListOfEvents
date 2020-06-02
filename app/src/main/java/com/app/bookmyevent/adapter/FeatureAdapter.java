package com.app.bookmyevent.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.bookmyevent.R;
import com.app.bookmyevent.listeners.OnItemClickListener;
import com.app.bookmyevent.model.parent.featured.Featured;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FeatureAdapter extends RecyclerView.Adapter<FeatureAdapter.MyViewHolder> {

    private Context mContext;
    private List<Featured> mParentMod;
    private OnItemClickListener<Featured> mListener;

    public FeatureAdapter(Context mContext, List<Featured> mParentMod, OnItemClickListener<Featured> listener) {
        this.mContext = mContext;
        this.mParentMod = mParentMod;
        this.mListener =listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pop_view_pager_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Featured model= mParentMod.get(position);
        Picasso.get().load(model.getVerticalCoverImage())
                .into(holder.mImageView);
        holder.mTitleTv.setText(model.getName());
        holder.mSubTit_one_tv.setText(model.getVenueDateString());
        holder.mSubTit_two_tv.setText(model.getVenueName());
        holder.mRupeeTv.setText(("\u20B9"+model.getMinPrice()).toString());

        holder.mPopCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            mListener.onItemClick(view,mParentMod.get(position),position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mParentMod.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {

        private ImageView mImageView;
        private TextView mTitleTv;
        private TextView mSubTit_one_tv;
        private TextView mSubTit_two_tv;
        private TextView mRupeeTv;
        private CardView mPopCV;

        public MyViewHolder(@NonNull View view) {
            super(view);
            mImageView= view.findViewById(R.id.pop_img_view);
            mTitleTv=view.findViewById(R.id.title_text_view2);
            mSubTit_one_tv=view.findViewById(R.id.sub_title_one_tv);
            mSubTit_two_tv=view.findViewById(R.id.sub_title_two_tv);
            mRupeeTv=view.findViewById(R.id.fees_tv);
            mPopCV=view.findViewById(R.id.pop_card);
        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }
}
