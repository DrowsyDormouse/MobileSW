package com.example.song.mobilesw;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Bundle;
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

public class Post extends AppCompatActivity {

    long now = System.currentTimeMillis();
    /*Date date = new Date(now);
    SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    String formatDate = sdfNow.format(date);*/

    //TextView dateNow;

    Button button = null;
    Button gallery = null;
    ImageView image = null;

    final int REQ_CODE_SELECT_IMAGE=100;

    private String imagePath;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.post_main);

        /*dateNow = (TextView) findViewById(R.id.dateNow);
        dateNow.setText(formatDate);*/

        Button send = (Button)findViewById(R.id.btn_send);
        send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        setup();
        fnffn();

    }

    //버튼 눌러서 카메라로 가는법
    private void setup()
    {
        button = (Button)findViewById(R.id.btn_camera);
        image = (ImageView)findViewById(R.id.image);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 1);
            }
        });
    }

    private void fnffn() //이미지 가져옴.
    {
        gallery = (Button)findViewById(R.id.gallery);
        image = (ImageView)findViewById(R.id.image);

        gallery.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,REQ_CODE_SELECT_IMAGE);
            }
        });
    }
    //이미지 불러오기
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        image.setImageURI(data.getData());

        Toast.makeText(getBaseContext(),"resultCode :" +requestCode,Toast.LENGTH_SHORT).show();

        if (requestCode == REQ_CODE_SELECT_IMAGE)
        {
            //Toast.makeText(getBaseContext(), "REQ_CODE_SELECT_IMAGE", Toast.LENGTH_LONG);
            if (resultCode == Activity.RESULT_OK)
            {
                //Toast.makeText(getBaseContext(), "Activity.RESULT_OK", Toast.LENGTH_LONG);
                try {
                    Bitmap image_bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),data.getData());
                    ImageView image = (ImageView)findViewById(R.id.image);

                    //Toast.makeText(getBaseContext(), "error?", Toast.LENGTH_LONG);
                    image.setImageBitmap(image_bitmap);
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                    //Toast.makeText(getBaseContext(), "error", Toast.LENGTH_LONG);
                }catch (IOException e){
                    e.printStackTrace();
                    //Toast.makeText(getBaseContext(), "error", Toast.LENGTH_LONG);
                }catch (Exception e)
                {
                    e.printStackTrace();
                   // Toast.makeText(getBaseContext(), "error", Toast.LENGTH_LONG);
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


    // 사진 회전
    /*public int exifOrientationToDegrees(int exifOrientation)
    {
        if(exifOrientation== ExifInterface.ORIENTATION_ROTATE_90)
        {
            return 90;
        }
        else if (exifOrientation==ExifInterface.ORIENTATION_ROTATE_180)
        {
            return 180;
        }
        else if (exifOrientation==ExifInterface.ORIENTATION_ROTATE_270)
        {
            return 270;
        }
        return 0;
    }
    // 죽었습니다.
    */



}
