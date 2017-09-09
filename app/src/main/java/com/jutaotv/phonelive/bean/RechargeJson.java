package com.jutaotv.phonelive.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by weipeng on 2017/1/22.
 */

public class RechargeJson {


    /**
     * coin : 93298617
     * rules : [{"id":"1","coin":"600","money":"6.00","money_ios":"6.00","product_id":"","give":"0"},{"id":"2","coin":"3000","money":"30.00","money_ios":"30.00","product_id":"","give":"0"},{"id":"3","coin":"9800","money":"98.00","money_ios":"98.00","product_id":"","give":"0"},{"id":"4","coin":"38800","money":"388.00","money_ios":"388.00","product_id":"","give":"0"},{"id":"5","coin":"58800","money":"588.00","money_ios":"588.00","product_id":"","give":"0"},{"id":"6","coin":"159800","money":"1598.00","money_ios":"1598.00","product_id":"","give":"0"}]
     * aliapp_switch : 1
     * aliapp_partner :
     * aliapp_seller_id :
     * aliapp_key_android :
     * aliapp_key_ios :
     * wx_switch : 1
     * wx_appid :
     * wx_appsecret :
     * wx_mchid :
     * wx_key :
     */
    @SerializedName("coin")
    public String coin;
    @SerializedName("aliapp_switch")
    public String aliapp_switch;
    @SerializedName("aliapp_partner")
    public String aliapp_partner;
    @SerializedName("aliapp_seller_id")
    public String aliapp_seller_id;
    @SerializedName("aliapp_key_android")
    public String aliapp_key_android;
    @SerializedName("aliapp_key_ios")
    public String aliapp_key_ios;
    @SerializedName("wx_switch")
    public String wx_switch;
    @SerializedName("wx_appid")
    public String wx_appid;
    @SerializedName("wx_appsecret")
    public String wx_appsecret;
    @SerializedName("wx_mchid")
    public String wx_mchid;
    @SerializedName("wx_key")
    public String wx_key;
    @SerializedName("rules")
    public List<RechargeBean> rules;
}
