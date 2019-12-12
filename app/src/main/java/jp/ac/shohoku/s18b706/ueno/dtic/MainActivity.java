package jp.ac.shohoku.s18b706.ueno.dtic;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
    private MediaPlayer mBgm; //BGM用の変数

    int mySoundID;
    int oto;
    private SoundPool soundPool;  //ボタンを押したときの効果音

    int count = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        // ボタンを押したときにイベントを取得できるようにする
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                if(count == 1){

                    Button button = findViewById(R.id.button);
                    button.setOnClickListener(this);
                    oto = getResources().getIdentifier("star",
                            "raw",getPackageName());


                    // 変更したいレイアウトを取得する
                    LinearLayout layout = findViewById(R.id.op);
                    // レイアウトのビューをすべて削除する
                    layout.removeAllViews();
                    // レイアウトをR.layout.sampleに変更する
                    getLayoutInflater().inflate(R.layout.brushing,layout);
                    KawaiiBGM(); // 可愛いBGMスタート
                    count=2;
                }else if(count == 2){
                    mBgm.stop(); // 可愛いBGMストップ
                    LinearLayout layout =  findViewById(R.id.brushing);
                    layout.removeAllViews();
                    getLayoutInflater().inflate(R.layout.angry,layout);
                    count=3;
                }else if(count == 3){
                    LinearLayout layout =  findViewById(R.id.angry);
                    layout.removeAllViews();
                    getLayoutInflater().inflate(R.layout.brushing,layout);
                    AngryBGM(); // 怒っているBGMスタート
                    count=4;
                }else if(count == 4){
                    mBgm.stop(); // 怒っているBGMストップ
                    LinearLayout layout =  findViewById(R.id.brushing);
                    layout.removeAllViews();
                    getLayoutInflater().inflate(R.layout.eat,layout);
                    count=5;
                }
                else if(count == 5){
                    LinearLayout layout =  findViewById(R.id.eat);
                    layout.removeAllViews();
                    getLayoutInflater().inflate(R.layout.op,layout);
                    count=1;
                }
            }
        });
    }

    private void KawaiiBGM(){ // 可愛いBGM
        int bgmResID = this.getResources().getIdentifier("kbgm","raw",
                "jp.ac.shohoku.s18b706.ueno.dtic");
        mBgm = MediaPlayer.create(this, R.raw.kawaiibgm);
        mBgm.seekTo(0); //先頭に再生位置を設定
        mBgm.start(); // 音楽再生開始
        mBgm.setLooping(true); //ループ再生する
    }
    private void AngryBGM(){ // 怒っているBGM
        int bgmResID = this.getResources().getIdentifier("kbgm","raw",
                "jp.ac.shohoku.s18b706.ueno.dtic");
        mBgm = MediaPlayer.create(this, R.raw.angrybgm);
        mBgm.seekTo(0);
        mBgm.start();
        mBgm.setLooping(true);
    }


    private void star(){ // ボタンを押すとキラキラが流れる

    }
}
