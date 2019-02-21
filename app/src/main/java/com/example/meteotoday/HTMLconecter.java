package com.example.meteotoday;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class HTMLconecter extends AsyncTask<Void, Void, Void> {
    String url;
    Document page;

    public HTMLconecter(String url) {
        this.url = url;
        this.page = null;
    }

    public HTMLconecter() {
        this.url = "https://www.gismeteo.ua/weather-odessa-4982/";
        this.page = null;
    }

    @Override
    protected void onPreExecute(){super.onPreExecute();}

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            page = Jsoup.parse(new URL(url), 5000);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void result){
        MainActivity.showMeteo();
    }
}
