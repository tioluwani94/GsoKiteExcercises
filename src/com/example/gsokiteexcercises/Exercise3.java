
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

/**
 * A binary search routine program that returns
 * the occurrence of a key value inputed by the user
 * @author Kolawole Tiouwani
 *
 */
public class Exercise3 extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercise3);

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
		TextView dataArray;
		TextView result;
		TextView request;
		Button go;
		EditText input;
		int[] arrayOfNumbers = new int[25]; // array of integers with 25 elements
		Random arrayGenerator;

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// inflate the layout with its Views and ViewGroups
			View rootView = inflater.inflate(R.layout.fragment_exercise3,
					container, false);
			// reference to TextView in xml for displaying arrays of numbers
			dataArray = (TextView) rootView.findViewById(R.id.textView1);
			
			// reference to EditText in xml for inputing key value
			input = (EditText) rootView.findViewById(R.id.editText1);
			
			// reference to TextView in xml requesting user to input a key value
			request = (TextView) rootView.findViewById(R.id.textView3);
			
			// reference to TextView in xml for displaying result
			result = (TextView) rootView.findViewById(R.id.textView2);
			
			// reference to Button to be clicked to display result
			go = (Button) rootView.findViewById(R.id.button1);
			
			// random number generator
			arrayGenerator = new Random();

			request.setText("Enter any integer value in the editText below");
			
			// for loop to populate array with numbers
			for (int i = 0; i < arrayOfNumbers.length; i++)
				arrayOfNumbers[i] = 1 + arrayGenerator.nextInt(100);
			
			//sort array in ascending order
			Arrays.sort(arrayOfNumbers);

			// display array values
			dataArray.setText(Arrays.toString(arrayOfNumbers));

			go.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// get inputed key value, convert to string and then convert to an integer
					String key = input.getText().toString();
					int keyValue = Integer.parseInt(key);

					// loop to decide the location of the key value in the array
					while (keyValue != -1) {
						
						// call to binarySearch method
						int indexLocation = binarySearch(arrayOfNumbers,
								keyValue);
						
						if (indexLocation == -1)
							result.setText(keyValue
									+ " is not found in the array.");
						else
							result.setText(keyValue + " is found in position "
									+ indexLocation + " of the array");
						break;
					}
				}
			});

			return rootView;
		}

		private int binarySearch(int data[], int key) {
			int low = 0; // index position of first element in array
			int high = data.length - 1; // index position of last element in array
			int middle = (low + high + 1) / 2; // index position of middle element in array
			int location = -1; // sets default position as -1 (i.e key not found in array)

			// loop to determine location of key value
			do {
				if (key == data[middle]) {
					location = middle;
				} else if (key < data[middle]) {
					high = middle - 1;
				} else
					low = middle + 1;

				middle = (low + high + 1) / 2;
			} while ((low <= high) && (location == -1));

			return location; // return location of key value
		}
	}

}
