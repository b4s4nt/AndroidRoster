package com.example.rosterapp;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EmployeeActivity extends AppCompatActivity {

    private Button Add_Employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

       // Add_Employee= findViewById(R.id.btn_AddEmployee);
        BottomNavigationView  topNav =findViewById(R.id.nav_top);

       getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Dipslay_EmployeeList_Fragment()).commit();
       // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Add_Employee_Fragment()).commit();

        topNav.setOnNavigationItemSelectedListener(navListener);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment= null;
            switch (item.getItemId()){
                case R.id.nav_searchEmployee:
                    selectedFragment = new Search_Employee_Fragment ();
                    break;
                case R.id.nav_addEmployee:
                    selectedFragment = new Add_Employee_Fragment ();
                    break;
                case R.id.nav_editEmployee:
                    selectedFragment = new Edit_Employee_Fragment ();
                    break;
                case R.id.nav_removeEmployee:
                    selectedFragment = new Remove_Employee_Fragment ();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            return true;
        }
    };

}
