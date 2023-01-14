// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.webview.g3webcore;

import android.annotation.SuppressLint;
import android.os.Build;
import android.webkit.WebSettings;


@SuppressWarnings({"deprecation", "NoSynchronizedMethodCheck"})
public class ContentSettingsAdapter extends WebSettings {
    private G3Settings mG3Settings;
    private PluginState mPluginState = PluginState.OFF;

    public ContentSettingsAdapter(G3Settings awSettings) {
        mG3Settings = awSettings;
    }

    public G3Settings getG3Settings() {
        return mG3Settings;
    }

//    @Override
//    @Deprecated
//    public void setNavDump(boolean enabled) {
//        // Intentional no-op.
//    }
//
//    @Override
//    @Deprecated
//    public boolean getNavDump() {
//        // Intentional no-op.
//        return false;
//    }

    @Override
    public void setSupportZoom(boolean support) {
        mG3Settings.setSupportZoom(support);
    }

    @Override
    public boolean supportZoom() {
        return mG3Settings.supportZoom();
    }

    @Override
    public void setBuiltInZoomControls(boolean enabled) {
        mG3Settings.setBuiltInZoomControls(enabled);
    }

    @Override
    public boolean getBuiltInZoomControls() {
        return mG3Settings.getBuiltInZoomControls();
    }

    @Override
    public void setDisplayZoomControls(boolean enabled) {
        mG3Settings.setDisplayZoomControls(enabled);
    }

    @Override
    public boolean getDisplayZoomControls() {
        return mG3Settings.getDisplayZoomControls();
    }

    @Override
    public void setAllowFileAccess(boolean allow) {
        mG3Settings.setAllowFileAccess(allow);
    }

    @Override
    public boolean getAllowFileAccess() {
        return mG3Settings.getAllowFileAccess();
    }

    @Override
    public void setAllowContentAccess(boolean allow) {
        mG3Settings.setAllowContentAccess(allow);
    }

    @Override
    public boolean getAllowContentAccess() {
        return mG3Settings.getAllowContentAccess();
    }

    @Override
    public void setLoadWithOverviewMode(boolean overview) {
        mG3Settings.setLoadWithOverviewMode(overview);
    }

    @Override
    public boolean getLoadWithOverviewMode() {
        return mG3Settings.getLoadWithOverviewMode();
    }

    @Override
    public void setSafeBrowsingEnabled(boolean accept) {
        mG3Settings.setSafeBrowsingEnabled(accept);
    }

    @Override
    public boolean getSafeBrowsingEnabled() {
        return mG3Settings.getSafeBrowsingEnabled();
    }

    @Override
    public void setEnableSmoothTransition(boolean enable) {
        // Intentional no-op.
    }

    @Override
    public boolean enableSmoothTransition() {
        // Intentional no-op.
        return false;
    }

