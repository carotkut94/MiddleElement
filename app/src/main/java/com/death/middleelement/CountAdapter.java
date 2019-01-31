package com.death.middleelement;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.death.middleelement.databinding.SingleItemBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class CountAdapter extends RecyclerView.Adapter<CountAdapter.CountViewHolder> {

    List<Counting> counting;

    public CountAdapter(List<Counting> counting) {
        this.counting = counting;
    }

    @NonNull
    @Override
    public CountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SingleItemBinding singleItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.single_item, parent, false);
        return new CountViewHolder(singleItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CountViewHolder holder, int position) {
        holder.bind(counting.get(position));
    }

    @Override
    public int getItemCount() {
        return counting.size();
    }

    public void setSelected(int pos) {
        counting.get(pos).isSelected = true;
        notifyItemChanged(pos);
    }

    public void clearSelection(int pos) {
        counting.get(pos).isSelected = false;
        notifyItemChanged(pos);
    }

    public class CountViewHolder extends RecyclerView.ViewHolder {
        SingleItemBinding singleItemBinding;
        public CountViewHolder(@NonNull SingleItemBinding singleItemBinding) {
            super(singleItemBinding.getRoot());
            this.singleItemBinding = singleItemBinding;
        }

        public void bind(Counting value){
            singleItemBinding.text.setText(String.valueOf(value.count));
            if(value.isSelected){
                singleItemBinding.container.setBackgroundColor(Color.GREEN);
            }else{
                singleItemBinding.container.setBackgroundColor(Color.WHITE);
            }
        }
    }
}
