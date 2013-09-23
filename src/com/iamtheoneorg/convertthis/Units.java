package com.iamtheoneorg.convertthis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.util.Log;

public abstract class Units {
	
	private String TAG = "";
	private  Map<String, Double> convertions;
	
	
	public Map<String, Double> getConvertions() {
		return convertions;
	}

	public void setConvertions(Map<String, Double> convertions) {
		this.convertions = convertions;
	}
	
	

	public Units() {
		super();
		
		convertions = new HashMap<String, Double>();
	}
	
	public Units(String tag) {
		this();
		
		TAG = tag;
	}

	public String convertTo ( String unit, double value) {
		try {
			return String.valueOf( (value * convertions.get(unit)));
		}
		catch ( Exception e ){
			return "";
		}
	}
	
    public ArrayList<String> availableConvertion() {
		
		ArrayList<String> result = new ArrayList<String>();
		
		if ( convertions.keySet().size() > 0 ) {
			
			for (String key : convertions.keySet() ) {
				Log.d(TAG,"key :" + key +"\n" );
				result.add( key);
			}
			
			
			return result ;
		} else return null;
	}
	
    @Override
    public String toString(){
    	return TAG;
    }
	
}
