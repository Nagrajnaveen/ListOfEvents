package com.app.bookmyevent.listeners;

import android.view.View;

public interface OnItemClickListener<T> {
    void onItemClick(View view,T model,int position);
}
