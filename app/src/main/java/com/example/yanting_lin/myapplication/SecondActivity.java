package com.example.yanting_lin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;

/**
 * 承接 2015/12/24 ContentFragment.java的註解
 * 原先要implement ContentFragment.OnContentSelectedListener
 */

public class SecondActivity extends FragmentActivity implements View.OnClickListener {

    private static final String SECOND_ACTIVITY_TAG = "SecondActivity";
    private static final String KEY_PUT_DATA_NAME = "ResponseFromSecondActivity";
    private boolean isContentSet = false;
    //動態產生的Fragment才需要
    private static final String TAG_FOR_FRAGMENT_CONTENT_CREATED = "ContentFragment";
    Button ContentFragmentButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.v(SECOND_ACTIVITY_TAG, "(1) OverrideOnCreate");
        Intent intent = getIntent();
        //取得MainActivity單方傳送之資料
        Log.v(SECOND_ACTIVITY_TAG, "DataFromMainActivity：" + intent.getExtras()
                .getString("ValueFromMainActivity"));
        //資料放置後，直接結束回傳
        Bundle bundle = new Bundle();
        bundle.putString(KEY_PUT_DATA_NAME, "ABCDEFG");
        intent.putExtras(bundle);
        setResult(753, intent);

        //Fragment Change Action
        final Button changeFragmentButton = (Button) findViewById(R.id.change_button);
        changeFragmentButton.setOnClickListener(this);

        final Button ArticleFragmentButton = (Button) findViewById(R.id.article_button);
        ArticleFragmentButton.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(SECOND_ACTIVITY_TAG, "(2) OverrideOnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(SECOND_ACTIVITY_TAG, "(3) OverrideOnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(SECOND_ACTIVITY_TAG, "(4) OverrideOnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(SECOND_ACTIVITY_TAG, "(5) OverrideOnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(SECOND_ACTIVITY_TAG, "(6) OverrideOnDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v(SECOND_ACTIVITY_TAG, "(7) OverrideOnSaveInstanceState");
    }


    public void onClick(View view) {
        Log.v(SECOND_ACTIVITY_TAG, "onClick event happened");
        ArticleFragment articleFragment;
        ContentFragment contentFragment;

        switch (view.getId()) {
            case R.id.change_button:
                //Add second Fragment
                Log.v(SECOND_ACTIVITY_TAG, "Get change button!");
                //Check second Fragment is created before or not
                if (getSupportFragmentManager()
                        .findFragmentByTag(TAG_FOR_FRAGMENT_CONTENT_CREATED) == null) {
                    ContentFragment secondFragment = new ContentFragment();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction SecondTransaction = fragmentManager
                            .beginTransaction();
                    SecondTransaction.add(R.id.vertical_layout_of_second_activity, secondFragment,
                            TAG_FOR_FRAGMENT_CONTENT_CREATED);
                    SecondTransaction.addToBackStack(null);
                    SecondTransaction.commit();
                    //可以同步
                    fragmentManager.executePendingTransactions();

                    Fragment checkContentFragment = getSupportFragmentManager()
                            .findFragmentByTag(TAG_FOR_FRAGMENT_CONTENT_CREATED);
                    //Content Button Event Initialization
                    if (!isContentSet && checkContentFragment != null) {
                        ContentFragmentButton = (Button) checkContentFragment.getView()
                                .findViewById(R.id.content_button);
                        if (ContentFragmentButton != null) {
                            ContentFragmentButton.setOnClickListener(this);
                            Log.v(SECOND_ACTIVITY_TAG, "Set Content button event");
                            isContentSet = true;
                        }
                    }

                }
                break;
            case R.id.article_button:
                //ArticleFragment transfer data to ContentFragment
                Log.v(SECOND_ACTIVITY_TAG, "Get article button!");
                articleFragment = (ArticleFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.article_Container);
                if (articleFragment != null) {
                    contentFragment = (ContentFragment) getSupportFragmentManager()
                            .findFragmentByTag(TAG_FOR_FRAGMENT_CONTENT_CREATED);
                    if (contentFragment != null) {
                        contentFragment.updateContentView(articleFragment.getEditText());
                    }
                }

                break;
            case R.id.content_button:
                //ContentFragment transfer data to ArticleFragment
                Log.v(SECOND_ACTIVITY_TAG, "Get content button!");
                contentFragment = (ContentFragment) getSupportFragmentManager()
                        .findFragmentByTag(TAG_FOR_FRAGMENT_CONTENT_CREATED);

                if (contentFragment != null) {
                    articleFragment = (ArticleFragment) getSupportFragmentManager()
                            .findFragmentById(R.id.article_Container);

                    if (articleFragment != null) {
                        articleFragment.updateArticleView(contentFragment.getEditText());
                    }
                }

        }
    }
}
