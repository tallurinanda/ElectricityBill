package com.wipro.eb.entity;

public class Commercial extends Connection {
	public Commercial(int currentReading, int previousReading,float slabs[]) {
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
		if(billamount>10000) {billamount*=1.09f;}
		else if(billamount>5000) {billamount*=1.05f;}
		else {billamount*=1.02f;}
		return(billamount);
	}


}
