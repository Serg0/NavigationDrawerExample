package com.nadolinskyi.serhii.navdrawersample;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class NavigationDrawerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navigation_drawer);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.navigation_drawer, menu);
		return true;
	}

}
