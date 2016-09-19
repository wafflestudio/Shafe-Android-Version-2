package com.wafflestudio.shafe;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public final class MapManager {
    private static final MapManager instance = new MapManager();
    private static MapView mapView = null;
    private static MapPoint mapCenterPoint;
    private static int zoomLevel = 2;

    private MapManager() {}

    // getInstance는 한 번만 호출할 것
    public static MapManager getInstance() {
        return instance;
    }

    // onStart() 에서 호출할 것. 그래야 필요할 때마다 MapView가 초기화됨.
    public void createMapView(Context context) {
        mapView = new MapView(context);
        mapView.setDaumMapApiKey(BuildConfig.SHAFE_DAUM_MAP_API_KEY);
    }

    public MapView getMapView() {
        return mapView;
    }

//    public void setMapCenterPoint(MapPoint centerPoint, boolean animated) {
//        mapView.setMapCenterPoint(centerPoint, animated);
//    }
//
//    public void setZoomLevel(int zoomLevel, boolean animated) {
//        mapView.setZoomLevel(zoomLevel, animated);
//    }

    public void initializeMapWithSavedValue() {
        // animated를 false로 넣어주면 에러가 뜸. 왜인지는 잘 모르겠음
        mapView.setMapCenterPointAndZoomLevel(mapCenterPoint, zoomLevel, false);
    }

    public void loadLocation(double latitude, double longitude, boolean overrideSavedValue) {
        if (mapCenterPoint == null || overrideSavedValue) {
            mapCenterPoint = MapPoint.mapPointWithGeoCoord(latitude, longitude);
        }
    }

    public void saveMapCenterPointAndZoomLevel() {
        mapCenterPoint = mapView.getMapCenterPoint();
        zoomLevel = mapView.getZoomLevel();
    }

    // add POI item to mapView
    public void addPOIItem(MapPOIItem poiItem) {
        mapView.addPOIItem(poiItem);
    }

    // add POI items to mapView
    public void addPOIItems(MapPOIItem[] poiItems) {
        mapView.addPOIItems(poiItems);
    }

    public void setPOIItemEventListener(MapView.POIItemEventListener poiItemEventListener) {
        mapView.setPOIItemEventListener(poiItemEventListener);
    }
}
