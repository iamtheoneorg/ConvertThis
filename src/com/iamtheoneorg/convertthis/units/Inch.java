package com.iamtheoneorg.convertthis.units;

import com.iamtheoneorg.convertthis.Units;

public class Inch extends Units{
	

	public Inch() {
		super("Inch");
		
		super.getConvertions().put("cm",2.54);
		super.getConvertions().put("m",0.0254);
		super.getConvertions().put("km",2.54E-5);
		super.getConvertions().put("arpent",0.000434028);
		super.getConvertions().put("feet",0.0833333333);
		super.getConvertions().put("yard",0.0277777778);
		
		
		
	}

	
}
