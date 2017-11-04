package com.example.song.mobilesw;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by USER on 2017-11-04.
 */

public class Info_item extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_item);

        Intent it = getIntent();
        String tag = it.getStringExtra("it_tag");

        LinearLayout layout_info = (LinearLayout)findViewById(R.id.info);
        TextView tv_title = (TextView)findViewById(R.id.info_title);
        TextView tv_date = (TextView)findViewById(R.id.info_date);
        TextView tv_writer = (TextView)findViewById(R.id.info_writer);
        TextView tv_body = (TextView)findViewById(R.id.info_body);

        Resources res = getResources();

        int stringId;
        String myKey;

        int id_title = res.getIdentifier("title" + tag, "string", getPackageName());
        String title = res.getString(id_title);
        tv_title.setText(title);

        int id_writer = res.getIdentifier("writer" + tag, "string", getPackageName());
        String writer = res.getString(id_writer);
        tv_writer.setText(writer);

        int id_date = res.getIdentifier("date" + tag, "string", getPackageName());
        String date = res.getString(id_date);
        tv_date.setText(date);
        int id_body = res.getIdentifier("body" + tag, "string", getPackageName());
        String body = res.getString(id_body);
        tv_body.setText(body);



    }
}

