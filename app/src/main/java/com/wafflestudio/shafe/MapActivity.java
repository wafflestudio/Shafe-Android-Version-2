package com.wafflestudio.shafe;

import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import android.Manifest;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MapActivity extends AppCompatActivity {

    protected static final String TAG = "MapActivity";

    protected MapManager searchResultMap = MapManager.getInstance();

    private static final int REQUEST_CODE_LOCATION = 2;

    @Bind(R.id.toolbar_main) Toolbar myToolbar;
    @Bind(R.id.map_view) ViewGroup mapViewContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_LOCATION);
        }
        //set toolbar
        ButterKnife.bind(this);
        setSupportActionBar(myToolbar);

        //enable up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if(requestCode == REQUEST_CODE_LOCATION) {
            if(grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                return;
            } else {
                Toast.makeText(this, "허용하지 않으면 위치서비스를 사용하실 수 없습니다", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        searchResultMap.createMapView(this);
        searchResultMap.initializeMapWithSavedValue();

        mapViewContainer.addView(searchResultMap.getMapView());
    }

    @Override
    protected void onStop() {
        super.onStop();

        // TODO : save를 어느 시점에서 할지 고민 해볼 것
        searchResultMap.saveMapCenterPointAndZoomLevel();
    }
}