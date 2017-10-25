package com.example.song.mobilesw;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Song on 2017-10-25.
 */

public class Timeline extends ListFragment {
    ListViewAdapter adapter;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        adapter = new ListViewAdapter();
        setListAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.cat), getString(R.string.pt_writer01), getString(R.string.pt_title01), getString(R.string.pt_body01));
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.cat), getString(R.string.pt_writer01), getString(R.string.pt_title01), getString(R.string.pt_body01));
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.cat), getString(R.string.pt_writer01), getString(R.string.pt_title01), getString(R.string.pt_body01));

        return super.onCreateView(inflater, container, savedInstanceState);

    }
    public interface OnFragmentInteractionListener {
        // 인수 유형 및 이름 업데이트
        void onFragmentInteraction(Uri uri);
    }

}
