package com.surendra535268.customeronboard;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.surendra535268.customeronboard.adapter.UploadListAdapter;

import org.w3c.dom.Text;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UploadActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_PICK_FILE = 1;

    private TextView mFilePathTextView;
    private Button mStartActivityButton, upload_button;
    private File selectedFile;
    private List<String> uploadItems;
    private UploadListAdapter uploadListAdapter;
    RecyclerView recList;
    private Button submitButton;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        // Set the views
        mFilePathTextView = (TextView) findViewById(R.id.file_path_text_view);
        mStartActivityButton = (Button) findViewById(R.id.start_file_picker_button);
        upload_button = (Button) findViewById(R.id.upload_button);

        mStartActivityButton.setOnClickListener(this);
        upload_button.setOnClickListener(this);

        recList = (RecyclerView) findViewById(R.id.uploadedList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        submitButton = (Button) findViewById(R.id.submitButton);
        uploadItems = new ArrayList();
        uploadListAdapter = new UploadListAdapter(this, uploadItems);
        recList.setAdapter(uploadListAdapter);

        uploadListAdapter.SetOnItemClickListener(new UploadListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                onListItemClick(view, position);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(uploadItems.size()!=0) {
                    startActivity(new Intent(UploadActivity.this, PlansActivity.class));
                }else {
                    Toast.makeText(UploadActivity.this, "", Toast.LENGTH_LONG).show();
                }

            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void onListItemClick(View v, int position) {
        Toast.makeText(this, "Clicked "+position+" file", Toast.LENGTH_LONG).show();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_file_picker_button:
                // Create a new Intent for the file picker activity
                Intent intent = new Intent(this, FilePickerActivity.class);

                // Set the initial directory to be the sdcard
                //intent.putExtra(FilePickerActivity.EXTRA_FILE_PATH, Environment.getExternalStorageDirectory());

                // Show hidden files
                //intent.putExtra(FilePickerActivity.EXTRA_SHOW_HIDDEN_FILES, true);

                // Only make .png files visible
                //ArrayList<String> extensions = new ArrayList<String>();
                //extensions.add(".png");
                //intent.putExtra(FilePickerActivity.EXTRA_ACCEPTED_FILE_EXTENSIONS, extensions);

                // Start the activity
                startActivityForResult(intent, REQUEST_PICK_FILE);
                break;

            case R.id.upload_button:

                String str = mFilePathTextView.getText().toString();
                if (str.equals(""))
                    Toast.makeText(UploadActivity.this, "Browse file to upload", Toast.LENGTH_LONG).show();
                else {
                    uploadItems.add(0, str);
                    uploadListAdapter.notifyDataSetChanged();

                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_PICK_FILE:
                    if (data.hasExtra(FilePickerActivity.EXTRA_FILE_PATH)) {
                        // Get the file path
                        selectedFile = new File(data.getStringExtra(FilePickerActivity.EXTRA_FILE_PATH));
                        // Set the file path text view
                        mFilePathTextView.setText(selectedFile.getPath());
                        //Now you have your selected file, You can do your additional requirement with file.
                    }
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Upload Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.surendra535268.customeronboard/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Upload Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.surendra535268.customeronboard/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}