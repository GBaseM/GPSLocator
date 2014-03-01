package com.example.gpstracking;

import java.util.List;

import android.app.Activity;
import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AndroidGPSTrackingActivity extends Activity {
	
	Button btnShowLocation;
	
	// GPSTracker class
	GPSTracker gps;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btnShowLocation = (Button) findViewById(R.id.btnShowLocation);
        
        // show location button click event
        btnShowLocation.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {		
				// create class object
		        gps = new GPSTracker(AndroidGPSTrackingActivity.this);

				// check if GPS enabled		
		        if(gps.canGetLocation()){
		        	
		        	double latitude = gps.getLatitude();
		        	double longitude = gps.getLongitude();
		        	
		        	/*List<Address> x=gps.getAddress(latitude,longitude) ;*/
		        	EditText etlat=(EditText)findViewById(R.id.editText1);
		        	etlat.setText(String.valueOf(latitude));
		        	EditText etlong=(EditText)findViewById(R.id.editText2);
		        	etlong.setText(String.valueOf(longitude));
		        	Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
		        	/*Toast.makeText(getApplicationContext(), "ur address is " + x , Toast.LENGTH_LONG).show();*/
		        }else{
		        	// can't get location
		        	// GPS or Network is not enabled
		        	// Ask user to enable GPS/network in settings
		        	gps.showSettingsAlert();
		        }
				
			}
		});
    }
    
}