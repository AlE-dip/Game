package com.dipale.dipgame;

import androidx.annotation.Nullable;
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
import android.view.animation.AnimationUtils;
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

public class lv1 extends Activity {

    ImageView imgBack,imgGoiY,imgCoSoi,imgSoi,imgBanh,imgBa,imgSung,imgCuc,imgDienThoai,imgTrongCom,imgBeKhoc;
    ImageView cmt1,cmt2,cmt3,imgcKhangQuang;
    boolean dieuKien=false,win=false;
    MediaPlayer atSoiKeu,atSungBang;
    RelativeLayout rMenu,rGoiY;
    Button btTiep,btChoiLai,btGoiY;
    CountDownTimer cBanh,cBa,cSung,cDienThoai,cCuc,cTrongCom;
    int lv,lanDau=1,lv5=0;
    TextView txtGoiY;
    CountDownTimer count30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_lv1);

        viewID();
        amThanh();
        rGoiY.setVisibility(View.INVISIBLE);
        docFileLV1("lv1.txt");
        docFileLV1OfLV5("lv1oflv5.txt");
        if(lv5==1){
            imgcKhangQuang.setImageResource(R.drawable.lv5danhdau);
            imgcKhangQuang.setEnabled(false);
        }
        imgcKhangQuang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lv5==0){
                    imgcKhangQuang.setImageResource(R.drawable.lv5danhdau);
                    imgcKhangQuang.setEnabled(false);
                    lv5=1;
                    ghiFileLV1("lv1oflv5.txt",lv5);
                }
            }
        });

        rMenu.setVisibility(View.INVISIBLE);

        final Animation lacNhe = AnimationUtils.loadAnimation(this,R.anim.lacnhe);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv1.this,R.raw.back);
                mediaPlayer.start();
                finishAndRemoveTask();
            }
        });
        final Animation animation= AnimationUtils.loadAnimation(this,R.anim.phongto);
        imgCoSoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgSoi.startAnimation(animation);
                atSoiKeu.start();
                atSoiKeu.setLooping(true);
                dieuKien=true;
            }
        });
        imgSung.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv1.this,R.raw.lv1dovat);
                mediaPlayer.start();
                v.startAnimation(lacNhe);
                if(dieuKien==false){
                    cmt2.setImageResource(0);
                    cmt1.setImageResource(0);
                    cmt3.setImageResource(R.drawable.lv1cmtsung);
                    cSung = new CountDownTimer(3000,1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            cmt1.setImageResource(0);
                            cmt2.setImageResource(0);
                            cmt3.setImageResource(R.drawable.lv1cmtkhoc);
                        }
                    }.start();
                }else {
                    imgCoSoi.setEnabled(false);
                    imgBanh.setEnabled(false);
                    imgBa.setEnabled(false);
                    imgSung.setEnabled(false);
                    imgDienThoai.setEnabled(false);
                    imgCuc.setEnabled(false);
                    imgTrongCom.setEnabled(false);
                    imgBack.setEnabled(false);
                    imgGoiY.setEnabled(false);
                    atSoiKeu.stop();
                    atSungBang.start();
                    imgSoi.setImageResource(R.drawable.lv1soichet);
                    imgBeKhoc.setImageResource(R.drawable.abecuoi);
                    cmt2.setImageResource(0);
                    cmt1.setImageResource(R.drawable.lv1cmtduoccuou);
                    cmt3.setImageResource(0);
                    cSung = new CountDownTimer(3000,1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            cmt1.setImageResource(0);
                            cmt2.setImageResource(0);
                            cmt3.setImageResource(R.drawable.lv1cmtkhoc);
                            win=true;
                            docFile();
                            if(lv<2) {
                                lv = 2;
                            }
                            ghiFile();
                            imgcKhangQuang.setEnabled(false);
                            rMenu.setVisibility(View.VISIBLE);
                        }
                    }.start();
                }
            }
        });

        imgBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv1.this,R.raw.lv1dovat);
                mediaPlayer.start();
                v.startAnimation(lacNhe);
                if(lanDau==1){
                    imgCoSoi.setEnabled(false);
                    imgBanh.setEnabled(false);
                    imgBa.setEnabled(false);
                    imgSung.setEnabled(false);
                    imgDienThoai.setEnabled(false);
                    imgCuc.setEnabled(false);
                    imgTrongCom.setEnabled(false);
                    lanDau=0;
                    ghiFileLV1("lv1.txt",lanDau);
                    rMenu.setVisibility(View.VISIBLE);
                }else {
                    cmt2.setImageResource(0);
                    cmt1.setImageResource(0);
                    cmt3.setImageResource(R.drawable.lv1cmtba);
                    cBa = new CountDownTimer(3000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            cmt1.setImageResource(0);
                            cmt2.setImageResource(0);
                            cmt3.setImageResource(R.drawable.lv1cmtkhoc);
                        }
                    }.start();
                }

            }
        });

        imgBanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv1.this,R.raw.lv1dovat);
                mediaPlayer.start();
                v.startAnimation(lacNhe);
                cmt1.setImageResource(0);
                cmt2.setImageResource(R.drawable.lv1cmtbanh);
                cmt3.setImageResource(0);
                cBanh = new CountDownTimer(3000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        cmt1.setImageResource(0);
                        cmt2.setImageResource(0);
                        cmt3.setImageResource(R.drawable.lv1cmtkhoc);
                    }
                }.start();
            }
        });

        imgDienThoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv1.this,R.raw.lv1dovat);
                mediaPlayer.start();
                v.startAnimation(lacNhe);
                cmt1.setImageResource(0);
                cmt2.setImageResource(R.drawable.lv1cmtdienthoai);
                cmt3.setImageResource(0);
                cDienThoai = new CountDownTimer(3000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        cmt1.setImageResource(0);
                        cmt2.setImageResource(0);
                        cmt3.setImageResource(R.drawable.lv1cmtkhoc);
                    }
                }.start();
            }
        });

        imgCuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv1.this,R.raw.lv1dovat);
                mediaPlayer.start();
                v.startAnimation(lacNhe);
                cmt1.setImageResource(0);
                cmt2.setImageResource(R.drawable.lv1cmtcuc);
                cmt3.setImageResource(0);
               cCuc = new CountDownTimer(3000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        cmt1.setImageResource(0);
                        cmt2.setImageResource(0);
                        cmt3.setImageResource(R.drawable.lv1cmtkhoc);
                    }
                }.start();
            }
        });

        imgTrongCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv1.this,R.raw.lv1dovat);
                mediaPlayer.start();
                v.startAnimation(lacNhe);
                cmt1.setImageResource(0);
                cmt2.setImageResource(R.drawable.lv1tcmttrongcom);
                cmt3.setImageResource(0);
                cTrongCom=new CountDownTimer(3000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        cmt1.setImageResource(0);
                        cmt2.setImageResource(0);
                        cmt3.setImageResource(R.drawable.lv1cmtkhoc);
                    }
                }.start();
            }
        });

        btTiep.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv1.this,R.raw.atnutplay);
                if(win){
                    mediaPlayer.start();
                    Intent intent=new Intent(lv1.this,menu.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.bmhdira,R.anim.bmnvao);
                    finishAndRemoveTask();
                }else {
                    mediaPlayer.start();
                    imgCoSoi.setEnabled(true);
                    imgBanh.setEnabled(true);
                    imgBa.setEnabled(true);
                    imgSung.setEnabled(true);
                    imgDienThoai.setEnabled(true);
                    imgCuc.setEnabled(true);
                    imgTrongCom.setEnabled(true);
                    rMenu.setVisibility(View.INVISIBLE);
                    Toast.makeText(lv1.this,"Chưa thắng đau chơi tiếp đi!",Toast.LENGTH_LONG).show();
                }
            }
        });
        btChoiLai.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv1.this,R.raw.atnutplay);
                if(win){
                    mediaPlayer.start();
                    Intent intent=new Intent(lv1.this,lv1.class);
                    startActivity(intent);
                    finishAndRemoveTask();
                }else {
                    mediaPlayer.start();
                    imgCoSoi.setEnabled(true);
                    imgBanh.setEnabled(true);
                    imgBa.setEnabled(true);
                    imgSung.setEnabled(true);
                    imgDienThoai.setEnabled(true);
                    imgCuc.setEnabled(true);
                    imgTrongCom.setEnabled(true);
                    rMenu.setVisibility(View.INVISIBLE);
                    Toast.makeText(lv1.this,"Vẫn chưa thắng mà",Toast.LENGTH_LONG).show();
                }
            }
        });

        imgGoiY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv1.this,R.raw.back);
                mediaPlayer.start();
                rGoiY.setVisibility(View.VISIBLE);
                final int[] time = {30};
                count30 = new CountDownTimer(30000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        time[0]--;
                        txtGoiY.setText(""+ time[0]);
                    }

                    @Override
                    public void onFinish() {
                        txtGoiY.setText("Hãy tìm con sói rồi giết nó");
                    }
                }.start();
            }
        });

        btGoiY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv1.this,R.raw.back);
                mediaPlayer.start();
                count30.cancel();
                rGoiY.setVisibility(View.INVISIBLE);
            }
        });
    }


    private void viewID(){
        imgBack = (ImageView) findViewById(R.id.lv1imgback);
        imgCoSoi = (ImageView) findViewById(R.id.lv1imgcosoi);
        imgSoi = (ImageView) findViewById(R.id.lv1imgsoi);
        imgBanh = (ImageView) findViewById(R.id.lv1imgbanh);
        imgBa = (ImageView) findViewById(R.id.lv1imgba);
        imgSung = (ImageView) findViewById(R.id.lv1imgsung);
        imgCuc = (ImageView) findViewById(R.id.lv1imgcuc);
        imgDienThoai = (ImageView) findViewById(R.id.lv1imgdienthoai);
        imgTrongCom = (ImageView) findViewById(R.id.lv1imgtrongcom);
        imgBeKhoc = (ImageView) findViewById(R.id.lv1imgbekhoc);

        imgcKhangQuang = (ImageView) findViewById(R.id.lv5imgckhangquang);

        cmt1 = (ImageView) findViewById(R.id.lv1imgcmt1);
        cmt2 = (ImageView) findViewById(R.id.lv1imgcmt2);
        cmt3 = (ImageView) findViewById(R.id.lv1imgcmt3);

        rMenu = (RelativeLayout) findViewById(R.id.lv1menu);
        btTiep = (Button) findViewById(R.id.lv1bttiep);
        btChoiLai = (Button) findViewById(R.id.lv1btchoilai);

        imgGoiY = (ImageView) findViewById(R.id.lv1imggoiy);
        rGoiY = (RelativeLayout) findViewById(R.id.lv1rlgiaithich);
        btGoiY = (Button) findViewById(R.id.lv1btgiaithich);
        txtGoiY = (TextView) findViewById(R.id.lv1txtgiaithich);
    }

    private void amThanh(){
        atSoiKeu=MediaPlayer.create(lv1.this,R.raw.soikeu);
        atSungBang=MediaPlayer.create(lv1.this,R.raw.sungbang);
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

    public void ghiFileLV1(String s, int t){
        try{
            FileOutputStream fileOutputStream = openFileOutput(s,0);
            OutputStreamWriter ghi = new OutputStreamWriter(fileOutputStream);
            ghi.write(String.valueOf(t));
            ghi.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void docFileLV1(String s){
        try {
            FileInputStream fileInputStream = openFileInput(s);
            BufferedReader doc = new BufferedReader(new InputStreamReader(fileInputStream));
            lanDau=Integer.parseInt(doc.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void docFileLV1OfLV5(String s){
        try {
            FileInputStream fileInputStream = openFileInput(s);
            BufferedReader doc = new BufferedReader(new InputStreamReader(fileInputStream));
            lv5=Integer.parseInt(doc.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
