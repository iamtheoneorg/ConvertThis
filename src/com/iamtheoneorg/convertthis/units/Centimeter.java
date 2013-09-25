package com.iamtheoneorg.convertthis.units;

import com.iamtheoneorg.convertthis.Units;

public class Centimeter extends Units {
		
	public Centimeter(){
		super("cm");
	
		super.getConvertions().put("mm",10.0);
		super.getConvertions().put("m",0.01);
		super.getConvertions().put("dm",0.10);
		super.getConvertions().put("km",0.00001);
		super.getConvertions().put("Angstrom",100000000.0);
		super.getConvertions().put("inch",0.3937007874);
		super.getConvertions().put("foot",0.032808399);
		super.getConvertions().put("yard",0.010936133);
		super.getConvertions().put("mile",0.0000062137);
		super.getConvertions().put("nautical mile",0.0000053996);
		
	}
}
