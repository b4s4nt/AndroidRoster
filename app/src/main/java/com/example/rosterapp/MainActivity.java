package com.example.rosterapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private TextView Register;
    private CardView Login;
    private TextView Name;
    private TextView Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Register = (TextView) findViewById(R.id.textView2);
        Login = (CardView) findViewById(R.id.cardView);
        Name = (TextView) findViewById(R.id.et_name);
        Password = (TextView) findViewById(R.id.et_password);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (!Name.getText().toString().isEmpty()) {

                    if (!Password.getText().toString().isEmpty()) {
                        validate((Name.getText()).toString().trim(), (Password.getText()).toString().trim());


                    } else {
                        Toast.makeText(MainActivity.this, "Password Field Is Empty", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Name Field Is Empty", Toast.LENGTH_LONG).show();

                }


            }
        });


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });


    }

    private void validate(String userName, String userPassword) {


        // List<String> usernameList= new ArrayList<>();
        String password;
        DatabaseHelper db = new DatabaseHelper(this);
        //usernameList=db.getAllUserNameFromDatabase();


        password = db.getSpecificColumnValueOnMatching(DatabaseHelper.signUpTableName, userName.trim());


        if (userPassword.equals(password.trim())) {


            Intent intent = new Intent(MainActivity.this, DashBoardActivity.class);
            startActivity(intent);


        } else {
            Toast.makeText(MainActivity.this,
                    "Incorrect Password Or Name", Toast.LENGTH_LONG).show();

        }

    }

}