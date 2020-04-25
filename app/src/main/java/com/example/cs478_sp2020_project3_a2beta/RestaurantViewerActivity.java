package com.example.cs478_sp2020_project3_a2beta;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class RestaurantViewerActivity
        extends AppCompatActivity
		implements RestaurantFragment.ListSelectionListener {

	public static Boolean curr_activity = true;

	public Boolean getActivity() {
		return curr_activity;
	}

	public static String[] mAttractionsArray;
	public static String[] mWebsiteArray;


	private final website_fragment_restaurants mWebsiteFragment = new website_fragment_restaurants();

	private FragmentManager mFragmentManager;

	private FrameLayout mRestaurantsFrameLayout, mWebsitesFrameLayout;
	private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;
	private static final String TAG = "RestaurantViewerActivity";


	@Override
	public boolean onCreateOptionsMenu(Menu m) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.back_to_attractions_menu, m); //your file name
		return super.onCreateOptionsMenu(m);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem m_item) {
		int id = m_item.getItemId();
		switch (id) {
			case R.id.back_to_attractions:
				Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show();
				startActivity(new Intent(RestaurantViewerActivity.this, AttractionsViewerActivity.class));
				return true;
			default:
				return super.onOptionsItemSelected(m_item);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		Log.i(TAG, getClass().getSimpleName() + ": entered onCreate()");

		super.onCreate(savedInstanceState);

		// Array for Restaurant + website
		mAttractionsArray = getResources().getStringArray(R.array.Restaurants);
		mWebsiteArray = getResources().getStringArray(R.array.Restaurants_Websites);

		setContentView(R.layout.activity_main);

		// Layout for Restaurant + loading webpage
		mRestaurantsFrameLayout = (FrameLayout) findViewById(R.id.restaurant_fragment_container);
		mWebsitesFrameLayout = (FrameLayout) findViewById(R.id.r_website_fragment_container);


		// Get a reference to the SupportFragmentManager instead of original FragmentManager
		mFragmentManager = getSupportFragmentManager();

		// Start a new FragmentTransaction with backward compatibility
		FragmentTransaction fragmentTransaction = mFragmentManager
				.beginTransaction();

		//Restaurant fragment
		fragmentTransaction.replace(
				R.id.restaurant_fragment_container,
				new RestaurantFragment());

		// Commit the FragmentTransaction
		fragmentTransaction.commit();

		// Add a OnBackStackChangedListener to reset the layout when the back stack changes
		mFragmentManager.addOnBackStackChangedListener(
				new FragmentManager.OnBackStackChangedListener() {
					public void onBackStackChanged() {
						setLayout();
					}
				});
	}

	private void setLayout() {

		// Determine whether the QuoteFragment has been added
		if (!mWebsiteFragment.isAdded()) {

			// Make the TitleFragment occupy the entire layout
			mRestaurantsFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(
					MATCH_PARENT, MATCH_PARENT));
			mWebsitesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
					MATCH_PARENT));
		} else {

			// Restaurant 1/3 width
			mRestaurantsFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
					MATCH_PARENT, 1f));

			// Website 2/3 width layout
			mWebsitesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
					MATCH_PARENT, 2f));
		}
	}

	// Implement Java interface ListSelectionListener defined in TitlesFragment
	// Called by TitlesFragment when the user selects an item in the TitlesFragment
	@Override
	public void onListSelection(int index) {

		// If the QuoteFragment has not been added, add it now
		if (!mWebsiteFragment.isAdded()) {

			// Start a new FragmentTransaction
			FragmentTransaction fragmentTransaction = mFragmentManager
					.beginTransaction();

			// Add the QuoteFragment to the layout
			fragmentTransaction.add(R.id.r_website_fragment_container,
					mWebsiteFragment);

			// Add this FragmentTransaction to the backstack
			fragmentTransaction.addToBackStack(null);

			// Commit the FragmentTransaction
			fragmentTransaction.commit();

			// Force Android to execute the committed FragmentTransaction
			mFragmentManager.executePendingTransactions();
		}

		if (mWebsiteFragment.getShownIndex() != index) {

			// Tell the QuoteFragment to show the quote string at position index
			mWebsiteFragment.showWebsiteAtIndex(index);

		}
	}

	@Override
	protected void onDestroy() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onDestroy()");
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onPause()");
		super.onPause();
	}

	@Override
	protected void onRestart() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onRestart()");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onResume()");
		super.onResume();
	}

	@Override
	protected void onStart() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onStart()");
		super.onStart();
	}

	@Override
	protected void onStop() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onStop()");
		super.onStop();
	}
}