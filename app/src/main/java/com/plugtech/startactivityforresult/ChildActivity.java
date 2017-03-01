package com.plugtech.startactivityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChildActivity extends AppCompatActivity implements View.OnClickListener {

    public static String TAG = "ChildActivity";
    public static String RESULT_TO_SEND_FROM_CHILD_TO_PARENT =
            "com.plugtech.startactivityforresult.RESULT_TO_SEND_FROM_CHILD_TO_PARENT";

    private EditText mEditText;
    private Button mButtonSaveInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        mEditText = (EditText) findViewById(R.id.activity_child_edit_text_return_this);
        mButtonSaveInput = (Button) findViewById(R.id.activity_child_button_save_input);

        mButtonSaveInput.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.activity_child_button_save_input:
                saveInput();
            default:
                break;
        }
    }

    private void saveInput() {
        String value = mEditText.getText().toString().trim();

        Intent intent = new Intent();
        intent.putExtra(RESULT_TO_SEND_FROM_CHILD_TO_PARENT, value);
        setResult(RESULT_OK, intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Activity restarted.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Activity started.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Activity resumed.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Activity paused.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Activity stopped.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Activity destroyed.");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "Restore instance.");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "Save instance.");

    }
}


