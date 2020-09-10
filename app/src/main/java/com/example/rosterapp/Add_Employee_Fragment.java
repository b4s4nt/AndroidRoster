package com.example.rosterapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class Add_Employee_Fragment extends Fragment implements View.OnClickListener {
    private Button AddEmployee;

    private EditText EmpName;
    private EditText EmpEmail;
    private EditText EmpMobile;
    private  String RosterDay;
    // index of array represents day like 0 for sunday
    private Spinner EmpStartSun;
    private Spinner EmpStartMon;
    private Spinner EmpStartTus;
    private Spinner EmpStartThus;
    private Spinner EmpStartWed;
    private Spinner EmpStartFri;
    private Spinner EmpStartSat;
    DatabaseHelper db;

    private Spinner EmpEndSun;
    private Spinner EmpEndMon;
    private Spinner EmpEndTus;
    private Spinner EmpEndThus;
    private Spinner EmpEndWed;
    private Spinner EmpEndFri;
    private Spinner EmpEndSat;
    ArrayList<String> day = new ArrayList<String>( );


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {





        View v= inflater.inflate(R.layout.fragment_add_employee,container,false);


        String [] values = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
        // Spinner spinner = (Spinner) v.findViewById(R.id.spinnerSundayStart);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        Spinner spinner1 = (Spinner) v.findViewById(R.id.spinnerSundayStart);
        spinner1.setAdapter(adapter);
        Spinner spinner2 = (Spinner) v.findViewById(R.id.spinnerMondayStart);
        spinner2.setAdapter(adapter);
        Spinner spinner3 = (Spinner) v.findViewById(R.id.spinnerTuesdayStart);
        spinner3.setAdapter(adapter);
        Spinner spinner4 = (Spinner) v.findViewById(R.id.spinnerWednesdayStart);
        spinner4.setAdapter(adapter);
        Spinner spinner5 = (Spinner) v.findViewById(R.id.spinnerThursdayStart);
        spinner5.setAdapter(adapter);
        Spinner spinner6 = (Spinner) v.findViewById(R.id.spinnerFridayStart);
        spinner6.setAdapter(adapter);
        Spinner spinner7 = (Spinner) v.findViewById(R.id.spinnerSaturdayStart);
        spinner7.setAdapter(adapter);
        Spinner spinner_1 = (Spinner) v.findViewById(R.id.spinnerSundayEnd);
        spinner_1.setAdapter(adapter);
        Spinner spinner_2 = (Spinner) v.findViewById(R.id.spinnerMondayEnd);
        spinner_2.setAdapter(adapter);
        Spinner spinner_3 = (Spinner) v.findViewById(R.id.spinnerTuesdayEnd);
        spinner_3.setAdapter(adapter);
        Spinner spinner_4 = (Spinner) v.findViewById(R.id.spinnerWednesdayEnd);
        spinner_4.setAdapter(adapter);
        Spinner spinner_5 = (Spinner) v.findViewById(R.id.spinnerThursdayEnd);
        spinner_5.setAdapter(adapter);
        Spinner spinner_6 = (Spinner) v.findViewById(R.id.spinnerFridayEnd);
        spinner_6.setAdapter(adapter);
        Spinner spinner_7 = (Spinner) v.findViewById(R.id.spinnerSaturdayEnd);
        spinner_7.setAdapter(adapter);

        EmpName = (EditText)v.findViewById(R.id.et_empfullname);
        EmpEmail= (EditText)v.findViewById(R.id.et_empemailadd);
        EmpMobile =(EditText)v.findViewById(R.id.et_empmobileno);


        EmpStartSun = (Spinner)v.findViewById(R.id.spinnerSundayStart);
        EmpStartMon= (Spinner)v.findViewById(R.id.spinnerMondayStart);
        EmpStartTus = (Spinner)v.findViewById(R.id.spinnerTuesdayStart);
        EmpStartWed = (Spinner)v.findViewById(R.id.spinnerWednesdayStart);
        EmpStartThus = (Spinner)v.findViewById(R.id.spinnerThursdayStart);
        EmpStartFri = (Spinner)v.findViewById(R.id.spinnerFridayStart);
        EmpStartSat = (Spinner)v.findViewById(R.id.spinnerSaturdayStart);

        EmpEndMon = (Spinner) v.findViewById(R.id.spinnerMondayEnd);
        EmpEndTus = (Spinner) v.findViewById(R.id.spinnerTuesdayEnd);
        EmpEndWed = (Spinner) v.findViewById(R.id.spinnerWednesdayEnd);
        EmpEndThus = (Spinner) v.findViewById(R.id.spinnerThursdayEnd);
        EmpEndFri = (Spinner) v.findViewById(R.id.spinnerFridayEnd);
        EmpEndSat = (Spinner) v.findViewById(R.id.spinnerSaturdayEnd);
        EmpEndSun = (Spinner) v.findViewById(R.id.spinnerSundayEnd);


        //String text = mySpinner.getSelectedItem().toString();


        String sun = EmpStartSun.getSelectedItem().toString() +EmpEndSun.getSelectedItem().toString();
        String mon= EmpStartMon.getSelectedItem().toString()+EmpEndMon.getSelectedItem().toString();
        String tus= EmpStartTus.getSelectedItem().toString()+EmpEndTus.getSelectedItem().toString();
        String wed= EmpStartWed.getSelectedItem().toString()+EmpEndWed.getSelectedItem().toString();
        String thus= EmpStartThus.getSelectedItem().toString()+EmpEndThus.getSelectedItem().toString();
        String fri= EmpStartFri.getSelectedItem().toString()+EmpEndFri.getSelectedItem().toString();
        String sat = EmpStartSat.getSelectedItem().toString()+EmpEndSat.getSelectedItem().toString();
        day.add(sun);
        day.add(mon);
        day.add(tus);
        day.add(wed);
        day.add(thus);
        day.add(fri);
        day.add(sat);




//        EmpStarMon =(Spinner)v.findViewById(R.id.spinnerMondayStart);
//        EmpStartTus= (Spinner)v.findViewById(R.id.spinnerTuesdayStart);
//        EmpStartWed = (Spinner)v.findViewById(R.id.spinnerWednesdayStart);
//        EmpStartThus= (Spinner)v.findViewById(R.id.spinnerThursdayStart);
//        EmpStartFri= (Spinner)v.findViewById(R.id.spinnerFridayStart);
//        EmpStartSat=(Spinner)v.findViewById(R.id.spinnerSaturdayStart);
//        EmpEndSun= (Spinner)v.findViewById(R.id.spinnerSundayEnd);
//        EmpEndMon=(Spinner)v.findViewById(R.id.spinnerMondayEnd);
//        EmpEndTus= (Spinner)v.findViewById(R.id.spinnerTuesdayEnd);
//        EmpEndWed=(Spinner)v.findViewById(R.id.spinnerWednesdayEnd);
//        EmpEndThus=(Spinner)v.findViewById(R.id.spinnerThursdayEnd);
//        EmpEndFri= (Spinner)v.findViewById(R.id.spinnerFridayEnd);
//        EmpEndSat= (Spinner)v.findViewById(R.id.spinnerSaturdayEnd);


        AddEmployee = (Button)v.findViewById(R.id.btnAddEmployee);


        // final Add_Employee_Spinner spinner=  v.findViewById(R.id.spinnerSundayStart);

//        Spinner [] spin = {spinner1,spinner2,spinner3,spinner4,spinner5,spinner6,spinner7};
//
//        switch (spin){
//            case R.id.nav_searchEmployee:
//                selectedFragment = new Search_Employee_Fragment ();
//                break;
//            case R.id.nav_addEmployee:
//                selectedFragment = new Add_Employee_Fragment ();
//                break;
//            case R.id.nav_editEmployee:
//                selectedFragment = new Edit_Employee_Fragment ();
//                break;
//            case R.id.nav_removeEmployee:
//                selectedFragment = new Remove_Employee_Fragment ();
//                break;
//        }


        AddEmployee.setOnClickListener(this);




        return  v;
    }

    @Override
    public void onClick(View v) {
         DatabaseHelper db = new DatabaseHelper(getContext());
        Toast.makeText(getActivity(), EmpName.getText().toString(), Toast.LENGTH_LONG).show();

        try {
            System.out.println(EmpName.getText().toString()+ EmpEmail.getText().toString()+ EmpMobile.getText().toString());
            db.insertIntoemployeeRecordTable(EmpName.getText().toString(), EmpEmail.getText().toString(), EmpMobile.getText().toString(), day);
            Toast.makeText(getActivity(), "New Employee Added", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            System.out.println(e.toString());

            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG).show();

        }
        Intent intent = new Intent(getActivity(), EmployeeActivity.class);
        startActivity(intent);// Move to the main activity
    }
}
