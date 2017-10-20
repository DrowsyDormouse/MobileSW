package com.example.song.mobilesw;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Song on 2017-10-16.
 */

public class SettingProfile extends AppCompatActivity {


    ImageView image = null;
    final int REQ_CODE_SELECT_IMAGE=100;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_profile);

        Button btn_iv_pro = (Button) findViewById(R.id.set_pro_image);
        btn_iv_pro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,REQ_CODE_SELECT_IMAGE);
            }
        });

        Button btn_complete = (Button) findViewById(R.id.set_complete);
        btn_complete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        image.setImageURI(data.getData());

        Toast.makeText(getBaseContext(),"resultCode :" +requestCode,Toast.LENGTH_SHORT).show();

        if (requestCode==REQ_CODE_SELECT_IMAGE)
        {
            if (resultCode==Activity.RESULT_OK)
            {
                try {
                    Bitmap image_bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),data.getData());
                    ImageView image = (ImageView)findViewById(R.id.iv_profile);

                    image.setImageBitmap(image_bitmap);
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getImageNameToUri(Uri data)
    {
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(data,proj,null,null,null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

        cursor.moveToFirst();

        String imgpath = cursor.getString(column_index);
        String imgName = imgpath.substring(imgpath.lastIndexOf("/")+1);

        return imgName;
    }
}
