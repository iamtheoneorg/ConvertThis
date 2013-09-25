package com.iamtheoneorg.convertthis.units;

import com.iamtheoneorg.convertthis.Units;

public class Meter extends Units {

	public Meter() {
		super("Meter");

		super.getConvertions().put("mm",1000.0);
		super.getConvertions().put("cm",100.0);
		super.getConvertions().put("dm",10.0);
		super.getConvertions().put("km",0.001);
		super.getConvertions().put("Angstrom",10000000000.0);
		super.getConvertions().put("inch",39.37007874);
		super.getConvertions().put("foot",3.2808399);
		super.getConvertions().put("yard",1.0936133);
		super.getConvertions().put("mile",0.00062137);
		super.getConvertions().put("nautical mile",0.00053996);

	}

}
