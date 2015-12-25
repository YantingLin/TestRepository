package com.example.yanting_lin.myapplication;

import android.app.Activity;
import android.os.Bundle;
//import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.EditText;
import android.widget.TextView;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;


/**
 * ForSecondActivityUsed
 * Created by yanting_lin on 2015/12/22.
 *
 * List 寫法實作動態更新比較困難
 * 首先實作editBox的新增與送出
 * 之前撰寫的List 寫法已於2015/12/24 commit
 * Edit by yanting_lin on 2015/12/25
 */

public class ContentFragment extends Fragment {


    final static String TAG_Content_FRAGMENT = "ContentFragment";

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.v(TAG_Content_FRAGMENT, "FragmentOnAttach()");
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG_Content_FRAGMENT, "FragmentOnCreate()");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        Log.v(TAG_Content_FRAGMENT, "FragmentOnCreateView()");
        return inflater.inflate(R.layout.content_fragment, container, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Log.v(TAG_Content_FRAGMENT, "FragmentOnActivityCreated()");
    }

    public void onStart() {
        super.onStart();
        Log.v(TAG_Content_FRAGMENT, "onStart()");
    }

    public void onResume() {
        super.onResume();
        Log.v(TAG_Content_FRAGMENT, "onResume()");

    }


    public void updateContentView(String inputText) {
        TextView article = (TextView) getActivity().findViewById(R.id.textView2);
        article.setText(inputText);
    }

    public String getEditText() {
        EditText editText = (EditText) getActivity().findViewById(R.id.editText2);
        return editText.getText().toString();
    }


}
