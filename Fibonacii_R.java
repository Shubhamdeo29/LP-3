public class Fibonacii_R {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        int n = 10; // Change this value for a different Fibonacci number
        
        long startTime = System.nanoTime();
        int result = fibonacci(n);
        long endTime = System.nanoTime();
        
        System.out.println("Fibonacci number at position " + n + " is: " + result);
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
    }
}
