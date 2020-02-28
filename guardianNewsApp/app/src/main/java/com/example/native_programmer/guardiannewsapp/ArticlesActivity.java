package com.example.native_programmer.guardiannewsapp;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ArticlesActivity extends AppCompatActivity implements LoaderCallbacks<List<BaseArticleData>> {
    /**
     * Constant value for the articles loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */

    private static final int ARTICLES_LOADER_ID = 1;
//    String ARTICLES_REQUEST_URL = "https://content.guardianapis.com/search?show-elements=all&show-tags=contributor&show-fields=thumbnail&q=sport&api-key=85a7db0b-5fc5-4f51-a147-48a8d2c9edab";
    private ArticleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_articles );
        // Find a reference to the {@link ListView} in the layout
        ListView articlesListView = (ListView) findViewById( R.id.list );

        // Create a new adapter that takes an empty list of articles as input
        mAdapter = new ArticleAdapter( this, new ArrayList<BaseArticleData>() );

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        articlesListView.setAdapter( mAdapter );

        // Set an item click listener on the ListView, which sends an intent to a web browser
        // to open a website with more information about the selected article.
        articlesListView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current article that was clicked on
                BaseArticleData currentArticle = mAdapter.getItem( position );

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri articleUri = Uri.parse( currentArticle.getArticleURL() );

                // Create a new intent to view the article URI
                Intent websiteIntent = new Intent( Intent.ACTION_VIEW, articleUri );

                // Send the intent to launch a new activity
                startActivity( websiteIntent );
            }
        } );


        // Get a reference to the ConnectivityManager to check state of network connectivity
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService( Context.CONNECTIVITY_SERVICE );
        // Get details on the currently active default data network
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();


        // If there is a network connection, fetch data
        if (networkInfo != null && networkInfo.isConnected())
        {
            loadingLoader();
        }
        else
        {
            // Otherwise, display error
            // First, hide loading indicator so error message will be visible
            View loadingIndicator = findViewById( R.id.loading_indicator );
            loadingIndicator.setVisibility( View.GONE );
            // Update empty state with no connection error message
            ((TextView) findViewById( R.id.empty_view )).setText( R.string.no_internet_connection );


        }
    }


        @Override
        public Loader<List<BaseArticleData>> onCreateLoader( int id, Bundle args)
        {



         //"https://content.guardianapis.com/search?show-elements=all&show-tags=contributor&show-fields=thumbnail&q=sport&api-key=85a7db0b-5fc5-4f51-a147-48a8d2c9edab"
            Uri.Builder builder = new Uri.Builder();
            builder.scheme("https")
                    .authority("content.guardianapis.com")
                    .appendPath("search")
                    .appendQueryParameter("show-elements",               "all"                       )
                    .appendQueryParameter("show-tags"    ,           "contributor"                   )
                    .appendQueryParameter("show-fields"  ,             "thumbnail"                   )
                    .appendQueryParameter("q"            ,               "sport"                     )
                    .appendQueryParameter("api-key"      , "85a7db0b-5fc5-4f51-a147-48a8d2c9edab"    );
            String ARTICLES_REQUEST_URL = builder.build().toString();
            // Create a new loader for the given URL
            return new articleLoader( this, ARTICLES_REQUEST_URL );
        }

        @Override
        public void onLoadFinished (Loader < List < BaseArticleData >> loader, List < BaseArticleData > articles){
            // Hide loading indicator because the data has been loaded
            View loadingIndicator = findViewById( R.id.loading_indicator );
            loadingIndicator.setVisibility( View.GONE );


            // Clear the adapter of previous article data
            mAdapter.clear();

            // If there is a valid list of {@link article}s, then add them to the adapter's
            // data set. This will trigger the ListView to update.
            if (articles != null && !articles.isEmpty())
            {

                mAdapter.addAll( articles );
            } else

            {
                // Set empty state text to display "No articles found."
                TextView mEmptyStateTextView = (TextView) findViewById( R.id.empty_view );
                mEmptyStateTextView.setText( R.string.no_articles );
            }
        }

        @Override
        public void onLoaderReset (Loader < List < BaseArticleData >> loader) {
            mAdapter.clear();
        }

        public void loadingLoader(){
      // Get a reference to the LoaderManager, in order to interact with loaders.
        LoaderManager loaderManager = getLoaderManager();
        // Initialize the loader. Pass in the int ID constant defined above and pass in null for
        // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
        // because this activity implements the LoaderCallbacks interface).
        loaderManager.initLoader( ARTICLES_LOADER_ID, null, this );
        return;
    }

    }
