package com.example.rosterapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
//public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {

public class Emp_Adapter extends  RecyclerView.Adapter<Emp_Adapter.Viewholder> {

    DatabaseHelper db;
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
        String phone = modelClassList.get(position).getEmployee_Phone();
        viewholder.setData(name, email,phone);
    }

    @Override
        public int getItemCount() {
        System.out.println("getItemCount");
        System.out.println(modelClassList.size());

            return modelClassList.size() ;
        }
        

        class Viewholder  extends  RecyclerView.ViewHolder implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
            private static final String TAG = "Viewholder";
            private TextView name;
            private  TextView email;
            private TextView phone;
            private ImageView menuImage;



            public Viewholder(@NonNull View itemView) {
                super(itemView);
                System.out.println("Here Viewholder: subclass viewholder");
                name = itemView.findViewById(R.id.employee_name);
                email = itemView.findViewById(R.id.employee_email);
                phone= itemView.findViewById(R.id.employee_phone);
                menuImage= itemView.findViewById(R.id.img_popup_ed);
                menuImage.setOnClickListener(this);

            }



            private  void setData( String nameText,String emailText, String phoneText){
                System.out.println("Here setData: subclass viewholder");
                name.setText(nameText);
                email.setText(emailText);
                phone.setText(phoneText);



            }

            @Override
            public void onClick(View v) {
              //  Log.d(TAG,"onClick");
              //  Log.d(TAG, "onClick:"+getAdapterPosition());
                showPopupMenu(v);

            }
            private void showPopupMenu(View view){
                PopupMenu popupMenu = new PopupMenu(view.getContext(),view);
                popupMenu.inflate(R.menu.popup_menu);
                popupMenu.setOnMenuItemClickListener(this);
                popupMenu.show();

            }

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case  R.id.action_popup_edit:
                        Log.d(TAG, "onMenuItemClick: action_popup_edit"+getAdapterPosition());
                        return true;

                    case  R.id.action_popup_delete:
                        Log.d(TAG, "onMenuItemClick: action_popup_delete"+getAdapterPosition());


                        String email = modelClassList.get((getAdapterPosition())).getEmployee_Email();

                        db = new DatabaseHelper(itemView.getContext());
                        db.deleteEmployeeFromDataBaseByEmailID(email);
                       // deletSelectedEmployee(email);// will delete the selected items from database

                        modelClassList.remove(getAdapterPosition());
                        return true;
                }
                return false;
            }



            }
        }




