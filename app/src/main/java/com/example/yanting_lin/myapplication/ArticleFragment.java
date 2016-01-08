package com.example.yanting_lin.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * ForSecondActivityUsed
 * Created by yanting_lin on 2015/12/22.
 */
public class ArticleFragment extends Fragment {

    final static String TAG_ARTICLE_FRAGMENT = "ArticleFragment";

    @Override
    //Note that this method was deprecated in API level 23. Using onAttach(Context) is better
    public void onAttach(Activity activity){
        super.onAttach(activity);
        Log.v(TAG_ARTICLE_FRAGMENT, "1. onAttach()");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG_ARTICLE_FRAGMENT, "2. onCreate()");

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        Log.v(TAG_ARTICLE_FRAGMENT, "3. onCreateView()");
        return inflater.inflate(R.layout.article_fragment, container, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Log.v(TAG_ARTICLE_FRAGMENT, "4. onActivityCreated()");
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.v(TAG_ARTICLE_FRAGMENT, "5. onStart()");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.v(TAG_ARTICLE_FRAGMENT, "6. onResume()");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.v(TAG_ARTICLE_FRAGMENT, "7. onPause()");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.v(TAG_ARTICLE_FRAGMENT, "8. onStop()");
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        Log.v(TAG_ARTICLE_FRAGMENT, "9. onDestroyView()");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.v(TAG_ARTICLE_FRAGMENT, "10. onDestroy()");
    }

    @Override
    public void onDetach(){
        super.onDetach();
        Log.v(TAG_ARTICLE_FRAGMENT, "11. onDetach()");
    }

    public void updateArticleView(String inputText) {
        TextView article = (TextView) getActivity().findViewById(R.id.textView);
        article.setText(inputText);
    }

    public String getEditText() {
        EditText editText = (EditText) getActivity().findViewById(R.id.editText);
        return editText.getText().toString();
    }

}
