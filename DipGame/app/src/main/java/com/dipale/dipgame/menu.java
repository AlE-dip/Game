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
import android.widget.Button;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class menu extends Activity {

    Button btLV1,btLV2,btLV3,btLV4,btLV5;
    ImageView imgBack;
    int lv=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);

        viewID();
        docFile();
        btLV2.setEnabled(false);
        btLV3.setEnabled(false);
        btLV4.setEnabled(false);
        btLV5.setEnabled(false);
        if(lv>=2){
            btLV2.setEnabled(true);
        }
        if(lv>=3){
            btLV3.setEnabled(true);
        }
        if(lv>=4){
            btLV4.setEnabled(true);
        }
        if(lv>=5){
            btLV5.setEnabled(true);
        }

        btLV1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(menu.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                Intent intent=new Intent(menu.this,lv1.class);
                startActivity(intent);
                overridePendingTransition(R.anim.mhdivao,R.anim.mhdira);
                finishAndRemoveTask();

            }
        });

        btLV2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(menu.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                Intent intent=new Intent(menu.this,lv2.class);
                startActivity(intent);
                overridePendingTransition(R.anim.mhdivao,R.anim.mhdira);
                finishAndRemoveTask();

            }
        });

        btLV3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(menu.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                Intent intent=new Intent(menu.this,lv3.class);
                startActivity(intent);
                overridePendingTransition(R.anim.mhdivao,R.anim.mhdira);
                finishAndRemoveTask();
            }
        });

        btLV4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(menu.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                Intent intent=new Intent(menu.this,lv4.class);
                startActivity(intent);
                overridePendingTransition(R.anim.mhdivao,R.anim.mhdira);
                finishAndRemoveTask();
            }
        });

        btLV5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(menu.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                Intent intent=new Intent(menu.this,lv5.class);
                startActivity(intent);
                overridePendingTransition(R.anim.mhdivao,R.anim.mhdira);
                finishAndRemoveTask();
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(menu.this,R.raw.back);
                mediaPlayer.start();
                finishAndRemoveTask();
            }
        });
    }

    private void viewID(){
        btLV1 = (Button) findViewById(R.id.btlv1);
        btLV2 = (Button) findViewById(R.id.btlv2);
        btLV3 = (Button) findViewById(R.id.btlv3);
        btLV4 = (Button) findViewById(R.id.btlv4);
        btLV5 = (Button) findViewById(R.id.btlv5);

        imgBack = (ImageView) findViewById(R.id.menuimgback);
    }
    public void ghiFile(){
        try{
            FileOutputStream fileOutputStream = openFileOutput("data.txt",0);
            OutputStreamWriter ghi = new OutputStreamWriter(fileOutputStream);
            ghi.write(String.valueOf(lv));
            ghi.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void docFile(){
        try {
            FileInputStream fileInputStream = openFileInput("data.txt");
            BufferedReader doc = new BufferedReader(new InputStreamReader(fileInputStream));
            lv=Integer.parseInt(doc.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
