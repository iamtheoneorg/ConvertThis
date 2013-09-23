package com.iamtheoneorg.convertthis.units;

import com.iamtheoneorg.convertthis.Units;

public class Feet extends Units {
	
	public Feet() {
		super("Feet");
		
        super.getConvertions().put("cm",30.48);
        super.getConvertions().put("m",0.3048);
        super.getConvertions().put("km",0.0003048);
        super.getConvertions().put("arpent",0.00520833);
		super.getConvertions().put("inch",12.0);
		super.getConvertions().put("yard",0.333333333);
	}
	

}
