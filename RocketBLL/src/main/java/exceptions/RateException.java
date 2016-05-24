package exceptions;

import rocketData.LoanRequest;

public class RateException extends Exception {

	private LoanRequest lq;
	
	public LoanRequest getLq() {
		return lq;
	}

	public RateException(LoanRequest lq){
		this.lq=lq;
	}
	
	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	//	* Add RateDomainModel as an attribute
	//	* Create a constructor, passing in RateDomainModel
	//	* Create a getter (no setter, set value only in Constructor)
}
