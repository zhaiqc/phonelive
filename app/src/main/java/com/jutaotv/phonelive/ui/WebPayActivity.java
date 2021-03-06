package com.jutaotv.phonelive.ui;


import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.jutaotv.phonelive.AppConfig;
import com.jutaotv.phonelive.AppContext;
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

    }

    @Override
    public void initView() {
        mTitle.setReturnListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        Log.d("initData: ", intent.getStringExtra("position"));
        WebSettings settings = mWbView.getSettings();
        settings.setJavaScriptEnabled(true);
        Log.d("initData: ",AppContext.getInstance().getLoginUid()  );
        mWbView.loadUrl(AppConfig.MAIN_URL + "/index.php?g=cz&m=index&a=index&uid=" + AppContext.getInstance().getLoginUid() + "&rules=" + intent.getStringExtra("position"));

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
