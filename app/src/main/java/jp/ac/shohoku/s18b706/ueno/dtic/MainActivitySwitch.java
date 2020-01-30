package jp.ac.shohoku.s18b706.ueno.dtic;

import android.app.Activity;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivitySwitch extends Activity {
    private MediaPlayer mBgm; //BGM用の変数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brushing);

        Switch switchB = findViewById(R.id.bruswitch);
        // switchButtonのオンオフが切り替わった時の処理を設定
        switchB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked == true) {
                    // オンなら
//                      mBgm.stop();
//                      FrameLayout layout = findViewById(R.id.brushing); // 変更したいレイアウトを取得する
//                      layout.removeAllViews(); // レイアウトのビューをすべて削除する
//                      getLayoutInflater().inflate(R.layout.angry,layout); // レイアウトをR.layout.brushingに変更する
//                      AngryBGM();
                } else {
                    // オフなら
                }
            }
        });
    }


    private void AngryBGM(){ // 怒った時のBGM
        int bgmResID = this.getResources().getIdentifier("kbgm","raw",
                "jp.ac.shohoku.s18b706.ueno.dtic");
        mBgm = MediaPlayer.create(this, R.raw.angrybgm);
        mBgm.seekTo(0);
        mBgm.start();
        //mBgm.setLooping(true); ループ再生はしない
    }
}
