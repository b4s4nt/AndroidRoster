package com.example.rosterapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Dipslay_EmployeeList_Fragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



       // recyclerView = findViewById(R.id.recyclearview);
        View v= inflater.inflate(R.layout.fragment_display_employeelist,container,false);

        recyclerView = v.findViewById(R.id.recyclearview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);


        System.out.println("Here , before creating database helper object to create addEmployeeTable");


        DatabaseHelper db = new DatabaseHelper(getContext());

        //usernameList=db.getAllUserNameFromDatabase();



        List<Emp_Model> modelClassList =  new ArrayList<>();


        List<String> rs = new ArrayList<>();
        rs= db.getAllValue(DatabaseHelper.addEmployeTableName);
        //db.getAllValue("Register");
        // System.out.println(rs.get(0));



        modelClassList.add(new Emp_Model("Basanta 1","Hello This is basanta"));
        modelClassList.add(new Emp_Model("Basanta 2","Hello This is basanta"));
        modelClassList.add(new Emp_Model ("Basanta 3","Hello This is basanta"));

        Emp_Adapter adapter = new  Emp_Adapter(modelClassList);
        System.out.println("Here After Creating recyclerview Adapter_");

        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();



       // return super.onCreateView(inflater, container, savedInstanceState);
        System.out.println("Here near return v");
        return v;


    }
}
