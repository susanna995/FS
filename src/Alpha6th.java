import java.util.HashMap;
import java.util.Scanner;

public class Alpha6th {
    /*
Sampoornesh Babu is learning arithmatics.
His teacher given him a task to find the minimum number of operations
required to convert a given integer I to 1.

Sampoornesh is allowed to perform the following operations:
	- If I is even, convert I with I/2 .
	- In I is odd, convert I with either I+1 or I-1.

Now it's your task to help Sampoornesh Babu to find and print
the minimum number of operations required.

Input Format:
-------------
An integer I.

Output Format:
--------------
Print an integer, the minimum number of operations required.


Sample Input-1:
---------------
10

Sample Output-1:
----------------
4

Explanation:
------------
10 -> 5 -> 4-> 2 -> 1.


Sample Input-2:
---------------
15

Sample Output-2:
----------------
5

Explanation:
------------
15 -> 16 -> 8 -> 4 -> 2 -> 1.
 */
    static HashMap<Integer,Integer> memo =new HashMap<>();
    public static int solve(int n)
    {
        if(n==1) return 0;
        if(n<1) return Integer.MAX_VALUE;
        int step=Integer.MAX_VALUE;
        if(memo.containsKey(n)) return memo.get(n);
        if(n%2==0)
        {
            step=Math.min(1+solve(n/2),step);
        }
        else{
            step=1+Math.min(solve(n+1),solve(n-1));
        }
        memo.put(n,step);
        return step;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(solve(n));
    }

}
