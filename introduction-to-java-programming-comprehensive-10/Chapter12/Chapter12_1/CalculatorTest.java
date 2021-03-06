public class CalculatorTest {
    /** Main method */
    public static void main(String[] args) {
    
        //Check number of strings passed 
        if (args.length != 3) {
            System.out.println("Usage: java Calculator operand1 operator operand2");
            System.exit(0);
        } 
         
        //Compute calculations
        try { 
            Calculator calc = new Calculator( Double.valueOf(args[0]), args[1].charAt(0), Double.valueOf(args[2]) );  
            calc.textDisplayResult();
        } catch (Exception e) { 
            System.out.println( "Wrong input: " + e.getMessage() );
        }  
        
    }
}
