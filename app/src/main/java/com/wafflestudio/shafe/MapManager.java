package com.wafflestudio.shafe;

import android.content.Context;
import android.view.ViewGroup;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public final class MapManager {
    private static final MapManager instance = new MapManager();
    private static MapView mapView = null;
    private static MapPoint mapCenterPoint = null;
    private static int zoomLevel = 2;

    private MapManager() {}

    // getInstance는 한 번만 호출할 것
    public static MapManager getInstance() {
        return instance;
    }

    // onStart() 에서 호출할 것. 그래야 필요할 때마다 MapView가 초기화됨.
    public void createMapView(Context context) {
        if(mapView != null) {
            ((ViewGroup) mapView.getParent()).removeView(mapView);
        }

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
        if(mapView == null) {return;}

        // animated를 false로 넣어주면 에러가 뜸. 왜인지는 잘 모르겠음
        mapView.setMapCenterPointAndZoomLevel(mapCenterPoint, zoomLevel, false);
    }

    public void loadLocation(double latitude, double longitude, boolean overrideSavedValue) {
        if (mapCenterPoint == null || overrideSavedValue) {
            mapCenterPoint = MapPoint.mapPointWithGeoCoord(latitude, longitude);
        }
    }

    public void saveMapCenterPointAndZoomLevel() {
        if(mapView == null) {return;}

        mapCenterPoint = mapView.getMapCenterPoint();
        zoomLevel = mapView.getZoomLevel();
    }

    // add POI item to mapView
    public void addPOIItem(MapPOIItem poiItem) {
        if(mapView == null) {return;}

        mapView.addPOIItem(poiItem);
    }

    // add POI items to mapView
    public void addPOIItems(MapPOIItem[] poiItems) {
        if(mapView == null) {return;}

        mapView.addPOIItems(poiItems);
    }

    public void setPOIItemEventListener(MapView.POIItemEventListener poiItemEventListener) {
        if(mapView == null) {return;}

        mapView.setPOIItemEventListener(poiItemEventListener);
    }
}
