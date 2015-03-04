package com.example.gsokiteexcercises;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Exercise1 extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercise1);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		// declaration of global variables
		TextView tv;
		int answer;
		String text;

		// static class constructor
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// inflate the layout with its Views and ViewGroups
			View rootView = inflater.inflate(R.layout.exercise1, container,
					false);
			
			// reference to TextView in xml to display result
			tv = (TextView) rootView.findViewById(R.id.textView1);
			// calculate the total number of possible arrangements of letters a, b, c, d, e.
			answer = (int) Math.pow(5.0, 5.0);
			// convert answer to text
			text = Integer.toString(answer);
			// display answer
			tv.setText("The total number of arrangements for the letters a, b, c, d, e is: "
					+ text + " arrangements.");
			return rootView;
			}
			
		}
	}


