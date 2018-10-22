package com.example.rizvyahmed.phonebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddContractActivity extends AppCompatActivity {
    EditText etName,etPhone;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contract);

        etName=(EditText)findViewById(R.id.editText);
        etPhone=(EditText)findViewById(R.id.editText2);
        dbHelper=new DBHelper(getApplicationContext());
    }

    public void saveContract(View btn){
        String name=etName.getText().toString().trim();
        String phone=etPhone.getText().toString().trim();

        ContactHolder values=new ContactHolder(name,phone);
       if (dbHelper.insertContact(values) != -1){

           setResult(RESULT_OK);
           finish();
        }

    }
}
