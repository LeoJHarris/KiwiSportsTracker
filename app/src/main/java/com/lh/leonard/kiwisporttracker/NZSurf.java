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

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class NZSurf extends Activity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fixture_layouts);

        //Nothing getting passed into the param
        new ParseURL().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nzsurf, menu);
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

        FixtureDetails[] fixturesDetailsArray;

        ArrayList<String> s = new ArrayList<String>();

        @Override
        protected void onPreExecute() {
            progressBar = (ProgressBar) findViewById(R.id.progressBar);
            progressBar.setVisibility(View.VISIBLE);
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Void doInBackground(Void... params) {

            try {

                Document doc = Jsoup.connect("http://www.surfingnz.co.nz/index.php?option=com_content&view=article&id=168&Itemid=97/").get(); // Connect to the site for Html
                doc = Jsoup.parse(doc.toString());
                doc.select(":containsOwn(\u00a0)").remove();
                Elements eles = doc.select(".art-article span");

                int number = 0;
                Date date = new Date();

                if (!eles.isEmpty()) {
                    for (Element ele : eles) {
                        if (!ele.text().contains("Last updated 29th April 2015")) {
                            s.add(ele.text());

                            if (number % 5 == 0) {
                                s.add(date.getDate());
                            }
                            number++;
                        }
                    }
                } else {
                    s.add("No Sport Fixtures Currently Available");
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
                Intent intent = new Intent(NZSurf.this, MainActivity.class);
                intent.putExtra("fail", "fail");
                finish();
                startActivity(intent);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            FixtureDetailsAdapter adapter = new FixtureDetailsAdapter(NZSurf.this,
                    R.layout.listview_item_rows_fixture_details, fixturesDetailsArray);

            ListView listView1 = (ListView) findViewById(R.id.listViewFixtures);

            View header = (View) getLayoutInflater().inflate(R.layout.listview_header_row, null);

            TextView headerValue = (TextView) header.findViewById(R.id.txtHeader);
            headerValue.setText("Surfing Events");

            listView1.addHeaderView(header);
            View footer = (View) getLayoutInflater().inflate(R.layout.listview_footer_row, null);
            listView1.addFooterView(footer);
            listView1.setAdapter(adapter);

            TextView credit = (TextView) findViewById(R.id.listViewCredit);
            credit.setText("Special thanks to Surfing NZ for the use of their Events Calender.");
            credit.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
}