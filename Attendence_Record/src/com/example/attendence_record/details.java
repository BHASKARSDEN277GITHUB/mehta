package com.example.attendence_record;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class details extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details);
		final EditText name = (EditText) findViewById(R.id.nameEdit);
		final EditText id = (EditText) findViewById(R.id.idEdit);
		final Button save = (Button) findViewById(R.id.saveButton);

		// setting contents of spinners (drop down list) ..

		/**
		 * for semester's drop down list
		 */

		final Spinner sem = (Spinner) findViewById(R.id.spinnerSem);

		// Create an ArrayAdapter using the string array and a default spinner
		// layout

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.sem, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		sem.setAdapter(adapter);

		/**
		 * for group's drop down list
		 */

		final Spinner group = (Spinner) findViewById(R.id.spinnerGroup);

		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
				this, R.array.group, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		group.setAdapter(adapter1);

		/**
		 * for section's drop down list
		 */

		final Spinner section = (Spinner) findViewById(R.id.spinnerSection);

		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
				this, R.array.section, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		section.setAdapter(adapter2);

		// method definitions
		save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// read values from all the fields .
				// create refrence to file named record_student.txt
				// save all the read details according to particular format in
				// this file
				// then redirect to main Activity

				// Toast.makeText(getApplicationContext(),"Hello reg page done successfully",
				// Toast.LENGTH_SHORT).show();

				String n = name.getText().toString();
				String i = id.getText().toString();
				String s = String.valueOf(sem.getSelectedItem());//semester
				String g = String.valueOf(group.getSelectedItem());
				String sec = String.valueOf(section.getSelectedItem());
				// checking for lengths of field values

				Pattern p = Pattern.compile("111\\d{5}");

				Matcher m = p.matcher(i);

				if (n.length() != 0 && m.find()) {
					// create file here and save the records to the file
					BufferedWriter writer = null;
					BufferedWriter writer1 = null;
					try {
						FileOutputStream outputstream = openFileOutput("record_student.txt", Context.MODE_PRIVATE);
						writer = new BufferedWriter(new OutputStreamWriter(outputstream));
						String data = "name:" + n + "\n" + "id:" + i + "\n"+ "section:" + sec + "\n" + "semester:" + s+ "\n" + "group:" + g + "\n";
						writer.write(data);
						Toast.makeText(getApplicationContext(),"Data written to file : \n" + data,Toast.LENGTH_LONG).show();

						/**
						 *get list of subjects for this semester 
						 * create file for bunk records
						 * make entry for each subject 
						 * initialise each subjects values as 0
						 */
						
						Resources res = getResources();
						int semester=Integer.parseInt(s);
						//Toast.makeText(getApplicationContext(),sem,Toast.LENGTH_LONG).show();
						//get sem subjects list here based upon value of sem
						
						
						String[] subjects=null ;
						
						
						if(semester==7) {
							subjects = res.getStringArray(R.array.sem7);
							} else if(semester==8) {
								subjects = res.getStringArray(R.array.sem8);
							} else if(semester==3) {
								subjects = res.getStringArray(R.array.sem3);
							}else if(semester==4) {
								subjects = res.getStringArray(R.array.sem4);
							}else if(semester==5) {
								subjects = res.getStringArray(R.array.sem5);
							}else if(semester==6) {
								subjects = res.getStringArray(R.array.sem6);
							} else {
								// "lauda le lo "
							}
							
						
						
						
						Toast.makeText(getApplicationContext(),"Data written to file : \n" + data,Toast.LENGTH_LONG).show();
						
						
						
						
						FileOutputStream  outputstream1 = openFileOutput("bunks.txt", Context.MODE_PRIVATE);
						writer1 = new BufferedWriter(new OutputStreamWriter(outputstream1));
						data="";
						for(int j=0;j<subjects.length;j++) {
							data=data+subjects[j]+":0"+"\n";
						}
						
						writer1.write(data);
						//Toast.makeText(getApplicationContext(),"Data written to bunks file : \n" + data,Toast.LENGTH_LONG).show();
						
						//redirect to main activity
						Intent in= new Intent(getApplicationContext(),MainActivity.class);
						startActivity(in);
						details.this.finish();

					}

					catch (Exception e) {

					}

					finally {
						try {
							writer.close();
							writer1.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else {
					Toast.makeText(getApplicationContext(),
							"Invalid Data\nPlease Enter valid data",
							Toast.LENGTH_SHORT).show();
				}

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
