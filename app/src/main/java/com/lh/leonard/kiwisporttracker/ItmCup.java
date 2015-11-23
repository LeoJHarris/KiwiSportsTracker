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

public class ItmCup extends Activity {

    private ListView listView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itm_cup);

        AdView mAdView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Sports rugbySports[] = new Sports[]
                {
                        new Sports("Auckland"),
                        new Sports("Southland "),
                        new Sports("Waikato"),
                        new Sports("Tasman"),
                        new Sports("Bay of Plenty"),
                        new Sports("North Harbour"),
                        new Sports("Taranaki"),
                        new Sports("Wellington"),
                        new Sports("Otago"),
                        new Sports("Canterbury"),
                        new Sports("Counties Manukau"),
                        new Sports("Manawatu"),
                        new Sports("Hawke’s Bay"),
                        new Sports("Northland"),
                };

        SportsAdapter adapter = new SportsAdapter(this,
                R.layout.listview_item_row, rugbySports);
        listView1 = (ListView) findViewById(R.id.listViewITM);
        View header = (View) getLayoutInflater().inflate(R.layout.listview_header_row, null);
        TextView headerValue = (TextView) header.findViewById(R.id.txtHeader);

        headerValue.setText("2015 ITM Cup");
        listView1.addHeaderView(header);
        View footer = (View) getLayoutInflater().inflate(R.layout.listview_footer_row, null);
        listView1.addFooterView(footer);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                if (position == 1) {
                    Intent intent = new Intent(ItmCup.this, AucklandItm.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(ItmCup.this, SouthlandItm.class);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(ItmCup.this, WaikatoItm.class);
                    startActivity(intent);
                } else if (position == 4) {
                    Intent intent = new Intent(ItmCup.this, TasmanItm.class);
                    startActivity(intent);
                } else if (position == 5) {
                    Intent intent = new Intent(ItmCup.this, BayOfPlentyItm.class);
                    startActivity(intent);
                } else if (position == 6) {
                    Intent intent = new Intent(ItmCup.this, NorthlandItm.class);
                    startActivity(intent);
                } else if (position == 7) {
                    Intent intent = new Intent(ItmCup.this, TaranakiItm.class);
                    startActivity(intent);
                } else if (position == 8) {
                    Intent intent = new Intent(ItmCup.this, WellingtonItm.class);
                    startActivity(intent);
                } else if (position == 9) {
                    Intent intent = new Intent(ItmCup.this, OtagoItm.class);
                    startActivity(intent);
                } else if (position == 10) {
                    Intent intent = new Intent(ItmCup.this, CanterburyItm.class);
                    startActivity(intent);
                } else if (position == 11) {
                    Intent intent = new Intent(ItmCup.this, CountiesManukauItm.class);
                    startActivity(intent);
                } else if (position == 12) {
                    Intent intent = new Intent(ItmCup.this, ManuwatuItm.class);
                    startActivity(intent);
                } else if (position == 13) {
                    Intent intent = new Intent(ItmCup.this, HawkesBayItm.class);
                    startActivity(intent);
                } else if (position == 14) {
                    Intent intent = new Intent(ItmCup.this, NorthlandItm.class);
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
