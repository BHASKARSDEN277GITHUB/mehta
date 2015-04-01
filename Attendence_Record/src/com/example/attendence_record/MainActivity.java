package com.example.attendence_record;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//creating refrences to the views
		final TextView day=(TextView)findViewById(R.id.textDaytoday);
		final TextView headermain=(TextView)findViewById(R.id.headerMain);
		final Button attend=(Button)findViewById(R.id.buttonAttendence);
		final Button time=(Button)findViewById(R.id.buttonTimetable);
		
		//getting day today
		//using Calendar class to get day today ..  //displaying current day on to the text box ..
		Calendar today = Calendar.getInstance();
		int daycount = today.get(Calendar.DAY_OF_WEEK);
				switch(daycount)
		{
		case 1:
			day.setText("Day Today : SUNDAY");
			break ;
		case 2:
			day.setText("Day Today : MONDAY");
			break ;
		case 3:
			day.setText("Day Today : TUESDAY");
			break ;
		case 4:
			day.setText("Day Today : WEDNESDAY");
			break ;
		case 5:
			day.setText("Day Today : THURSDAY");
			break ;
		case 6:
			day.setText("Day Today : FRIDAY");
			break ;
		case 7:
			day.setText("Day Today : SATURDAY");
			break ;
		}

				
				
					
				
		// create refrence to the record file
		File file = getBaseContext().getFileStreamPath("record_student.txt");

		/**
		 * if file exists redirect him to activity showing list of the subjects
		 * etc else redirect to registration page
		 */

		if (file.exists()) {
			// redirect to main Activity for now . will checklater for the list
			// part
			/**
			 * read data values from file
			 */
			
			String name = "";
			String id = "";
			String group = "";
			String sec = "";
			String sem = "";
			String data="";
			
			BufferedReader reader = null;
			try {

				FileInputStream inputstream = openFileInput("record_student.txt");
				reader = new BufferedReader(new InputStreamReader(inputstream));
				String str=reader.readLine();
				while(str!=null) {
					if(str.startsWith("name")) {
						name=str.split(":")[1];
						data=data+name;
					}else if(str.startsWith("id")) {
						id=str.split(":")[1];
						data=data+id;
					}else if(str.startsWith("group")) {
						group=str.split(":")[1];
						data=data+group;
					}else if(str.startsWith("section")) {
						sec=str.split(":")[1];
						data=data+sec;
					}else if(str.startsWith("semester")) {
						sem=str.split(":")[1];
						data=data+sem;
					}else {
						//do nothing
					}
					
					str=reader.readLine();
				}
				
				headermain.setText("Hi "+name+ "\n"+"Section "+sec+"\nSem "+sem+"\nGroup "+group+"\n\n"+"Welcome to Attendence Record");
				reader.close();

			} catch (Exception e) {

			} finally {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			

		} else {
			// redirect to reg activity
			Intent i = new Intent(this, details.class);
			startActivity(i);
			this.finish();
		}
		
		
		
		//writing onClickListeners
		//for attendence button
		attend.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				/**
				 * read data values from file
				 */
				
				String name = "";
				String id = "";
				String group = "";
				String sec = "";
				String sem = "";
				String data="";
				
				BufferedReader reader = null;
				try {

					FileInputStream inputstream = openFileInput("record_student.txt");
					reader = new BufferedReader(new InputStreamReader(inputstream));
					String str=reader.readLine();
					while(str!=null) {
						if(str.startsWith("name")) {
							name=str.split(":")[1];
							data=data+name;
						}else if(str.startsWith("id")) {
							id=str.split(":")[1];
							data=data+id;
						}else if(str.startsWith("group")) {
							group=str.split(":")[1];
							data=data+group;
						}else if(str.startsWith("section")) {
							sec=str.split(":")[1];
							data=data+sec;
						}else if(str.startsWith("semester")) {
							sem=str.split(":")[1];
							data=data+sem;
						}else {
							//do nothing
						}
						
						str=reader.readLine();
					}
					
					reader.close();
					//redirect to Attendence activity with semester value
					Intent att=new Intent(getApplicationContext(),attendence.class);
					att.putExtra("sem",sem);
					startActivity(att);
					//MainActivity.this.finish();

				} catch (Exception e) {

				} finally {
					try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		
		//for time table button
		time.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				/**
				 * read data values from file
				 */
				
				String name = "";
				String id = "";
				String group = "";
				String sec = "";
				String sem = "";
				String data="";
				
				BufferedReader reader = null;
				try {

					FileInputStream inputstream = openFileInput("record_student.txt");
					reader = new BufferedReader(new InputStreamReader(inputstream));
					String str=reader.readLine();
					while(str!=null) {
						if(str.startsWith("name")) {
							name=str.split(":")[1];
							data=data+name;
						}else if(str.startsWith("id")) {
							id=str.split(":")[1];
							data=data+id;
						}else if(str.startsWith("group")) {
							group=str.split(":")[1];
							data=data+group;
						}else if(str.startsWith("section")) {
							sec=str.split(":")[1];
							data=data+sec;
						}else if(str.startsWith("semester")) {
							sem=str.split(":")[1];
							data=data+sem;
						}else {
							//do nothing
						}
						
						str=reader.readLine();
					}
					reader.close();
					
					
					//if((sec.equals("A") || sec.equals("B") && sem.equals("3")) ) {
					//redirect to  time table activity with semester value
					Intent tt=new Intent(getApplicationContext(),timetable.class);
					tt.putExtra("sem",sem);
					tt.putExtra("section", sec);
					startActivity(tt);
					
					//} else {
						//Toast.makeText(getApplicationContext(),"App under Development yet",Toast.LENGTH_SHORT).show();
					//}
					

				} catch (Exception e) {

				} finally {
					try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
