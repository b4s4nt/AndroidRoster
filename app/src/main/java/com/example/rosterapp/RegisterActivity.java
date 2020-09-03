package com.example.rosterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    /*Decleration of Variables*/
    private Button RegisterUser;
    private EditText RegName;
    private EditText RegPassword;
    private EditText CRegPassword;
    private EditText RegEmail;
    private EditText RegMobile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

/*       Get data from the UI */
        RegPassword = (EditText) findViewById(R.id.et_password);
        RegName = (EditText) findViewById(R.id.et_fullname);
        RegEmail = (EditText) findViewById(R.id.et_emailadd);
        RegisterUser = (Button) findViewById(R.id.btn_signup);
        RegMobile = (EditText) findViewById(R.id.et_mobileno);
        CRegPassword = (EditText) findViewById(R.id.et_cpassword);
        /*On click lister for register or signup */
        RegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                registerUser(RegName.getText(), RegEmail.getText(), RegPassword.getText());
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);// Move to the main activity


            }


        });


    }

    private void registerUser(Editable name, Editable email, Editable password) {
        // Creating object of databasehelper class as db
        DatabaseHelper db = new DatabaseHelper(this);// here you have to pass context object ie this (object of this class)

        /*Note we have to create object  to call methods of that class */
        try {
            db.insertIntoSignUpTable(name.toString(), email.toString(), password.toString());// calling insertIntoSignUpTable methods in class databasehelper
            Toast.makeText(RegisterActivity.this, "New Account Created", Toast.LENGTH_LONG).show();


        } catch (Exception e) {
            System.out.println(e.toString());
            Toast.makeText(RegisterActivity.this, e.toString(), Toast.LENGTH_LONG).show();


        }
    }
}
