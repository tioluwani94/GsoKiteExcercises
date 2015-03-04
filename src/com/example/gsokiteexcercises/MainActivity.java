package com.example.gsokiteexcercises;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}


	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		
		ListView lv;
		ArrayAdapter<String> adapter;
		String[] exercises = {"Exercise 1", "Exercise 2", "Exercise 3", "Exercise 4"};
		Intent intent = new Intent();
		
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			lv = (ListView) rootView.findViewById(R.id.listView1);
			adapter = new ArrayAdapter<String>(getActivity(), R.layout.listview_item_text, R.id.textView1, exercises);
			lv.setAdapter(adapter);
			
			lv.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					if (position == 0) {
						intent.setClass(getActivity(), Exercise1.class);
						startActivity(intent);
					}
					else if(position == 1){
						intent.setClass(getActivity(), Exercise2.class);
						startActivity(intent);
					}
					else if(position == 2){
						intent.setClass(getActivity(), Exercise3.class);
						startActivity(intent);
					}
					else{
						intent.setClass(getActivity(), Exercise4.class);
						startActivity(intent);
					}
				}
			});
			return rootView;
		}
	}

}
