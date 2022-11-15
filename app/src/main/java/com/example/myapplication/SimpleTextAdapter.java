package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SimpleTextAdapter extends RecyclerView.Adapter<SimpleTextAdapter.ViewHolder> {
    private ArrayList<SingleItem> items = null;
    private int imageView;

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView text_name;
        TextView text_minOrderAmount;
        TextView text_deliveryFee;
        ImageView imageView;

        public ViewHolder(@Nullable View itemView) {
            super(itemView);

            text_name = itemView.findViewById(R.id.text_name);
            text_minOrderAmount = itemView.findViewById(R.id.text_minOrderAmount);
            text_deliveryFee = itemView.findViewById(R.id.text_deliveryFee);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    // 생성자
    SimpleTextAdapter(ArrayList<SingleItem> list){
        items = list;
    }

    // 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴
    @Override
    public ViewHolder onCreateViewHolder(@Nullable ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.items, parent, false);
        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    // position 에 해당하는 데이터를 뷰홀더의 아이템 뷰에 표시
    @Override
    public void onBindViewHolder(@Nullable ViewHolder holder, int position) {
        String name = items.get(position).name;
        String description = items.get(position).minOrderAmount;
        String deliveryFee = items.get(position).deliveryFee;
        int resId = items.get(position).imageId;

        holder.text_name.setText(name);
        holder.text_minOrderAmount.setText(description);
        holder.text_deliveryFee.setText(deliveryFee);
        holder.imageView.setImageResource(imageView);
    }

    // 전체 데이터 개수 리턴
    @Override
    public int getItemCount() {
        return items.size();
    }

    // 어댑터 아이템 수정
    public void setItems(ArrayList<SingleItem> list){
        items = list;
        notifyDataSetChanged();
    }
}