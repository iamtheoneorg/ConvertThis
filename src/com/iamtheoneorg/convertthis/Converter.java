package com.iamtheoneorg.convertthis;

import java.util.ArrayList;
import java.util.HashMap;

import com.iamtheoneorg.convertthis.units.Feet;
import com.iamtheoneorg.convertthis.units.Inch;

import android.util.Log;
import android.widget.ArrayAdapter;

public class Converter {
	private final String TAG = "Converter.java";
	private HashMap<String,Units> convertionList;
	
	private Units[] availlableUnits = new Units[] { 
			new Inch(),
			
			new Feet() }; 
	
	public ArrayList<String> getFromUnits () {
		
		ArrayList<String> result = new ArrayList<String>();
		
		if ( availlableUnits.length > 0 ) {
			
			for (Units key : availlableUnits ) {
				Log.d(TAG,"key :" + key +"\n" );
				result.add( key.toString());
			}
			
			
			return result ;
		} else return null;
		
	}

	public ArrayList<String> getToUnitsAvailableToFromUnit(String fromUnit){
		
		return convertionList.get(fromUnit).availableConvertion() ;		
	}
	
	public Converter() {
		super();
		
		convertionList = new HashMap<String, Units>();
		
		for (Units units : availlableUnits) {
			convertionList.put(units.toString(), units);
		}
		
	}
	
	public String convertThis(String from,String to,double value) {
		Units unit = convertionList.get(from);
		
		return  unit.convertTo(to,value);
				
				
	}

}
