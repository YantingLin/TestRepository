package com.example.yanting_lin.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;


public class SecondActivity extends FragmentActivity implements View.OnClickListener,ContentFragment.OnContentSelectedListener  {

    private static String SECOND_ACTIVITY_TAG = "SecondActivity";
    private static String KEY_PUT_DATA_NAME = "ResponseFromSecondActivity";
    private static int ARTICLE_FRAGMENT_ID = 0;

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
        bundle.putString(KEY_PUT_DATA_NAME, "ABCDEFG");
        intent.putExtras(bundle);
        setResult(753, intent);
       // finish();

        //Fragment Change Action
        final Button changeFragmentButton = (Button) findViewById(R.id.change_button);
        changeFragmentButton.setOnClickListener(this);

        //Fragment Dynamically Create
        if(findViewById(R.id.fragment_container)!=null){
            if(savedInstanceState != null){
                return;
            }
            ArticleFragment firstFragment = new ArticleFragment();
            firstFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();

            ContentFragment secondFragment = new ContentFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, secondFragment).commit();
            Log.v(SECOND_ACTIVITY_TAG, secondFragment.getId() + "Content_FRAGMENT_ID's Value");
        }

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


    public void onClick(View view){
//        switch (){
//           case R.layout.article_fragment:
                //Replace firstFragment
                ContentFragment secondFragment = new ContentFragment();
                FragmentTransaction SecondTransaction = getSupportFragmentManager().beginTransaction();
                SecondTransaction.replace(R.id.fragment_container,secondFragment);
                SecondTransaction.addToBackStack(null);
                SecondTransaction.commit();
//                break;
//            case R.layout.content_fragment:
//                //Replace secondFragment
//                ArticleFragment firstFragment = new ArticleFragment();
//                FragmentTransaction firstTransaction = getSupportFragmentManager().beginTransaction();
//                firstTransaction.replace(R.id.fragment_container,firstFragment);
//                firstTransaction.addToBackStack(null);
//                firstTransaction.commit();
//                break;
//        }

    }

    public void onArticleSelected(int position){
        //Check ArticleFragment exist or not
        //有Try Catch就可以傳送資料
        //Log.v(SECOND_ACTIVITY_TAG, getSupportFragmentManager().getFragments().get(0));

        ArticleFragment checkFragment = (ArticleFragment) getSupportFragmentManager()
                .getFragments().get(0);

        if (checkFragment!=null){
            checkFragment.updateArticleView(position);
            Log.v(SECOND_ACTIVITY_TAG, "onArticleSelected&firstFragment!=NULL");
        }
        else {
            Log.v(SECOND_ACTIVITY_TAG,"firstFragment is NULL");
            ArticleFragment newFragment = new ArticleFragment();
            Bundle args = new Bundle();
            args.putInt(ArticleFragment.ARG_POSITION, position);
            newFragment.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }




}
