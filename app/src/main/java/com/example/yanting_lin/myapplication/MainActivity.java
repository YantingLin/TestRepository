package com.example.yanting_lin.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("ActivityStage", "(1) OverrideOnCreate");
        //Toast ToastMessage = Toast.makeText(this,"(1) OverrideOnCreate",Toast.LENGTH_LONG);
        //ToastMessage.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ActivityStage", "(2) OverrideOnStart");
        //Toast ToastMessage = Toast.makeText(this,"(2) OverrideOnStart",Toast.LENGTH_LONG);
        //ToastMessage.show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ActivityStage","(3) OverrideOnResume");
        //Toast ToastMessage = Toast.makeText(this,"(3) OverrideOnResume",Toast.LENGTH_LONG);
        //ToastMessage.show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("ActivityStage","(7) OverrideOnSaveInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ActivityStage", "(4) OverrideOnPause");
        //Toast ToastMessage = Toast.makeText(this,"(4) OverrideOnPause",Toast.LENGTH_LONG);
        //ToastMessage.show();

    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ActivityStage", "(5) OverrideOnStop");
        //Toast ToastMessage = Toast.makeText(this,"(5) OverrideOnStop",Toast.LENGTH_LONG);
        //ToastMessage.show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ActivityStage", "(6) OverrideOnDestroy");
        //Toast ToastMessage = Toast.makeText(this,"(6) OverrideOnDestroy",Toast.LENGTH_LONG);
        //ToastMessage.show();
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
