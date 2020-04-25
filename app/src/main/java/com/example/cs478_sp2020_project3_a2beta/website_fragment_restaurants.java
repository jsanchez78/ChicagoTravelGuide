package com.example.cs478_sp2020_project3_a2beta;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.fragment.app.Fragment;

import com.example.cs478_sp2020_project3_a2beta.AttractionsViewerActivity;
import com.example.cs478_sp2020_project3_a2beta.R;
import com.example.cs478_sp2020_project3_a2beta.RestaurantViewerActivity;


public class website_fragment_restaurants extends Fragment {

	private static final String TAG = "websites_restaurant_fragment";

	private WebView websiteView;
	private int mCurrIdx = -1;
	private int websiteArrLen;

	int getShownIndex() {
		return mCurrIdx;
	}

	// Show the Quote string at position newIndex

	void showWebsiteAtIndex(int newIndex) {
		if (newIndex < 0 || newIndex >= websiteArrLen)
			return;
		mCurrIdx = newIndex;
		//Get the URL at this particular index
		websiteView.loadUrl(RestaurantViewerActivity.mWebsiteArray[mCurrIdx]);

	}

	@Override
	public void onAttach(Context activity) {
		Log.i(TAG, getClass().getSimpleName() + ":entered onAttach()");
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, getClass().getSimpleName() + ":entered onCreate()");
		super.onCreate(savedInstanceState);

	}

	// Called to create the content view for this Fragment
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i(TAG, getClass().getSimpleName() + ":entered onCreateView()");

		// Inflate the layout defined in quote_fragment.xml
		// The last parameter is false because the returned view does not need to be attached to the container ViewGroup
		return inflater.inflate(R.layout.website_fragment,
				container, false);
	}

	// Set up some information about the mQuoteView TextView
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		Log.i(TAG, getClass().getSimpleName() + ":entered onActivityCreated()");
		super.onActivityCreated(savedInstanceState);

		websiteView = (WebView) getActivity().findViewById(R.id.website);
		websiteArrLen = RestaurantViewerActivity.mWebsiteArray.length;
	}

	@Override
	public void onStart() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onStart()");
		super.onStart();
	}

	@Override
	public void onResume() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onResume()");
		super.onResume();
	}


	@Override
	public void onPause() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onPause()");
		super.onPause();
	}

	@Override
	public void onStop() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onStop()");
		super.onStop();
	}

	@Override
	public void onDetach() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onDetach()");
		super.onDetach();
	}


	@Override
	public void onDestroy() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onDestroy()");
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onDestroyView()");
		super.onDestroyView();
	}

}
