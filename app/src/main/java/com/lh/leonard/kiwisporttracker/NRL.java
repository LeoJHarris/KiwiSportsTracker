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

public class NRL extends Activity {

    private ListView listView1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nrl);

        AdView mAdView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Sports nrlTeams[] = new Sports[]
                {
                        new Sports("Warriors")
                        // new Sports("NRL Auckland Nines") // Uncomment when NRL9's Starts again
                };

        SportsAdapter adapter = new SportsAdapter(this,
                R.layout.listview_item_row, nrlTeams);

        listView1 = (ListView) findViewById(R.id.listViewNrl);

        View header = (View) getLayoutInflater().inflate(R.layout.listview_header_row, null);

        TextView headerValue = (TextView) header.findViewById(R.id.txtHeader);
        headerValue.setText("NRL");

        listView1.addHeaderView(header);

        listView1.setAdapter(adapter);
        View footer = (View) getLayoutInflater().inflate(R.layout.listview_footer_row, null);
        listView1.addFooterView(footer);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                if (position == 1) {
                    Intent intent = new Intent(NRL.this, WarriorsFixtures.class);
                    startActivity(intent);
                } //else if (position == 2) {
                //  Intent intent = new Intent(NRL.this, NRL9Fixtures.class);
                //   startActivity(intent);
                //     }
            }
        });
    }

    public void goToFacebook(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/KiwiSportsTracker"));
        startActivity(browserIntent);
    }
}
