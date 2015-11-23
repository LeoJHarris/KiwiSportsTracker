package com.lh.leonard.kiwisporttracker;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;
import java.util.Stack;

public class MainActivity extends Activity {

    private ListView listView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView mAdView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Sports mainSports[] = new Sports[]
                {
                        new Sports("Rugby"),
                        new Sports("Cricket"),
                        new Sports("Soccer"),
                        new Sports("Basketball"),
                        new Sports("Netball"),
                        new Sports("NRL"),
                        new Sports("Tennis"),
                        new Sports("Surfing"),
                        new Sports("Golf"),
                        new Sports("Rowing"),
                        new Sports("FINA Swimming"),
                        new Sports("World Sporting Events")
                };

        SportsAdapter adapter = new SportsAdapter(this,
                R.layout.listview_item_row, mainSports);

        listView1 = (ListView) findViewById(R.id.listViewSport);

        View header = (View) getLayoutInflater().inflate(R.layout.listview_header_row, null);

        TextView headerValue = (TextView) header.findViewById(R.id.txtHeader);
        headerValue.setText("New Zealand Sports");

        View footer = (View) getLayoutInflater().inflate(R.layout.listview_footer_row, null);
        listView1.addHeaderView(header);
        listView1.setAdapter(adapter);
        listView1.addFooterView(footer);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                if (position == 1) {
                    Intent intent = new Intent(MainActivity.this, Rugby.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(MainActivity.this, Cricket.class);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(MainActivity.this, Soccer.class);
                    startActivity(intent);
                } else if (position == 4) {
                    Intent intent = new Intent(MainActivity.this, BasketBall.class);
                    startActivity(intent);
                } else if (position == 5) {
                    Intent intent = new Intent(MainActivity.this, NetBall.class);
                    startActivity(intent);
                } else if (position == 6) {
                    Intent intent = new Intent(MainActivity.this, NRL.class);
                    startActivity(intent);
                } else if (position == 7) {
                    Intent intent = new Intent(MainActivity.this, Tennis.class);
                    startActivity(intent);
                } else if (position == 8) {
                    Intent intent = new Intent(MainActivity.this, Surfing.class);
                    startActivity(intent);
                } else if (position == 9) {
                    Intent intent = new Intent(MainActivity.this, Golf.class);
                    startActivity(intent);
                } else if (position == 10) {
                    Intent intent = new Intent(MainActivity.this, RowingEvents.class);
                    startActivity(intent);
                } else if (position == 11) {
                    Intent intent = new Intent(MainActivity.this, Swimming.class);
                    startActivity(intent);
                } else if (position == 12) {
                    Intent intent = new Intent(MainActivity.this, MajorWorldSportingEvents.class);
                    startActivity(intent);
                }

            }
        });
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.getString("fail") != null) {
                if (extras.getString("fail").equals("fail")) {

                    Toast.makeText(this,
                            "Page temporarily unavailable or " +
                                    "your Internet Connection is turned off.",
                            Toast.LENGTH_LONG).show();

                }
            }
        }
    }

    public void goToFacebook(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/KiwiSportsTracker"));
        startActivity(browserIntent);
    }
}
