package com.example.yanting_lin.myapplication;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
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

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("ActivityStage", "(1) OverrideOnCreate");
        final Button DialogButton = (Button) findViewById(R.id.DialogButton);
        DialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initialize AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Kobayashi");
                builder.setMessage("Find a chair");
                builder.setPositiveButton("OK",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Toast ToastMessage = Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_LONG);
                        ToastMessage.show();
                        //Activity Transfer
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, Sencond_Activity.class);
                        intent.putExtra("ValueFromMainActivity", "DataABCD");
                        startActivityForResult(intent, 753);
                        //MainActivity.this.finish();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                   public void onClick(DialogInterface dialog,int id) {
                       //Toast ToastMessage = Toast.makeText(MainActivity.this,"No~~~",Toast.LENGTH_LONG);
                       //ToastMessage.show();
                   }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
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
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("ActivityStage", "(8) OverrideOnActivityResult");
        switch (resultCode){
            //resultCode 要與startActivityForResult所設定的requestCode相同
            case 753: {
                Log.i("DataFromSecondActivity",data.getExtras().getString("ResponseFromSecondActivity"));
            }
            break;
            default: {
                Log.i("Nothing","NoSuitableResultCode");
            }
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
