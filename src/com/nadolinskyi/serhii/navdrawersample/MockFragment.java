package com.nadolinskyi.serhii.navdrawersample;

import java.util.Locale;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MockFragment extends Fragment {

	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.mock_fragment_view, container, false);
        
        String title = getArguments().getString(NavigationDrawerActivity.ARG_TITLE_NAME);

        ((TextView) rootView.findViewById(R.id.textTabel)).setText(title);
        getActivity().setTitle(title);
        return rootView;
    }
}
