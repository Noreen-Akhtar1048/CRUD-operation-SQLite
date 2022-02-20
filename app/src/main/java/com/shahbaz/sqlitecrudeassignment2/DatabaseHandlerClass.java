package com.shahbaz.sqlitecrudeassignment2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandlerClass extends SQLiteOpenHelper {

    public static final String ID = "ID";
    public static final String EMPLOYEEDATA = "EMPLOYEEDATA";
    public static final String NAME = "NAME";
    public static final String AGE = "AGE";
    public static final String DESIGNATION = "Designation";
    public static final String SALARY = "SALARY";
    public static final String BONUS = "BONUS";
    public Context context;
    public DatabaseHandlerClass(@Nullable Context context) {
        super(context, "EmployeeDB", null, 1);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createQuery = "CREATE TABLE " + EMPLOYEEDATA + " (" + ID + " INTEGER PRIMARY KEY," + NAME + " TEXT," + AGE
                + " INTEGER," + DESIGNATION + " TEXT," + SALARY + " INTEGER," + BONUS + " INTEGER)";
        sqLiteDatabase.execSQL(createQuery);

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertData(employeeClass employeeClas) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, employeeClas.getID());
        values.put(NAME, employeeClas.getName());
        values.put(AGE, employeeClas.getAge());
        values.put(DESIGNATION, employeeClas.getDesignation());
        values.put(SALARY, employeeClas.getSalary());
        values.put(BONUS, employeeClas.getBonus());

        if(db.insert(EMPLOYEEDATA, null, values)==-1){
            Toast.makeText(context, "Error occured while inserting data...", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Stored Data...", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
    public List<employeeClass> getData() {
        List<employeeClass> employeeClassArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from EMPLOYEEDATA", null);
        if (cursor.moveToFirst()) {
            do {
                employeeClass employeeClas = new employeeClass();
                employeeClas.setID(cursor.getInt(0));
                employeeClas.setName(cursor.getString(1));
                employeeClas.setAge(cursor.getInt(2));
                employeeClas.setDesignation(cursor.getString(3));
                employeeClas.setSalary(cursor.getInt(4));
                employeeClas.setBonus(cursor.getInt(5));
                employeeClassArrayList.add(employeeClas);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return employeeClassArrayList;
    }
    public void updateData(int Id, String name, String designation, int age, int bonus, int salary) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(DESIGNATION, designation);
        values.put(AGE, age);
        values.put(BONUS, bonus);
        values.put(SALARY, salary);
        if(db.update(EMPLOYEEDATA, values, "ID=?", new String[]{String.valueOf(Id)})==-1){
            Toast.makeText(context, "Error Occured while updating record!!!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Updated record...", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
    public void delete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + EMPLOYEEDATA + " WHERE " + ID + " = " + id + "");
        db.close();
    }
}
