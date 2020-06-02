package com.app.bookmyevent.listeners;

import android.view.View;

public interface OnItemPopClickListener<T> {
    void onPopItemClick(View view, T model, int position);
}
