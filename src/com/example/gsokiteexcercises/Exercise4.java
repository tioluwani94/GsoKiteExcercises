package com.example.gsokiteexcercises;

import java.util.Arrays;
import java.util.Random;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Exercise4 extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercise4);

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
		EditText inputKey;
		EditText inputStartIndex;
		EditText inputEndIndex;
		TextView introText;
		TextView dataArray;
		TextView startIndexText;
		TextView endIndexText;
		TextView information;
		TextView result;
		Button go;
		Random generator;
		int[] data;

		// static class constructor
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_exercise4,
					container, false);
			// reference to TextView in xml for displaying arrays of numbers
			dataArray = (TextView) rootView.findViewById(R.id.textView1);
			
			// reference to TextView in xml for displaying instruction to user
			introText = (TextView) rootView.findViewById(R.id.textView2);
			
			// reference to EditText in xml for inputing key value
			inputKey = (EditText) rootView.findViewById(R.id.editText1);
			
			// reference to TextView in xml requesting user to input index position of first element in array 
			startIndexText = (TextView) rootView.findViewById(R.id.textView3);
			
			// reference to EditText in xml for inputing key value
			inputStartIndex = (EditText) rootView.findViewById(R.id.editText2);
			
			// reference to TextView in xml requesting user to input index position of last element in array
			endIndexText = (TextView) rootView.findViewById(R.id.textView4);
			
			// reference to EditText in xml for inputing key value
			inputEndIndex = (EditText) rootView.findViewById(R.id.editText3);
			
			// reference to TextView in xml for displaying hint
			information = (TextView) rootView.findViewById(R.id.textView6);
			
			// reference to TextView in xml for displaying result
			result = (TextView) rootView.findViewById(R.id.textView5);
			
			// reference to Button to be clicked to display result
			go = (Button) rootView.findViewById(R.id.button1);

			// random number generator
			generator = new Random();
			
			// initialize array with 25 elements
			data = new int[25];
			
			// for loop to populate array with numbers 
			for (int i = 0; i < data.length; i++)
				data[i] = 0 + generator.nextInt(100);

			// sort array in ascending order
			Arrays.sort(data);

			dataArray.setText(Arrays.toString(data));
			information.setText("Note that the array is zero-indexed and it has 25 elements");

			introText.setText("Enter any value in the array.");
			startIndexText.setText("Enter the index value of the position you want to start from.");
			endIndexText.setText("Enter the index value of the position you want to end at.");
			
			go.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// get inputed key value and convert to string and then convert to an integer
					String keyText = inputKey.getText().toString();
					int key = Integer.parseInt(keyText);
					
					// get inputed index value and convert to string and then convert to an integer
					String startIndexText = inputStartIndex.getText()
							.toString();
					int startIndex = Integer.parseInt(startIndexText);
					
					// get inputed index value convert to string and then convert to an integer
					String endIndexText = inputEndIndex.getText().toString();
					int endIndex = Integer.parseInt(endIndexText);

					while (key != -1) {
						// call to binarySearch method
						int location = binarySearch(data, key, startIndex,
								endIndex);

						if (location == -1)
							result.setText(key + " is not found in the array.");
						else
							result.setText(key + " is found in position "
									+ location + " of the array");
						break;
					}
				}
			});

			return rootView;
		}

	}

	private static int binarySearch(int data[], int searchKey, int high, int low) {
		int middle = (low + high + 1) / 2; // index position of middle element in array
		int location = -1; // sets default position as -1 (i.e key not found in array)

		// test base case
		if (searchKey == data[middle]) 
			return location = middle;
		
		// recursion step
		else if (searchKey < data[middle])
			return binarySearch(data, searchKey, middle - 1, low);
		
		// recursion step
		else
			return binarySearch(data, searchKey, high, middle + 1);

	}
}
