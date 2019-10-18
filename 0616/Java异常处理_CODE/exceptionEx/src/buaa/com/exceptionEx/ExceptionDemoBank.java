package buaa.com.exceptionEx;

class Account {
	double balance;

	Account(double bal) {
		balance = bal;
	}

	public void deposite(double dAmount) {
		if (dAmount > 0.0) {
			balance += dAmount;
		}
	}

	public void withdrawal(double dAmount) throws InsufficientFundsException {
		if (balance < dAmount) {
			throw new InsufficientFundsException(this, dAmount);
		}
		balance = balance - dAmount;
	}

	public String show_balance() {
		return "The balance is " + (int) balance;
	}
}

class InsufficientFundsException extends Exception {
	private Account excepbank;

	private double excepAmount;

	InsufficientFundsException(Account ba, double dAmount) {
		excepbank = ba;
		excepAmount = dAmount;
	}

	public String excepMesagge() {
		String str = excepbank.show_balance() + " The withdrawal was "
				+ excepAmount;
		return str;
	}
}

public class ExceptionDemoBank {
	public static void main(String args[]) {
		try {
			Account ba = new Account(50);
			ba.withdrawal(20);
			System.out.println("Withdrawal successful!");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		try {
			Account ba = new Account(50);
			ba.withdrawal(200);
			System.out.println("Withdrawal successful!");
		} catch (InsufficientFundsException e) {
			System.out.println(e.excepMesagge());
		}
	}
}