import java.util.* ;
public class Driver {
    private static final int DUMMY = 0 ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number=1;
		while(true) {
			
        System.out.println("Please Input a number to work out the number of calculations it takes to reach kaprekars constant from it: ");
        Scanner input = new Scanner(System.in) ;
        number = input.nextInt() ;
        if(number == DUMMY) {
        	break;
        }
        India object = new India(number) ;
        
        int steps = object.kaprekar() ;
        
        System.out.printf("It takes %d calculations to reach 6174 from the input number%n", steps) ;
		}
        
 
	}

}
