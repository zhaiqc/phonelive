package com.jutaotv.phonelive.ui;


import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.jutaotv.phonelive.AppConfig;
import com.jutaotv.phonelive.R;
import com.jutaotv.phonelive.base.ToolBarBaseActivity;
import com.jutaotv.phonelive.ui.customviews.ActivityTitle;

import butterknife.InjectView;

/**
 * Created by zqc on 2017/9/29.
 */

public class WebPayActivity extends ToolBarBaseActivity {
    @InjectView(R.id.webView)
    WebView mWbView;
    @InjectView(R.id.activity_title)
    ActivityTitle mTitle;
    @Override
    protected int getLayoutId() {
        return R.layout.layout_web_pay;
    }

    @Override
    public void onClick(View v) {
        mTitle.setReturnListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        Intent intent =getIntent();
        Log.d("initData: ",intent.getStringExtra("position") );
        WebSettings settings = mWbView.getSettings();
        settings.setJavaScriptEnabled(true);
        mWbView.loadUrl(AppConfig.MAIN_URL + "/pay.html");

    }

    @Override
    protected boolean hasActionBar() {
        return false;
    }

    @Override
    protected void onDestroy() {
        mWbView.destroy();
        super.onDestroy();
    }
}
