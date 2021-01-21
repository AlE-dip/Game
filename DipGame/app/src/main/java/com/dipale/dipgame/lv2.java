package com.dipale.dipgame;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

public class lv2 extends Activity {

    SeekBar sbRua,sbSoc,sbSen;
    CountDownTimer chay,thoiGianChay;
    int iRua,iSen,txtTG=4,lv;
    TextView txtThang,txtThoiGian,txtGoiY;
    ImageView imgQuac,imgBack,imgGoiY;
    Button btChay,btTiep,btChoiLai,btGoiY;
    RelativeLayout rlBatDau,rlmenu,rGoiY;
    boolean win=false;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_lv2);

        viewID();
        rlmenu.setVisibility(View.INVISIBLE);
        rGoiY.setVisibility(View.INVISIBLE);

        sbSoc.setEnabled(false);
        sbSen.setEnabled(false);
        sbRua.setEnabled(false);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv2.this,R.raw.back);
                mediaPlayer.start();
                finishAndRemoveTask();
            }
        });

        chay = new CountDownTimer(10000,200) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(sbRua.getProgress()>= sbRua.getMax()){
                    chay.cancel();
                    txtThang.setText("Rùa thắng");
                    imgQuac.setEnabled(false);
                    CountDownTimer countDownTimer=new CountDownTimer(3000,1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            rlBatDau.setVisibility(View.VISIBLE);
                            txtTG=4;
                            thoiGianChay.start();
                            sbRua.setProgress(0);
                            sbSoc.setProgress(0);
                            sbSen.setProgress(0);
                            imgQuac.setEnabled(true);
                            chay.cancel();
                        }
                    }.start();
                }
                if(sbSen.getProgress()>= sbSen.getMax()){
                    chay.cancel();
                    txtThang.setText("Sên thắng");
                    imgQuac.setEnabled(false);
                    CountDownTimer countDownTimer=new CountDownTimer(3000,1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            rlBatDau.setVisibility(View.VISIBLE);
                            txtTG=4;
                            thoiGianChay.start();
                            sbRua.setProgress(0);
                            sbSoc.setProgress(0);
                            sbSen.setProgress(0);
                            imgQuac.setEnabled(true);
                            this.cancel();
                        }
                    }.start();
                }
                if(sbSoc.getProgress()>= sbRua.getMax()){
                    chay.cancel();
                    txtThang.setText("Bạn thắng");
                    imgQuac.setEnabled(false);
                    imgBack.setEnabled(false);
                    imgGoiY.setEnabled(false);
                    CountDownTimer thangRoi = new CountDownTimer(3000,1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            docFile();
                            if(lv<3) {
                                lv = 3;
                            }
                            ghiFile();
                            chay.cancel();
                            rlmenu.setVisibility(View.VISIBLE);
                        }
                    }.start();
                }

                Random random = new Random();
                iRua=random.nextInt(15-5+1)+5;
                iSen=random.nextInt(15-5+1)+5;

                sbRua.setProgress(sbRua.getProgress()+iRua);
                sbSen.setProgress(sbSen.getProgress()+iSen);
            }

            @Override
            public void onFinish() {
                chay.start();
            }
        };

        imgQuac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv2.this,R.raw.lv2gio);
                mediaPlayer.start();
                imgQuac.setImageResource(R.drawable.lv2quacthoi);
                CountDownTimer countDownTimer = new CountDownTimer(100,100) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        imgQuac.setImageResource(R.drawable.lv2quac);
                    }
                }.start();
                sbSoc.setProgress(sbSoc.getProgress()+5);
            }
        });
        txtThoiGian.setText(""+txtTG);
        thoiGianChay = new CountDownTimer(4000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                txtTG--;
                txtThoiGian.setText(""+txtTG);
            }

            @Override
            public void onFinish() {
                rlBatDau.setVisibility(View.INVISIBLE);
                chay.start();
            }
        }.start();
        btChay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(lv2.this,R.raw.amthangnhanlv);
                mediaPlayer.start();
                rlBatDau.setVisibility(View.INVISIBLE);
                thoiGianChay.cancel();
                chay.start();
            }
        });

        btTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv2.this,R.raw.atnutplay);
                mediaPlayer.start();
                Intent intent=new Intent(lv2.this,menu.class);
                startActivity(intent);
                overridePendingTransition(R.anim.bmhdira,R.anim.bmnvao);
                finishAndRemoveTask();
            }
        });
        btChoiLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv2.this,R.raw.atnutplay);
                mediaPlayer.start();
                Intent intent=new Intent(lv2.this,lv2.class);
                startActivity(intent);
                finishAndRemoveTask();
            }
        });

        imgGoiY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv2.this,R.raw.back);
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
                        txtGoiY.setText("Con sóc có thể chạy trước á");
                    }
                }.start();
            }
        });

        btGoiY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv2.this,R.raw.back);
                mediaPlayer.start();
                rGoiY.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void viewID(){
        sbSoc = (SeekBar) findViewById(R.id.lv2sbsoc);
        sbSen = (SeekBar) findViewById(R.id.lv2sbsen);
        sbRua = (SeekBar) findViewById(R.id.lv2sbrua);

        txtThang = (TextView) findViewById(R.id.lv2txtthang);
        txtThoiGian = (TextView) findViewById(R.id.lv2txtthoigian);

        imgQuac = (ImageView) findViewById(R.id.lv2imgquac);
        imgBack = (ImageView) findViewById(R.id.lv2imgback);

        btChay = (Button) findViewById(R.id.lv2btchay);
        btChoiLai = (Button) findViewById(R.id.lv2btchoilai);
        btTiep = (Button) findViewById(R.id.lv2bttiep);

        rlBatDau = (RelativeLayout) findViewById(R.id.lv2rlbatdau);
        rlmenu = (RelativeLayout) findViewById(R.id.lv2menu);

        imgGoiY = (ImageView) findViewById(R.id.lv2imggoiy);
        rGoiY = (RelativeLayout) findViewById(R.id.lv2rlgiaithich);
        btGoiY = (Button) findViewById(R.id.lv2btgiaithich);
        txtGoiY = (TextView) findViewById(R.id.lv2txtgiaithich);
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
