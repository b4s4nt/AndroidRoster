package com.example.rosterapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class Emp_Remove_Adapter extends RecyclerView.Adapter<Emp_Remove_Adapter.Viewholder> {

    private List<Emp_Model> modelClassList;
    public Emp_Remove_Adapter(List<Emp_Model> modelClassList) {
        this.modelClassList = modelClassList;
    }


    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        System.out.println("Here Viewholder onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_table_remove_layout,parent,false);
        return new Viewholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Emp_Remove_Adapter.Viewholder holder, int position) {
        System.out.println("Here onBindViewHolder");
        String name = modelClassList.get(position).getEmployee_Name();
        String phone = modelClassList.get(position).getEmployee_Phone();
        holder.setData(name,phone);
    }

    @Override
    public int getItemCount() {
        return modelClassList.size() ;
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView phone;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            System.out.println("Here Viewholder: subclass viewholder");
            name = itemView.findViewById(R.id.employee_remove_name);

            phone= itemView.findViewById(R.id.employee_remove_phone);
        }

        public void setData(String nameText,String phoneText) {

            System.out.println("Here setData: subclass viewholder");
            name.setText(nameText);
            phone.setText(phoneText);
        }

    }
}
