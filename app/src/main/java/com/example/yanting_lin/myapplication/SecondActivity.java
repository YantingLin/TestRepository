package com.example.yanting_lin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

public class SecondActivity extends ActionBarActivity {
        private static int TRANSFER_KEY1 = 753;
        private static String SECOND_ACTIVITY_TAG = "SecondActivity";
        private static String PUT_DATA_NAME1 = "ResponseFromSecondActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.v(SECOND_ACTIVITY_TAG, "(1) OverrideOnCreate");
        Intent intent = getIntent();
        //取得MainActivity單方傳送之資料
        Log.v(SECOND_ACTIVITY_TAG, "DataFromMainActivity："+ intent.getExtras()
                .getString("ValueFromMainActivity"));
        //資料放置後，直接結束回傳。
        Bundle bundle = new Bundle();
        bundle.putString(PUT_DATA_NAME1, "ABCDEFG");
        intent.putExtras(bundle);
        setResult(TRANSFER_KEY1, intent);
       // finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(SECOND_ACTIVITY_TAG, "(2) OverrideOnStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(SECOND_ACTIVITY_TAG, "(3) OverrideOnResume");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.v(SECOND_ACTIVITY_TAG, "(4) OverrideOnPause");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.v(SECOND_ACTIVITY_TAG, "(5) OverrideOnStop");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(SECOND_ACTIVITY_TAG, "(6) OverrideOnDestroy");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        Log.v(SECOND_ACTIVITY_TAG, "(7) OverrideOnSaveInstanceState");
    }




}
