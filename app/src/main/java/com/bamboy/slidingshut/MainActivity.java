package com.bamboy.slidingshut;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bamboy.slidingshut.baseactivity.BamActivity;

/**
 * Created by Bamboy on 2018/10/24.
 */
public class MainActivity extends BamActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openSlideFinish(false);

        findViewById(R.id.btn_start_instantly).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, StartInstantlyActivity.class));
            }
        });

        findViewById(R.id.btn_start_up_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UpFinishActivity.class));
            }
        });

        findViewById(R.id.btn_intercept_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InterceptFinishActivity.class));
            }
        });

    }
}
