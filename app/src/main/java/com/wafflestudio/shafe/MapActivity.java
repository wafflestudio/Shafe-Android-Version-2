package com.wafflestudio.shafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import net.daum.mf.map.api.MapView;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        //set toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(myToolbar);

        //enable up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);

        MapManager searchResultMap = MapManager.getInstance(this);

        mapViewContainer.addView(searchResultMap.getMapView());
    }
}
