package com.jutaotv.phonelive.utils;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jutaotv.phonelive.bean.PrivateChatUserBean;
import com.jutaotv.phonelive.bean.SimpleBackPage;
import com.jutaotv.phonelive.ui.ActionBarSimpleBackActivity;
import com.jutaotv.phonelive.ui.DedicateOrderActivity;
import com.jutaotv.phonelive.ui.EditInfoActivity;
import com.jutaotv.phonelive.ui.ReadyStartLiveActivity;
import com.jutaotv.phonelive.ui.SimpleBackActivity;
import com.jutaotv.phonelive.ui.UserLevelActivity;
import com.jutaotv.phonelive.ui.UserProfitActivity;
import com.jutaotv.phonelive.ui.UserSelectAvatarActivity;
import com.jutaotv.phonelive.fragment.ManageListDialogFragment;
import com.jutaotv.phonelive.ui.RequestCashActivity;
import com.jutaotv.phonelive.ui.SettingActivity;
import com.jutaotv.phonelive.ui.UserChangeSexActivity;
import com.jutaotv.phonelive.R;
import com.jutaotv.phonelive.ui.AttentionActivity;
import com.jutaotv.phonelive.em.ChangInfo;
import com.jutaotv.phonelive.ui.PhoneChangePassActivity;
import com.jutaotv.phonelive.ui.PhoneFindPassActivity;
import com.jutaotv.phonelive.ui.PhoneRegActivity;
import com.jutaotv.phonelive.ui.FansActivity;
import com.jutaotv.phonelive.ui.HomePageActivity;
import com.jutaotv.phonelive.ui.LiveRecordActivity;
import com.jutaotv.phonelive.ui.PhoneLoginActivity;
import com.jutaotv.phonelive.ui.MainActivity;
import com.jutaotv.phonelive.ui.UserDiamondsActivity;
import com.jutaotv.phonelive.ui.UserInfoDetailActivity;
import com.jutaotv.phonelive.ui.VideoPlayerActivity;
import com.jutaotv.phonelive.ui.WebPayActivity;
import com.jutaotv.phonelive.ui.WebViewActivity;

/**
 * 界面帮助类
 * 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @version 创建时间：2014年10月10日 下午3:33:36
 * 
 */

public class UIHelper {
    /**
     * 发送通知广播
     *
     * @param context
     */
    public static void sendBroadcastForNotice(Context context) {
        /*Intent intent = new Intent(NoticeService.INTENT_ACTION_BROADCAST);
        context.sendBroadcast(intent);*/
    }
    /**
     * 手机登录
     *
     * @param context
     */

    public static void showMobilLogin(Context context) {
        Intent intent = new Intent(context, PhoneLoginActivity.class);
        context.startActivity(intent);
    }

    /**
     * 手机密码注册 HHH 2016-09-09
     *
     * @param context
     */

    public static void showMobileRegLogin(Context context) {
        Intent intent = new Intent(context, PhoneRegActivity.class);
        context.startActivity(intent);
    }

    /**
     * 手机密码注册 HHH 2016-09-09
     *
     * @param context
     */

    public static void showUserFindPass(Context context) {
        Intent intent = new Intent(context, PhoneFindPassActivity.class);
        context.startActivity(intent);
    }
    /**
     * 登陆选择
     *
     * @param context
     */
    public static void showLoginSelectActivity(Context context) {
        /*Intent intent = new Intent(context, LiveLoginSelectActivity.class);
        context.startActivity(intent);*/
        showMobilLogin(context);

    }

