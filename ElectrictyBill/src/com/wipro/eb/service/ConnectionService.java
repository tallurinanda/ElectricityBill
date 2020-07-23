package com.wipro.eb.service;

import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService {
	float bill;
	public boolean validate(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException
	{
		if((currentReading<previousReading) || (currentReading<0) || (previousReading<0)) {
			
			throw new InvalidReadingException();
			}
		if((type.equals("Domestic")) || (type.equals("Commercial"))) {
			return(true);
		}
		else{throw new InvalidConnectionException();}}
		public float  calculateBillAmt(int currentReading, int previousReading, String type) {
			
			
			try {
				
		
				validate(currentReading, previousReading, type);
				if(type.equals("Domestic")) {
					float slabs[]= {2.3f,4.2f,5.5f};
					Domestic d= new Domestic(currentReading, previousReading,slabs);
					bill=d.computeBill();
				}
				else {
					float slabs[]= {5.2f,6.8f,8.3f};
					Commercial c= new Commercial(currentReading, previousReading,slabs);
					bill=(c.computeBill());
				}
				return(bill);
			}
			catch(InvalidReadingException e) {return(-1);}
			catch(InvalidConnectionException e) {return(-2);}
	
}
		
		public String generateBill(int currentReading, int previousReading, String type) {
			float f= calculateBillAmt(currentReading, previousReading, type);
			if(f==-1) {return("Incorrect Reading");}
			else if(f==-2) {return("Invalid Connection type");}
			else {
				String b=Float.toString(bill);
			return("Amount to be paid:"+b);
		}





}}