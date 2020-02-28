package com.example.native_programmer.guardiannewsapp;
import android.content.AsyncTaskLoader;
import android.content.Context;

import android.util.Log;

import java.util.List;

public class articleLoader extends AsyncTaskLoader<List<BaseArticleData>> {

    /** Tag for log messages */
    private static final String LOG_TAG = articleLoader.class.getName();

    /** Query URL */
    private String mUrl;
    private static String TAG = MainActivity.class.getSimpleName();

    /**
     * Constructs a new {@link articleLoader}.
     *
     * @param articleLoader
     * @param context of the activity
     * @param url to load data from
     */
    public articleLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {


        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<BaseArticleData> loadInBackground() {

        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of articles.
        List<BaseArticleData> articles = QueryUtils.fetchArticlesData(mUrl);
        return articles;
    }
}