    /**
     * 首页
     *
     * @param context
     */
    public static void showMainActivity(Context context) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.setClass(context, MainActivity.class);
        //Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);

    }
    /**
     * 我的详细资料
     *
     * @param context
     */
    public static void showMyInfoDetailActivity(Context context) {
        Intent intent = new Intent(context, UserInfoDetailActivity.class);
        context.startActivity(intent);
    }
    /**
     * 编辑资料
     *
     * @param context
     */
    public static void showEditInfoActivity(UserInfoDetailActivity context, String action,
                                            String prompt, String defaultStr, ChangInfo changInfo) {
        Intent intent = new Intent(context, EditInfoActivity.class);
        intent.putExtra(EditInfoActivity.EDITACTION,action);
        intent.putExtra(EditInfoActivity.EDITDEFAULT,defaultStr);
        intent.putExtra(EditInfoActivity.EDITPROMP,prompt);
        intent.putExtra(EditInfoActivity.EDITKEY, changInfo.getAction());
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.activity_open_start, 0);
    }

    public static void showSelectAvatar(UserInfoDetailActivity context, String avatar) {
        Intent intent = new Intent(context, UserSelectAvatarActivity.class);
        intent.putExtra("uhead",avatar);
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.activity_open_start, 0);
    }

    /**
     * 获取webviewClient对象
     *
     * @return
     */
    public static WebViewClient getWebViewClient() {

        return new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //showUrlRedirect(view.getContext(), url);
                return true;
            }
        };
    }

    /**
     * 我的等级
     *
     * @return
     */
    public static void showLevel(Context context) {
        Intent intent = new Intent(context, UserLevelActivity.class);
        context.startActivity(intent);
    }

    /**
     * 网页支付
     *
     * @return
     */
    public static void showWebPay(Context context,String position ) {
        Intent intent = new Intent(context, WebPayActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("position",position);
        context.startActivity(intent);
    }
    /**
     * 我的钻石
     *
     * @return
     */
    public static void showMyDiamonds(Context context) {
        Intent intent = new Intent(context, UserDiamondsActivity.class);
        context.startActivity(intent);
    }
    /**
     * 我的收益
     *
     * @return
     */
    public static void showProfitActivity(Context context) {
        Intent intent = new Intent(context, UserProfitActivity.class);
        context.startActivity(intent);
    }
    /**
     * 设置
     *
     * @return
     */
    public static void showSetting(Context context) {
        Intent intent = new Intent(context, SettingActivity.class);
        context.startActivity(intent);
    }
    /**
     * 看直播
     *
     * @return
     */
    public static void showLookLiveActivity(Context context, Bundle bundle) {
        Intent intent = new Intent(context, VideoPlayerActivity.class);
        intent.putExtra(VideoPlayerActivity.USER_INFO,bundle);
        context.startActivity(intent);
    }
    /**
     * 直播
     *
     * @return
     */
    public static void showStartLiveActivity(Context context) {
        Intent intent = new Intent(context, ReadyStartLiveActivity.class);
        context.startActivity(intent);
    }
    /*
    * 其他用户个人信息
    * */
    public static void showHomePageActivity(Context context,String id) {
        Intent intent = new Intent(context, HomePageActivity.class);
        intent.putExtra("uid",id);
        context.startActivity(intent);
    }
    /*
    * 粉丝列表
    * */
    public static void showFansActivity(Context context, String uid) {
        Intent intent = new Intent(context, FansActivity.class);
        intent.putExtra("uid",uid);
        context.startActivity(intent);
    }
    /*
    * 关注列表
    * */
    public static void showAttentionActivity(Context context, String uid) {
        Intent intent = new Intent(context, AttentionActivity.class);
        intent.putExtra("uid",uid);
        context.startActivity(intent);
    }
    //魅力值贡献榜
    public static void showDedicateOrderActivity(Context context, String uid) {

        Intent intent = new Intent(context, DedicateOrderActivity.class);
        intent.putExtra("uid",uid);
        context.startActivity(intent);
    }
    //直播记录
    public static void showLiveRecordActivity(Context context, String uid) {
        Intent intent = new Intent(context, LiveRecordActivity.class);
        intent.putExtra("uid",uid);
        context.startActivity(intent);
    }
    //私信页面
    public static void showPrivateChatSimple(Context context, String uid) {
        Intent intent = new Intent(context, SimpleBackActivity.class);
        intent.putExtra("uid",uid);
        intent.putExtra(SimpleBackActivity.BUNDLE_KEY_PAGE, SimpleBackPage.USER_PRIVATECORE.getValue());
        context.startActivity(intent);
    }
    //私信详情
    public static void showPrivateChatMessage(Context context, PrivateChatUserBean user) {
        Intent intent = new Intent(context, SimpleBackActivity.class);
        intent.putExtra("user",user);
        intent.putExtra(SimpleBackActivity.BUNDLE_KEY_PAGE, SimpleBackPage.USER_PRIVATECORE_MESSAGE.getValue());
        context.startActivity(intent);

    }
    //地区选择
    public static void showSelectArea(Context context) {
        Intent intent = new Intent(context,SimpleBackActivity.class);
        intent.putExtra(SimpleBackActivity.BUNDLE_KEY_PAGE,SimpleBackPage.AREA_SELECT.getValue());
        context.startActivity(intent);
    }
    //搜索
    public static void showScreen(Context context) {
        Intent intent = new Intent(context,SimpleBackActivity.class);
        intent.putExtra(SimpleBackActivity.BUNDLE_KEY_PAGE,SimpleBackPage.INDEX_SECREEN.getValue());
        context.startActivity(intent);
    }
    //打开网页
    public static void showWebView(Context context,String url, String title) {
        Intent intent = new Intent(context, WebViewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url",url);
        bundle.putString("title",title);
        intent.putExtra("URL_INFO",bundle);
        context.startActivity(intent);
    }
    //黑名单
    public static void showBlackList(Context context) {
        Intent intent = new Intent(context,ActionBarSimpleBackActivity.class);
        intent.putExtra(ActionBarSimpleBackActivity.BUNDLE_KEY_PAGE,SimpleBackPage.USER_BLACK_LIST.getValue());
        context.startActivity(intent);
    }
    //推送管理
    public static void showPushManage(Context context) {
        Intent intent = new Intent(context,ActionBarSimpleBackActivity.class);
        intent.putExtra(ActionBarSimpleBackActivity.BUNDLE_KEY_PAGE,SimpleBackPage.USER_PUSH_MANAGE.getValue());
        context.startActivity(intent);
    }
    //搜索歌曲
    public static void showSearchMusic(Activity context) {
        Intent intent = new Intent(context,SimpleBackActivity.class);
        intent.putExtra(SimpleBackActivity.BUNDLE_KEY_PAGE,SimpleBackPage.LIVE_START_MUSIC.getValue());
        context.startActivityForResult(intent,1);
    }
    //管理员列表
    public static void shoManageListActivity(Context context) {
        Intent intent = new Intent(context,ManageListDialogFragment.class);
        context.startActivity(intent);
    }

    public static void showChangeSex(Context context) {
        Intent intent = new Intent(context, UserChangeSexActivity.class);
        context.startActivity(intent);

    }

    public static void showPhoneChangePassActivity(Context context) {
        Intent intent = new Intent(context, PhoneChangePassActivity.class);
        context.startActivity(intent);
    }

    public static void showRequestCashActivity(Context context) {
        Intent intent = new Intent(context, RequestCashActivity.class);
        context.startActivity(intent);
    }



}
