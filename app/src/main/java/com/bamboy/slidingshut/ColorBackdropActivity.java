package com.bamboy.slidingshut;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.bamboy.slidingshut.baseactivity.BamActivity;

/**
 * 彩色背景下改变进度条颜色示例
 * <p>
 * Created by Bamboy on 2018/10/25.
 */
public class ColorBackdropActivity extends BamActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_backdrop);

        // 设置进度条颜色
        setProgressColor(ContextCompat.getColor(this, R.color.white));
    }
}
