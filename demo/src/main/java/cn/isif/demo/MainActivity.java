package cn.isif.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Date;

import cn.isif.alibs.utils.TimeUtil;
import cn.isif.alibs.utils.log.ALog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ALog.d(TimeUtil.getWeekOfDate(new Date(System.currentTimeMillis())));

    }
}
