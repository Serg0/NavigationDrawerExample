package com.nadolinskyi.serhii.navdrawersample;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NavigationDrawerActivity extends Activity {

	private ListView mDrawerList;
	private String[] mockArray;
	private DrawerLayout mDrawerLayout;

	public static final String ARG_TITLE_NAME = "ARG_TITLE_NAME";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navigation_drawer);
		
		
		 mDrawerList = (ListView) findViewById(R.id.left_drawer);
		 
		 mockArray = getResources().getStringArray(R.array.mock_array);
		 mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		 mDrawerList.setAdapter(new ArrayAdapter<String>(this,
	                R.layout.drawer_list_item, mockArray));
		 
		 mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		 
	}

	 /* The click listner for ListView in the navigation drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        // update the main content by replacing fragments
        MockFragment fragment = new MockFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE_NAME, mockArray[position]);
        fragment.setArguments(args);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        // update selected item and title, then close the drawer
        mDrawerList.setItemChecked(position, true);
        setTitle(mockArray[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.navigation_drawer, menu);
		return true;
	}

	

}