    @Override
    public void setSaveFormData(boolean save) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) return;

        mG3Settings.setSaveFormData(save);
    }

    @Override
    public boolean getSaveFormData() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) return false;

        return mG3Settings.getSaveFormData();
    }

    @Override
    public void setSavePassword(boolean save) {
        // Intentional no-op.
    }

    @Override
    public boolean getSavePassword() {
        // Intentional no-op.
        return false;
    }

    @Override
    public synchronized void setTextZoom(int textZoom) {
        mG3Settings.setTextZoom(textZoom);
    }

    @Override
    public synchronized int getTextZoom() {
        return mG3Settings.getTextZoom();
    }

    @Override
    public void setDefaultZoom(ZoomDensity zoom) {
        // Intentional no-op
    }

    @Override
    public ZoomDensity getDefaultZoom() {
        // Intentional no-op
        return ZoomDensity.MEDIUM;
    }

    @Override
    public void setLightTouchEnabled(boolean enabled) {
        // Intentional no-op.
    }

    @Override
    public boolean getLightTouchEnabled() {
        // Intentional no-op.
        return false;
    }

    @Override
    public synchronized void setUseWideViewPort(boolean use) {
        mG3Settings.setUseWideViewPort(use);
    }

    @Override
    public synchronized boolean getUseWideViewPort() {
        return mG3Settings.getUseWideViewPort();
    }

    @Override
    public synchronized void setSupportMultipleWindows(boolean support) {
        mG3Settings.setSupportMultipleWindows(support);
    }

    @Override
    public synchronized boolean supportMultipleWindows() {
        return mG3Settings.supportMultipleWindows();
    }

    @Override
    public synchronized void setLayoutAlgorithm(LayoutAlgorithm l) {
        switch (l) {
            case NORMAL:
                mG3Settings.setLayoutAlgorithm(G3Settings.LAYOUT_ALGORITHM_NORMAL);
                return;
            case SINGLE_COLUMN:
                mG3Settings.setLayoutAlgorithm(G3Settings.LAYOUT_ALGORITHM_SINGLE_COLUMN);
                return;
            case NARROW_COLUMNS:
                mG3Settings.setLayoutAlgorithm(G3Settings.LAYOUT_ALGORITHM_NARROW_COLUMNS);
                return;
            case TEXT_AUTOSIZING:
                mG3Settings.setLayoutAlgorithm(G3Settings.LAYOUT_ALGORITHM_TEXT_AUTOSIZING);
                return;
            default:
                throw new IllegalArgumentException("Unsupported value: " + l);
        }
    }

    @Override
    public synchronized LayoutAlgorithm getLayoutAlgorithm() {
        int value = mG3Settings.getLayoutAlgorithm();
        switch (value) {
            case G3Settings.LAYOUT_ALGORITHM_NORMAL:
                return LayoutAlgorithm.NORMAL;
            case G3Settings.LAYOUT_ALGORITHM_SINGLE_COLUMN:
                return LayoutAlgorithm.SINGLE_COLUMN;
            case G3Settings.LAYOUT_ALGORITHM_NARROW_COLUMNS:
                return LayoutAlgorithm.NARROW_COLUMNS;
            case G3Settings.LAYOUT_ALGORITHM_TEXT_AUTOSIZING:
                return LayoutAlgorithm.TEXT_AUTOSIZING;
            default:
                throw new IllegalArgumentException("Unsupported value: " + value);
        }
    }

    @Override
    public synchronized void setStandardFontFamily(String font) {
        mG3Settings.setStandardFontFamily(font);
    }

    @Override
    public synchronized String getStandardFontFamily() {
        return mG3Settings.getStandardFontFamily();
    }

    @Override
    public synchronized void setFixedFontFamily(String font) {
        mG3Settings.setFixedFontFamily(font);
    }

    @Override
    public synchronized String getFixedFontFamily() {
        return mG3Settings.getFixedFontFamily();
    }

    @Override
    public synchronized void setSansSerifFontFamily(String font) {
        mG3Settings.setSansSerifFontFamily(font);
    }

    @Override
    public synchronized String getSansSerifFontFamily() {
        return mG3Settings.getSansSerifFontFamily();
    }

    @Override
    public synchronized void setSerifFontFamily(String font) {
        mG3Settings.setSerifFontFamily(font);
    }

    @Override
    public synchronized String getSerifFontFamily() {
        return mG3Settings.getSerifFontFamily();
    }

    @Override
    public synchronized void setCursiveFontFamily(String font) {
        mG3Settings.setCursiveFontFamily(font);
    }

    @Override
    public synchronized String getCursiveFontFamily() {
        return mG3Settings.getCursiveFontFamily();
    }

    @Override
    public synchronized void setFantasyFontFamily(String font) {
        mG3Settings.setFantasyFontFamily(font);
    }

    @Override
    public synchronized String getFantasyFontFamily() {
        return mG3Settings.getFantasyFontFamily();
    }

    @Override
    public synchronized void setMinimumFontSize(int size) {
        mG3Settings.setMinimumFontSize(size);
    }

    @Override
    public synchronized int getMinimumFontSize() {
        return mG3Settings.getMinimumFontSize();
    }

    @Override
    public synchronized void setMinimumLogicalFontSize(int size) {
        mG3Settings.setMinimumLogicalFontSize(size);
    }

    @Override
    public synchronized int getMinimumLogicalFontSize() {
        return mG3Settings.getMinimumLogicalFontSize();
    }

    @Override
    public synchronized void setDefaultFontSize(int size) {
        mG3Settings.setDefaultFontSize(size);
    }

    @Override
    public synchronized int getDefaultFontSize() {
        return mG3Settings.getDefaultFontSize();
    }

    @Override
    public synchronized void setDefaultFixedFontSize(int size) {
        mG3Settings.setDefaultFixedFontSize(size);
    }

    @Override
    public synchronized int getDefaultFixedFontSize() {
        return mG3Settings.getDefaultFixedFontSize();
    }

    @Override
    public synchronized void setLoadsImagesAutomatically(boolean flag) {
        mG3Settings.setLoadsImagesAutomatically(flag);
    }

    @Override
    public synchronized boolean getLoadsImagesAutomatically() {
        return mG3Settings.getLoadsImagesAutomatically();
    }

    @Override
    public synchronized void setBlockNetworkImage(boolean flag) {
        mG3Settings.setImagesEnabled(!flag);
    }

    @Override
    public synchronized boolean getBlockNetworkImage() {
        return !mG3Settings.getImagesEnabled();
    }

    @Override
    public synchronized void setBlockNetworkLoads(boolean flag) {
        mG3Settings.setBlockNetworkLoads(flag);
    }

    @Override
    public synchronized boolean getBlockNetworkLoads() {
        return mG3Settings.getBlockNetworkLoads();
    }

    @Override
    public synchronized void setJavaScriptEnabled(boolean flag) {
        mG3Settings.setJavaScriptEnabled(flag);
    }

    @Override
    public void setAllowUniversalAccessFromFileURLs(boolean flag) {
        mG3Settings.setAllowUniversalAccessFromFileURLs(flag);
    }

    @Override
    public void setAllowFileAccessFromFileURLs(boolean flag) {
        mG3Settings.setAllowFileAccessFromFileURLs(flag);
    }

