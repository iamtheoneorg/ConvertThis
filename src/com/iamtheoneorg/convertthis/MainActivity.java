package com.iamtheoneorg.convertthis;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.iamtheoneorg.convertthis.*;
import com.iamtheoneorg.convertthis.units.*;

public class MainActivity extends Activity {
	
	private static final String TAG = "MainActivity.java";

	private Spinner	fromSpinner;
	private Spinner toSpinner;
	private TextView result;
	private EditText value;
	private Converter converter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		fromSpinner = (Spinner) findViewById(R.id.fromUnit);
		toSpinner = (Spinner) findViewById(R.id.toUnit);
		result = (TextView) findViewById(R.id.result);
		value = (EditText) findViewById(R.id.valueEditText);
		
		setFromSpinnerValue();
		setToSpinnerValue();
		
		setFromSpinnerEvent();
		}

	private void setFromSpinnerEvent() {
		fromSpinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				setToSpinnerValue();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		

	}

	private void setToSpinnerValue() {
		
		converter = new Converter();
		String fromUnit = fromSpinner.getSelectedItem().toString();
		
		ArrayAdapter<String> fromAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, converter.getToUnitsAvailableToFromUnit( fromUnit  ));
		
		toSpinner.setAdapter(fromAdapter);
		
	}

	private void setFromSpinnerValue() {
		
		converter = new Converter();
		
		ArrayAdapter<String> fromAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,converter.getFromUnits());
		
		fromSpinner.setAdapter(fromAdapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void butConvertClicked(View view) {
		
		String from = fromSpinner.getSelectedItem().toString();
		String to = toSpinner.getSelectedItem().toString();
		double myValue = Double.parseDouble( value.getText().toString());

		result.setText(converter.convertThis(from, to, myValue));
	}
	
}
