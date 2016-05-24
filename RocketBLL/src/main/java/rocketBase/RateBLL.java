package rocketBase;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketData.LoanRequest;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		double IR=-1;
		try{
		for(RateDomainModel r: RateDAL.getAllRates()){
			if(GivenCreditScore >= r.getiMinCreditScore()){
				IR=r.getdInterestRate();
			}
			else break;
		}
		
		} catch(Exception e){
			LoanRequest lq = new LoanRequest();
			lq.setiCreditScore(GivenCreditScore);
			throw new RateException(lq);

		}
		
		if(IR==-1)
		{
			LoanRequest lq = new LoanRequest();
			lq.setiCreditScore(GivenCreditScore);
			throw new RateException(lq);
		}
		return IR;
	}
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		r=r/100;
		r=r/12;
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
