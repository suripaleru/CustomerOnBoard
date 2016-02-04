package com.surendra535268.customeronboard;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textFirstName, textLastName ;
    EditText editAddress1, editAddress2, editPIN, editAltCntNumber, editEmail;
    ImageView imgPerson;
    Button btnVerify;
    Typeface tf, tfEdit;
    ProgressDialog pDialog;
    String editStrAdd1 = "", editStrAdd2 = "", editStrPin = "", editStrAltCntNum = "", editStrEmail = "";

    String strFirstName = "", strLastName = "", strAdd1 = "", strAdd2 = "", strPin = "", strAltCntNum = "", strEmail = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tf = Typeface.createFromAsset(getAssets(), "fonts/Sweetie.ttf");
        tfEdit = Typeface.createFromAsset(getAssets(), "fonts/calibri.ttf");

        textFirstName = (TextView) findViewById(R.id.textFirstName);
        textLastName = (TextView) findViewById(R.id.textLastName);

        editAddress1 = (EditText) findViewById(R.id.editAddress1);
        editAddress2 = (EditText) findViewById(R.id.editAddress2);
        editPIN = (EditText) findViewById(R.id.editPIN);
        editAltCntNumber = (EditText) findViewById(R.id.editAltCntNumber);
        editEmail = (EditText) findViewById(R.id.editEmail);

        imgPerson = (ImageView) findViewById(R.id.imgPerson);

        btnVerify = (Button) findViewById(R.id.btnVerify);

        textFirstName.setTypeface(tfEdit);
        textLastName.setTypeface(tfEdit);
        editAddress1.setTypeface(tfEdit);
        editAddress2.setTypeface(tfEdit);
        editPIN.setTypeface(tfEdit);
        editAltCntNumber.setTypeface(tfEdit);
        editEmail.setTypeface(tfEdit);
        btnVerify.setTypeface(tf);

        new FetchUserDetails().execute();

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editStrAdd1 = editAddress1.getText().toString();
                editStrAdd2 = editAddress2.getText().toString();
                editStrPin = editPIN.getText().toString();
                editStrAltCntNum = editAltCntNumber.getText().toString();
                editStrEmail = editEmail.getText().toString();;

                if(editStrAdd1.length() == 0)
                    Toast.makeText(MainActivity.this, "Please enter correct address", Toast.LENGTH_LONG).show();
                else if(editStrPin.length() == 0)
                    Toast.makeText(MainActivity.this, "Please enter PIN code", Toast.LENGTH_LONG).show();
                else if(editStrEmail.length() == 0)
                    Toast.makeText(MainActivity.this, "Please enter email address", Toast.LENGTH_LONG).show();
                else {

                        if((!editStrAdd1.equals(strAdd1)) || (!editStrAdd2.equals(strAdd2))) {

                            new AlertDialog.Builder(MainActivity.this)
                                    .setMessage("Address has been changed. Please upload the corresponding documents!")
                                    .setCancelable(false)
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {

                                            Intent i = new Intent(MainActivity.this, UploadActivity.class);
                                            startActivity(i);

                                        }
                                    })
                                    .setNegativeButton("Not now", null)
                                    .show();

                        }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Async Task Class
    class FetchUserDetails extends AsyncTask<String, String, String> {

        int status = 0;
        // Show Progress bar before downloading Music
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
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
                Thread.sleep(1000);
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

            pDialog.dismiss();

            strFirstName = "TATA";
            strLastName = "DNA";
            strAdd1 = "Chennai One Building, Chennai";
            strAdd2 = "T4F6";
            strPin = "600096";
            strEmail = "surendranadh.paleru@tcs.com";

            textFirstName.setText(strFirstName);
            textLastName.setText(strLastName);
            editAddress1.setText(strAdd1);
            editAddress2.setText(strAdd2);
            editPIN.setText(strPin);
            editAltCntNumber.setText(strAltCntNum);
            editEmail.setText(strEmail);
        }
    }

}
