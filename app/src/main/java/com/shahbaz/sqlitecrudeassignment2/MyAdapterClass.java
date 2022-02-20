package com.shahbaz.sqlitecrudeassignment2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapterClass extends RecyclerView.Adapter<MyAdapterClass.ViewHolder> {
    private List<employeeClass> employeeClasses;
    private Context context;
    private onItemClickListenerInterface onItemClickListener;

    public MyAdapterClass(Context applicationContext, List<employeeClass> employeeClas,onItemClickListenerInterface onItemClickListener) {
        this.context = context;
        this.employeeClasses = employeeClas;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.single_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem,onItemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameTxt.setText(employeeClasses.get(position).getName());
        holder.designationTxt.setText(employeeClasses.get(position).getDesignation());

    }

    @Override
    public int getItemCount() {
        return employeeClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nameTxt,designationTxt;
        private onItemClickListenerInterface onItemClickListener;
        public ViewHolder(@NonNull View itemView,onItemClickListenerInterface onItemClickListener) {
            super(itemView);
            nameTxt = itemView.findViewById(R.id.eName);
            designationTxt = itemView.findViewById(R.id.eDesignation);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onitemClickListener(getAdapterPosition());
        }
    }
    public interface onItemClickListenerInterface {
        void onitemClickListener(int position);
    }
}
