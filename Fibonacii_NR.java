import java.util.*;
public class Fibonacii_NR {
    
        public static int fibonacci(int n) {
            if (n <= 1) {
                return n;
            }
            
            int a = 0;
            int b = 1;
            int c = 0;
            
            for (int i = 2; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            
            return c;
        }
    
        public static void main(String[] args) {
            //nt n = 3; // Change this value for a different Fibonacci number
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter n: ");
            int n= sc.nextInt();
            
            long startTime = System.nanoTime();
            int result = fibonacci(n);
            long endTime = System.nanoTime();
            
            System.out.println("Fibonacci number at position " + n + " is: " + result);
            System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
        }
    }
    

