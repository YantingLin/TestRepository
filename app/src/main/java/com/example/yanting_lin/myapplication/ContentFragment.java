package com.example.yanting_lin.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * ForSecondActivityUsed
 * Created by yanting_lin on 2015/12/22.
 */
public class ContentFragment extends ListFragment{
    OnContentSelectedListener mListener;
    final static String TAG_Content_FRAGMENT = "ContentFragment";

    public interface OnContentSelectedListener {
        void onArticleSelected(int position);
    }

    //還沒寫完，extend ListFragment會爆Error
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        Log.v(TAG_Content_FRAGMENT, "onAttach()");
        try {
            mListener = (OnContentSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnContentSelectedListener");
        }
    }
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        String[] presidents = { "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" };
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.abc_list_menu_item_checkbox,
                presidents));
        Log.v(TAG_Content_FRAGMENT, "FragmentOnCreate()");

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
      //        ListView listView =(ListView) getListView().findViewById(R.id.listView);
        Log.v(TAG_Content_FRAGMENT, "FragmentOnCreateView()");
        return  inflater.inflate(R.layout.content_fragment,container,false);
    }

    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        Log.v(TAG_Content_FRAGMENT, "FragmentOnActivityCreated()");
    }
    public void onStart(){
        super.onStart();
        Log.v(TAG_Content_FRAGMENT, "onStart()");
    }
    public void onResume(){
        super.onResume();
        Log.v(TAG_Content_FRAGMENT, "onResume()");

    }


    @Override
    public void onListItemClick(ListView listView,View view, int position, long id){
        Log.v(TAG_Content_FRAGMENT, "onListItemClick()");
        mListener.onArticleSelected(position);
    }

}
