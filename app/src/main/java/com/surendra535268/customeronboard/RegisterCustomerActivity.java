package com.surendra535268.customeronboard;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterCustomerActivity extends AppCompatActivity {

    EditText editAadharPart1, editAadharPart2, editAadharPart3, editAadharPart4;
    EditText editAadharPart5, editAadharPart6, editAadharPart7, editAadharPart8;
    EditText editAadharPart9, editAadharPart10, editAadharPart11, editAadharPart12;
    EditText editSSN;
    EditText editPassport, editAltContNumber, editEmail;

    ImageView imgIndia, imgOthers;

    Button btnFetchDetails;
    Typeface tf, tfEdit;
    TextView textviewOR;
    ProgressDialog pDialog;
    String editStrAadharNumber = "", editStrPassportNumber = "", editStrAltContNumber = "", editStrEmailAdd = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_customer);

        tf = Typeface.createFromAsset(getAssets(), "fonts/Sweetie.ttf");
        tfEdit = Typeface.createFromAsset(getAssets(), "fonts/calibri.ttf");

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

        editSSN = (EditText) findViewById(R.id.editSSN);
        editPassport = (EditText) findViewById(R.id.editPassport);
        editAltContNumber = (EditText) findViewById(R.id.editAltContNumber);
        editEmail = (EditText) findViewById(R.id.editEmail);

        editAadharPart1.setTypeface(tfEdit);
        editAadharPart2.setTypeface(tfEdit);
        editAadharPart3.setTypeface(tfEdit);
        editAadharPart4.setTypeface(tfEdit);
        editAadharPart5.setTypeface(tfEdit);
        editAadharPart6.setTypeface(tfEdit);
        editAadharPart7.setTypeface(tfEdit);
        editAadharPart8.setTypeface(tfEdit);
        editAadharPart9.setTypeface(tfEdit);
        editAadharPart10.setTypeface(tfEdit);
        editAadharPart11.setTypeface(tfEdit);
        editAadharPart12.setTypeface(tfEdit);
        editSSN.setTypeface(tfEdit);
        editPassport.setTypeface(tfEdit);
        editAltContNumber.setTypeface(tfEdit);
        editEmail.setTypeface(tfEdit);

        textviewOR = (TextView) findViewById(R.id.textviewOR);
        textviewOR.setTypeface(tf);

        btnFetchDetails = (Button) findViewById(R.id.btnFetchDetails);
        btnFetchDetails.setTypeface(tf);

        btnFetchDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editStrAadharNumber = editAadharPart1.getText().toString() +
                        editAadharPart2.getText().toString() +
                        editAadharPart3.getText().toString() +
                        editAadharPart4.getText().toString() + "-" +
                        editAadharPart5.getText().toString() +
                        editAadharPart6.getText().toString() +
                        editAadharPart7.getText().toString() +
                        editAadharPart8.getText().toString() + "-" +
                        editAadharPart9.getText().toString() +
                        editAadharPart10.getText().toString() +
                        editAadharPart11.getText().toString() +
                        editAadharPart12.getText().toString();

                editStrPassportNumber = editPassport.getText().toString();

                editStrAltContNumber = editAltContNumber.getText().toString();
                editStrEmailAdd = editEmail.getText().toString();

                if(editStrAadharNumber.length() == 0 && editStrPassportNumber.length() == 0 ) {
                    Toast.makeText(RegisterCustomerActivity.this, "Enter Aadhar or Passport number", Toast.LENGTH_LONG).show();
                }else if(editStrAadharNumber.length() !=0 && editStrAadharNumber.length() != 14){
                    Toast.makeText(RegisterCustomerActivity.this, "One or more fields of Aadhar number are empty", Toast.LENGTH_LONG).show();
                }else if(editStrPassportNumber.length() !=0 && editStrPassportNumber.length() < 8){
                    Toast.makeText(RegisterCustomerActivity.this, "Enter proper passport number", Toast.LENGTH_LONG).show();
                }else {
                    if (editStrEmailAdd.length() == 0) {
                        Toast.makeText(RegisterCustomerActivity.this, "Email address is mandatory", Toast.LENGTH_LONG).show();
                    }else if(! android.util.Patterns.EMAIL_ADDRESS.matcher(editStrEmailAdd).matches()) {
                        Toast.makeText(RegisterCustomerActivity.this, "Enter correct email address", Toast.LENGTH_LONG).show();
                    } else {

                        new CheckUserDetails().execute();

                    }
                }
            }
        });

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
//
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
//
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


    // Async Task Class
    class CheckUserDetails extends AsyncTask<String, String, String> {

        int status = 0;
        // Show Progress bar before downloading Music
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(RegisterCustomerActivity.this);
            pDialog.setMessage("Fetching your details...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        // Download Music File from Internet
        @Override
        protected String doInBackground(String... f_url) {

            try {
                Thread.sleep(3000);
            }catch (Exception e){}

            status = 1;
            publishProgress();

            try {
                Thread.sleep(3000);
            }catch (Exception e){}

            return null;
        }

        // While Downloading Music File
        protected void onProgressUpdate(String... progress) {

            if(status == 1)
                pDialog.setMessage("Data fetched successfully...\nPlease validate your data!!");

        }

        // Once Music File is downloaded
        @Override
        protected void onPostExecute(String file_url) {


            Intent i = new Intent(RegisterCustomerActivity.this, MainActivity.class);
            startActivity(i);
        }
    }

}
