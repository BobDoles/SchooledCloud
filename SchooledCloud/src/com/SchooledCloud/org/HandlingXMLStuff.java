package com.SchooledCloud.org;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class HandlingXMLStuff extends DefaultHandler{
	
	XMLDataCollected info = new XMLDataCollected();
	
	public String getInformation()
	{
		return info.dataToString();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		if(localName.equals("loginstatuas"))
		{
			String loginstataus = attributes.getValue("data");
			info.setLoggedIn(loginstataus);
		}
	}
	
}
