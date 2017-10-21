package com.example.song.mobilesw;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Song on 2017-10-22.
 */

public class TimeLine extends ListFragment {

    TimeLineList timeLineList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        timeLineList = new TimeLineList();
        setListAdapter(timeLineList);


        Resources res = getResources();

        for(int i = 1; i<4; i++)
        {
            int id_image = res.getIdentifier("pt_image0"+i,"drawable", getActivity().getPackageName());
            Drawable image = res.getDrawable(id_image);
            int id_writer = res.getIdentifier("pt_writer0"+i,"string",getActivity().getPackageName());
            String writer = res.getString(id_writer);
            int id_title = res.getIdentifier("pt_title0"+i,"string", getActivity().getPackageName());
            String title = res.getString(id_title);
            int id_body = res.getIdentifier("pt_body0"+i, "string", getActivity().getPackageName());
            String body = res.getString(id_body);
            timeLineList.addItem(image, writer, title, body);
        }

        return  super.onCreateView(inflater, container, savedInstanceState);
    }
}
