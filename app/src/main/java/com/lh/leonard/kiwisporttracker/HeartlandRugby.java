package com.lh.leonard.kiwisporttracker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class HeartlandRugby extends Activity {

    private ListView listView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heartland_rugby);

        AdView mAdView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Sports rugbySports[] = new Sports[]
                {
                        new Sports("Full Heartland Rugby Fixtures"),
                        new Sports("Buller"),
                        new Sports("East Coast"),
                        new Sports("Horowhenua Kapiti"),
                        new Sports("King Country"),
                        new Sports("Mid Canterbury"),
                        new Sports("North Otago"),
                        new Sports("Poverty Bay"),
                        new Sports("South Canterbury"),
                        new Sports("Thames Valley"),
                        new Sports("Wanganui"),
                        new Sports("West Coast"),
                        new Sports("Wairarapa Bush")

                };

        SportsAdapter adapter = new SportsAdapter(this,
                R.layout.listview_item_row, rugbySports);
        listView1 = (ListView) findViewById(R.id.listHeartlandRugby);
        View header = (View) getLayoutInflater().inflate(R.layout.listview_header_row, null);
        TextView headerValue = (TextView) header.findViewById(R.id.txtHeader);

        headerValue.setText("Heartland Rugby");
        listView1.addHeaderView(header);
        View footer = (View) getLayoutInflater().inflate(R.layout.listview_footer_row, null);
        listView1.addFooterView(footer);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                if (position == 1) {
                    Intent intent = new Intent(HeartlandRugby.this, HeartlandRugbyAllTeams.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(HeartlandRugby.this, BullerHeartland.class);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(HeartlandRugby.this, EastCoastHeatland.class);
                    startActivity(intent);
                } else if (position == 4) {
                    Intent intent = new Intent(HeartlandRugby.this, HorowhenuaKapitiHeartland.class);
                    startActivity(intent);
                } else if (position == 5) {
                    Intent intent = new Intent(HeartlandRugby.this, KingCountryHeartland.class);
                    startActivity(intent);
                } else if (position == 6) {
                    Intent intent = new Intent(HeartlandRugby.this, MidCanterburyHeartland.class);
                    startActivity(intent);
                } else if (position == 7) {
                    Intent intent = new Intent(HeartlandRugby.this, NorthOtagoHeartland.class);
                    startActivity(intent);
                } else if (position == 8) {
                    Intent intent = new Intent(HeartlandRugby.this, PovertyBayHeartland.class);
                    startActivity(intent);
                } else if (position == 9) {
                    Intent intent = new Intent(HeartlandRugby.this, SouthCanterburyHeartland.class);
                    startActivity(intent);
                } else if (position == 10) {
                    Intent intent = new Intent(HeartlandRugby.this, ThamesValleyHeartland.class);
                    startActivity(intent);
                } else if (position == 11) {
                    Intent intent = new Intent(HeartlandRugby.this, WanganuiHeartland.class);
                    startActivity(intent);
                } else if (position == 12) {
                    Intent intent = new Intent(HeartlandRugby.this, WestCoastHeartland.class);
                    startActivity(intent);
                } else if (position == 13) {
                    Intent intent = new Intent(HeartlandRugby.this, WairarapaBushHeartland.class);
                    startActivity(intent);
                }

            }
        });
    }

    public void goToFacebook(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/KiwiSportsTracker"));
        startActivity(browserIntent);
    }
}
