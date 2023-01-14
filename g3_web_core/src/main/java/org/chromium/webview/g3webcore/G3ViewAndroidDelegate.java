package org.chromium.webview.g3webcore;


import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.VisibleForTesting;

import org.chromium.ui.base.ViewAndroidDelegate;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;


public class G3ViewAndroidDelegate extends ViewAndroidDelegate {
    private final Map<View, Position> mAnchorViews = new LinkedHashMap<>();

    private final G3ContentsClient mContentsClient;

    private static class Position {
        public final float mX;
        public final float mY;
        public final float mWidth;
        public final float mHeight;
        public final int mLeftMargin;
        public final int mTopMargin;

        public Position(float x, float y, float width, float height, int leftMargin,
                        int topMargin) {
            mX = x;
            mY = y;
            mWidth = width;
            mHeight = height;
            mLeftMargin = leftMargin;
            mTopMargin = topMargin;
        }
    }

    public G3ViewAndroidDelegate(ViewGroup containerView, G3ContentsClient contentsClient) {
        super(containerView);
        mContentsClient = contentsClient;
    }

    @Override
    public View acquireView() {
        ViewGroup containerView = getContainerView();
        if (containerView == null) return null;
        View anchorView = new View(containerView.getContext());
        containerView.addView(anchorView);
        mAnchorViews.put(anchorView, null);
        return anchorView;
    }

    @Override
    public void removeView(View anchorView) {
        mAnchorViews.remove(anchorView);
        ViewGroup containerView = getContainerView();
        if (containerView != null) {
            containerView.removeView(anchorView);
        }
    }

    @Override
    public void updateAnchorViews(ViewGroup oldContainerView) {
        for (Entry<View, Position> entry : mAnchorViews.entrySet()) {
            View anchorView = entry.getKey();
            Position position = entry.getValue();
            if (oldContainerView != null) {
                oldContainerView.removeView(anchorView);
            }
            mContainerView.addView(anchorView);
            if (position != null) {
                setViewPosition(anchorView, position.mX, position.mY, position.mWidth,
                        position.mHeight, position.mLeftMargin, position.mTopMargin);
            }
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setViewPosition(View anchorView, float x, float y, float width, float height,
                                int leftMargin, int topMargin) {
        ViewGroup containerView = getContainerView();
        if (!mAnchorViews.containsKey(anchorView) || containerView == null) return;

        mAnchorViews.put(anchorView, new Position(x, y, width, height, leftMargin, topMargin));

        if (containerView instanceof FrameLayout) {
            super.setViewPosition(anchorView, x, y, width, height, leftMargin, topMargin);
            return;
        }

        android.widget.AbsoluteLayout.LayoutParams lp =
                new android.widget.AbsoluteLayout.LayoutParams(
                        Math.round(width), Math.round(height), leftMargin, topMargin);
        anchorView.setLayoutParams(lp);
    }

    @Override
    public void onBackgroundColorChanged(int color) {
        mContentsClient.onBackgroundColorChanged(color);
    }
}
