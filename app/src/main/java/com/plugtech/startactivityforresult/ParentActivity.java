package com.plugtech.startactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ParentActivity extends AppCompatActivity implements View.OnClickListener {

    public static String TAG = "ParentActivity";
    private static int REQUEST_CODE_CHILD_ACTIVITY = 0;

    private TextView mTextView;
    private Button mButtonNavigateToChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);

        mButtonNavigateToChild = (Button) findViewById(R.id.activity_parent_button_navigate_to_child);
        mTextView = (TextView) findViewById(R.id.activity_parent_text_view_result);

        mButtonNavigateToChild.setOnClickListener(this);
        mTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.activity_parent_button_navigate_to_child:
                navigateToChildActivity();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_CODE_CHILD_ACTIVITY) {
            if (data == null) {
                return;
            }

            String resultString = data.getStringExtra(ChildActivity.RESULT_TO_SEND_FROM_CHILD_TO_PARENT);

            mTextView.setText(resultString);
        }
    }

    private void navigateToChildActivity() {
        startActivityForResult(new Intent(ParentActivity.this, ChildActivity.class), REQUEST_CODE_CHILD_ACTIVITY);
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


