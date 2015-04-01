package com.example.attendence_record;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;

public class timedisplay extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timedisplay);
		Intent i = this.getIntent();
		String sem = i.getStringExtra("sem");
		String section = i.getStringExtra("section");
		String day = i.getStringExtra("day");
		ImageView im = (ImageView) findViewById(R.id.image);

		// Toast.makeText(getApplicationContext(),sem+section+day,Toast.LENGTH_SHORT).show();
		// displaying image ..

		// im.setImageResource(R.drawable.a_three_thursday);

		if (sem.equals("7")) {

			if (day.equals("Monday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Tuesday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Wednesday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Thursday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Friday")) {
				im.setImageResource(R.drawable.third_monday);
			} else {
				// fasfdasfasf
			}

		} else if (sem.equals("8")) {
			if (day.equals("Monday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Tuesday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Wednesday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Thursday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Friday")) {
				im.setImageResource(R.drawable.third_monday);
			} else {
				// fasfdasfasf
			}

		} else if (sem.equals("3")) {
			if (day.equals("Monday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Tuesday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Wednesday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Thursday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Friday")) {
				im.setImageResource(R.drawable.third_monday);
			} else {
				// fasfdasfasf
			}

		} else if (sem.equals("4")) {
			if (day.equals("Monday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Tuesday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Wednesday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Thursday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Friday")) {
				im.setImageResource(R.drawable.third_monday);
			} else {
				// fasfdasfasf
			}

		} else if (sem.equals("5")) {
			if (day.equals("Monday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Tuesday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Wednesday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Thursday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Friday")) {
				im.setImageResource(R.drawable.third_monday);
			} else {
				// fasfdasfasf
			}

		} else if (sem.equals("6")) {
			if (day.equals("Monday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Tuesday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Wednesday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Thursday")) {
				im.setImageResource(R.drawable.third_monday);
			} else if (day.equals("Friday")) {
				im.setImageResource(R.drawable.third_monday);
			} else {
				// fasfdasfasf
			}

		} else {
			// "lauda le lo "
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
