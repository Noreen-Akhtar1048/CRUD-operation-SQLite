package com.shahbaz.sqlitecrudeassignment2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateDataActivity extends AppCompatActivity {
    private EditText name, iD, designation, salary, age, bonus;
    private Button saveBtn, goBack;
    private DatabaseHandlerClass databaseHandlerClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseHandlerClass = new DatabaseHandlerClass(getApplicationContext());
        setContentView(R.layout.activity_update_data);
        name = findViewById(R.id.uname);
        iD = findViewById(R.id.uid);
        designation = findViewById(R.id.udesignation);
        salary = findViewById(R.id.usalary);
        age = findViewById(R.id.uage);
        bonus = findViewById(R.id.ubonus);
        saveBtn = findViewById(R.id.usaveDataBtn);
        goBack = findViewById(R.id.uBack);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(name.getText().toString()) || TextUtils.isEmpty(age.getText().toString()) || TextUtils.isEmpty(designation.getText().toString())
                        || TextUtils.isEmpty(salary.getText().toString()) || TextUtils.isEmpty(bonus.getText().toString()) || TextUtils.isEmpty(iD.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please fill all the fields...", Toast.LENGTH_SHORT).show();
                    return;
                }
                databaseHandlerClass.updateData(Integer.parseInt(iD.getText().toString()),
                        name.getText().toString(), designation.getText().toString(), Integer.parseInt(age.getText().toString())
                        , Integer.parseInt(bonus.getText().toString()), Integer.parseInt(salary.getText().toString()));
            }
        });
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}