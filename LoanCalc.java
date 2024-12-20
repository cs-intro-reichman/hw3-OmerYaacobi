// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
    
    static double epsilon = 0.001;  // Approximation accuracy
    static int iterationCounter;    // Number of iterations 
    
    // Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
    public static void main(String[] args) {        
        // Gets the loan data
        double loan = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);
        System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

        // Computes the ending balance of the loan, given a periodical payment
        double payment = 10000.0;
        double endBalance = endBalance(loan, rate, n, payment);
        
        // Computes the periodical payment using brute force search
        System.out.print("\nPeriodical payment, using brute force: ");
        System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
        System.out.println("number of iterations: " + iterationCounter);

        // Computes the periodical payment using bisection search
        System.out.print("\nPeriodical payment, using bi-section search: ");
        System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
        System.out.println("number of iterations: " + iterationCounter);
    }

    // Computes the ending balance of a loan, given the loan amount, the periodical
    // interest rate (as a percentage), the number of periods (n), and the periodical payment.
    private static double endBalance(double loan, double rate, int n, double payment) { 
         
        double endBalance = loan;
        for (int i = 0; i < n; i++){
            endBalance = ((endBalance - payment) * (1 + (rate/100)));
        }
        
        return endBalance;
    }
    
    // Uses sequential search to compute an approximation of the periodical payment
    // that will bring the ending balance of a loan close to 0.
    // Given: the sum of the loan, the periodical interest rate (as a percentage),
    // the number of periods (n), and epsilon, the approximation's accuracy
    // Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {  
        
        double increment = 0.001;
        int itrCounter = 0;
        double payment = loan / n;
        while (endBalance(loan, rate, n, payment) > epsilon) {
            payment += increment;
            itrCounter++ ;
            if (payment > loan) break; 
        }
        iterationCounter = itrCounter;
        
        return payment;
        
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
    // that will bring the ending balance of a loan close to 0.
    // Given: the sum of the loan, the periodical interest rate (as a percentage),
    // the number of periods (n), and epsilon, the approximation's accuracy
    // Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
       
        int itr2Counter = 0;
        double highLimit = loan; 
        double lowLimiit = 0;
        double g = 0;
        

        while (highLimit- lowLimiit > epsilon) {
            g = (highLimit + lowLimiit) / 2;
            double balance = endBalance(loan, rate, n, g);
            if (Math.abs(balance) <= epsilon ){
                break;
            } else if (balance > 0) {
                lowLimiit = g;
            } else {
                highLimit = g;
            }
            
            itr2Counter++ ;
            }
            
            iterationCounter =itr2Counter;
            
        return g;
    }
}

