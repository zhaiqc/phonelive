package com.jutaotv.phonelive.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/5/20.
 */
public class ManageListBean {

    /**
     * id : 66
     * user_nicename : 真由理
     * avatar : http://yy.yunbaozhibo.com/public/upload/avatar/20160422/05146309952320709.png
     * sex : 0
     * signature : 这家伙很懒，什么都没留下
     * experience : 11244320
     * consumption : 1124432
     * votestotal : 353134
     * province :
     * city :
     * isrecommend : 0
     * level : 6
     */
    @SerializedName("id")
    private int id;
    @SerializedName("user_nicename")
    private String user_nicename;
    @SerializedName("avatar")
    private String avatar;
    @SerializedName("sex")
    private int sex;
    @SerializedName("signature")
    private String signature;
    @SerializedName("experience")
    private String experience;
    @SerializedName("consumption")
    private String consumption;
    @SerializedName("votestotal")
    private String votestotal;
    @SerializedName("province")
    private String province;
    @SerializedName("city")
    private String city;
    @SerializedName("isrecommend")
    private String isrecommend;
    @SerializedName("level")
    private int level;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_nicename() {
        return user_nicename;
    }

    public void setUser_nicename(String user_nicename) {
        this.user_nicename = user_nicename;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    public String getVotestotal() {
        return votestotal;
    }

    public void setVotestotal(String votestotal) {
        this.votestotal = votestotal;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIsrecommend() {
        return isrecommend;
    }

    public void setIsrecommend(String isrecommend) {
        this.isrecommend = isrecommend;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
