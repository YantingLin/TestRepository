package com.example.yanting_lin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

public class Sencond_Activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sencond_);
        Log.i("Second_ActivityStage", "(1) OverrideOnCreate");
        Intent intent = getIntent();
        //取得MainActivity單方傳送之資料
        Log.i("DataFromMainActivity", intent.getExtras().getString("ValueFromMainActivity"));
        //資料放置後，直接結束回傳。
        Bundle bundle = new Bundle();
        bundle.putString("ResponseFromSecondActivity", "ABCDEFG");
        intent.putExtras(bundle);
        setResult(753, intent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Second_ActivityStage", "(2) OverrideOnStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Second_ActivityStage", "(3) OverrideOnResume");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i("Second_ActivityStage", "(4) OverrideOnPause");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Second_ActivityStage", "(5) OverrideOnStop");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Second_ActivityStage", "(6) OverrideOnDestroy");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        Log.i("Second_ActivityStage", "(7) OverrideOnSaveInstanceState");
    }




}