//    @Override
//    public synchronized void setPluginsEnabled(boolean flag) {
//        mPluginState = flag ? PluginState.ON : PluginState.OFF;
//    }

    @Override
    public synchronized void setPluginState(PluginState state) {
        mPluginState = state;
    }

    @Override
    public synchronized void setDatabasePath(String databasePath) {
        // Intentional no-op.
    }

    @Override
    public synchronized void setGeolocationDatabasePath(String databasePath) {
        // Intentional no-op.
    }

    @Override
    public synchronized void setAppCacheEnabled(boolean flag) {
        mG3Settings.setAppCacheEnabled(flag);
    }

    @Override
    public synchronized void setAppCachePath(String appCachePath) {
        mG3Settings.setAppCachePath(appCachePath);
    }

    @Override
    public synchronized void setAppCacheMaxSize(long appCacheMaxSize) {
        // Intentional no-op.
    }

    @Override
    public synchronized void setDatabaseEnabled(boolean flag) {
        mG3Settings.setDatabaseEnabled(flag);
    }

    @Override
    public synchronized void setDomStorageEnabled(boolean flag) {
        mG3Settings.setDomStorageEnabled(flag);
    }

    @Override
    public synchronized boolean getDomStorageEnabled() {
        return mG3Settings.getDomStorageEnabled();
    }

    @Override
    public synchronized String getDatabasePath() {
        // Intentional no-op.
        return "";
    }

    @Override
    public synchronized boolean getDatabaseEnabled() {
        return mG3Settings.getDatabaseEnabled();
    }

    @Override
    public synchronized void setGeolocationEnabled(boolean flag) {
        mG3Settings.setGeolocationEnabled(flag);
    }

    @Override
    public synchronized boolean getJavaScriptEnabled() {
        return mG3Settings.getJavaScriptEnabled();
    }

    @Override
    public boolean getAllowUniversalAccessFromFileURLs() {
        return mG3Settings.getAllowUniversalAccessFromFileURLs();
    }

    @Override
    public boolean getAllowFileAccessFromFileURLs() {
        return mG3Settings.getAllowFileAccessFromFileURLs();
    }

//    @Override
//    public synchronized boolean getPluginsEnabled() {
//        return mPluginState == PluginState.ON;
//    }

    @Override
    public synchronized PluginState getPluginState() {
        return mPluginState;
    }

    @Override
    public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean flag) {
        mG3Settings.setJavaScriptCanOpenWindowsAutomatically(flag);
    }

    @Override
    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        return mG3Settings.getJavaScriptCanOpenWindowsAutomatically();
    }

    @Override
    public synchronized void setDefaultTextEncodingName(String encoding) {
        mG3Settings.setDefaultTextEncodingName(encoding);
    }

    @Override
    public synchronized String getDefaultTextEncodingName() {
        return mG3Settings.getDefaultTextEncodingName();
    }

    @Override
    public synchronized void setUserAgentString(String ua) {
        mG3Settings.setUserAgentString(ua);
    }

    @Override
    public synchronized String getUserAgentString() {
        return mG3Settings.getUserAgentString();
    }

    @Override
    public void setNeedInitialFocus(boolean flag) {
        mG3Settings.setShouldFocusFirstNode(flag);
    }

    @Override
    public synchronized void setRenderPriority(RenderPriority priority) {
        // Intentional no-op.
    }

    @Override
    public void setCacheMode(int mode) {
        mG3Settings.setCacheMode(mode);
    }

    @Override
    public int getCacheMode() {
        return mG3Settings.getCacheMode();
    }

    @Override
    public void setMediaPlaybackRequiresUserGesture(boolean require) {
        mG3Settings.setMediaPlaybackRequiresUserGesture(require);
    }

    @Override
    public boolean getMediaPlaybackRequiresUserGesture() {
        return mG3Settings.getMediaPlaybackRequiresUserGesture();
    }

    @Override
    public void setMixedContentMode(int mode) {
        mG3Settings.setMixedContentMode(mode);
    }

    @Override
    public int getMixedContentMode() {
        return mG3Settings.getMixedContentMode();
    }

    @Override
    public void setOffscreenPreRaster(boolean enabled) {
        mG3Settings.setOffscreenPreRaster(enabled);
    }

    @Override
    public boolean getOffscreenPreRaster() {
        return mG3Settings.getOffscreenPreRaster();
    }

    @Override
    public void setDisabledActionModeMenuItems(int menuItems) {
        mG3Settings.setDisabledActionModeMenuItems(menuItems);
    }

    @Override
    public int getDisabledActionModeMenuItems() {
        return mG3Settings.getDisabledActionModeMenuItems();
    }

//    @Override
//    public void setVideoOverlayForEmbeddedEncryptedVideoEnabled(boolean flag) {
//        // No-op, see http://crbug.com/616583
//    }
//
//    @Override
//    public boolean getVideoOverlayForEmbeddedEncryptedVideoEnabled() {
//        // Always false, see http://crbug.com/616583
//        return false;
//    }

    @Override
    @SuppressLint("Override")
    public void setForceDark(int forceDarkMode) {

    }

    @Override
    @SuppressLint("Override")
    public int getForceDark() {
        return WebSettings.FORCE_DARK_AUTO;
    }
}
