package jp.ac.shohoku.s18b706.ueno.dtic;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
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
                    // 変更したいレイアウトを取得する
                    LinearLayout layout = findViewById(R.id.op);
                    // BGM
                    // レイアウトのビューをすべて削除する
                    layout.removeAllViews();
                    // レイアウトをR.layout.sampleに変更する
                    getLayoutInflater().inflate(R.layout.brushing,layout);
                    count=2;
                }else if(count == 2){
                    LinearLayout layout =  findViewById(R.id.brushing);
                    layout.removeAllViews();
                    getLayoutInflater().inflate(R.layout.angry,layout);
                    count=3;
                }else if(count == 3){
                    LinearLayout layout =  findViewById(R.id.angry);
                    layout.removeAllViews();
                    getLayoutInflater().inflate(R.layout.stroking,layout);
                    count=4;
                }else if(count == 4){
                    LinearLayout layout =  findViewById(R.id.stroking);
                    layout.removeAllViews();
                    getLayoutInflater().inflate(R.layout.eat,layout);
                    count=5;
                }else if(count == 5){
                    LinearLayout layout =  findViewById(R.id.eat);
                    layout.removeAllViews();
                    getLayoutInflater().inflate(R.layout.op,layout);
                    count=1;
                }
            }
        });
    }
}
