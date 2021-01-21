package com.dipale.dipgame;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class lv5 extends AppCompatActivity {

    ImageView imgCaVay,imgCaMat,imgCaMuc,imgMaMat,imgMaTay,imgMaSeo,imgBack,imgGoiY;
    ImageView imgcMatMa,imgcMatCa,imgcMatLogo,imgcMuCuop,imgcMuc,imgcNgonTay,imgcSeo,imgcKhangQuang,imgcVay,imgcI;
    int win=0,mainlv5=0,lv1lv5=0,lv3lv5=0,ttlv5=0,lv=0;
    TextView txtCauHoi,txtGoiY;
    Button btTiep,btChoiLai,btGoiY;
    RelativeLayout rl,rGoiY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_lv5);

        viewID();
        docFile();
        docFileMainOfLV5("mainlv5.txt");
        docFileLV1OfLV5("lv1oflv5.txt");
        docFileLV3OfLV5("lv3oflv5.txt");
        docFileTTOfLV5("ttlv5.txt");
        rl.setVisibility(View.INVISIBLE);
        rGoiY.setVisibility(View.INVISIBLE);
        if(mainlv5==1){
            imgcI.setImageResource(R.drawable.lv5danhdau);
            win++;
        }
        if(lv1lv5==1){
            imgcKhangQuang.setImageResource(R.drawable.lv5danhdau);
            win++;
        }
        if(lv3lv5==1){
            imgcMuCuop.setImageResource(R.drawable.lv5danhdau);
            win++;
        }
        if(ttlv5==1){
            imgcMatLogo.setImageResource(R.drawable.lv5danhdau);
            win++;
        }

        imgBack.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv5.this,R.raw.back);
                mediaPlayer.start();
                finishAndRemoveTask();
            }
        });

        imgCaVay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgCaVay.setImageResource(R.drawable.lv5danhdau);
                imgcVay.setImageResource(R.drawable.lv5danhdau);
                win++;
                v.setEnabled(false);
            }
        });

        imgCaMuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgCaMuc.setImageResource(R.drawable.lv5danhdau);
                imgcMuc.setImageResource(R.drawable.lv5danhdau);
                win++;
                v.setEnabled(false);
            }
        });

        imgCaMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgCaMat.setImageResource(R.drawable.lv5danhdau);
                imgcMatCa.setImageResource(R.drawable.lv5danhdau);
                win++;
                v.setEnabled(false);
            }
        });

        imgMaTay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgMaTay.setImageResource(R.drawable.lv5danhdau);
                imgcNgonTay.setImageResource(R.drawable.lv5danhdau);
                win++;
                v.setEnabled(false);
            }
        });

        imgMaSeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgMaSeo.setImageResource(R.drawable.lv5danhdau);
                imgcSeo.setImageResource(R.drawable.lv5danhdau);
                win++;
                v.setEnabled(false);
            }
        });

        imgMaMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgMaMat.setImageResource(R.drawable.lv5danhdau);
                imgcMatMa.setImageResource(R.drawable.lv5danhdau);
                win++;
                v.setEnabled(false);
            }
        });

        final CountDownTimer countDownTimer = new CountDownTimer(10000,500) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(win==10){
                    CountDownTimer delay = new CountDownTimer(3000,3000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            imgBack.setEnabled(false);
                            rl.setVisibility(View.VISIBLE);
                        }
                    }.start();
                    this.cancel();
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
                MediaPlayer mediaPlayer = MediaPlayer.create(lv5.this,R.raw.atnutplay);
                mediaPlayer.start();
                Intent intent = new Intent(lv5.this,menu.class);
                startActivity(intent);
                overridePendingTransition(R.anim.bmhdira,R.anim.bmnvao);
                finishAndRemoveTask();
            }
        });

        btChoiLai.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv5.this,R.raw.atnutplay);
                mediaPlayer.start();
                Intent intent = new Intent(lv5.this,lv5.class);
                startActivity(intent);
                finishAndRemoveTask();
            }
        });

        imgGoiY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv5.this,R.raw.back);
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
                        txtGoiY.setText("Tìm tất cả các hình có trong game này");
                    }
                }.start();
            }
        });

        btGoiY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv5.this,R.raw.back);
                mediaPlayer.start();
                rGoiY.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void viewID(){
        imgCaVay = (ImageView) findViewById(R.id.lv5imgcavay);
        imgCaMat = (ImageView) findViewById(R.id.lv5imgcamat);
        imgCaMuc = (ImageView) findViewById(R.id.lv5imgcamuc);
        imgMaMat = (ImageView) findViewById(R.id.lv5imgmamat);
        imgMaSeo = (ImageView) findViewById(R.id.lv5imgmaseo);
        imgMaTay = (ImageView) findViewById(R.id.lv5imgmatay);

        imgcI = (ImageView) findViewById(R.id.lv5imgci);
        imgcMatCa = (ImageView) findViewById(R.id.lv5imgcmatca);
        imgcMatLogo = (ImageView) findViewById(R.id.lv5imgcmatlogo);
        imgcMatMa = (ImageView) findViewById(R.id.lv5imgcmatma);
        imgcMuc = (ImageView) findViewById(R.id.lv5imgcmuc);
        imgcMuCuop = (ImageView) findViewById(R.id.lv5imgcmucuop);
        imgcKhangQuang = (ImageView) findViewById(R.id.lv5imgckhangquang);
        imgcNgonTay = (ImageView) findViewById(R.id.lv5imgcngontay);
        imgcSeo = (ImageView) findViewById(R.id.lv5imgcseo);
        imgcVay = (ImageView) findViewById(R.id.lv5imgcvayca);

        imgBack = (ImageView) findViewById(R.id.lv5imgback);

        txtCauHoi = (TextView) findViewById(R.id.lv5txtcauhoi);

        btChoiLai = (Button) findViewById(R.id.lv5btchoilai);
        btTiep = (Button) findViewById(R.id.lv5bttiep);

        rl = (RelativeLayout) findViewById(R.id.lv5menu);

        imgGoiY = (ImageView) findViewById(R.id.lv5imggoiy);
        rGoiY = (RelativeLayout) findViewById(R.id.lv5rlgiaithich);
        btGoiY = (Button) findViewById(R.id.lv5btgiaithich);
        txtGoiY = (TextView) findViewById(R.id.lv5txtgiaithich);
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

    public void ghiFileOfLV5(String s,int lv5){
        try{
            FileOutputStream fileOutputStream = openFileOutput(s,0);
            OutputStreamWriter ghi = new OutputStreamWriter(fileOutputStream);
            ghi.write(String.valueOf(lv5));
            ghi.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void docFileLV1OfLV5(String s){
        try {
            FileInputStream fileInputStream = openFileInput(s);
            BufferedReader doc = new BufferedReader(new InputStreamReader(fileInputStream));
            lv1lv5=Integer.parseInt(doc.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void docFileMainOfLV5(String s){
        try {
            FileInputStream fileInputStream = openFileInput(s);
            BufferedReader doc = new BufferedReader(new InputStreamReader(fileInputStream));
            mainlv5=Integer.parseInt(doc.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
