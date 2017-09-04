package com.jutaotv.phonelive.ui;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.jutaotv.phonelive.AppConfig;
import com.jutaotv.phonelive.base.ToolBarBaseActivity;
import com.jutaotv.phonelive.R;
import com.jutaotv.phonelive.ui.customviews.ActivityTitle;

import butterknife.InjectView;

/**
 * 等级
 */
public class UserLevelActivity extends ToolBarBaseActivity {
    @InjectView(R.id.wv_level)
    WebView mWbView;

    @InjectView(R.id.pb_loading)
    ProgressBar mProgressBar;

    @InjectView(R.id.view_title)
    ActivityTitle mActivityTitle;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_level;
    }

    @Override
    public void initView() {
        mActivityTitle.setReturnListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void initData() {

        mProgressBar.setMax(100);
        mWbView.setWebChromeClient(new WebViewClient());
        WebSettings settings = mWbView.getSettings();
        settings.setJavaScriptEnabled(true);
        mWbView.loadUrl(AppConfig.MAIN_URL + "/index.php?g=Appapi&m=level&a=index&uid="+getUserID());
    }

    @Override
    public void onClick(View v) {

    }

    private class WebViewClient extends WebChromeClient{
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            mProgressBar.setProgress(newProgress);
            if(newProgress == 100){
                mProgressBar.setVisibility(View.GONE);
            }
            super.onProgressChanged(view, newProgress);

        }
    }

    @Override
    protected void onDestroy() {
        mWbView.destroy();
        super.onDestroy();

    }

    @Override
    protected boolean hasActionBar() {
        return false;
    }
}
