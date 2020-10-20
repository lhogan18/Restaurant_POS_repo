package com.example.restaurant_pos;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddEmployee extends AppCompatActivity {
    DataBaseHelper myDb;
    EditText editIDNumber, editName, editPhoneNumber, editAddress, editWage, editPaymentType;
    Button btnAddData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        myDb = new DataBaseHelper(this);

        editIDNumber = (EditText) findViewById(R.id.editText_IDNumber);
        editName = (EditText) findViewById(R.id.editText_Name);
        editPhoneNumber = (EditText) findViewById(R.id.editText_PhoneNumber);
        editAddress = (EditText) findViewById(R.id.editText_Address);
        editWage = (EditText) findViewById(R.id.editText_Wage);
        editPaymentType = (EditText) findViewById(R.id.editText_PaymentType);
        btnAddData = (Button) findViewById(R.id.AddData);
        AddData();
    }

    public void AddData(){
        btnAddData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                boolean isInserted = myDb.insertData(editIDNumber.getText().toString(),
                        editName.getText().toString(),
                        editPhoneNumber.getText().toString(),
                        editAddress.getText().toString(),
                        editWage.getText().toString(),
                        editPaymentType.getText().toString());
                if(isInserted == true)
                    Toast.makeText(AddEmployee.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AddEmployee.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
