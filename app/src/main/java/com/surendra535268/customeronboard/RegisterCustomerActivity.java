package com.surendra535268.customeronboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class RegisterCustomerActivity extends AppCompatActivity {

    EditText editAadharPart1, editAadharPart2, editAadharPart3, editAadharPart4;
    EditText editAadharPart5, editAadharPart6, editAadharPart7, editAadharPart8;
    EditText editAadharPart9, editAadharPart10, editAadharPart11, editAadharPart12;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_customer);

        editAadharPart1 = (EditText) findViewById(R.id.editAadharPart1);
        editAadharPart2 = (EditText) findViewById(R.id.editAadharPart2);
        editAadharPart3 = (EditText) findViewById(R.id.editAadharPart3);
        editAadharPart4 = (EditText) findViewById(R.id.editAadharPart4);
        editAadharPart5 = (EditText) findViewById(R.id.editAadharPart5);
        editAadharPart6 = (EditText) findViewById(R.id.editAadharPart6);
        editAadharPart7 = (EditText) findViewById(R.id.editAadharPart7);
        editAadharPart8 = (EditText) findViewById(R.id.editAadharPart8);
        editAadharPart9 = (EditText) findViewById(R.id.editAadharPart9);
        editAadharPart10 = (EditText) findViewById(R.id.editAadharPart10);
        editAadharPart11 = (EditText) findViewById(R.id.editAadharPart11);
        editAadharPart12 = (EditText) findViewById(R.id.editAadharPart12);

        editAadharPart1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(editAadharPart1.getText().toString().length()==1)     //size as per your requirement
                {
                    editAadharPart2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        editAadharPart2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(editAadharPart2.getText().toString().length()==1)     //size as per your requirement
                {
                    editAadharPart3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editAadharPart3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(editAadharPart3.getText().toString().length()==1)     //size as per your requirement
                {
                    editAadharPart4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editAadharPart4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(editAadharPart4.getText().toString().length()==1)     //size as per your requirement
                {
                    editAadharPart5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editAadharPart5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(editAadharPart5.getText().toString().length()==1)     //size as per your requirement
                {
                    editAadharPart6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editAadharPart6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(editAadharPart6.getText().toString().length()==1)     //size as per your requirement
                {
                    editAadharPart7.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editAadharPart7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(editAadharPart7.getText().toString().length()==1)     //size as per your requirement
                {
                    editAadharPart8.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editAadharPart8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(editAadharPart8.getText().toString().length()==1)     //size as per your requirement
                {
                    editAadharPart9.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editAadharPart9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(editAadharPart9.getText().toString().length()==1)     //size as per your requirement
                {
                    editAadharPart10.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editAadharPart10.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(editAadharPart10.getText().toString().length()==1)     //size as per your requirement
                {
                    editAadharPart11.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editAadharPart11.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(editAadharPart11.getText().toString().length()==1)     //size as per your requirement
                {
                    editAadharPart12.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editAadharPart12.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(editAadharPart12.getText().toString().length()==1)     //size as per your requirement
                {
                    editAadharPart1.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
