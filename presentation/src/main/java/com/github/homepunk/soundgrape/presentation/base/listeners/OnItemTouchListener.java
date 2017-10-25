package com.github.homepunk.soundgrape.presentation.base.listeners;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;

/**
 * Created by Homepunk on 10.10.2017.
 **/

public class OnItemTouchListener implements RecyclerView.OnItemTouchListener {
    private final GestureDetector mGestureDetector;
    private final GestureListener mGestureListener;
    private final OnItemTouchEventListener mListener;

    public OnItemTouchListener(Context context, OnItemTouchEventListener listener) {
        mListener = listener;
        mGestureListener = new GestureListener();
        mGestureDetector = new GestureDetector(context, mGestureListener);
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        mGestureListener.setRecyclerView(view);
        mGestureDetector.onTouchEvent(e);

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private RecyclerView mRecyclerView;

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            View view = findView(e);
            if (validate(view)) {
                int position = findPosition(view);
                mListener.onItemClick(view, position);
            }
            return true;
        }


        @Override
        public void onLongPress(MotionEvent e) {
            View view = findView(e);
            if (validate(view)) {
                int position = findPosition(view);
                mListener.onItemLongClick(view, position);
            }
        }

        private boolean validate(View view) {
            if (view != null && mListener != null) {
                return true;
            } else {
                return false;
            }
        }

        private View findView(MotionEvent e) {
            View childView = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
            return childView;
        }

        private int findPosition(View view) {
            return mRecyclerView.getChildPosition(view);
        }

        public void setRecyclerView(RecyclerView mRecyclerView) {
            this.mRecyclerView = mRecyclerView;
        }
    }

    public interface OnItemTouchEventListener {
        public void onItemClick(View view, int position);

        public void onItemLongClick(View view, int position);
    }

    public static class SimpleItemTouchEventListener implements OnItemTouchEventListener {
        @Override
        public void onItemClick(View view, int position) {

        }

        @Override
        public void onItemLongClick(View view, int position) {

        }
    }
}