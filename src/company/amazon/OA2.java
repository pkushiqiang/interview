package amazon;
import java.io.*;
import java.util.*;
public class OA2 {

	public static void rotateArray(int[][] A, int n) {
        int[][] dire = { {0,1}, {1,0}, {0,-1},{-1,0} }; 
        
        int k=n/2;
        for (int a=0; a<k; a++) {
            int last = A[a][a];
            int i=a, j=a;
            int total = ( n-2*a)*2+(n-2*a-2)*2;
            int dir = 0;
            for (int c=0; c<total; c++) {
                i+=dire[dir][0];
                j+=dire[dir][1];
                
                if ( i == n-a || j==n-a || i==a-1 || j== a-1 ) {
                    if ( i == n-a ) {
                        i--;
                    } else if ( i == a-1 ) {
                        i++ ;
                    } else if ( j == n-a ) {
                        j--;
                    } else  if ( j== a-1) {
                        j++;
                    }
                    dir = (dir+1) % 4;
                    i+=dire[dir][0];
                    j+=dire[dir][1];
                }
                int p = A[i][j];
                A[i][j] = last;
                last = p;
            } // for c
            
        } // for a 
    }
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        in.nextLine();
        int[][] A = new int[n][n];
        for (int i=0;i<n; i++) {
              String line = in.nextLine();
              String[] strs = line.split(" ");
              if (strs.length != n) {
                  System.out.println("ERROR");
                  return;
              }
              for (int j=0; j<n; j++) {
                A[i][j] = Integer.parseInt(strs[j]);
              }              
        }

        rotateArray(A, n);
        for (int i=0;i<n; i++) {
            System.out.print(" "+A[i][0]);
            for (int j=1;j<n;j++) {
                System.out.print(" "+A[i][j]);
            }
            System.out.println();
        }
    }

}
