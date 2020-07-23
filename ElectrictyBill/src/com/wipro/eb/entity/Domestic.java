package com.wipro.eb.entity;

public class Domestic extends Connection {
	public Domestic(int currentReading, int previousReading,float slabs[]) {
		super(currentReading, previousReading, slabs);
	}
	
	public float computeBill() {
		
		int consumedunits=currentReading-previousReading;
		float billamount=0.0f;
		if(consumedunits>100) {
			billamount=(consumedunits-100)*slabs[2]+50*slabs[1]+50*slabs[0];
		}
		else if(consumedunits>50) {
			billamount=(consumedunits-50)*slabs[1]+50*slabs[0];
		}
		else {
			billamount=(consumedunits)*slabs[0];
		}
		return(billamount);
	}

}
