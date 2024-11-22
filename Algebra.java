// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	System.out.println("2 + 3 =");
		System.out.println(plus(2,3));   // 2 + 3
	System.out.println("2 + -3 =");
			System.out.println(plus(2,-3));   // 2 + -3
	System.out.println("7 - 2 =");
	    System.out.println(minus(7,2));  // 7 - 2
	System.out.println("2 - 7 =");
   		System.out.println(minus(2,7));  // 2 - 7
	System.out.println("2 - -7 =");	
			System.out.println(minus(2,-7));  // 2 - -7
	System.out.println("3 * 4=");
 		System.out.println(times(3,4));  //
	System.out.println("3 * -4 ="); 
			System.out.println(times(3,-4));  // 
	System.out.println("-3 * 4 =");
			System.out.println(times(-3,4));  // 
	System.out.println("-3 * -4 =");
			System.out.println(times(-3,-4));  // 
	System.out.println("2 + 4 * 2 =");
   		System.out.println(plus(2,times(4,2)));  // 
	System.out.println("5^3 =");
   		System.out.println(pow(5,3));      // 
	System.out.println("3^5 =");
   		System.out.println(pow(3,5));      // 
	System.out.println("12 / 0 =");
   		System.out.println(div(12,0));   //
	System.out.println("5 / 5 =");     
   		System.out.println(div(5,5));    //  
	System.out.println("5 / -5 =");
			System.out.println(div(5,-5));    //  
	System.out.println("-10 / 5  ="); 
			System.out.println(div(-10,5));    // 
			System.out.println("-25 / -5 =");
			System.out.println(div(-25,-5));    //  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
		   System.out.println(mod(-25,7));   // -25 % 7
		   System.out.println(mod(25,-7));   // 25 % -7
		   System.out.println(mod(-25,-7));   // -25 % -7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(-1));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
		
	}  

	// Returns x1 + x2
	public static int plus(double x1, double x2) {
		// Replace the following statement with your code
		 
		int resultPlus = (int) x1;
		// if x2 is positive:
		if (x2 > 0) {
		for (int i = 0; i < x2; i++){
			resultPlus++;
		}
		 }
		 // if x1 is negative:
		 if (x2 < 0) {
			x2 = -x2;
			for (int i = 0; i < x2; i++){
				resultPlus--;
			}
		 }
		return (int) resultPlus;
	}

	// Returns x1 - x2
	public static int minus(int x1, double x2) {

		int resultMinus = x1;
		// if x2 is positive:
		if (x2 > 0) {
			for (int i = 0; i < x2; i++){
			resultMinus--;
		}
		}
		// if x2 is negative:
		if (x2 < 0) {
			x2 = -x2;
			for (int i = 0; i < x2; i++){
				resultMinus++;
			}
		}
		return (int) resultMinus;
	}

	// Returns x1 * x2
	public static int times(int x1, double x2) {
      
		int resultMulti = 0;
		// if one of them equels 0:
		if (x1 == 0 || x2 == 0) {
			return 0;
		}
		// if both positive:
		if (x1 > 0 && x2 > 0){
		
		for (int i = 0; i < x2; i++){
			resultMulti= Algebra.plus(resultMulti, x1);
		}
	}
	//if one is negative
	if (x1 > 0 && x2 < 0) {
		x2 = -x2;

		for (int i = 0; i < x2; i++){
			resultMulti= Algebra.plus(resultMulti, x1);
		}
		resultMulti = -resultMulti;
	}
	if (x1 < 0 && x2 > 0) {
		x1 =-x1;
	
		for (int i = 0; i < x2; i++){
			resultMulti= Algebra.plus(resultMulti, x1);
		}
		resultMulti = -resultMulti;}
	
	if (x1 < 0 && x2 < 0) {
		x1 = -x1;
		x2 = -x2;
		for (int i = 0; i < x2; i++){
			resultMulti= Algebra.plus(resultMulti, x1);
	}

	}
		return (int) resultMulti;
	}

	// Returns x^n (for n >= 0)
	public static int pow(double x, int n) {
		// Replace the following statement with your code

		int resultPower = 1;
		for (int i = 0; i < n; i++){
			resultPower = Algebra.times(resultPower, x);
		}

		return (int) resultPower;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
        // Replace the following statement with your code
		if (x2 == 0) {
		return (int) Double.NaN;
	}
		
			int resultDivide = 0;
		// if both positive:
		if (x1 > 0 && x2 > 0){
			while (x1 >= x2) {
			x1 = Algebra.minus(x1, x2);
			resultDivide ++ ; }

		}
		// if x1 is negative:
		if (x1 < 0 && x2 > 0){
			x1 = x1 * -1;
			
			while (x1 >= x2) {
			x1 = Algebra.minus(x1, x2);
			resultDivide ++ ; 
		}
		resultDivide = resultDivide * -1;
		}
		// if x2 is negative:
		if (x1 > 0 && x2 < 0){
			x2 = x2 * -1;
			
			while (x1 >= x2) {
			x1 = Algebra.minus(x1, x2);
			resultDivide ++ ; 
		}
		resultDivide = resultDivide * -1;
	}
			// if both negative:
		if (x1 < 0 && x2 < 0){
			x2 = x2 * -1;
			x1 = x1 * -1;
			while (x1 >= x2) {
			x1 = Algebra.minus(x1, x2);
			resultDivide ++ ; 
		}
	}
			return (int) resultDivide;
		
		}
	
		

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
        // Replace the following statement with your code
		
		if (x2 == 0) {
			return (int) Double.NaN;}
			
			int i = x1;
			int j = x2;
			if (i < 0) {
				x1 = -x1;
			}
			if (j < 0) {
				x2 = -x2;
			}
				
				while (x1 >= x2) {
				x1 = Algebra.minus(x1, x2);
				}
			
			int resultMod= x1;
			if (j > 0 && i < 0){
				resultMod = x2 -resultMod;
			}
			if (j < 0 && i > 0) {
				resultMod = -(x2 - resultMod);
			}
			if (j < 0 && i < 0) {
				resultMod = -resultMod;
			}
		return  (int) resultMod;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
        // Replace the following statement with your code
		
		if (x < 0){
			return (int) Double.NaN;
		}
		double resultSqrt = 0;
		while (Algebra.pow(resultSqrt, 2) < x) {
			resultSqrt++;
			 if (resultSqrt > x) break;
		}
		if (Algebra.pow(resultSqrt, 2) != x){
			resultSqrt--;
		}
		
		return (int) resultSqrt;
	}	  	  
}