package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.RateException;
import rocketData.LoanRequest;

public class rate_test {

	@Test 
	public void rateTest1() throws RateException{
		assert(RateBLL.getRate(600)==5);
	}
	
	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	@Test (expected= RateException.class)
	public void rateTest2() throws RateException
	{
		RateBLL.getRate(500);
	}
	//TODO - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void getPaymentTest() {
		assert(RateBLL.getPayment(4, 360, 300000, 0, false)==1432.25);
	}

}
