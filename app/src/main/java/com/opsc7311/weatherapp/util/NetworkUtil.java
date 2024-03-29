package com.opsc7311.weatherapp.util;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtil {

    private static final String API_KEY = "\ta4QNHqZ73Je6OtInOPGGMV3F0tOY5A92";
    private static final String PARAM_API_KEY = "apikey";
    private static final String METRIC_PARAM = "metric";
    private static final String METRIC_VALUE = "true";
    private static final String TAG = "NETWORK_UTIL";

    public static URL buildURLForWeather(String BASE_URL)
    {
        Uri uri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendQueryParameter(PARAM_API_KEY, API_KEY)
                .appendQueryParameter(METRIC_PARAM, METRIC_VALUE)
                .build();

        URL url = null;

        try {
            url = new URL((uri).toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {

        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        try
        {
            //gets input from the http GET request response
            InputStream in = httpURLConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            //find next line
            scanner.useDelimiter("//A");//delimiter for JSON
            boolean hasInput = scanner.hasNext();
            if (hasInput)
            {
                return scanner.next();
            }
            else
            {
                Log.i(TAG,"getResponse: " + scanner.next());
                return null;
            }

        }
        finally
        {
            httpURLConnection.disconnect();
        }
    }

}
