package com.shahbaz.sqlitecrudeassignment2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteActivity extends AppCompatActivity {
    private EditText deleteID;
    private Button deleteTBtn,deletBack;
    private DatabaseHandlerClass databaseHandlerClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        databaseHandlerClass = new DatabaseHandlerClass(getApplicationContext());
        deleteID = findViewById(R.id.dID);
        deleteTBtn = findViewById(R.id.dBTn);
        deletBack = findViewById(R.id.dback);
        deleteTBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHandlerClass.delete(Integer.parseInt(deleteID.getText().toString()));
                Toast.makeText(getApplicationContext(), "Record is deleted!!!", Toast.LENGTH_SHORT).show();

            }
        });
        deletBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}