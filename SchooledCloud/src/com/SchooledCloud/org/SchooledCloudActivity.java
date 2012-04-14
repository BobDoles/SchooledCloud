package com.SchooledCloud.org;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SchooledCloudActivity extends Activity {
    /** Called when the activity is first created. */
	EditText email;
	EditText password;
	Button login;
	String sEmail;
	String sPassword;
	String baseUrl = "http://192.168.1.65/login.xml.php?email=";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        email = (EditText) findViewById(R.id.eEmail);
        password = (EditText) findViewById(R.id.ePassword);
        login = (Button) findViewById(R.id.bLogin);
        login.setOnClickListener(new View.OnClickListener() {
        	
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sEmail = email.getText().toString();
				sPassword = password.getText().toString();
				//Debug
				Log.d("Email: ", "Email = " + sEmail);
				Log.d("Password: ", "Password = " + sPassword);
				//End of debug
				StringBuilder URL = new StringBuilder(baseUrl);
				URL.append(sEmail + "&password=" + sPassword);
				String fullUrl = URL.toString();
				try{
					URL website = new URL(fullUrl);
					SAXParserFactory spf = SAXParserFactory.newInstance();
					SAXParser sp = spf.newSAXParser();
					XMLReader xr = sp.getXMLReader();
					
					HandlingXMLStuff doingWork = new HandlingXMLStuff();
					xr.setContentHandler(doingWork);
					xr.parse(new InputSource(website.openStream()));
					String information = doingWork.getInformation();
					Log.d("XML: ", "data= " + information);
					switchClass(v, information);
				}catch (Exception e){
					
				}
			}
		});
    }
    public void switchClass(View v, String i)
    {
    	if(i.contains("dtrued"))
    	{
			Log.d("Login: ", "True");
			Intent myIntent = new Intent(v.getContext(), UiHome.class);
			startActivityForResult(myIntent, 0);
    	}
    }
}