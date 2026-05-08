package in.veerdev.beans;

import org.springframework.stereotype.Service;

@Service("credit")
public class CreditCardPayment implements IPayment{
	
	@Override
	public boolean doPayment(double amt) {
			System.out.println("CRedit Card Payment Completed");
		return true;
	}
}
