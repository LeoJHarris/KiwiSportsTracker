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

public class NetBall extends Activity {

    private ListView listView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_ball);

        AdView mAdView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Sports netBallSports[] = new Sports[]
                {
                        new Sports("Silver Ferns"),
                        new Sports("Magic"),
                        new Sports("Northern Mystics"),
                        new Sports("Southern Steel"),
                        new Sports("Pulse"),
                        new Sports("Tactix")
                };

        SportsAdapter adapter = new SportsAdapter(this,
                R.layout.listview_item_row, netBallSports);


        listView1 = (ListView) findViewById(R.id.listViewNetball);

        View header = (View) getLayoutInflater().inflate(R.layout.listview_header_row, null);

        TextView headerValue = (TextView) header.findViewById(R.id.txtHeader);
        headerValue.setText("Netball");

        listView1.addHeaderView(header);

        View footer = (View) getLayoutInflater().inflate(R.layout.listview_footer_row, null);
        listView1.addFooterView(footer);

        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                if (position == 1) {
                    Intent intent = new Intent(NetBall.this, SilverFernsOceaniaTriSeriesSchedule.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(NetBall.this, MagicFixtures.class);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(NetBall.this, NorthernMysticsFixtures.class);
                    startActivity(intent);
                } else if (position == 4) {
                    Intent intent = new Intent(NetBall.this, SouthernSteelFixtures.class);
                    startActivity(intent);
                } else if (position == 5) {
                    Intent intent = new Intent(NetBall.this, PulseFixtures.class);
                    startActivity(intent);
                } else if (position == 6) {
                    Intent intent = new Intent(NetBall.this, TactixFixtures.class);
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