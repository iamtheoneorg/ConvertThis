package com.iamtheoneorg.convertthis.units;

import com.iamtheoneorg.convertthis.Units;

public class Inch extends Units{
	

	public Inch() {
		super("Inch");
		
		super.getConvertions().put("cm",2.54);
		super.getConvertions().put("m",0.0254);
		super.getConvertions().put("km",2.54E-5);
		
		
		
	}

	
}
