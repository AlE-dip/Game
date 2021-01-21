package com.dipale.dipgame;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends Activity {

    ImageView imgNutPlay,imgNutThoat,imgNutThongTin,imgLV5I;
    MediaPlayer atNhacNen;
    Boolean ld;
    int mainlv5=0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        viewID();
        AmThanh();
        docFileLV1OfLV5();
        if(mainlv5==1){
            imgLV5I.setImageResource(R.drawable.lv5danhdau);
            imgLV5I.setEnabled(false);
        }

        imgLV5I.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainlv5==0){
                    imgLV5I.setImageResource(R.drawable.lv5danhdau);
                    v.setEnabled(false);
                    mainlv5=1;
                    ghiFileOfLV5();
                }
            }
        });

        if(this.isTaskRoot()) {
            atNhacNen.start();
            atNhacNen.setLooping(true);
        }else {
            finishAndRemoveTask();
        };

        imgNutPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.atnutplay);
                mediaPlayer.start();
                Intent intent = new Intent(MainActivity.this,menu.class);
                startActivity(intent);
                overridePendingTransition(R.anim.mhdivao,R.anim.mhdira);
            }
        });

        imgNutThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.atnutplay);
                mediaPlayer.start();
                System.exit(0);
            }
        });

        imgNutThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.atnutplay);
                mediaPlayer.start();
                Intent intent = new Intent(MainActivity.this,thongtin.class);
                startActivity(intent);
                overridePendingTransition(R.anim.bmhdira,R.anim.bmnvao);
            }
        });


    }

    private void viewID(){
        imgNutPlay = (ImageView) findViewById(R.id.imgnutplay);
        imgNutThoat = (ImageView) findViewById(R.id.imgnutthoat);
        imgNutThongTin = (ImageView) findViewById(R.id.imgnutthongtin);

        imgLV5I = (ImageView) findViewById(R.id.lv5imgci);
    }
    private void AmThanh(){
        atNhacNen=MediaPlayer.create(MainActivity.this,R.raw.nhacnen);
    }
    public void ghiFileOfLV5(){
        try{
            FileOutputStream fileOutputStream = openFileOutput("mainlv5.txt",0);
            OutputStreamWriter ghi = new OutputStreamWriter(fileOutputStream);
            ghi.write(String.valueOf(mainlv5));
            ghi.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void docFileLV1OfLV5(){
        try {
            FileInputStream fileInputStream = openFileInput("mainlv5.txt");
            BufferedReader doc = new BufferedReader(new InputStreamReader(fileInputStream));
            mainlv5=Integer.parseInt(doc.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
