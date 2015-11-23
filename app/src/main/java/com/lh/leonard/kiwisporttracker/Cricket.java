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

public class Cricket extends Activity {

    private ListView listView1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricket);

        AdView mAdView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Sports cricketTeams[] = new Sports[]
                {


                        new Sports("Black Caps"),
                        new Sports("White Ferns"),
                        new Sports("Auckland Aces"),
                        new Sports("Auckland Hearts"),
                        new Sports("Canterbury"),
                        new Sports("Canterbury Kings"),
                        new Sports("Canterbury Magicians"),
                        new Sports("Canterbury Hinds"),
                        new Sports("Central Stags"),
                        new Sports("Northern Knights"),
                        new Sports("Northern Spirit"),
                        new Sports("Otago Sparks"),
                        new Sports("Otago Volts"),
                        new Sports("Wellington Blaze"),
                        new Sports("Wellington Firebirds")
                };

        SportsAdapter adapter = new SportsAdapter(this,
                R.layout.listview_item_row, cricketTeams);

        listView1 = (ListView) findViewById(R.id.listViewCricket);

        View header = (View) getLayoutInflater().inflate(R.layout.listview_header_row, null);

        TextView headerValue = (TextView) header.findViewById(R.id.txtHeader);

        headerValue.setText("Cricket");

        listView1.addHeaderView(header);
        View footer = (View) getLayoutInflater().inflate(R.layout.listview_footer_row, null);
        listView1.addFooterView(footer);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                if (position == 1) {
                    Intent intent = new Intent(Cricket.this, BlackCapsSchedule.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(Cricket.this, WhiteFernsSchedule.class);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(Cricket.this, AucklandAcesFixtures.class);
                    startActivity(intent);
                } else if (position == 4) {
                    Intent intent = new Intent(Cricket.this, AucklandHeartsFixtures.class);
                    startActivity(intent);
                } else if (position == 5) {
                    Intent intent = new Intent(Cricket.this, CanterburyCricketFixtures.class);
                    startActivity(intent);
                } else if (position == 6) {
                    Intent intent = new Intent(Cricket.this, CanterburyKingsFixtures.class);
                    startActivity(intent);
                } else if (position == 7) {
                    Intent intent = new Intent(Cricket.this, CanterburyMagiciansFixtures.class);
                    startActivity(intent);
                } else if (position == 8) {
                    Intent intent = new Intent(Cricket.this, CentralHindsFixtures.class);
                    startActivity(intent);
                } else if (position == 9) {
                    Intent intent = new Intent(Cricket.this, CentralStagsFixtures.class);
                    startActivity(intent);
                } else if (position == 10) {
                    Intent intent = new Intent(Cricket.this, NorthernKnightsFixtures.class);
                    startActivity(intent);
                } else if (position == 11) {
                    Intent intent = new Intent(Cricket.this, NorthernSpiritFixtures.class);
                    startActivity(intent);
                } else if (position == 12) {
                    Intent intent = new Intent(Cricket.this, OtagoSparksFixtures.class);
                    startActivity(intent);
                } else if (position == 13) {
                    Intent intent = new Intent(Cricket.this, OtagoVoltsFixtures.class);
                    startActivity(intent);
                } else if (position == 14) {
                    Intent intent = new Intent(Cricket.this, WellingtonBlazeFixtures.class);
                    startActivity(intent);
                } else if (position == 15) {
                    Intent intent = new Intent(Cricket.this, WellingtonFirebirdsFixtures.class);
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
