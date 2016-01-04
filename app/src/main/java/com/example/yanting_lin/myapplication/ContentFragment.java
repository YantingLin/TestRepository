package com.example.yanting_lin.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



/**
 * ForSecondActivityUsed
 * Created by yanting_lin on 2015/12/22.
 *
 */

public class ContentFragment extends Fragment implements View.OnClickListener{

    final static String TAG_Content_FRAGMENT = "ContentFragment";
    OnContentFragmentClickListener mCallback;

    public interface OnContentFragmentClickListener{
        void onButtonClicked();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.v(TAG_Content_FRAGMENT, "FragmentOnAttach()");
        try{
            mCallback = (OnContentFragmentClickListener) activity;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(
                    activity.toString() + " must implement OnHeadlineSelectedListener");
        }

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG_Content_FRAGMENT, "FragmentOnCreate()");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        Log.v(TAG_Content_FRAGMENT, "FragmentOnCreateView()");
        View view = inflater.inflate(R.layout.content_fragment,container,false);
        Button button = (Button) view.findViewById(R.id.content_button);
        button.setOnClickListener(this);
        return view;
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

    @Override
    public void onClick(View view){
        Log.v(TAG_Content_FRAGMENT, "OnClick()");
        mCallback.onButtonClicked();
    }


}
