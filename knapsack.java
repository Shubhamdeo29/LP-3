import java.util.*;
public class knapsack {
    public static void main (String args[]){
        System.out.println("Enter n: ");
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int [] val= new int [n];
        int [] weight= new int[n];
        System.out.println("Enter values: ");
        for(int i=0; i<n; i++){
            val[i]= sc.nextInt();
        }
         System.out.println("Enter weights: ");
        for(int i=0; i<n; i++){
            weight[i]= sc.nextInt();
        }
        System.out.println("Enter capacity: ");
        int w= sc.nextInt();
        // int val[]= {60,100,120};
        // int weight[]= {10,20,30};
        // int w= 50;

        double ratio[][]= new double[val.length][2];
        for(int i= 0; i<val.length; i++){
            ratio[i][0]=i;
            ratio[i][1]= val[i] / (double) weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble (o->o[1]));
        
        int capacity = w;
        int finalval= 0;
        for(int i=ratio.length-1; i>=0; i--){
            int idx= (int) ratio[i][0];
            if(capacity>=weight[idx]){
                finalval+= val[idx];
                capacity -= weight[idx];
            }
            else{
                finalval+= (ratio[i][1] * capacity );
                capacity= 0;
                break;
            }
        }
        System.out.println(finalval);
    }
}
