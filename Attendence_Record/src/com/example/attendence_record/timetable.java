package com.example.attendence_record;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;



public class timetable extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timetable);
		
		Intent i = this.getIntent();
		final String sem=i.getStringExtra("sem");
		final String section=i.getStringExtra("section");
		
		final ListView l = (ListView)findViewById(R.id.listTimeTable);
		String days[]={"Monday","Tuesday","Wednesday","Thursday","Friday"};
		//setting listviews items values
		ArrayAdapter<String> adapter_for_this_list=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,days);
		l.setAdapter(adapter_for_this_list);
		
		
		//setting onclick listner here .....
		l.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>parent,View view,int position,long id){


            //do whatever you wanna do with the listview items here .......
            	String day=(String)parent.getItemAtPosition(position);
            	String genName=sem+section+day;
            	//create intent for the timedisplay activity
            	Intent ii=new Intent(getApplicationContext(),timedisplay.class);
            	ii.putExtra("sem", sem);
            	ii.putExtra("section", section);
            	ii.putExtra("day", day);
            	//ii.putExtra("genName", genName);
            	Toast.makeText(getApplicationContext(),genName,Toast.LENGTH_SHORT).show();
            	startActivity(ii);
            	

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
