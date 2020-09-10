package com.example.rosterapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
//public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {

public class Emp_Adapter extends  RecyclerView.Adapter<Emp_Adapter.Viewholder> {


        private List<Emp_Model> modelClassList;

        public Emp_Adapter(List<Emp_Model> modelClassList) {
            System.out.println("Here Adapter Constructor");
            this.modelClassList = modelClassList;
        }


    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        System.out.println("Here Viewholder onCreateViewHolder");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.employee_table_item_layout,viewGroup,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int position) {
        System.out.println("Here onBindViewHolder");
        String name = modelClassList.get(position).getEmployee_Name();
        String email = modelClassList.get(position).getEmployee_Email();
        viewholder.setData(name, email);
    }

    @Override
        public int getItemCount() {
        System.out.println("getItemCount");
        System.out.println(modelClassList.size());

            return modelClassList.size() ;
        }

        class Viewholder  extends  RecyclerView.ViewHolder{

            private TextView name;
            private  TextView email;



            public Viewholder(@NonNull View itemView) {
                super(itemView);
                System.out.println("Here Viewholder: subclass viewholder");
                name = itemView.findViewById(R.id.employee_name);
                email = itemView.findViewById(R.id.employee_email);
            }

            private  void setData( String nameText,String emailText){
                System.out.println("Here setData: subclass viewholder");
                name.setText(nameText);
                email.setText(emailText);

            }
        }
    }



