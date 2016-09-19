package com.wafflestudio.shafe;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;

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

        //set toolbar
        ButterKnife.bind(this);
        setSupportActionBar(myToolbar);

        //enable up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();

        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(MapActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();

                searchResultMap.createMapView(MapActivity.this);
                searchResultMap.initializeMapWithSavedValue();

                mapViewContainer.addView(searchResultMap.getMapView());
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                Toast.makeText(MapActivity.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();

                finish();
            }
        };

        new TedPermission(this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.ACCESS_FINE_LOCATION)
                .check();
    }

    @Override
    protected void onStop() {
        super.onStop();

        // TODO : save는 '이 지역에서 검색하기' 기능을 사용한 순간 하도록 나중에 수정할 것
        searchResultMap.saveMapCenterPointAndZoomLevel();
    }
}