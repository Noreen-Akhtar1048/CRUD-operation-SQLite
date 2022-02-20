package com.shahbaz.sqlitecrudeassignment2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class ViewDataActivity extends AppCompatActivity implements MyAdapterClass.onItemClickListenerInterface {
    private RecyclerView recyclerView;
    private DatabaseHandlerClass databaseHandlerClass;
    private Intent intent;
    private List<employeeClass> employeeClas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        databaseHandlerClass = new DatabaseHandlerClass(getApplicationContext());
        employeeClas = databaseHandlerClass.getData();
        if(employeeClas.size() == 0){
            Toast.makeText(getApplicationContext(), "No Record Found!!!", Toast.LENGTH_SHORT).show();
            return;
        }
        recyclerView = findViewById(R.id.recyclerView);
        MyAdapterClass adapter = new MyAdapterClass(getApplicationContext(), employeeClas,this::onitemClickListener);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onitemClickListener(int position) {
        intent = new Intent(getApplicationContext(),viewAllDataActivity.class);
        intent.putExtra("position",String.valueOf(position));
        startActivity(intent);
    }
}