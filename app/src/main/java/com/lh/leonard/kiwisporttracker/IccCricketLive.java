package com.lh.leonard.kiwisporttracker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class IccCricketLive extends Activity {

    private ProgressBar progressBar;
    private boolean showInfo = true;

    FixtureDetails[] fixturesDetailsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.icc_live_score);

        AdView mAdView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ParseURL p = new ParseURL();
        p.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_icc_cricket_live, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void goToFacebook(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/KiwiSportsTracker"));
        startActivity(browserIntent);
    }

    private class ParseURL extends AsyncTask<Void, Integer, Void> {


        ArrayList<String> s = new ArrayList<String>();

        @Override
        protected void onPreExecute() {
            if (showInfo == true) {
                progressBar = (ProgressBar) findViewById(R.id.progressBar);
                progressBar.setVisibility(View.VISIBLE);

            }
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Void doInBackground(Void... params) {

            try {

                if (showInfo == false) {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        this.cancel(true);
                        Intent intent = new Intent(IccCricketLive.this, Cricket.class);

                        finish();
                        startActivity(intent);
                    }
                }

                Document doc = Jsoup.connect("http://sports.ndtv.com/cricket/live-scores/").get(); // Connect to the site for Html
                doc = Jsoup.parse(doc.toString());
                doc.select(".live-runs, .over-tot").remove(); // tm-nm-1
                // tm-nm-1-scr
                Elements eles = doc.select(".live-score-bx"); //live-score-bx


                Boolean liveScoring = false;

                if (!(eles.isEmpty())) {
                    for (Element ele : eles) {
                        if (ele.text().contains("Live Score")) {
                            s.add(ele.text());
                            liveScoring = true;
                        }
                        if (liveScoring == false) {
                            s.add("No games are playing at the moment");
                            break;
                        }
                    }
                } else {
                    s.add("No games are playing at the moment");
                }

                int size = s.size();
                fixturesDetailsArray = new FixtureDetails[size];

                int i = 0;

                for (String item : s) {

                    FixtureDetails f = new FixtureDetails(item.toString());
                    fixturesDetailsArray[i] = f;
                    i++;
                }

            } catch (IOException e) {
                this.cancel(true);
                Intent intent = new Intent(IccCricketLive.this, MainActivity.class);
                intent.putExtra("fail", "fail");
                finish();
                startActivity(intent);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            FixtureDetailsAdapter adapter = new FixtureDetailsAdapter(IccCricketLive.this,
                    R.layout.listview_item_rows_fixture_details, fixturesDetailsArray);

            ListView listView1 = (ListView) findViewById(R.id.listViewFixtures);

            listView1.setAdapter(null);

            if (showInfo == true) {
                View header = (View) getLayoutInflater().inflate(R.layout.listview_header_row, null);
                TextView headerValue = (TextView) header.findViewById(R.id.txtHeader);
                headerValue.setText("ICC Cricket World Cup Live Score");

                listView1.addHeaderView(header);
                View footer = (View) getLayoutInflater().inflate(R.layout.listview_footer_row, null);
                listView1.addFooterView(footer);
            }
            listView1.setAdapter(adapter);

            if (showInfo == true) {
                progressBar.setVisibility(View.INVISIBLE);
            }
            showInfo = false;
            new ParseURL().execute();
        }
    }
}