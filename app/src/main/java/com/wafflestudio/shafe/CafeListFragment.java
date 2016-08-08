package com.wafflestudio.shafe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * Created by heesu on 16. 8. 5..
 */
public class CafeListFragment extends Fragment{

    private CafeListAdapter cafeListAdapter;

    public CafeListFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        cafeListAdapter = new CafeListAdapter();

        View rootView = inflater.inflate(R.layout.fragment_cafelist, container, false);

        // Get a reference to the GridView, and attach this adapter to it.
        GridView gridView = (GridView) rootView.findViewById(R.id.gridview_cafe);
        gridView.setAdapter(cafeListAdapter);

        //TODO : dummy data를 실제 data로 교체할 것
        cafeListAdapter.addItem(getResources().getDrawable(R.drawable.sample_0), "Dog 1", "dog description 1");
        cafeListAdapter.addItem(getResources().getDrawable(R.drawable.sample_1), "Dog 2", "dog description 2");
        cafeListAdapter.addItem(getResources().getDrawable(R.drawable.sample_2), "Dog 3", "dog description 3");
        cafeListAdapter.addItem(getResources().getDrawable(R.drawable.sample_3), "Dog 4", "dog description 4");
        cafeListAdapter.addItem(getResources().getDrawable(R.drawable.sample_0), "Dog 1", "dog description 1");
        cafeListAdapter.addItem(getResources().getDrawable(R.drawable.sample_1), "Dog 2", "dog description 2");
        cafeListAdapter.addItem(getResources().getDrawable(R.drawable.sample_2), "Dog 3", "dog description 3");
        cafeListAdapter.addItem(getResources().getDrawable(R.drawable.sample_3), "Dog 4", "dog description 4");

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                //TODO : 마저 구현할 것
            }
        });

        return rootView;
    }
}
