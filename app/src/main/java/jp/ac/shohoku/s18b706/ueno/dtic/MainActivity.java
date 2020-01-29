package jp.ac.shohoku.s18b706.ueno.dtic;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
    private MediaPlayer mBgm; //BGM用の変数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Button opbutton = findViewById(R.id.opbutton); // op.xmlの★ボタン
        opbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                starBGM(); // ★の効果音
                new Handler().postDelayed(new Runnable() { // 画面切り替えの遅延
                    @Override
                    public void run() {
                        LinearLayout layout = findViewById(R.id.op); // 変更したいレイアウトを取得する
                        layout.removeAllViews(); // レイアウトのビューをすべて削除する
                        getLayoutInflater().inflate(R.layout.brushing,layout); // レイアウトをR.layout.brushingに変更する
                        KawaiiBGM(); // 可愛いBGMスタート
                    }
                },1500);
            }
        });



//        final Button button1 = findViewById(R.id.button1);
//        button1.setOnClickListener(new OnClickListener(){
//            @Override
//            public void onClick(View v){
//                if(count == 1){
//                    // 変更したいレイアウトを取得する
//                    LinearLayout layout = findViewById(R.id.op);
//                    // レイアウトのビューをすべて削除する
//                    layout.removeAllViews();
//                    // レイアウトをR.layout.sampleに変更する
//                    getLayoutInflater().inflate(R.layout.brushing,layout);
//                    KawaiiBGM(); // 可愛いBGMスタート
//                    count=2;
//                }else if(count == 2){
//                    mBgm.stop(); // 可愛いBGMストップ
//                    LinearLayout layout =  findViewById(R.id.brushing);
//                    layout.removeAllViews();
//                    getLayoutInflater().inflate(R.layout.angry,layout);
//                    AngryBGM(); // 怒った時のBGMスタート
//                    count=3;
//                }else if(count == 3){
//                    mBgm.stop(); // 怒った時のBGMストップ
//                    LinearLayout layout =  findViewById(R.id.angry);
//                    layout.removeAllViews();
//                    getLayoutInflater().inflate(R.layout.brushing,layout);
//                    BrushingBGM(); // ブラッシングする時のBGMスタート
//                    count=4;
//                }else if(count == 4){
//                    mBgm.stop(); // ブラッシングする時のBGMストップ
//                    LinearLayout layout =  findViewById(R.id.brushing);
//                    layout.removeAllViews();
//                    getLayoutInflater().inflate(R.layout.eat,layout);
//                    BadendBGM();  // 死んだBGM
//                    BadendBGM2(); // 死んだBGM（くちゃくちゃ）
//                    count=5;
//                } else if(count == 5){
//                    mBgm.stop(); // 死んだBGMストップ
//                    LinearLayout layout =  findViewById(R.id.eat);
//                    layout.removeAllViews();
//                    getLayoutInflater().inflate(R.layout.op,layout);
//                    count=1;
//                }
//            }
//        });
    }

    private void KawaiiBGM(){ // 可愛いBGM
        int bgmResID = this.getResources().getIdentifier("kbgm","raw",
                "jp.ac.shohoku.s18b706.ueno.dtic");
        mBgm = MediaPlayer.create(this, R.raw.kawaiibgm);
        mBgm.seekTo(0); //先頭に再生位置を設定
        mBgm.start(); // 音楽再生開始
        mBgm.setLooping(true); //ループ再生する
    }
    private void AngryBGM(){ // 怒った時のBGM
        int bgmResID = this.getResources().getIdentifier("kbgm","raw",
                "jp.ac.shohoku.s18b706.ueno.dtic");
        mBgm = MediaPlayer.create(this, R.raw.angrybgm);
        mBgm.seekTo(0);
        mBgm.start();
        //mBgm.setLooping(true); ループ再生はしない
    }
    private void BrushingBGM(){ // ブラッシングする時のBGM
        int bgmResID = this.getResources().getIdentifier("kbgm","raw",
                "jp.ac.shohoku.s18b706.ueno.dtic");
        mBgm = MediaPlayer.create(this, R.raw.brushingbgm);
        mBgm.seekTo(0);
        mBgm.start();
        mBgm.setLooping(true);
    }
    private void BadendBGM(){ // 死んだBGM
        int bgmResID = this.getResources().getIdentifier("kbgm","raw",
                "jp.ac.shohoku.s18b706.ueno.dtic");
        mBgm = MediaPlayer.create(this, R.raw.badendbgm);
        mBgm.seekTo(0);
        mBgm.start();
        //mBgm.setLooping(true); ループ再生はしない
    }
    private void BadendBGM2(){ // 死んだBGM2（くちゃくちゃ）
        int bgmResID = this.getResources().getIdentifier("kbgm","raw",
                "jp.ac.shohoku.s18b706.ueno.dtic");
        mBgm = MediaPlayer.create(this, R.raw.badendbgm2);
        mBgm.seekTo(0);
        mBgm.start();
        mBgm.setLooping(true);
    }
    private void starBGM(){ // ★効果音
        int bgmResID = this.getResources().getIdentifier("kbgm","raw",
                "jp.ac.shohoku.s18b706.ueno.dtic");
        mBgm = MediaPlayer.create(this, R.raw.star);
        mBgm.seekTo(0);
        mBgm.start();
    }
}
