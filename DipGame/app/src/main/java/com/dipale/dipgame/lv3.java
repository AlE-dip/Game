package com.dipale.dipgame;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class lv3 extends Activity {

    Button btchon1,btchon2,btchon3,btchon4,btchon5,btchon6,btchon7,btchon8,btchon9,btchon10,btchon11,btchon12;
    Button bttl1,bttl2,bttl3,bttl4,bttl5,bttl6,btTiep,btChoiLai,btGoiY;
    ImageView imgBack,imgGoiY;
    int n1,n2,n3,n4,n5,n6,n=0,lv,lv3lv5=0;
    TextView txtThang,txtCauHoi,txtGoiY;
    RelativeLayout rlmenu,rGoiY;
    ImageView imgcMu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_lv3);

        viewID();
        docFile();
        docFileLV3OfLV5("lv3oflv5.txt");
        if(lv3lv5==1){
            imgcMu.setImageResource(R.drawable.lv5danhdau);
            imgcMu.setEnabled(false);
        }
        imgcMu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lv3lv5==0){
                    imgcMu.setImageResource(R.drawable.lv5danhdau);
                    imgcMu.setEnabled(false);
                    lv3lv5=1;
                    ghiFileLV3("lv3oflv5.txt",lv3lv5);
                }
            }
        });

        rGoiY.setVisibility(View.INVISIBLE);
        rlmenu.setVisibility(View.INVISIBLE);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv3.this,R.raw.back);
                mediaPlayer.start();
                finishAndRemoveTask();
            }
        });

        btchon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(lv3.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                if(bttl1.getText().toString().compareTo("")==0){
                    bttl1.setText(btchon1.getText().toString());
                    n1=btchon1.getId();
                    btchon1.setBackgroundResource(R.drawable.lv3bttraloichon);
                    btchon1.setEnabled(false);
                }else {
                    if(bttl2.getText().toString().compareTo("")==0){
                        bttl2.setText(btchon1.getText().toString());
                        n2=btchon1.getId();
                        btchon1.setBackgroundResource(R.drawable.lv3bttraloichon);
                        btchon1.setEnabled(false);
                    }else {
                        if(bttl3.getText().toString().compareTo("")==0){
                            bttl3.setText(btchon1.getText().toString());
                            n3=btchon1.getId();
                            btchon1.setBackgroundResource(R.drawable.lv3bttraloichon);
                            btchon1.setEnabled(false);
                        }else {
                            if(bttl4.getText().toString().compareTo("")==0){
                                bttl4.setText(btchon1.getText().toString());
                                n4=btchon1.getId();
                                btchon1.setBackgroundResource(R.drawable.lv3bttraloichon);
                                btchon1.setEnabled(false);
                            }else {
                                if(bttl5.getText().toString().compareTo("")==0){
                                    bttl5.setText(btchon1.getText().toString());
                                    n5=btchon1.getId();
                                    btchon1.setBackgroundResource(R.drawable.lv3bttraloichon);
                                    btchon1.setEnabled(false);
                                }else {
                                    if(bttl6.getText().toString().compareTo("")==0){
                                        bttl6.setText(btchon1.getText().toString());
                                        n6=btchon1.getId();
                                        btchon1.setBackgroundResource(R.drawable.lv3bttraloichon);
                                        btchon1.setEnabled(false);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        btchon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(lv3.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                if(bttl1.getText().toString().compareTo("")==0){
                    bttl1.setText(btchon2.getText().toString());
                    n1=btchon2.getId();
                    btchon2.setBackgroundResource(R.drawable.lv3bttraloichon);
                    btchon2.setEnabled(false);
                }else {
                    if(bttl2.getText().toString().compareTo("")==0){
                        bttl2.setText(btchon2.getText().toString());
                        n2=btchon2.getId();
                        btchon2.setBackgroundResource(R.drawable.lv3bttraloichon);
                        btchon2.setEnabled(false);
                    }else {
                        if(bttl3.getText().toString().compareTo("")==0){
                            bttl3.setText(btchon2.getText().toString());
                            n3=btchon2.getId();
                            btchon2.setBackgroundResource(R.drawable.lv3bttraloichon);
                            btchon2.setEnabled(false);
                        }else {
                            if(bttl4.getText().toString().compareTo("")==0){
                                bttl4.setText(btchon2.getText().toString());
                                n4=btchon2.getId();
                                btchon2.setBackgroundResource(R.drawable.lv3bttraloichon);
                                btchon2.setEnabled(false);
                            }else {
                                if(bttl5.getText().toString().compareTo("")==0){
                                    bttl5.setText(btchon2.getText().toString());
                                    n5=btchon2.getId();
                                    btchon2.setBackgroundResource(R.drawable.lv3bttraloichon);
                                    btchon2.setEnabled(false);
                                }else {
                                    if(bttl6.getText().toString().compareTo("")==0){
                                        bttl6.setText(btchon2.getText().toString());
                                        n6=btchon2.getId();
                                        btchon2.setBackgroundResource(R.drawable.lv3bttraloichon);
                                        btchon2.setEnabled(false);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        btchon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(lv3.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                if(bttl1.getText().toString().compareTo("")==0){
                    bttl1.setText(btchon3.getText().toString());
                    n1=btchon3.getId();
                    btchon3.setBackgroundResource(R.drawable.lv3bttraloichon);
                    btchon3.setEnabled(false);
                }else {
                    if(bttl2.getText().toString().compareTo("")==0){
                        bttl2.setText(btchon3.getText().toString());
                        n2=btchon3.getId();
                        btchon3.setBackgroundResource(R.drawable.lv3bttraloichon);
                        btchon3.setEnabled(false);
                    }else {
                        if(bttl3.getText().toString().compareTo("")==0){
                            bttl3.setText(btchon3.getText().toString());
                            n3=btchon3.getId();
                            btchon3.setBackgroundResource(R.drawable.lv3bttraloichon);
                            btchon3.setEnabled(false);
                        }else {
                            if(bttl4.getText().toString().compareTo("")==0){
                                bttl4.setText(btchon3.getText().toString());
                                n4=btchon3.getId();
                                btchon3.setBackgroundResource(R.drawable.lv3bttraloichon);
                                btchon3.setEnabled(false);
                            }else {
                                if(bttl5.getText().toString().compareTo("")==0){
                                    bttl5.setText(btchon3.getText().toString());
                                    n5=btchon3.getId();
                                    btchon3.setBackgroundResource(R.drawable.lv3bttraloichon);
                                    btchon3.setEnabled(false);
                                }else {
                                    if(bttl6.getText().toString().compareTo("")==0){
                                        bttl6.setText(btchon3.getText().toString());
                                        n6=btchon3.getId();
                                        btchon3.setBackgroundResource(R.drawable.lv3bttraloichon);
                                        btchon3.setEnabled(false);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        btchon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(lv3.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                if(bttl1.getText().toString().compareTo("")==0){
                    bttl1.setText(btchon4.getText().toString());
                    n1=btchon4.getId();
                    btchon4.setBackgroundResource(R.drawable.lv3bttraloichon);
                    btchon4.setEnabled(false);
                }else {
                    if(bttl2.getText().toString().compareTo("")==0){
                        bttl2.setText(btchon4.getText().toString());
                        n2=btchon4.getId();
                        btchon4.setBackgroundResource(R.drawable.lv3bttraloichon);
                        btchon4.setEnabled(false);
                    }else {
                        if(bttl3.getText().toString().compareTo("")==0){
                            bttl3.setText(btchon4.getText().toString());
                            n3=btchon4.getId();
                            btchon4.setBackgroundResource(R.drawable.lv3bttraloichon);
                            btchon4.setEnabled(false);
                        }else {
                            if(bttl4.getText().toString().compareTo("")==0){
                                bttl4.setText(btchon4.getText().toString());
                                n4=btchon4.getId();
                                btchon4.setBackgroundResource(R.drawable.lv3bttraloichon);
                                btchon4.setEnabled(false);
                            }else {
                                if(bttl5.getText().toString().compareTo("")==0){
                                    bttl5.setText(btchon4.getText().toString());
                                    n5=btchon4.getId();
                                    btchon4.setBackgroundResource(R.drawable.lv3bttraloichon);
                                    btchon4.setEnabled(false);
                                }else {
                                    if(bttl6.getText().toString().compareTo("")==0){
                                        bttl6.setText(btchon4.getText().toString());
                                        n6=btchon4.getId();
                                        btchon4.setBackgroundResource(R.drawable.lv3bttraloichon);
                                        btchon4.setEnabled(false);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        btchon5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(lv3.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                if(bttl1.getText().toString().compareTo("")==0){
                    bttl1.setText(btchon5.getText().toString());
                    n1=btchon5.getId();
                    btchon5.setBackgroundResource(R.drawable.lv3bttraloichon);
                    btchon5.setEnabled(false);
                }else {
                    if(bttl2.getText().toString().compareTo("")==0){
                        bttl2.setText(btchon5.getText().toString());
                        n2=btchon5.getId();
                        btchon5.setBackgroundResource(R.drawable.lv3bttraloichon);
                        btchon5.setEnabled(false);
                    }else {
                        if(bttl3.getText().toString().compareTo("")==0){
                            bttl3.setText(btchon5.getText().toString());
                            n3=btchon5.getId();
                            btchon5.setBackgroundResource(R.drawable.lv3bttraloichon);
                            btchon5.setEnabled(false);
                        }else {
                            if(bttl4.getText().toString().compareTo("")==0){
                                bttl4.setText(btchon5.getText().toString());
                                n4=btchon5.getId();
                                btchon5.setBackgroundResource(R.drawable.lv3bttraloichon);
                                btchon5.setEnabled(false);
                            }else {
                                if(bttl5.getText().toString().compareTo("")==0){
                                    bttl5.setText(btchon5.getText().toString());
                                    n5=btchon5.getId();
                                    btchon5.setBackgroundResource(R.drawable.lv3bttraloichon);
                                    btchon5.setEnabled(false);
                                }else {
                                    if(bttl6.getText().toString().compareTo("")==0){
                                        bttl6.setText(btchon5.getText().toString());
                                        n6=btchon5.getId();
                                        btchon5.setBackgroundResource(R.drawable.lv3bttraloichon);
                                        btchon5.setEnabled(false);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        btchon6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(lv3.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                if(bttl1.getText().toString().compareTo("")==0){
                    bttl1.setText(btchon6.getText().toString());
                    n1=btchon6.getId();
                    btchon6.setBackgroundResource(R.drawable.lv3bttraloichon);
                    btchon6.setEnabled(false);
                }else {
                    if(bttl2.getText().toString().compareTo("")==0){
                        bttl2.setText(btchon6.getText().toString());
                        n2=btchon6.getId();
                        btchon6.setBackgroundResource(R.drawable.lv3bttraloichon);
                        btchon6.setEnabled(false);
                    }else {
                        if(bttl3.getText().toString().compareTo("")==0){
                            bttl3.setText(btchon6.getText().toString());
                            n3=btchon6.getId();
                            btchon6.setBackgroundResource(R.drawable.lv3bttraloichon);
                            btchon6.setEnabled(false);
                        }else {
                            if(bttl4.getText().toString().compareTo("")==0){
                                bttl4.setText(btchon6.getText().toString());
                                n4=btchon6.getId();
                                btchon6.setBackgroundResource(R.drawable.lv3bttraloichon);
                                btchon6.setEnabled(false);
                            }else {
                                if(bttl5.getText().toString().compareTo("")==0){
                                    bttl5.setText(btchon6.getText().toString());
                                    n5=btchon6.getId();
                                    btchon6.setBackgroundResource(R.drawable.lv3bttraloichon);
                                    btchon6.setEnabled(false);
                                }else {
                                    if(bttl6.getText().toString().compareTo("")==0){
                                        bttl6.setText(btchon6.getText().toString());
                                        n6=btchon6.getId();
                                        btchon6.setBackgroundResource(R.drawable.lv3bttraloichon);
                                        btchon6.setEnabled(false);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        btchon7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(lv3.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                if(bttl1.getText().toString().compareTo("")==0){
                    bttl1.setText(btchon7.getText().toString());
                    n1=btchon7.getId();
                    btchon7.setBackgroundResource(R.drawable.lv3bttraloichon);
                    btchon7.setEnabled(false);
                }else {
                    if(bttl2.getText().toString().compareTo("")==0){
                        bttl2.setText(btchon7.getText().toString());
                        n2=btchon7.getId();
                        btchon7.setBackgroundResource(R.drawable.lv3bttraloichon);
                        btchon7.setEnabled(false);
                    }else {
                        if(bttl3.getText().toString().compareTo("")==0){
                            bttl3.setText(btchon7.getText().toString());
                            n3=btchon7.getId();
                            btchon7.setBackgroundResource(R.drawable.lv3bttraloichon);
                            btchon7.setEnabled(false);
                        }else {
                            if(bttl4.getText().toString().compareTo("")==0){
                                bttl4.setText(btchon7.getText().toString());
                                n4=btchon7.getId();
                                btchon7.setBackgroundResource(R.drawable.lv3bttraloichon);
                                btchon7.setEnabled(false);
                            }else {
                                if(bttl5.getText().toString().compareTo("")==0){
                                    bttl5.setText(btchon7.getText().toString());
                                    n5=btchon7.getId();
                                    btchon7.setBackgroundResource(R.drawable.lv3bttraloichon);
                                    btchon7.setEnabled(false);
                                }else {
                                    if(bttl6.getText().toString().compareTo("")==0){
                                        bttl6.setText(btchon7.getText().toString());
                                        n6=btchon7.getId();
                                        btchon7.setBackgroundResource(R.drawable.lv3bttraloichon);
                                        btchon7.setEnabled(false);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        btchon8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(lv3.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                if(bttl1.getText().toString().compareTo("")==0){
                    bttl1.setText(btchon8.getText().toString());
                    n1=btchon8.getId();
                    btchon8.setBackgroundResource(R.drawable.lv3bttraloichon);
                    btchon8.setEnabled(false);
                }else {
                    if(bttl2.getText().toString().compareTo("")==0){
                        bttl2.setText(btchon8.getText().toString());
                        n2=btchon8.getId();
                        btchon8.setBackgroundResource(R.drawable.lv3bttraloichon);
                        btchon8.setEnabled(false);
                    }else {
                        if(bttl3.getText().toString().compareTo("")==0){
                            bttl3.setText(btchon8.getText().toString());
                            n3=btchon8.getId();
                            btchon8.setBackgroundResource(R.drawable.lv3bttraloichon);
                            btchon8.setEnabled(false);
                        }else {
                            if(bttl4.getText().toString().compareTo("")==0){
                                bttl4.setText(btchon8.getText().toString());
                                n4=btchon8.getId();
                                btchon8.setBackgroundResource(R.drawable.lv3bttraloichon);
                                btchon8.setEnabled(false);
                            }else {
                                if(bttl5.getText().toString().compareTo("")==0){
                                    bttl5.setText(btchon8.getText().toString());
                                    n5=btchon8.getId();
                                    btchon8.setBackgroundResource(R.drawable.lv3bttraloichon);
                                    btchon8.setEnabled(false);
                                }else {
                                    if(bttl6.getText().toString().compareTo("")==0){
                                        bttl6.setText(btchon8.getText().toString());
                                        n6=btchon8.getId();
                                        btchon8.setBackgroundResource(R.drawable.lv3bttraloichon);
                                        btchon8.setEnabled(false);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        btchon9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(lv3.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                if(bttl1.getText().toString().compareTo("")==0){
                    bttl1.setText(btchon9.getText().toString());
                    n1=btchon9.getId();
                    btchon9.setBackgroundResource(R.drawable.lv3bttraloichon);
                    btchon9.setEnabled(false);
                }else {
                    if(bttl2.getText().toString().compareTo("")==0){
                        bttl2.setText(btchon9.getText().toString());
                        n2=btchon9.getId();
                        btchon9.setBackgroundResource(R.drawable.lv3bttraloichon);
                        btchon9.setEnabled(false);
                    }else {
                        if(bttl3.getText().toString().compareTo("")==0){
                            bttl3.setText(btchon9.getText().toString());
                            n3=btchon9.getId();
                            btchon9.setBackgroundResource(R.drawable.lv3bttraloichon);
                            btchon9.setEnabled(false);
                        }else {
                            if(bttl4.getText().toString().compareTo("")==0){
                                bttl4.setText(btchon9.getText().toString());
                                n4=btchon9.getId();
                                btchon9.setBackgroundResource(R.drawable.lv3bttraloichon);
                                btchon9.setEnabled(false);
                            }else {
                                if(bttl5.getText().toString().compareTo("")==0){
                                    bttl5.setText(btchon9.getText().toString());
                                    n5=btchon9.getId();
                                    btchon9.setBackgroundResource(R.drawable.lv3bttraloichon);
                                    btchon9.setEnabled(false);
                                }else {
                                    if(bttl6.getText().toString().compareTo("")==0){
                                        bttl6.setText(btchon9.getText().toString());
                                        n6=btchon9.getId();
                                        btchon9.setBackgroundResource(R.drawable.lv3bttraloichon);
                                        btchon9.setEnabled(false);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        btchon10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(lv3.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                if(bttl1.getText().toString().compareTo("")==0){
                    bttl1.setText(btchon10.getText().toString());
                    n1=btchon10.getId();
                    btchon10.setBackgroundResource(R.drawable.lv3bttraloichon);
                    btchon10.setEnabled(false);
                }else {
                    if(bttl2.getText().toString().compareTo("")==0){
                        bttl2.setText(btchon10.getText().toString());
                        n2=btchon10.getId();
                        btchon10.setBackgroundResource(R.drawable.lv3bttraloichon);
                        btchon10.setEnabled(false);
                    }else {
                        if(bttl3.getText().toString().compareTo("")==0){
                            bttl3.setText(btchon10.getText().toString());
                            n3=btchon10.getId();
                            btchon10.setBackgroundResource(R.drawable.lv3bttraloichon);
                            btchon10.setEnabled(false);
                        }else {
                            if(bttl4.getText().toString().compareTo("")==0){
                                bttl4.setText(btchon10.getText().toString());
                                n4=btchon10.getId();
                                btchon10.setBackgroundResource(R.drawable.lv3bttraloichon);
                                btchon10.setEnabled(false);
                            }else {
                                if(bttl5.getText().toString().compareTo("")==0){
                                    bttl5.setText(btchon10.getText().toString());
                                    n5=btchon10.getId();
                                    btchon10.setBackgroundResource(R.drawable.lv3bttraloichon);
                                    btchon10.setEnabled(false);
                                }else {
                                    if(bttl6.getText().toString().compareTo("")==0){
                                        bttl6.setText(btchon10.getText().toString());
                                        n6=btchon10.getId();
                                        btchon10.setBackgroundResource(R.drawable.lv3bttraloichon);
                                        btchon10.setEnabled(false);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        btchon11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(lv3.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                if(bttl1.getText().toString().compareTo("")==0){
                    bttl1.setText(btchon11.getText().toString());
                    n1=btchon11.getId();
                    btchon11.setBackgroundResource(R.drawable.lv3bttraloichon);
                    btchon11.setEnabled(false);
                }else {
                    if(bttl2.getText().toString().compareTo("")==0){
                        bttl2.setText(btchon11.getText().toString());
                        n2=btchon11.getId();
                        btchon11.setBackgroundResource(R.drawable.lv3bttraloichon);
                        btchon11.setEnabled(false);
                    }else {
                        if(bttl3.getText().toString().compareTo("")==0){
                            bttl3.setText(btchon11.getText().toString());
                            n3=btchon11.getId();
                            btchon11.setBackgroundResource(R.drawable.lv3bttraloichon);
                            btchon11.setEnabled(false);
                        }else {
                            if(bttl4.getText().toString().compareTo("")==0){
                                bttl4.setText(btchon11.getText().toString());
                                n4=btchon11.getId();
                                btchon11.setBackgroundResource(R.drawable.lv3bttraloichon);
                                btchon11.setEnabled(false);
                            }else {
                                if(bttl5.getText().toString().compareTo("")==0){
                                    bttl5.setText(btchon11.getText().toString());
                                    n5=btchon11.getId();
                                    btchon11.setBackgroundResource(R.drawable.lv3bttraloichon);
                                    btchon11.setEnabled(false);
                                }else {
                                    if(bttl6.getText().toString().compareTo("")==0){
                                        bttl6.setText(btchon11.getText().toString());
                                        n6=btchon11.getId();
                                        btchon11.setBackgroundResource(R.drawable.lv3bttraloichon);
                                        btchon11.setEnabled(false);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        btchon12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(lv3.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                if(bttl1.getText().toString().compareTo("")==0){
                    bttl1.setText(btchon12.getText().toString());
                    n1=btchon12.getId();
                    btchon12.setBackgroundResource(R.drawable.lv3bttraloichon);
                    btchon12.setEnabled(false);
                }else {
                    if(bttl2.getText().toString().compareTo("")==0){
                        bttl2.setText(btchon12.getText().toString());
                        n2=btchon12.getId();
                        btchon12.setBackgroundResource(R.drawable.lv3bttraloichon);
                        btchon12.setEnabled(false);
                    }else {
                        if(bttl3.getText().toString().compareTo("")==0){
                            bttl3.setText(btchon12.getText().toString());
                            n3=btchon12.getId();
                            btchon12.setBackgroundResource(R.drawable.lv3bttraloichon);
                            btchon12.setEnabled(false);
                        }else {
                            if(bttl4.getText().toString().compareTo("")==0){
                                bttl4.setText(btchon12.getText().toString());
                                n4=btchon12.getId();
                                btchon12.setBackgroundResource(R.drawable.lv3bttraloichon);
                                btchon12.setEnabled(false);
                            }else {
                                if(bttl5.getText().toString().compareTo("")==0){
                                    bttl5.setText(btchon12.getText().toString());
                                    n5=btchon12.getId();
                                    btchon12.setBackgroundResource(R.drawable.lv3bttraloichon);
                                    btchon12.setEnabled(false);
                                }else {
                                    if(bttl6.getText().toString().compareTo("")==0){
                                        bttl6.setText(btchon12.getText().toString());
                                        n6=btchon12.getId();
                                        btchon12.setBackgroundResource(R.drawable.lv3bttraloichon);
                                        btchon12.setEnabled(false);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        bttl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(lv3.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                bttl1.setText("");
                if(n1==btchon1.getId()){
                    btchon1.setBackgroundResource(R.drawable.lv3bttrailoi);
                    btchon1.setEnabled(true);
                }else {
                    if(n1==btchon2.getId()){
                        btchon2.setBackgroundResource(R.drawable.lv3bttrailoi);
                        btchon2.setEnabled(true);
                    }else {
                        if(n1==btchon3.getId()){
                            btchon3.setBackgroundResource(R.drawable.lv3bttrailoi);
                            btchon3.setEnabled(true);
                        }else {
                            if(n1==btchon4.getId()){
                                btchon4.setBackgroundResource(R.drawable.lv3bttrailoi);
                                btchon4.setEnabled(true);
                            }else {
                                if(n1==btchon5.getId()){
                                    btchon5.setBackgroundResource(R.drawable.lv3bttrailoi);
                                    btchon5.setEnabled(true);
                                }else {
                                    if(n1==btchon6.getId()){
                                        btchon6.setBackgroundResource(R.drawable.lv3bttrailoi);
                                        btchon6.setEnabled(true);
                                    }else {
                                        if(n1==btchon7.getId()){
                                            btchon7.setBackgroundResource(R.drawable.lv3bttrailoi);
                                            btchon7.setEnabled(true);
                                        }else {
                                            if(n1==btchon8.getId()){
                                                btchon8.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                btchon8.setEnabled(true);
                                            }else {
                                                if(n1==btchon9.getId()){
                                                    btchon9.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                    btchon9.setEnabled(true);
                                                }else {
                                                    if(n1==btchon10.getId()){
                                                        btchon10.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                        btchon10.setEnabled(true);
                                                    }else {
                                                        if(n1==btchon11.getId()){
                                                            btchon11.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                            btchon11.setEnabled(true);
                                                        }else {
                                                            if(n1==btchon12.getId()){
                                                                btchon12.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                                btchon12.setEnabled(true);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        bttl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(lv3.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                bttl2.setText("");
                if(n2==btchon1.getId()){
                    btchon1.setBackgroundResource(R.drawable.lv3bttrailoi);
                    btchon1.setEnabled(true);
                }else {
                    if(n2==btchon2.getId()){
                        btchon2.setBackgroundResource(R.drawable.lv3bttrailoi);
                        btchon2.setEnabled(true);
                    }else {
                        if(n2==btchon3.getId()){
                            btchon3.setBackgroundResource(R.drawable.lv3bttrailoi);
                            btchon3.setEnabled(true);
                        }else {
                            if(n2==btchon4.getId()){
                                btchon4.setBackgroundResource(R.drawable.lv3bttrailoi);
                                btchon4.setEnabled(true);
                            }else {
                                if(n2==btchon5.getId()){
                                    btchon5.setBackgroundResource(R.drawable.lv3bttrailoi);
                                    btchon5.setEnabled(true);
                                }else {
                                    if(n2==btchon6.getId()){
                                        btchon6.setBackgroundResource(R.drawable.lv3bttrailoi);
                                        btchon6.setEnabled(true);
                                    }else {
                                        if(n2==btchon7.getId()){
                                            btchon7.setBackgroundResource(R.drawable.lv3bttrailoi);
                                            btchon7.setEnabled(true);
                                        }else {
                                            if(n2==btchon8.getId()){
                                                btchon8.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                btchon8.setEnabled(true);
                                            }else {
                                                if(n2==btchon9.getId()){
                                                    btchon9.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                    btchon9.setEnabled(true);
                                                }else {
                                                    if(n2==btchon10.getId()){
                                                        btchon10.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                        btchon10.setEnabled(true);
                                                    }else {
                                                        if(n2==btchon11.getId()){
                                                            btchon11.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                            btchon11.setEnabled(true);
                                                        }else {
                                                            if(n2==btchon12.getId()){
                                                                btchon12.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                                btchon12.setEnabled(true);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        bttl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(lv3.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                bttl3.setText("");
                if(n3==btchon1.getId()){
                    btchon1.setBackgroundResource(R.drawable.lv3bttrailoi);
                    btchon1.setEnabled(true);
                }else {
                    if(n3==btchon2.getId()){
                        btchon2.setBackgroundResource(R.drawable.lv3bttrailoi);
                        btchon2.setEnabled(true);
                    }else {
                        if(n3==btchon3.getId()){
                            btchon3.setBackgroundResource(R.drawable.lv3bttrailoi);
                            btchon3.setEnabled(true);
                        }else {
                            if(n3==btchon4.getId()){
                                btchon4.setBackgroundResource(R.drawable.lv3bttrailoi);
                                btchon4.setEnabled(true);
                            }else {
                                if(n3==btchon5.getId()){
                                    btchon5.setBackgroundResource(R.drawable.lv3bttrailoi);
                                    btchon5.setEnabled(true);
                                }else {
                                    if(n3==btchon6.getId()){
                                        btchon6.setBackgroundResource(R.drawable.lv3bttrailoi);
                                        btchon6.setEnabled(true);
                                    }else {
                                        if(n3==btchon7.getId()){
                                            btchon7.setBackgroundResource(R.drawable.lv3bttrailoi);
                                            btchon7.setEnabled(true);
                                        }else {
                                            if(n3==btchon8.getId()){
                                                btchon8.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                btchon8.setEnabled(true);
                                            }else {
                                                if(n3==btchon9.getId()){
                                                    btchon9.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                    btchon9.setEnabled(true);
                                                }else {
                                                    if(n3==btchon10.getId()){
                                                        btchon10.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                        btchon10.setEnabled(true);
                                                    }else {
                                                        if(n3==btchon11.getId()){
                                                            btchon11.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                            btchon11.setEnabled(true);
                                                        }else {
                                                            if(n3==btchon12.getId()){
                                                                btchon12.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                                btchon12.setEnabled(true);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        bttl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(lv3.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                bttl4.setText("");
                if(n4==btchon1.getId()){
                    btchon1.setBackgroundResource(R.drawable.lv3bttrailoi);
                    btchon1.setEnabled(true);
                }else {
                    if(n4==btchon2.getId()){
                        btchon2.setBackgroundResource(R.drawable.lv3bttrailoi);
                        btchon2.setEnabled(true);
                    }else {
                        if(n4==btchon3.getId()){
                            btchon3.setBackgroundResource(R.drawable.lv3bttrailoi);
                            btchon3.setEnabled(true);
                        }else {
                            if(n4==btchon4.getId()){
                                btchon4.setBackgroundResource(R.drawable.lv3bttrailoi);
                                btchon4.setEnabled(true);
                            }else {
                                if(n4==btchon5.getId()){
                                    btchon5.setBackgroundResource(R.drawable.lv3bttrailoi);
                                    btchon5.setEnabled(true);
                                }else {
                                    if(n4==btchon6.getId()){
                                        btchon6.setBackgroundResource(R.drawable.lv3bttrailoi);
                                        btchon6.setEnabled(true);
                                    }else {
                                        if(n4==btchon7.getId()){
                                            btchon7.setBackgroundResource(R.drawable.lv3bttrailoi);
                                            btchon7.setEnabled(true);
                                        }else {
                                            if(n4==btchon8.getId()){
                                                btchon8.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                btchon8.setEnabled(true);
                                            }else {
                                                if(n4==btchon9.getId()){
                                                    btchon9.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                    btchon9.setEnabled(true);
                                                }else {
                                                    if(n4==btchon10.getId()){
                                                        btchon10.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                        btchon10.setEnabled(true);
                                                    }else {
                                                        if(n4==btchon11.getId()){
                                                            btchon11.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                            btchon11.setEnabled(true);
                                                        }else {
                                                            if(n4==btchon12.getId()){
                                                                btchon12.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                                btchon12.setEnabled(true);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        bttl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(lv3.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                bttl5.setText("");
                if(n5==btchon1.getId()){
                    btchon1.setBackgroundResource(R.drawable.lv3bttrailoi);
                    btchon1.setEnabled(true);
                }else {
                    if(n5==btchon2.getId()){
                        btchon2.setBackgroundResource(R.drawable.lv3bttrailoi);
                        btchon2.setEnabled(true);
                    }else {
                        if(n5==btchon3.getId()){
                            btchon3.setBackgroundResource(R.drawable.lv3bttrailoi);
                            btchon3.setEnabled(true);
                        }else {
                            if(n5==btchon4.getId()){
                                btchon4.setBackgroundResource(R.drawable.lv3bttrailoi);
                                btchon4.setEnabled(true);
                            }else {
                                if(n5==btchon5.getId()){
                                    btchon5.setBackgroundResource(R.drawable.lv3bttrailoi);
                                    btchon5.setEnabled(true);
                                }else {
                                    if(n5==btchon6.getId()){
                                        btchon6.setBackgroundResource(R.drawable.lv3bttrailoi);
                                        btchon6.setEnabled(true);
                                    }else {
                                        if(n5==btchon7.getId()){
                                            btchon7.setBackgroundResource(R.drawable.lv3bttrailoi);
                                            btchon7.setEnabled(true);
                                        }else {
                                            if(n5==btchon8.getId()){
                                                btchon8.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                btchon8.setEnabled(true);
                                            }else {
                                                if(n5==btchon9.getId()){
                                                    btchon9.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                    btchon9.setEnabled(true);
                                                }else {
                                                    if(n5==btchon10.getId()){
                                                        btchon10.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                        btchon10.setEnabled(true);
                                                    }else {
                                                        if(n5==btchon11.getId()){
                                                            btchon11.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                            btchon11.setEnabled(true);
                                                        }else {
                                                            if(n5==btchon12.getId()){
                                                                btchon12.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                                btchon12.setEnabled(true);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        bttl6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(lv3.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                bttl6.setText("");
                if(n6==btchon1.getId()){
                    btchon1.setBackgroundResource(R.drawable.lv3bttrailoi);
                    btchon1.setEnabled(true);
                }else {
                    if(n6==btchon2.getId()){
                        btchon2.setBackgroundResource(R.drawable.lv3bttrailoi);
                        btchon2.setEnabled(true);
                    }else {
                        if(n6==btchon3.getId()){
                            btchon3.setBackgroundResource(R.drawable.lv3bttrailoi);
                            btchon3.setEnabled(true);
                        }else {
                            if(n6==btchon4.getId()){
                                btchon4.setBackgroundResource(R.drawable.lv3bttrailoi);
                                btchon4.setEnabled(true);
                            }else {
                                if(n6==btchon5.getId()){
                                    btchon5.setBackgroundResource(R.drawable.lv3bttrailoi);
                                    btchon5.setEnabled(true);
                                }else {
                                    if(n6==btchon6.getId()){
                                        btchon6.setBackgroundResource(R.drawable.lv3bttrailoi);
                                        btchon6.setEnabled(true);
                                    }else {
                                        if(n6==btchon7.getId()){
                                            btchon7.setBackgroundResource(R.drawable.lv3bttrailoi);
                                            btchon7.setEnabled(true);
                                        }else {
                                            if(n6==btchon8.getId()){
                                                btchon8.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                btchon8.setEnabled(true);
                                            }else {
                                                if(n6==btchon9.getId()){
                                                    btchon9.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                    btchon9.setEnabled(true);
                                                }else {
                                                    if(n6==btchon10.getId()){
                                                        btchon10.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                        btchon10.setEnabled(true);
                                                    }else {
                                                        if(n6==btchon11.getId()){
                                                            btchon11.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                            btchon11.setEnabled(true);
                                                        }else {
                                                            if(n6==btchon12.getId()){
                                                                btchon12.setBackgroundResource(R.drawable.lv3bttrailoi);
                                                                btchon12.setEnabled(true);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        final CountDownTimer countDownTimer = new CountDownTimer(10000,500) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(bttl1.getText().toString().compareTo("B")==0&&
                        bttl2.getText().toString().compareTo("A")==0&&
                        bttl3.getText().toString().compareTo("T")==0&&
                        bttl4.getText().toString().compareTo("C")==0&&
                        bttl5.getText().toString().compareTo("O")==0&&
                        bttl6.getText().toString().compareTo("P")==0){
                    txtThang.setText("Tìm chữ chứ không đoán chữ...");
                }else {
                    if(bttl1.getText().toString().compareTo("B")==0&&
                            bttl2.getText().toString().compareTo("O")==0&&
                            bttl3.getText().toString().compareTo("P")==0&&
                            bttl4.getText().toString().compareTo("C")==0&&
                            bttl5.getText().toString().compareTo("A")==0&&
                            bttl6.getText().toString().compareTo("C")==0){
                        txtThang.setText("Tầm bậy tầm bạ...");
                    }else {
                        if(bttl1.getText().toString().compareTo("D")==0&&
                                bttl2.getText().toString().compareTo("I")==0&&
                                bttl3.getText().toString().compareTo("P")==0&&
                                bttl4.getText().toString().compareTo("")==0&&
                                bttl5.getText().toString().compareTo("")==0&&
                                bttl6.getText().toString().compareTo("")==0){
                            txtThang.setText("Bạn thắng.");
                            bttl1.setEnabled(false);
                            bttl2.setEnabled(false);
                            bttl3.setEnabled(false);
                            bttl4.setEnabled(false);
                            bttl5.setEnabled(false);
                            bttl6.setEnabled(false);
                            btchon1.setEnabled(false);
                            btchon2.setEnabled(false);
                            btchon3.setEnabled(false);
                            btchon4.setEnabled(false);
                            btchon5.setEnabled(false);
                            btchon6.setEnabled(false);
                            btchon7.setEnabled(false);
                            btchon8.setEnabled(false);
                            btchon9.setEnabled(false);
                            btchon10.setEnabled(false);
                            btchon11.setEnabled(false);
                            btchon12.setEnabled(false);
                            imgBack.setEnabled(false);
                            imgGoiY.setEnabled(false);
                            CountDownTimer delay = new CountDownTimer(3000,3000) {
                                @Override
                                public void onTick(long millisUntilFinished) {

                                }

                                @Override
                                public void onFinish() {
                                    imgcMu.setEnabled(false);
                                    if(lv<4) {
                                        lv = 4;
                                    }
                                    ghiFile();
                                    rlmenu.setVisibility(View.VISIBLE);
                                }
                            }.start();
                        }
                    }
                }
            }

            @Override
            public void onFinish() {
                this.start();
            }
        }.start();

        btTiep.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv3.this,R.raw.atnutplay);
                mediaPlayer.start();
                Intent intent = new Intent(lv3.this,menu.class);
                startActivity(intent);
                overridePendingTransition(R.anim.bmhdira,R.anim.bmnvao);
                finishAndRemoveTask();
            }
        });

        btChoiLai.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv3.this,R.raw.atnutplay);
                mediaPlayer.start();
                Intent intent = new Intent(lv3.this,lv3.class);
                startActivity(intent);
                finishAndRemoveTask();
            }
        });

        imgGoiY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv3.this,R.raw.back);
                mediaPlayer.start();
                rGoiY.setVisibility(View.VISIBLE);
                final int[] time = {30};
                CountDownTimer countDownTimer = new CountDownTimer(30000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        time[0]--;
                        txtGoiY.setText(""+ time[0]);
                    }

                    @Override
                    public void onFinish() {
                        txtGoiY.setText("Hãy tìm chữ nằm trong các tấm hình dưới");
                    }
                }.start();
            }
        });

        btGoiY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv3.this,R.raw.back);
                mediaPlayer.start();
                rGoiY.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void viewID(){
        btchon1 = (Button) findViewById(R.id.lv3btchon1);
        btchon2 = (Button) findViewById(R.id.lv3btchon2);
        btchon3 = (Button) findViewById(R.id.lv3btchon3);
        btchon4 = (Button) findViewById(R.id.lv3btchon4);
        btchon5 = (Button) findViewById(R.id.lv3btchon5);
        btchon6 = (Button) findViewById(R.id.lv3btchon6);
        btchon7 = (Button) findViewById(R.id.lv3btchon7);
        btchon8 = (Button) findViewById(R.id.lv3btchon8);
        btchon9 = (Button) findViewById(R.id.lv3btchon9);
        btchon10 = (Button) findViewById(R.id.lv3btchon10);
        btchon11 = (Button) findViewById(R.id.lv3btchon11);
        btchon12 = (Button) findViewById(R.id.lv3btchon12);

        bttl1 = (Button) findViewById(R.id.lv3bt1);
        bttl2 = (Button) findViewById(R.id.lv3bt2);
        bttl3 = (Button) findViewById(R.id.lv3bt3);
        bttl4 = (Button) findViewById(R.id.lv3bt4);
        bttl5 = (Button) findViewById(R.id.lv3bt5);
        bttl6 = (Button) findViewById(R.id.lv3bt6);

        btChoiLai = (Button) findViewById(R.id.lv3btchoilai);
        btTiep = (Button) findViewById(R.id.lv3bttiep);

        imgBack = (ImageView) findViewById(R.id.lv3imgback);

        txtThang = (TextView) findViewById(R.id.lv3txtthang);
        txtCauHoi = (TextView) findViewById(R.id.lv3txtcauhoi);

        rlmenu = (RelativeLayout) findViewById(R.id.lv3menu);

        imgcMu = (ImageView) findViewById(R.id.lv5imgcmu);

        imgGoiY = (ImageView) findViewById(R.id.lv3imggoiy);
        rGoiY = (RelativeLayout) findViewById(R.id.lv3rlgiaithich);
        btGoiY = (Button) findViewById(R.id.lv3btgiaithich);
        txtGoiY = (TextView) findViewById(R.id.lv3txtgiaithich);
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
    public void ghiFileLV3(String s, int t){
        try{
            FileOutputStream fileOutputStream = openFileOutput(s,0);
            OutputStreamWriter ghi = new OutputStreamWriter(fileOutputStream);
            ghi.write(String.valueOf(t));
            ghi.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void docFileLV3OfLV5(String s){
        try {
            FileInputStream fileInputStream = openFileInput(s);
            BufferedReader doc = new BufferedReader(new InputStreamReader(fileInputStream));
            lv3lv5=Integer.parseInt(doc.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
