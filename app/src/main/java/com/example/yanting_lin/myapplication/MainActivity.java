package com.example.yanting_lin.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity
        implements View.OnClickListener, DialogInterface.OnClickListener {

    private final static String KEY_DIALOG = "isShowDialog";
    private final static String KEY_SECOND_ACTIVITY = "ResponseFromSecondActivity";
    private final static String MAIN_ACTIVITY_TAG = "MainActivity";
    private final static String TOAST_FOR_RESPONSE_OK = "Thanks";
    private final static String TOAST_FOR_RESPONSE_CANCEL = "No~~~";
    private AlertDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button dialogButton = (Button) findViewById(R.id.dialog_button);
        dialogButton.setOnClickListener(this);
        Log.v(MAIN_ACTIVITY_TAG, "(1) OverrideOnCreate");
        if(savedInstanceState!=null) {
            Log.v(MAIN_ACTIVITY_TAG, String.valueOf(savedInstanceState.getInt(KEY_DIALOG)));
            if(savedInstanceState.getInt(KEY_DIALOG)==1) {
                mDialog = dialogConstruction(R.string.dialog_title,
                        R.string.dialog_message,
                        R.string.dialog_ok_button,
                        R.string.dialog_cancel_button);
                mDialog.show();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(MAIN_ACTIVITY_TAG, "(2) OverrideOnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(MAIN_ACTIVITY_TAG, "(3) OverrideOnResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v(MAIN_ACTIVITY_TAG, "(7) OverrideOnSaveInstanceState");


        if (mDialog!=null) {
            if(mDialog.isShowing()) {
                Log.v(MAIN_ACTIVITY_TAG, "dialogIsShowing");
                outState.putInt(KEY_DIALOG, 1);
            }
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(MAIN_ACTIVITY_TAG, "(4) OverrideOnPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.v(MAIN_ACTIVITY_TAG, "(5) OverrideOnStop");
     }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(MAIN_ACTIVITY_TAG, "(6) OverrideOnDestroy");
        if(mDialog!=null) {
            if(mDialog.isShowing()) {
                mDialog.dismiss();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Log.v(MAIN_ACTIVITY_TAG, "(8) OverrideOnActivityResult");
        switch (resultCode) {
            //resultCode 要與startActivityForResult所設定的requestCode相同
            case 753:
                Log.v(MAIN_ACTIVITY_TAG,
                        "DataFromSecondActivity：" + data.getExtras().
                                getString(KEY_SECOND_ACTIVITY));
                break;
            default:
                Log.v(MAIN_ACTIVITY_TAG, "NoSuitableResultCode");
                break;
        }
    }

    /**
     *
     * @param titleID: Dialog Title name ID
     * @param messageID : Dialog Message ID
     * @param okID : Dialog OK button ID
     * @param cancelID : Dialog Cancel button ID
     * @return AlertDialog with initialization
     */
    protected AlertDialog dialogConstruction(int titleID,int messageID,int okID,int cancelID){
        AlertDialog customAlertDialog;
        // Initialize AlertDialog
        customAlertDialog = new AlertDialog.Builder(this)
                .setTitle(getText(titleID))
                .setMessage(getText(messageID))
                .create();

        customAlertDialog.setButton(DialogInterface.BUTTON_POSITIVE, getText(okID), this);
        customAlertDialog.setButton(DialogInterface.BUTTON_NEGATIVE ,getText(cancelID),this);
        return customAlertDialog;
    }
    // Implement view.onClickListener's method
    public void onClick(View view){
        mDialog = dialogConstruction(R.string.dialog_title,
                R.string.dialog_message,
                R.string.dialog_ok_button,
                R.string.dialog_cancel_button);
        mDialog.show();
        //switch (view.getId())
    }
    public void onClick(DialogInterface dialog,int id){
        switch (id) {
            case DialogInterface.BUTTON_POSITIVE:
                //Positive Button
                Toast.makeText(this, TOAST_FOR_RESPONSE_OK,
                        Toast.LENGTH_LONG).show();
                //Activity Transfer
                Intent intent = new Intent();
                intent.setClass(this, SecondActivity.class);
                intent.putExtra("ValueFromMainActivity", "DataABCD");
                startActivityForResult(intent, 753);
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                //Negative Button
                Toast.makeText(this, TOAST_FOR_RESPONSE_CANCEL,
                        Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
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



}
