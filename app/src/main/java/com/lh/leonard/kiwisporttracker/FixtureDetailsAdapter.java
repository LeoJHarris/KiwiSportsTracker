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
public class FixtureDetailsAdapter extends ArrayAdapter<FixtureDetails> {

    Context context;
    int layoutResourceId;
    FixtureDetails data[] = null;

    public FixtureDetailsAdapter(Context context, int layoutResourceId, FixtureDetails[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        FixturesDetailsHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new FixturesDetailsHolder();
            holder.txtFixtureDescription = (TextView) row.findViewById(R.id.txtFixtureDescription);

            row.setTag(holder);
        } else {
            holder = (FixturesDetailsHolder) row.getTag();
        }

        FixtureDetails fixturedetails = data[position];
        holder.txtFixtureDescription.setText(fixturedetails.details);

        if (position % 2 == 0) {
            holder.txtFixtureDescription.setBackgroundColor(Color.BLACK);
            holder.txtFixtureDescription.setTextColor(Color.WHITE);
        } else {
            holder.txtFixtureDescription.setBackgroundColor(Color.WHITE);
            holder.txtFixtureDescription.setTextColor(Color.BLACK);
        }
        return row;
    }

    static class FixturesDetailsHolder {
        //ImageView imgIcon;
        TextView txtFixtureDescription;
    }
}