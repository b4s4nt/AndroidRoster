package com.example.rosterapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Roster.db";

    public static final String username = "username";
    public static final String email = "email";
    public static final String password = "password";
    public static final String signUpTableName = "Register";



    // Variable for Add Employee....
    public static final String addEmployeTableName="Add_Employee";
    public static final String rosterSunDay="rosterSunDay";
    public static final String rosterMonDay="rosterMonDay";
    public static final String rosterTusDay="rosterTusDay";
    public static final String rosterWedDay="rosterWedDay";
    public static final String rosterThuDay="rosterThuDay";
    public static final String rosterFriDay="rosterFriDay";
    public static final String rosterSatDay="rosterSatDay";
    public static final String empName="empName";
    public static final String empEmail="empEmail";
    public static final String empMob="empMob";


    SQLiteDatabase db2;
    /*This is DatabaseHelper Constructor , when  an object of DatabaseHelper Class is created, it will initialise with following parramaters*/
    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
        System.out.println("Database Helper Constructor ");
    }
    @Override

    public void onCreate(SQLiteDatabase db) {
        db2=db;
    System.out.println("oncreate Database helper");
//        //Signup Table
        String signUpTableCreationQuery = "create table if not exists " + signUpTableName + "(" +
                username + " text," +
                email + " text," +
                password + " text)";
        db.execSQL(signUpTableCreationQuery);
        //Add Employee Table:

        String employeeRecordTable="create table if not exists " + addEmployeTableName + "(" +
                empName + " text," +
                empEmail + " text," +
                empMob + " text," +
                rosterSunDay + " text," +
                rosterMonDay + " text," +
                rosterTusDay + " text," +
                rosterWedDay + " text," +
                rosterThuDay + " text," +
                rosterFriDay + " text," +
                rosterSatDay + " text)";
        try {
            db.execSQL(employeeRecordTable);
            System.out.println(" HErer we are in Add Employee Table : Success");

        } catch (Exception e) {
            System.out.println(" HErer we are in Add Employee Table : Failed");
            e.printStackTrace();
        }



    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + signUpTableName);
        db.execSQL("DROP TABLE IF EXISTS " +addEmployeTableName );

        //Drop if exists
        onCreate(db);
    }

    // Table for registration :
    public boolean insertIntoSignUpTable(String name, String  email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.username, name);
        contentValues.put(this. email, email);
        contentValues.put(this.password, password);
        long flag = db.insert(signUpTableName, null, contentValues);
        return flag != -1;

    }

    // Table to add  new emplyee on list
    public boolean insertIntoemployeeRecordTable(String Name,String Email, String Mobile, List<String> rosterDay){
        System.out.println(" here we are in databasehelper:insertIntoemployeeRecordTable");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.empName, Name);
        contentValues.put(this. empEmail, Email);
        contentValues.put(this.empMob,Mobile);
        contentValues.put(this.rosterSunDay,rosterDay.get(0));
        contentValues.put(this.rosterMonDay,rosterDay.get(1));
        contentValues.put(this.rosterTusDay,rosterDay.get(2));
        contentValues.put(this.rosterWedDay,rosterDay.get(3));
        contentValues.put(this.rosterThuDay,rosterDay.get(4));
        contentValues.put(this.rosterFriDay,rosterDay.get(5));
        contentValues.put(this.rosterSatDay,rosterDay.get(6));

        long flag = db.insert(addEmployeTableName, null, contentValues);

        return flag != -1;
    }



// Query to get  check password of specific name :
    public String getSpecificColumnValueOnMatching (String tableName, String regName){
        String returnValue = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from " +tableName  + " where " +  DatabaseHelper.username + " = '" +regName +"'", null);

        if (rs != null && rs.getCount() > 0) {
            rs.moveToFirst();
            returnValue = rs.getString(rs.getColumnIndex(DatabaseHelper.password));
            rs.close();
        }
        System.out.println("Here is Required Return Value:"+returnValue);
        return returnValue;
    }

    public List getAllValue(String tableName){
        List< String> returnValue = new ArrayList<String>();//
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs= db.rawQuery("select * from  Add_Employee ",null);
        System.out.println(rs.getColumnCount());
        System.out.println("Database Helper in get all Values befor Curssor");
       // System.out.println(rs.getString(0));
//        int i =0;
//        for (rs.moveToFirst(); !rs.isAfterLast(); rs.moveToNext()) {
//            returnValue.add(rs.getString(i));
//            i++;
//
//        }
//        System.out.println(returnValue.get(0));
          return returnValue;

    }


    // general method to get  getSpecificRowValueOnMatchingColumnName
    public Object getSpecificRowValueOnMatchingColumnName(String tableName, String matchingColumn, String equalsTo) {

        List< String> returnValue = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs= db.rawQuery("select * from"+tableName +"where"+matchingColumn +"='"+equalsTo+"'",null);
        int i =0;
       for (rs.moveToFirst(); !rs.isAfterLast(); rs.moveToNext()) {
        returnValue.add(rs.getString(i));
        i++;

      }
        return returnValue;

    }

}