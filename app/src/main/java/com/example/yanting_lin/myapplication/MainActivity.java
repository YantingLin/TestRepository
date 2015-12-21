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



    private final static int TRANSFER_KEY1 = 753;
    private final static String MAIN_ACTIVITY_TAG = "MainActivity";
    private final static String TOAST_FOR_RESPONSE_OK = "Thanks";
    private final static String TOAST_FOR_RESPONSE_CANCEL = "No~~~";
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(MAIN_ACTIVITY_TAG, "(1) OverrideOnCreate");
        if(savedInstanceState!=null) {
            Log.v(MAIN_ACTIVITY_TAG, String.valueOf(savedInstanceState.getInt("isShowDialog")));
            if(savedInstanceState.getInt("isShowDialog")==1) {
                dialog = dialogConstruction(getString(R.string.dialog_title),
                        getString(R.string.dialog_message),
                        getString(R.string.dialog_ok_button),
                        getString(R.string.dialog_cancel_button));
                dialog.show();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(MAIN_ACTIVITY_TAG, "(2) OverrideOnStart");
        final Button dialogButton = (Button) findViewById(R.id.dialog_button);
        dialogButton.setOnClickListener(this);

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

        try {
            if (dialog.isShowing()) {
                Log.e(MAIN_ACTIVITY_TAG, "dialogIsShowing");
                outState.putInt("isShowDialog", 1);
            }
        } catch (Exception e) {
            Log.v(MAIN_ACTIVITY_TAG,e.getMessage());
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
        try {
            if(dialog.isShowing()) {
                dialog.dismiss();
            }
        }
        catch (NullPointerException e){
            Log.e(MAIN_ACTIVITY_TAG, e.getMessage());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(MAIN_ACTIVITY_TAG, "(6) OverrideOnDestroy");
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
                                getString("ResponseFromSecondActivity"));
                break;
            default:
                Log.v(MAIN_ACTIVITY_TAG, "NoSuitableResultCode");
                break;
        }
    }

    /**
     *
     * @param title: Dialog Title name
     * @param message : Dialog Message text
     * @param ok : Dialog OK button text
     * @param cancel : Dialog Cancel button text
     * @return AlertDialog with initialization
     */
    protected AlertDialog dialogConstruction(String title,String message,String ok,String cancel){
        AlertDialog customAlertDialog;
        // Initialize AlertDialog
        customAlertDialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle(title)
                .setMessage(message)
                .create();
        customAlertDialog.setButton(-1, ok, this);
        customAlertDialog.setButton(-2 ,cancel,this);
        return customAlertDialog;
    }
    // Implement view.onClickListener's method
    public void onClick(View view){
        dialog = dialogConstruction(getString(R.string.dialog_title),
                getString(R.string.dialog_message),
                getString(R.string.dialog_ok_button),
                getString(R.string.dialog_cancel_button));
        dialog.show();
    }
    public void onClick(DialogInterface dialog,int id){
        switch (id) {
            case -1:
                //Positive Button
                Toast.makeText(MainActivity.this, TOAST_FOR_RESPONSE_OK,
                        Toast.LENGTH_LONG).show();
                //Activity Transfer
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SecondActivity.class);
                intent.putExtra("ValueFromMainActivity", "DataABCD");
                startActivityForResult(intent, TRANSFER_KEY1);
                //MainActivity.this.finish();
                break;
            case -2:
                //Negative Button
                Toast.makeText(MainActivity.this, TOAST_FOR_RESPONSE_CANCEL,
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
