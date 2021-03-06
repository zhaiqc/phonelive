package com.jutaotv.phonelive.ui;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

import com.jutaotv.phonelive.AppConfig;
import com.jutaotv.phonelive.AppContext;
import com.jutaotv.phonelive.base.ToolBarBaseActivity;
import com.jutaotv.phonelive.fragment.LoginAwardDialogFragment;
import com.jutaotv.phonelive.ui.customviews.ActivityTitle;
import com.jutaotv.phonelive.ui.customviews.LineControllerView;
import com.jutaotv.phonelive.utils.LoginUtils;
import com.jutaotv.phonelive.utils.TDevice;
import com.jutaotv.phonelive.utils.UIHelper;
import com.jutaotv.phonelive.utils.UpdateManager;
import com.jutaotv.phonelive.R;

import java.util.Locale;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 设置
 */
public class SettingActivity extends ToolBarBaseActivity {


    @InjectView(R.id.ll_check_update)
    LineControllerView mTvVersion;

    @InjectView(R.id.view_title)
    ActivityTitle mActivityTitle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
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
        mTvVersion.setContent(String.format(Locale.CHINA, "(当前版本%s)", TDevice.getVersionName()));
    }

    @OnClick({R.id.ll_login_out, R.id.ll_room_setting, R.id.ll_clearCache, R.id.ll_push_manage, R.id.ll_about, R.id.ll_feedback, R.id.ll_blank_list, R.id.rl_change_pass, R.id.ll_check_update})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_login_out:
                LoginUtils.outLogin(this);
                finish();
                break;
            //房间设置
            case R.id.ll_room_setting:

                break;
            case R.id.ll_clearCache:
                clearCache();
                break;
            case R.id.ll_push_manage:
                UIHelper.showPushManage(this);
                break;
            case R.id.ll_about:
                UIHelper.showWebView(this, AppConfig.MAIN_URL + "/index.php?g=portal&m=page&a=lists", "服务条款");
                break;
            //用户反馈
            case R.id.ll_feedback:
                String model = android.os.Build.MODEL;
                String release = android.os.Build.VERSION.RELEASE;
                UIHelper.showWebView(this, AppConfig.MAIN_URL + "/index.php?g=portal&m=page&a=newslist&uid="
                        + getUserID() + "&version=" + release + "&model=" + model, "");
                break;
            case R.id.ll_blank_list:
                UIHelper.showBlackList(SettingActivity.this);
                break;
            case R.id.rl_change_pass:
                UIHelper.showPhoneChangePassActivity(SettingActivity.this);
                break;
            case R.id.ll_check_update:
                checkNewVersion();
                break;
        }
    }

    private void checkNewVersion() {
        UpdateManager manager;
        if (!AppConfig.USER_VERSION.equals(TDevice.getVersionName())) {
            manager = new UpdateManager(this, true);
            manager.checkUpdate(AppConfig.APK_URL);
//            Log.d("checkNewVersion: ", AppConfig.APK_URL);
        } else {
            manager = new UpdateManager(this, false);
            manager.checkUpdate(AppConfig.APK_URL);
        }


    }

    private void clearCache() {
        AppContext.getInstance().clearAppCache();
        AppContext.showToastAppMsg(this, "缓存清理成功");
    }

    @Override
    protected boolean hasActionBar() {
        return false;
    }
}
