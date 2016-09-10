package com.wafflestudio.shafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.Manifest;
import android.content.pm.PackageManager;
import android.widget.Toast;
import android.support.v4.app.ActivityCompat;

import net.daum.mf.map.api.MapView;

public class MapActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_LOCATION = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_LOCATION);
        }
        else {
            //set toolbar
            Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_main);
            setSupportActionBar(myToolbar);
            //enable up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            MapView mapView = new MapView(this);
            mapView.setDaumMapApiKey(BuildConfig.SHAFE_DAUM_MAP_API_KEY);

            ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
            mapViewContainer.addView(mapView);
        }

    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if(requestCode == REQUEST_CODE_LOCATION) {
	    if(grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
	        //set toolbar
	        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_main);
		setSupportActionBar(myToolbar);
		//enable up button
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                MapView mapView = new MapView(this);
                mapView.setDaumMapApiKey(BuildConfig.SHAFE_DAUM_MAP_API_KEY);
                ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
                mapViewContainer.addView(mapView);
            }
            else {
                Toast.makeText(this, "허용하지 않으면 위치서비스를 사용하실 수 없습니다", Toast.LENGTH_SHORT).show();
                finish();
   																											    //                //set toolbar
																											    //                Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_main);
																											    //                setSupportActionBar(myToolbar);
																											    //                //enable up button
																											    //                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
																											    //
																											    //                MapView mapView = new MapView(this);
																											    //                mapView.setDaumMapApiKey(BuildConfig.SHAFE_DAUM_MAP_API_KEY);
																											    //
																											    //                ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
																											    //                mapViewContainer.addView(mapView);
             }
        }
    }
}
