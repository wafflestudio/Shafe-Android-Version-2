package com.wafflestudio.shafe;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by heesu on 16. 8. 7..
 */
public class CafeListAdapter extends BaseAdapter {

    private ArrayList<CafeItem> CafeItemList = new ArrayList<>() ;

    public CafeListAdapter() {
    }

    @Override
    public int getCount(){
        return CafeItemList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if( convertView == null ){
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_cafe, parent, false);
        }
        //TODO : 마저 구현할 것

        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1) ;
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1) ;
        TextView descTextView = (TextView) convertView.findViewById(R.id.textView2) ;

        CafeItem listViewItem = CafeItemList.get(position);

        iconImageView.setImageDrawable(listViewItem.getIcon());
        titleTextView.setText(listViewItem.getTitle());
        descTextView.setText(listViewItem.getDesc());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }

    @Override
    public Object getItem(int position) {
        return CafeItemList.get(position) ;
    }

    public void addItem(Drawable icon, String title, String desc) {
        //TODO : 마저 구현할 것
        CafeItem item = new CafeItem();

        item.setIcon(icon);
        item.setTitle(title);
        item.setDesc(desc);

        CafeItemList.add(item);
    }
}
