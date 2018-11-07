package com.bamboy.slidingshut;

import android.os.Bundle;

import com.bamboy.slidingshut.baseactivity.BamActivity;

/**
 * 即刻模式示例
 * <p>
 * Created by Bamboy on 2018/10/25.
 */
public class StartInstantlyActivity extends BamActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_instantly);

        setUpFinish(false);
    }
}
