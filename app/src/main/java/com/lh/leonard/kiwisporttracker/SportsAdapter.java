package com.lh.leonard.kiwisporttracker;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


/**
 * Created by Leonard on 3/01/2015.
 */
public class SportsAdapter extends ArrayAdapter<Sports> {

    Context context;
    int layoutResourceId;
    Sports data[] = null;

    public SportsAdapter(Context context, int layoutResourceId, Sports[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        SportsHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new SportsHolder();
            // holder.imgIcon = (ImageView) row.findViewById(R.id.imgIcon);
            holder.txtTitle = (TextView) row.findViewById(R.id.txtTitle);

            row.setTag(holder);
        } else {
            holder = (SportsHolder) row.getTag();
        }

        Sports sport = data[position];

        holder.txtTitle.setText(sport.title);

        if (position % 2 == 0) {
            holder.txtTitle.setBackgroundColor(Color.BLACK);
            holder.txtTitle.setTextColor(Color.WHITE);
        } else {
            holder.txtTitle.setBackgroundColor(Color.WHITE);
            holder.txtTitle.setTextColor(Color.BLACK);
        }
        //holder.imgIcon.setImageResource(sport.icon);

        return row;
    }

    static class SportsHolder {
        //ImageView imgIcon;
        TextView txtTitle;
    }
}

