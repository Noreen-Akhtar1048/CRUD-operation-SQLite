package com.shahbaz.sqlitecrudeassignment2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText name, iD, designation, salary, age, bonus;
    private Button saveBtn, updateBtn, deleteBtn, viewBtn;
    private Intent intent;
    private String Name, ID, Designation, Salary, Age, Bonus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        iD = findViewById(R.id.id);
        designation = findViewById(R.id.designation);
        salary = findViewById(R.id.salary);
        age = findViewById(R.id.age);
        bonus = findViewById(R.id.bonus);
        saveBtn = findViewById(R.id.saveDataBtn);
        viewBtn = findViewById(R.id.viewData);
        updateBtn = findViewById(R.id.updateData);
        deleteBtn = findViewById(R.id.deleteData);

        DatabaseHandlerClass databaseHandlerClass = new DatabaseHandlerClass(getApplicationContext());

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name = name.getText().toString();
                Age = age.getText().toString();
                Designation = designation.getText().toString();
                Salary = salary.getText().toString();
                Bonus = bonus.getText().toString();
                ID = iD.getText().toString();
                if (TextUtils.isEmpty(Name) || TextUtils.isEmpty(Age) || TextUtils.isEmpty(Designation)
                        || TextUtils.isEmpty(Salary) || TextUtils.isEmpty(Bonus) || TextUtils.isEmpty(ID)) {
                    Toast.makeText(getApplicationContext(), "Please fill all the fields...", Toast.LENGTH_SHORT).show();
                    return;
                }
                employeeClass employeeClas = new employeeClass(Name, Designation, Integer.parseInt(ID), Integer.parseInt(Salary), Integer.parseInt(Bonus), Integer.parseInt(Age));
                databaseHandlerClass.insertData(employeeClas);
            }
        });
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), UpdateDataActivity.class);
                startActivity(intent);
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), DeleteActivity.class);
                startActivity(intent);
            }
        });
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), ViewDataActivity.class);
                startActivity(intent);

            }
        });

    }
}