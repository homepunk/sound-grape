package com.github.homepunk.soundgrape.presentation.browser.adapter.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.github.homepunk.soundgrape.databinding.ItemGrapeBinding;
import com.github.homepunk.soundgrape.presentation.browser.model.GrapeModel;
import com.github.homepunk.soundgrape.presentation.browser.viewmodel.GrapeItemViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Homepunk on 10.10.2017.
 **/

public class GrapeAdapter extends RecyclerView.Adapter<GrapeAdapter.GrapeHolder> {
    private List<GrapeModel> grapeList;

    public GrapeAdapter() {
        this.grapeList = new ArrayList<>();
    }

    @Override
    public GrapeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemGrapeBinding grapeBinding = ItemGrapeBinding.inflate(inflater, parent, false);
        return new GrapeHolder(grapeBinding);
    }

    @Override
    public void onBindViewHolder(GrapeHolder holder, int position) {
        holder.bind(grapeList.get(position));
    }

    @Override
    public int getItemCount() {
        return grapeList.size();
    }

    public void setGrapeList(List<GrapeModel> grapeModelList) {
        this.grapeList = grapeModelList;
    }

    public static class GrapeHolder extends RecyclerView.ViewHolder {
        private final ItemGrapeBinding binding;

        public GrapeHolder(ItemGrapeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(GrapeModel grapeModel) {
            binding.setViewModel(new GrapeItemViewModel(grapeModel));
        }
    }
}
