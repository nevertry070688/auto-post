package com.example.nevertry.auto_register;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nevertry on 6/11/15.
 */
public class NameAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> No;
    private ArrayList<String> content;
    public NameAdapter(Context c, ArrayList<String> id,ArrayList<String> name) {
        this.mContext = c;
        this.No = id;
        this.content = name;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return No.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public View getView(int pos, View child, ViewGroup parent) {
        Holder mHolder;
        LayoutInflater layoutInflater;
        if (child == null) {
            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            child = layoutInflater.inflate(R.layout.name_list, null);
            mHolder = new Holder();
            mHolder.txt_id = (TextView) child.findViewById(R.id.txt_No);
            mHolder.txt_content = (TextView) child.findViewById(R.id.txt_Name);
            child.setTag(mHolder);
        } else {
            mHolder = (Holder) child.getTag();
        }
        mHolder.txt_id.setText(No.get(pos));
        mHolder.txt_content.setText(content.get(pos));

        return child;
    }

    public class Holder {
        TextView txt_id;
        TextView txt_content;
    }
}
