package com.example.attendence_record;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class attendencedisplay extends Activity {

	
	private static String subject="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.attendencedisplay);
		//creating refrences to the views
		final TextView bunks=(TextView)findViewById(R.id.textBunks);
		final Button plus=(Button)findViewById(R.id.buttonPlus);
		final Button minus=(Button)findViewById(R.id.buttonMinus);
		
		//get messasge from intent ie. name of subject
		Intent i =this.getIntent();
		subject=i.getStringExtra("subject");
		//Toast.makeText(getApplicationContext(),subject,Toast.LENGTH_LONG).show();
		
		//read value of bunks from the bunks.txt file for the current subject
		
	    String bunkS="";
	    int bunkI=0;
		BufferedReader reader = null ;
		try{
			
			
			FileInputStream inputstream  = openFileInput("bunks.txt");		
			reader = new BufferedReader(new InputStreamReader(inputstream));
			String str=reader.readLine();
			
			while(str!=null) {
				if(str.startsWith(subject)) {
						bunkS=str.split(":")[1];
						bunkI=Integer.parseInt(bunkS);
						bunks.setText(bunkS);
						break;
				}else {
					//do nothing
				}
				str=reader.readLine();
			}
		
			
			
		}
		catch(Exception e){
			
		}
		finally
		{
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
		bunks.setText(bunkS);
		
		//writing onclick handlers for the buttons
		plus.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// increment the number of bunks and rewrite to the file 
				int b=0;
				b=Integer.parseInt((String)bunks.getText());
				b++;
				bunks.setText(b+"");
				//Toast.makeText(getApplicationContext(),b,Toast.LENGTH_LONG).show();
				
				//changing values in file
				String data="";
				
				BufferedReader reader = null ;
				try{
					
					
					FileInputStream inputstream  = openFileInput("bunks.txt");		
					reader = new BufferedReader(new InputStreamReader(inputstream));
					String str=reader.readLine();
					while(str!=null) {
						if(str.startsWith(subject)) {
							data=data+subject+":"+b+"\n";
						}else {
							data=data+str+"\n";
						}
						str=reader.readLine();
					}
					
					
				}
				catch(Exception e){
					
				}
				finally
				{
					try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
				
				//write new data to the bunks.txt file
				BufferedWriter writer = null;
				try{
					FileOutputStream outputstream = openFileOutput("bunks.txt",Context.MODE_PRIVATE);
					writer = new BufferedWriter(new OutputStreamWriter(outputstream));
					writer.write(data);
					//bunks.setText(str2+"done");
					
				}
				catch(Exception e){
					
				}
				finally
				{
					try {
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		minus.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// decrement the number of bunks and rewrite to the file
				int b=0;
				b=Integer.parseInt((String)bunks.getText());
				if(b!=0) {
					b--;
				}
				
				bunks.setText(b+"");
				//Toast.makeText(getApplicationContext(),b,Toast.LENGTH_LONG).show();
				
				//changing values in file
				String data="";
				
				BufferedReader reader = null ;
				try{
					
					
					FileInputStream inputstream  = openFileInput("bunks.txt");		
					reader = new BufferedReader(new InputStreamReader(inputstream));
					String str=reader.readLine();
					while(str!=null) {
						if(str.startsWith(subject)) {
							data=data+subject+":"+b+"\n";
						}else {
							data=data+str+"\n";
						}
						str=reader.readLine();
					}
					
					
				}
				catch(Exception e){
					
				}
				finally
				{
					try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
				
				//write new data to the bunks.txt file
				BufferedWriter writer = null;
				try{
					FileOutputStream outputstream = openFileOutput("bunks.txt",Context.MODE_PRIVATE);
					writer = new BufferedWriter(new OutputStreamWriter(outputstream));
					writer.write(data);
					//bunks.setText(str2+"done");
					
				}
				catch(Exception e){
					
				}
				finally
				{
					try {
						writer.close();
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
