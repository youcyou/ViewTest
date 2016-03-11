package com.example.youcyou.viewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nineoldandroids.animation.ObjectAnimator;

public class MainActivity extends AppCompatActivity {

    private CostumView ll;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ll= (CostumView) findViewById(R.id.ll);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ll.smootScrollBy(-200, -200);
                ObjectAnimator.ofFloat(button, "translationX", 0, 800).setDuration(1000).start();

                Toast.makeText(MainActivity.this,"x:"+button.getX()+"\ny:"+button.getY(),Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
