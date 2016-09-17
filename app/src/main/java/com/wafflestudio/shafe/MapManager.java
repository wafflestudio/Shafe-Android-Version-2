package com.wafflestudio.shafe;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import net.daum.mf.map.api.MapView;

public final class MapManager {
    private static final MapManager instance = new MapManager();
    private static MapView mapView = null;

    private MapManager() {}

    // getInstance는 한 번만 호출할 것
    public static MapManager getInstance(Context context) {
        mapView = new MapView(context);
        mapView.setDaumMapApiKey(BuildConfig.SHAFE_DAUM_MAP_API_KEY);

        return instance;
    }

    public MapView getMapView() {
        return mapView;
    }
}
