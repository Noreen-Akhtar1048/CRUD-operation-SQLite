package com.shahbaz.sqlitecrudeassignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class viewAllDataActivity extends AppCompatActivity {
    private TextView name, iD, designation, salary, age, bonus;
    private Button goBackBtn;
    private int position;
    private DatabaseHandlerClass databaseHandlerClass;
    private employeeClass employeeClassList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_data);
        Intent i = getIntent();
        databaseHandlerClass = new DatabaseHandlerClass(getApplicationContext());
        position = Integer.parseInt(i.getStringExtra("position"));
        employeeClassList = databaseHandlerClass.getData().get(position);
        name = findViewById(R.id.vName);
        iD = findViewById(R.id.vID);
        designation = findViewById(R.id.vDesignation);
        salary = findViewById(R.id.vSalary);
        age = findViewById(R.id.vAGe);
        bonus = findViewById(R.id.vBonus);
        goBackBtn = findViewById(R.id.vGoback);

        name.setText("Name:  " + String.valueOf(employeeClassList.getName()));
        iD.setText("ID:  " +String.valueOf(employeeClassList.getID()));
        salary.setText("Salary:  " +String.valueOf(employeeClassList.getSalary())+"Rs");
        designation.setText("Designation:  " +String.valueOf(employeeClassList.getDesignation()));
        bonus.setText("Bonus:  " +String.valueOf(employeeClassList.getBonus())+"Rs");
        age.setText("Age:  " +String.valueOf(employeeClassList.getAge()));

        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}