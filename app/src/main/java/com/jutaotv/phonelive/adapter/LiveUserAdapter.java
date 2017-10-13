package com.jutaotv.phonelive.adapter;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.jutaotv.phonelive.AppContext;
import com.jutaotv.phonelive.R;
import com.jutaotv.phonelive.bean.LiveJson;
import com.jutaotv.phonelive.utils.SimpleUtils;
import com.jutaotv.phonelive.widget.BlackTextView;
import com.jutaotv.phonelive.widget.LoadUrlImageView;
import com.jutaotv.phonelive.widget.AvatarView;


import java.util.List;

//热门主播
public class LiveUserAdapter extends BaseAdapter {
    private List<LiveJson> mUserList;
    private LayoutInflater inflater;

    public LiveUserAdapter(LayoutInflater inflater, List<LiveJson> mUserList) {
        this.mUserList = mUserList;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return mUserList.size();
    }

    @Override
    public Object getItem(int position) {
        return mUserList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_hot_user,null);
            viewHolder = new ViewHolder();
            viewHolder.mUserNick = (BlackTextView) convertView.findViewById(R.id.tv_live_nick);
            viewHolder.mUserLocal = (BlackTextView) convertView.findViewById(R.id.tv_live_local);
            viewHolder.mUserNums = (BlackTextView) convertView.findViewById(R.id.tv_live_usernum);
            viewHolder.mUserHead = (AvatarView) convertView.findViewById(R.id.iv_live_user_head);
            viewHolder.mUserPic = (LoadUrlImageView) convertView.findViewById(R.id.iv_live_user_pic);
            viewHolder.mRoomTitle = (BlackTextView) convertView.findViewById(R.id.tv_hot_room_title);
            convertView.setTag(viewHolder);
        }
        LiveJson live = mUserList.get(position);
        Log.d("getView: ",live.city );
        viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.mUserNick.setText(live.user_nicename);
        viewHolder.mUserLocal.setText(live.city);
        viewHolder.mUserHead.setAvatarUrl(live.avatar_thumb);
        viewHolder.mUserNums.setText(live.nums);
        //用于平滑加载图片
        SimpleUtils.loadImageForView(AppContext.getInstance(),viewHolder.mUserPic,live.thumb,0);


        if(!TextUtils.isEmpty(live.title)){
            viewHolder.mRoomTitle.setVisibility(View.VISIBLE);
            viewHolder.mRoomTitle.setText(live.title);
        }else{
            viewHolder.mRoomTitle.setVisibility(View.GONE);
            viewHolder.mRoomTitle.setText("");
        }
        return convertView;
    }
    private class ViewHolder{
        public BlackTextView mUserNick,mUserLocal,mUserNums,mRoomTitle;
        public LoadUrlImageView mUserPic;
        public AvatarView mUserHead;
    }
}


