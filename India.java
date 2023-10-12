import java.util.*;


/*
 * Kaprekar's constant 6174. Kaprekars constant is a theorem that stipulates if we have a 4 digit number and sort it out into descending
 * and ascending orders respectively, and then subtract those sortings from another and then run the result from the subtraction
 * through the whole sorting process once again, we're to bound to getting the result 6174 eventually.
 * 
 * this class calculates how many subtractions it takes to reach the constant from a given number supplied by the user.
 */


public class India {
	
	    private final int KAPREKARS_CONSTANT = 6174 ;
	
	 	private int descending ;
	 	private int ascending ;
	 	private int number ;
	 	private boolean check ;
			
		public India(int number) {
			this.number = number ;
			this.descending = this.desc(number);
			this.ascending = this.asc(number) ;
            this.check = Check(this.descending,this.ascending) ;
		}
		
		/*@return integer
		 * the ascending and descending versions of the number are stacked against one another to see which is bigger to subtract
		 * the smaller number from it. the result of the subtraction is passed onto the sorting methods and the entire process is repeated 
		 * where the descending and ascending representations of the resulting number are subtracted from one another and so forth until 
		 * the result eventually reaches 6174
		 * 
		 * defining a counter variable to keep track of how many subtractions it took to reach 6174 from the number input by the user.
		 */
		
		public int kaprekar() {
			if (!this.check) {
				System.out.println("Invalid Number. Can't Contain Identical Digits Please Try Again!") ;
				Driver.main(null);
			}
			int result = 0 ;
	        int counter = 0 ;
	        while (result != KAPREKARS_CONSTANT) { // keep on executing the loop so long as the constant is not reached yet.
	        	
				if (this.descending > this.ascending) { // determining which number is going to be subtracted from the other based off which is bigger
					
				result = this.descending - this.ascending ;
				
				}
				
				else {
					
					result = ascending - descending; 
				}
				this.descending = this.desc(result) ;
				this.ascending = this.asc(result) ;
				counter += 1 ;
			}
	        return counter ;
			
		}
		
		
		/*
		 * a method to rearrange the number into descending order
		 * @param int num
		 * @return int[] array
		 */
		private int desc(int num) {
			int[] array = convertInteger(num) ; // an array to store the digits of the number given, individually. Making a call to the method convertInteger to convert the integer argument into an array so that it's easier to sort the number in a descending order with it being an array of elements rather than a whole number.
			int counter = 0 ; // a counter to aid in looping through different arrays presented in this method
			int nest = 0 ; // this variable represents the element which i'm comparing a given element in the array against. typically it will hold an element that comes after the element on hand.
			int elemnt = 0 ; // a placeholder variable used to store a value that occupies a position in an array but is about to be replaced by a new value. retaining the old value in case I need it later on.
				
			while(counter < array.length) { // looping through the array to sort it in a descending order
				
				if (counter != 3) { // making sure the counter is not at the last element of the array. 
				nest = counter + 1 ; // the variable nest represents the element in the array that comes right after the element the program's at to compare them against one another and sort them so that the bigger comes before the smaller in the array 
				}
				
				else {
					break; // if the counter is already pointing at the last element of the array then there will be no elements to compare it against so might as well just break;
				}
				
				while (nest < array.length) { // making sure the index for the element that comes right after the element that is being pointed at in the outer loop is never out of bounds
					
					if (array[counter] < array[nest]) { // if this element is smaller than the element right next in the array then swap them out.
						elemnt= array[counter]; // hold smaller element in a variable
						array[counter] = array[nest] ; // have the bigger element occupy this position instead of the smaller element
						array[nest] = elemnt ; // Now fill the vacant position that used to hold the bigger element in the array with the smaller element
					}
					
					nest+= 1; // increment the nest counter to move onto the next element for comparison
				}
				
				nest = counter + 1; // resetting the nest for the next element in the array to be compared against the neighboring elements for which is larger
				counter += 1 ;//increment the counter to move onto the next element to compare it against the array
			}
			return convertArray(array) ; // return the digits initially fed to the method in the form of an array sorted in descending order.
		}
		
		
		private int asc(int num) {
			    int[] array = convertInteger(num) ;
			    int counter = 0 ;
			    int nest = 0 ;
			    int elemnt = 0;
				while(counter < array.length) { // looping through the array to sort it in an ascending order
				
					if (counter != 3) { // making sure the counter is not at the last element of the array. 
						nest = counter + 1 ; // the variable nest represents the element in the array that comes right after the element the counter's at. it's to compare both elements against one another and sort them so that the smaller comes before the bigger in the array 
					}
				
					else {
						break; // if the counter is already pointing at the last element of the array then there will be no elements to compare it against so might as well just break;
					}
				
					while (nest < array.length) { // making sure the index for the element that comes right after the element that is being pointed at in the outer loop is never out of bounds
					
						if (array[counter] > array[nest]) { // if this element is bigger than the element right next in the array then swap them out.
						elemnt= array[counter]; // hold the bigger element in a variable
						array[counter] = array[nest] ; // have the smaller element occupy this position instead of this element
						array[nest] = elemnt ; // Now fill the vacant position that used to hold the smaller element in the array with the bigger element
						}
					
						nest+= 1; // increment the nest counter to move onto the next element for comparison
					}
				
					nest =counter + 1; // resetting the nest in order for the next element in the array to be compared against the appropriate neighboring elements for which is smaller
					counter += 1 ; // increment the counter to move onto the next element to compare it against the rest of the elements in the array.
				}
				return convertArray(array) ;
		}
		
		
		/*
		 * converts an array of integers into a single integer entity by looping through 
		 * all elements in the array and applying the decimal formulas (n * 10^p) upon each element to work out
		 * a whole number consisting of the elements in the array.
		 *
		 */
		private int convertArray(int[] array) {
			int counter = 0 ;
			int number = 0;
			int exponent = 0 ;
			while(counter < array.length) {
				
				exponent = (array.length - counter) - 1 ;
				number = (int) (number + (array[counter] * Math.pow(10, exponent))) ; // any digit in a decimal number can be represented by the equation: n * 10^p. where p is the position the digit occupies(tenth, hundredth, thousandth, so forth)
				counter = counter + 1 ;
			}
					
			return number;
			
		}
		
		/*
		 * kaprekars constant only works if the digits are not identical
		 * a method that checks the number input by the user lives up to this criteria
		 * a work method hence the private access
		 */
		private boolean Check(int a, int b) {
			if (a - b == 0) {
				return false ;
			}
			else {
				return true ;
			}
		}
		/*
		 * converts an integer into an array so that the sorting methods have an easier job of sorting the number into
		 * ascending and descending orders now having to deal with elements individually instead of an unbreakable whole 
		 * number
		 */
		private int[] convertInteger(int num) {
			int counter = 0 ;
			int array[] = new int[4] ;
				while(counter < 4) { // populating the array with the digits of the number passed onto the method.
				
						array[counter] = num % 10 ; // this equation always results in the last digit of a number
						num = num / 10 ; // after a given last digit of a number has been added to the array, this digit is eliminated for the next digit to be the last digit and to be added to the array in the next iteration
						counter +=1 ; // increment counter to move onto the next position in the array
			}
				return array ;
		}
	}

