package com.dipale.dipgame;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class thongtin extends AppCompatActivity {

    ImageView imgNut,imgBack,imgcMatLogo;
    int ttlv5=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_thongtin);

        viewID();
        docFileTTOfLV5("ttlv5.txt");
        if(ttlv5==1){
            imgcMatLogo.setImageResource(R.drawable.lv5danhdau);
            imgcMatLogo.setEnabled(false);
        }

        imgcMatLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ttlv5==0) {
                    imgcMatLogo.setImageResource(R.drawable.lv5danhdau);
                    ttlv5=1;
                    ghiFileTTOfLV5("ttlv5.txt",ttlv5);
                }
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(thongtin.this,R.raw.back);
                mediaPlayer.start();
                finishAndRemoveTask();
            }
        });

        imgNut.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        imgNut.setImageResource(R.drawable.nutdaan);
                        break;
                    case MotionEvent.ACTION_UP:
                        imgNut.setImageResource(R.drawable.nutchuaan);
                        break;
                }

                return true;
            }
        });
    }

    private void viewID(){
        imgBack = (ImageView) findViewById(R.id.ttimgback);
        imgNut = (ImageView) findViewById(R.id.ttnut);
        imgcMatLogo = (ImageView) findViewById(R.id.lv5imgcmatlogo);
    }

    public void ghiFileTTOfLV5(String s,int t){
        try{
            FileOutputStream fileOutputStream = openFileOutput(s,0);
            OutputStreamWriter ghi = new OutputStreamWriter(fileOutputStream);
            ghi.write(String.valueOf(t));
            ghi.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void docFileTTOfLV5(String s){
        try {
            FileInputStream fileInputStream = openFileInput(s);
            BufferedReader doc = new BufferedReader(new InputStreamReader(fileInputStream));
            ttlv5=Integer.parseInt(doc.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
