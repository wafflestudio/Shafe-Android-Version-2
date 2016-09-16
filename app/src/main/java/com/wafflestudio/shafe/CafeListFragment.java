package com.wafflestudio.shafe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by heesu on 16. 8. 5..
 */
public class CafeListFragment extends Fragment{

    public static RecyclerView.Adapter<CafeListAdapter.ViewHolder> cafeListAdapter;
    public static List<CafeItem> cafeItemList = new ArrayList<>();

    @Bind(R.id.recyclerview_cafe) RecyclerView recyclerView;

    public CafeListFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cafeItemList.add( new CafeItem(getResources().getDrawable(R.drawable.sample_0), "Dog 1", "dog description 1"));
        cafeItemList.add(new CafeItem(getResources().getDrawable(R.drawable.sample_1), "Dog2", "dog description 2"));
        cafeItemList.add(new CafeItem(getResources().getDrawable(R.drawable.sample_2), "Dog3", "dog description 3"));
        cafeItemList.add(new CafeItem(getResources().getDrawable(R.drawable.sample_3), "Dog4", "dog description 4"));

        //TODO : 카페를 등록하는건 다른 activity에서 구현한다. 이곳에선 파일에서 저장된 데이터를 불러오는 기능만 구현.
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        cafeListAdapter = new CafeListAdapter(cafeItemList);

        View rootView = inflater.inflate(R.layout.fragment_cafelist, container, false);

        ButterKnife.bind(this, rootView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(cafeListAdapter);

        return rootView;
    }
}
