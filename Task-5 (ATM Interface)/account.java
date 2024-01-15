package skybug_internship;

import java.util.Scanner;

public class account {


	private int  pin[]=new int[10]; //array to store the pins of accounts 
	private float bal[]= new float[10]; // array to store balance of accounts 
	static private int count=0;
	Scanner sc =new Scanner(System.in);

	boolean validateUser(int pinNumber) {
		for(int i=0;i<10;i++) {
			if(pin[i]==pinNumber) {
				return true;
			}
		}
		return false;

	}


	void newAccount() {

		System.out.println("\nEnter Pin Number : ");
		int pinNo=sc.nextInt();
		pin[count]=pinNo;

		System.out.println("\nEnter the Balance : ");
		float balance=sc.nextFloat();
		bal[count]=balance;

		count++;


	}


	void checkBal(int pinNumber) {
		for(int i=0;i<10;i++) {

			if(pin[i]==pinNumber) {
				System.out.println("\nBalance is : "+bal[i]);
				break;
			}else {
				System.out.println("\nAccount not found");


			}
		}

	}

	void withdraw(int pinNumber,float amount) {
		for(int i=0;i<10;i++) {
			if(pinNumber == pin[i]) {
				if(bal[i]<100.0) {
					System.out.println("\nSorry!! Low balance ");
					break;
				}
				else {
					bal[i]=bal[i]-amount;
					System.out.println("\nAmount of ruppees "+amount+" successfully withdrawn.\nRemaining Balance is : "+bal[i]);
					break;
				}
			}else {
				System.out.println("\nAccount not found");
			}

		}

	}



	void deposit(int pinNumber,float amount) {
		for(int i=0;i<10;i++) {
			if(pin[i]==pinNumber) {
				bal[i]=bal[i]+amount;
				System.out.println("\nAmount added successfully.\nUpdated Balance is : "+bal[i]);
				break;
			}else {
				System.out.println("\nAccount not found");
			}
		}
	}

}
