package com.github.homepunk.soundgrape.presentation.browser.viewmodel;

import android.view.View;

import com.github.homepunk.soundgrape.R;
import com.github.homepunk.soundgrape.presentation.base.BaseViewModel;
import com.github.homepunk.soundgrape.presentation.base.listeners.OnItemTouchListener;
import com.github.homepunk.soundgrape.presentation.browser.adapter.recycler.GrapeAdapter;
import com.github.homepunk.soundgrape.presentation.browser.model.GrapeModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by Homepunk on 18.10.2017.
 **/

public class GrapeListViewModel extends BaseViewModel {
    private final int spanCount;
    private final List<GrapeModel> grapeList;
    private final GrapeAdapter grapeAdapter;
    private final OnItemTouchListener.OnItemTouchEventListener onItemTouchEventListener;
    private final PublishSubject<GrapeModel> grapeItemEventStream = PublishSubject.create();

    public GrapeListViewModel() {
        spanCount = 3;
        grapeList = new ArrayList<>();
        grapeList.add(new GrapeModel("youtube", "www.youtube.com", R.color.red_youtube));
        grapeList.add(new GrapeModel("soundcloud", "www.soundcloud.com", R.color.orange_soundcloud));
        grapeList.add(new GrapeModel("spotify", "www.spotify.com", R.color.green_spotify));
        grapeAdapter = new GrapeAdapter();
        grapeAdapter.setGrapeList(grapeList);
        onItemTouchEventListener = new OnItemTouchListener.SimpleItemTouchEventListener() {
            @Override
            public void onItemClick(View view, int position) {
                grapeItemEventStream.onNext(grapeList.get(position));
            }
        };
    }

    public GrapeAdapter getGrapeAdapter() {
        return grapeAdapter;
    }

    public int getSpanCount() {
        return spanCount;
    }

    public OnItemTouchListener.OnItemTouchEventListener getOnItemTouchEventListener() {
        return onItemTouchEventListener;
    }

    public PublishSubject<GrapeModel> getGrapeItemEventStream() {
        return grapeItemEventStream;
    }
}
