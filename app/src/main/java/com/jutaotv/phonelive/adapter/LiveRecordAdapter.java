package com.jutaotv.phonelive.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.jutaotv.phonelive.AppContext;
import com.jutaotv.phonelive.R;
import com.jutaotv.phonelive.bean.LiveRecordBean;

import com.jutaotv.phonelive.widget.BlackTextView;

import java.util.ArrayList;

/**
 * Created by weipeng on 2017/1/9.
 */

public class LiveRecordAdapter extends BaseAdapter {
    private ArrayList<LiveRecordBean> mRecordList;


    public LiveRecordAdapter(ArrayList<LiveRecordBean> recordList) {
        mRecordList = recordList;
    }

    @Override
    public int getCount() {
        return mRecordList.size();
    }

    @Override
    public Object getItem(int position) {
        return mRecordList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(null == convertView){
            convertView = View.inflate(AppContext.getInstance(), R.layout.item_live_record,null);
            viewHolder = new ViewHolder();
            viewHolder.mLiveNum = (BlackTextView) convertView.findViewById(R.id.tv_item_live_record_num);
            viewHolder.mLiveTime = (BlackTextView) convertView.findViewById(R.id.tv_item_live_record_time);
            viewHolder.mLiveTitle = (BlackTextView) convertView.findViewById(R.id.tv_item_live_record_title);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        LiveRecordBean l = mRecordList.get(position);
        viewHolder.mLiveNum.setText(l.getNums());
        viewHolder.mLiveTitle.setText(l.getTitle().equals("")?"无标题":l.getTitle());
        viewHolder.mLiveTime.setText(l.getDatetime());
        return convertView;
    }
    class ViewHolder{
        public BlackTextView mLiveTime,mLiveNum,mLiveTitle;
    }
}