package com.github.homepunk.soundgrape.presentation.browser.adapter.binding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.homepunk.soundgrape.presentation.base.listeners.OnItemTouchListener;
import com.github.homepunk.soundgrape.presentation.browser.adapter.recycler.GrapeAdapter;

/**
 * Created by Homepunk on 11.10.2017.
 **/

public class RecyclerBindingAdapter {
    @BindingAdapter({"app:adapter", "app:onItemTouch", "app:gridLayoutManager"})
    public static void setUpRecycler(RecyclerView recycler, GrapeAdapter grapeAdapter, OnItemTouchListener.OnItemTouchEventListener onItemTouchEventListener, int spanCount) {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(recycler.getContext(), spanCount);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(grapeAdapter);
        recycler.addOnItemTouchListener(new OnItemTouchListener(recycler.getContext(), onItemTouchEventListener));
    }
}
