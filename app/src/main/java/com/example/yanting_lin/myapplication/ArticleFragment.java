package com.example.yanting_lin.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * ForSecondActivityUsed
 * Created by yanting_lin on 2015/12/22.
 *
 */
public class ArticleFragment extends Fragment {
    final static String ARG_POSITION = "position";
    final static String TAG_ARTICLE_FRAGMENT = "ArticleFragment";
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        Log.v(TAG_ARTICLE_FRAGMENT, "FragmentCreate");

        return  inflater.inflate(R.layout.article_fragment,container,false);
    }
    public void updateArticleView(int position) {
        TextView article = (TextView) getActivity().findViewById(R.id.textView);
        article.setText("傳值：" + position);
    }
}
