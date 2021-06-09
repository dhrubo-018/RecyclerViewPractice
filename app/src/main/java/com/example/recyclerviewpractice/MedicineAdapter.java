package com.example.recyclerviewpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.ViewHolder> {

    private ArrayList<Medicine> medicineList;

    public interface ItemClicked{
        void onItemClicked(int index);
    }

    ItemClicked activity;

    public MedicineAdapter(Context context, ArrayList<Medicine> medicineList){
        this.medicineList = medicineList;
        activity = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvPrice;
        TextView tvPiecesPerBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvPiecesPerBox = itemView.findViewById(R.id.tvPiecesPerBox);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onItemClicked(medicineList.indexOf((Medicine)view.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public MedicineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineAdapter.ViewHolder holder, int position) {

        holder.itemView.setTag(medicineList.get(position));

        holder.tvName.setText(medicineList.get(position).getName());
        holder.tvPrice.setText(medicineList.get(position).getPrice().toString());
        holder.tvPiecesPerBox.setText(medicineList.get(position).getPiecesPerBox().toString());
    }

    @Override
    public int getItemCount() {
        return this.medicineList.size();
    }
}
