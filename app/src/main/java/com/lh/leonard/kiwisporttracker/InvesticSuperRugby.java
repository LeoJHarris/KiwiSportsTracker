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

public class InvesticSuperRugby extends Activity {

    private ListView listView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investic_super_rugby);

        AdView mAdView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Sports rugbySports[] = new Sports[]
                {
                        new Sports("Chiefs"),
                        new Sports("Crusaders"),
                        new Sports("Hurricanes"),
                        new Sports("Highlanders"),
                        new Sports("Blues")
                };

        SportsAdapter adapter = new SportsAdapter(this,
                R.layout.listview_item_row, rugbySports);
        listView1 = (ListView) findViewById(R.id.listInvesticSuperRugby);
        View header = (View) getLayoutInflater().inflate(R.layout.listview_header_row, null);
        TextView headerValue = (TextView) header.findViewById(R.id.txtHeader);

        headerValue.setText("Investic Super Rugby");
        listView1.addHeaderView(header);
        View footer = (View) getLayoutInflater().inflate(R.layout.listview_footer_row, null);
        listView1.addFooterView(footer);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                if (position == 1) {
                    Intent intent = new Intent(InvesticSuperRugby.this, ChiefsFixtures.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(InvesticSuperRugby.this, CrusadersFixtures.class);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(InvesticSuperRugby.this, HurricanesFixtures.class);
                    startActivity(intent);
                } else if (position == 4) {
                    Intent intent = new Intent(InvesticSuperRugby.this, HighlandersFixtures.class);
                    startActivity(intent);
                } else if (position == 5) {
                    Intent intent = new Intent(InvesticSuperRugby.this, BluesFixtures.class);
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
