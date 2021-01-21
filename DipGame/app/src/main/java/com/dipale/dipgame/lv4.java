package com.dipale.dipgame;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
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

public class lv4 extends Activity {

    ImageView imgBack,imgDien,imgChuot,imgGoiY;
    ImageView imgXitDoc,imgPhongXa,imgThuocchuot,imgKeoMut,imgDapRuoi,imgDao;
    int doidien=1,doichuot=2,td=0,tc=0,doitxt=0,lv;
    TextView txtThang,txtCauHoi,txtGoiY;
    boolean thang=false;
    RelativeLayout rlMenu,rGoiY;
    Button btTiep,btChoiLai,btGoiY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_lv4);

        viewID();
        rlMenu.setVisibility(View.INVISIBLE);
        rGoiY.setVisibility(View.INVISIBLE);
        final Animation lacnhe = AnimationUtils.loadAnimation(this,R.anim.lacnhe);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv4.this,R.raw.back);
                mediaPlayer.start();
                finishAndRemoveTask();
            }
        });

        CountDownTimer dienchop = new CountDownTimer(10000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(doidien==1){
                    imgDien.setImageResource(R.drawable.lv4dien1);
                    doidien=2;
                }else {
                    if(doidien==2){
                        imgDien.setImageResource(R.drawable.lv4dien2);
                        doidien=3;
                    }else {
                        imgDien.setImageResource(R.drawable.lv4dien3);
                        doidien=1;
                    }
                }
            }

            @Override
            public void onFinish() {
                this.start();
            }
        }.start();

        imgDien.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        td=1;
                        break;
                    case  MotionEvent.ACTION_UP:
                        td=0;
                        break;
                }
                return true;
            }
        });

        imgChuot.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        tc=1;
                        break;
                    case MotionEvent.ACTION_UP:
                        tc=0;
                        break;
                }
                if(td==1) {
                    final CountDownTimer countDownTimer = new CountDownTimer(6000, 100) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            MediaPlayer dien = MediaPlayer.create(lv4.this,R.raw.dien);
                            if(tc==1&&td==1){
                                thang=true;
                                dien.start();
                            }else {
                                dien.stop();
                            }
                            if (doichuot == 2 && tc==1 && td==1) {
                                imgChuot.setImageResource(R.drawable.lv4chuot2);
                                doichuot = 3;
                            } else {
                                if (doichuot == 3 && tc==1 && td==1) {
                                    imgChuot.setImageResource(R.drawable.lv4chuot3);
                                    doichuot = 4;
                                } else {
                                    if (doichuot == 4 && tc==1  && td==1) {
                                        imgChuot.setImageResource(R.drawable.lv4chuot4);
                                        doichuot = 5;
                                    } else {
                                        if (doichuot == 5 && tc==1  && td==1) {
                                            imgChuot.setImageResource(R.drawable.lv4chuot5);
                                            doichuot = 2;
                                        }else {
                                            imgChuot.setImageResource(R.drawable.lv4chuot6);
                                            doichuot=2;
                                            dien.stop();
                                            this.cancel();
                                        }
                                    }
                                }
                            }
                        }

                        @Override
                        public void onFinish() {
                            imgChuot.setImageResource(R.drawable.lv4chuot6);
                        }
                    }.start();
                }
                return true;
            }
        });

        imgXitDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv4.this,R.raw.lv1dovat);
                mediaPlayer.start();
                v.startAnimation(lacnhe);
                txtThang.setText("Không nó vẫn sống kìa.");
                doitxt++;
                CountDownTimer countDownTimer = new CountDownTimer(3000,3000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        txtThang.setText("");
                    }
                }.start();
            }
        });

        imgPhongXa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv4.this,R.raw.lv1dovat);
                mediaPlayer.start();
                v.startAnimation(lacnhe);
                txtThang.setText("Nếu dùng bạn cũng chết theo đấy.");
                doitxt++;
                CountDownTimer countDownTimer = new CountDownTimer(3000,3000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        txtThang.setText("");
                    }
                }.start();
            }
        });

        imgThuocchuot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv4.this,R.raw.lv1dovat);
                mediaPlayer.start();
                v.startAnimation(lacnhe);
                txtThang.setText("Ôi chỉ là hộp rỗng.");
                doitxt++;
                CountDownTimer countDownTimer = new CountDownTimer(3000,3000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        txtThang.setText("");
                    }
                }.start();
            }
        });

        imgDao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv4.this,R.raw.lv1dovat);
                mediaPlayer.start();
                v.startAnimation(lacnhe);
                txtThang.setText("Không có tác dụng rồi.");
                doitxt++;
                CountDownTimer countDownTimer = new CountDownTimer(3000,3000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        txtThang.setText("");
                    }
                }.start();
            }
        });

        imgKeoMut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv4.this,R.raw.lv1dovat);
                mediaPlayer.start();
                v.startAnimation(lacnhe);
                txtThang.setText("Không bạn nên ăn nó thì hơn.");
                doitxt++;
                CountDownTimer countDownTimer = new CountDownTimer(3000,3000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        txtThang.setText("");
                    }
                }.start();
            }
        });

        imgDapRuoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv4.this,R.raw.lv1dovat);
                mediaPlayer.start();
                v.startAnimation(lacnhe);
                txtThang.setText("Nó không đập được chuột đâu.");
                doitxt++;
                CountDownTimer countDownTimer = new CountDownTimer(3000,3000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        txtThang.setText("");
                    }
                }.start();
            }
        });

        final CountDownTimer win = new CountDownTimer(1000,500) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(doitxt>=10){
                    txtCauHoi.setText("Nhấn bừa cũng không thắng nổi đâu.");
                }
                if(thang){
                    CountDownTimer countDownTimer = new CountDownTimer(3000,3000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            docFile();
                            if(lv<5) {
                                lv = 5;
                            }
                            ghiFile();
                            rlMenu.setVisibility(View.VISIBLE);
                            imgChuot.setEnabled(false);
                            imgDien.setEnabled(false);
                            imgBack.setEnabled(false);
                            imgDao.setEnabled(false);
                            imgDapRuoi.setEnabled(false);
                            imgKeoMut.setEnabled(false);
                            imgPhongXa.setEnabled(false);
                            imgThuocchuot.setEnabled(false);
                            imgXitDoc.setEnabled(false);
                            imgGoiY.setEnabled(false);
                        }
                    }.start();
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
                MediaPlayer mediaPlayer = MediaPlayer.create(lv4.this,R.raw.atnutplay);
                mediaPlayer.start();
                Intent intent = new Intent(lv4.this,menu.class);
                startActivity(intent);
                overridePendingTransition(R.anim.bmhdira,R.anim.bmnvao);
                finishAndRemoveTask();
            }
        });

        btChoiLai.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv4.this,R.raw.atnutplay);
                mediaPlayer.start();
                Intent intent = new Intent(lv4.this,lv4.class);
                startActivity(intent);
                finishAndRemoveTask();
            }
        });

        imgGoiY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv4.this,R.raw.back);
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
                        txtGoiY.setText("Điện có thể chuyền qua cơ thể người á");
                    }
                }.start();
            }
        });

        btGoiY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(lv4.this,R.raw.back);
                mediaPlayer.start();
                rGoiY.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void viewID(){
        imgBack = (ImageView) findViewById(R.id.lv4imgback);
        imgDien = (ImageView) findViewById(R.id.lv4imgdien);
        imgChuot = (ImageView) findViewById(R.id.lv4imgchuot);
        imgXitDoc = (ImageView) findViewById(R.id.lv4imgxitdoc);
        imgPhongXa = (ImageView) findViewById(R.id.lv4imgphongxa);
        imgThuocchuot = (ImageView) findViewById(R.id.lv4imgthuocchuot);
        imgKeoMut = (ImageView) findViewById(R.id.lv4imgkeomut);
        imgDapRuoi = (ImageView) findViewById(R.id.lv4imgdapruoi);
        imgDao = (ImageView) findViewById(R.id.lv4imgdao);

        txtThang = (TextView) findViewById(R.id.lv4txtthang);
        txtCauHoi = (TextView) findViewById(R.id.lv4txtcauhoi);

        rlMenu = (RelativeLayout) findViewById(R.id.lv4menu);

        btChoiLai = (Button) findViewById(R.id.lv4btchoilai);
        btTiep = (Button) findViewById(R.id.lv4bttiep);

        imgGoiY = (ImageView) findViewById(R.id.lv4imggoiy);
        rGoiY = (RelativeLayout) findViewById(R.id.lv4rlgiaithich);
        btGoiY = (Button) findViewById(R.id.lv4btgiaithich);
        txtGoiY = (TextView) findViewById(R.id.lv4txtgiaithich);
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
