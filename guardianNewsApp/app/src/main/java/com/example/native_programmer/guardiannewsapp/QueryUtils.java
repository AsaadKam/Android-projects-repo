package com.example.native_programmer.guardiannewsapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

class QueryUtils {


    /**
     * Query the Guardin news dataset and return a list of {@link BaseArticleData} objects.
     */
    public static List<BaseArticleData> fetchArticlesData(String requestUrl) {

        // Create URL object using url builder
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Extract relevant fields from the JSON response and create a list of {@link article}s
        List<BaseArticleData> articles = extractArticlesFromJson(jsonResponse);

        // Return the list of {@link Article}s
        return articles;
    }

    /**
     * Returns new URL object from the given string URL.
     */
    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL( stringUrl );
        } catch (MalformedURLException exception) {
            return null;
        }
        return url;
    }

    /**
     * Make an HTTP request to the given URL and return a String as the response.
     */
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.connect();
            inputStream = urlConnection.getInputStream();
            jsonResponse = convertStreamToString(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return jsonResponse;
        }
    }
    /**
     * Convert the {@link InputStream} into a String which contains the
     * whole JSON response from the server.
     */
    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }
    /**
     * Return a list of {@link BaseArticleData} objects that has been built up from
     * parsing the given JSON response.
     */
    private static List<BaseArticleData> extractArticlesFromJson(String jsonResponse) {


        // If JSON is empty then return
        if (TextUtils.isEmpty( jsonResponse )) {
            Log.e( TAG, "Couldn't get json from server " );

            return null;

        }

        // Create base articles
        ArrayList<BaseArticleData> articles = new ArrayList<>();
        // Try to extract JSON
        try {
            // Set main JSON object
            JSONObject responseObjMain = new JSONObject(jsonResponse);
            // Set response JSON object
            JSONObject responseObj = responseObjMain.getJSONObject("response");
            // Set JSON array of results
            JSONArray resultsArray = responseObj.getJSONArray("results");
            // Iterate through array
            for (int i = 0; i < resultsArray.length(); i++) {
                // Set variables to default
                String sectionName = null;
                String webTitle = null;
                String webPublicationDate = null;
                String shortUrl = null;
                Bitmap thumbnailBitmap = null;
                String contributor = null;
                // Set current JSON object
                JSONObject result = resultsArray.getJSONObject(i);
                // Get section
                if (result.has("sectionName")) {
                    sectionName = result.getString("sectionName");
                }
                // Get title
                if (result.has("webTitle")) {
                    webTitle = result.getString("webTitle");
                }
                // Get publication date
                if (result.has("webPublicationDate")) {
                    webPublicationDate = result.getString("webPublicationDate");
                }
                // Get URL
                if (result.has("webUrl")) {
                    shortUrl = result.getString("webUrl");
                }
                // Set fields JSON object
                JSONObject fields = result.getJSONObject("fields");

                // Get image
                if (fields.has("thumbnail")) {
                    String thumbnail = fields.getString("thumbnail");
                    URL url = new URL(thumbnail);
                    thumbnailBitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                }
                // Set tags JSON array for contributor data
                JSONArray tagsArray = result.getJSONArray("tags");
                for (int j = 0; j < tagsArray.length(); j++) {
                    // Get contributor
                    JSONObject tag = tagsArray.getJSONObject(j);
                    if (tag.has("webTitle")) {
                        contributor = tag.getString("webTitle");
                    } else {
                        contributor = "unnamed";
                    }
                }
                if (tagsArray.length() == 0) {
                    contributor = "unnamed";
                }
                // Set base article
                BaseArticleData articleData = new BaseArticleData(sectionName, webTitle, contributor, thumbnailBitmap, webPublicationDate, shortUrl);
                // Add article to array
                articles.add(articleData);
            }
         // Handle exceptions

        } catch (final JSONException e) {
            Log.e( TAG, "Json parsing error: " + e.getMessage() );


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Return articles array
        return articles;
    }




}
