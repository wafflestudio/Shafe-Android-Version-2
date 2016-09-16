package com.wafflestudio.shafe;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by heesu on 16. 8. 7..
 */
public class CafeListAdapter extends RecyclerView.Adapter<CafeListAdapter.ViewHolder> {

    private List<CafeItem> cafeItemList;

    public CafeListAdapter(List<CafeItem> cafeItemList) {
        this.cafeItemList = cafeItemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cafe, null);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        CafeItem cafeItem = cafeItemList.get(position);
        holder.setCafe(cafeItem);
    }

    @Override
    public int getItemCount() { return cafeItemList == null ? 0 : cafeItemList.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.imageView1)
        ImageView iconImageView;
        @Bind(R.id.textView1)
        TextView titleTextView;
        @Bind(R.id.textView2)
        TextView descTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Context context = v.getContext();

                    Intent intent = new Intent(context, CafeDetailActivity.class).putExtra(Intent.EXTRA_TEXT, titleTextView.getText().toString());
                    context.startActivity(intent);
                }
            });
        }

        public void setCafe(CafeItem cafeItem) {

            this.iconImageView.setImageDrawable(cafeItem.getIcon());
            this.titleTextView.setText(cafeItem.getTitle());
            this.descTextView.setText(cafeItem.getDesc());
        }
    }
}
