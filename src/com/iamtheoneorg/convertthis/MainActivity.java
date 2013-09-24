package com.iamtheoneorg.convertthis;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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
		setToSpinnerEvent();
		
		setEditTextEvent();
		}

	private void setEditTextEvent() {
		value.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				setResult();
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	private void setFromSpinnerEvent() {
		fromSpinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				setToSpinnerValue();
				setResult();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		

	}
	

	private void setToSpinnerEvent() {
		toSpinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				setResult();
				
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
		
		ArrayAdapter<String> fromAdapter = new ArrayAdapter<String>(this, R.layout.spinner_layout, converter.getToUnitsAvailableToFromUnit( fromUnit  ));
		
		toSpinner.setAdapter(fromAdapter);
		
	}

	private void setFromSpinnerValue() {
		
		converter = new Converter();
		
		ArrayAdapter<String> fromAdapter = new ArrayAdapter<String>(this, R.layout.spinner_layout,converter.getFromUnits());
		
		fromSpinner.setAdapter(fromAdapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void setResult(){
		String from = fromSpinner.getSelectedItem().toString();
		String to = toSpinner.getSelectedItem().toString();
		
		double myValue;
		try {
			myValue = Double.parseDouble( value.getText().toString());
		}
		catch (Exception e ){
			myValue = 0.0;
		}
		
		result.setText(converter.convertThis(from, to, myValue));
	}
	
	public void butConvertClicked(View view) {
		setResult();
		
	}
	
}
