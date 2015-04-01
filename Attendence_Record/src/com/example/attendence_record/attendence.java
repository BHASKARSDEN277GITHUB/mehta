package com.example.attendence_record;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;



public class attendence extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.attendence);
		//creating refrences
		final ListView l=(ListView)findViewById(R.id.listAttendence);
		
		Intent i=this.getIntent();
		String sem=i.getStringExtra("sem");
		//Toast.makeText(getApplicationContext(),"sem "+sem,Toast.LENGTH_LONG).show();
		Resources res = getResources();
		int semester=Integer.parseInt(sem);
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
		
		
		
		
		
		
	//setting listviews items values
		ArrayAdapter<String> adapter_for_this_list=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,subjects);
		l.setAdapter(adapter_for_this_list);
		
		
		//setting on click listeners for the list items
		l.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?>parent,View view,int position,long id){
			
				//create intent for the attendencedisplay activity and send value of the subject
				String subject=(String)parent.getItemAtPosition(position);
				//Toast.makeText(getApplicationContext(),subject,Toast.LENGTH_LONG).show();
				//create intent
				Intent i=new Intent(getApplicationContext(),attendencedisplay.class);
				i.putExtra("subject", subject);
				startActivity(i);
				

				
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
