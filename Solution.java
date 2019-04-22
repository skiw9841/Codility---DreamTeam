// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int[] B, int F) {
        // write your code in Java SE 8
        int MAX_GAP = 2001;//-1000~1000
        int N = A.length;
        
        Person p[] = new Person[N];
        Person rp[] = new Person[N];
        //int gap[] = new int[N]; 
        
        int count[] = new int[MAX_GAP + 1];
        
        int sum1 = 0 , sum2 = 0;
        int i=0;
        

        for( i=0 ; i<MAX_GAP+1;i++ )
        {
            count[i] = 0;
        }
        
        for( i=0 ; i<N ; i++ ) 
        {
            p[i] = new Person(A[i], B[i], A[i] - B[i] + 1000);//0~2000
            rp[i] = new Person();
        }
        
        for( i=0 ; i<N ; i++ )
        {
            count[ (p[i].gap)+1]++;
        }
        
        for( i=0 ; i<MAX_GAP ; i++ )
        {
            count[i+1] += count[i];
        }
        
        for( i=N-1; i>=0 ; i-- )
        {
            rp[--count[p[i].gap+1]] = p[i];
        }

        /////////////////////////////
        
        for( i=0 ; i<N ; i++ )
        {
            if( i < F )
                sum1 += rp[i].A;
            else 
                sum1 += rp[i].B;
        }
        
        for( i=0 ; i<N ; i++ )
        {
            if( i < F )
                sum2 += rp[N-i-1].A;
            else
                sum2 += rp[N-i-1].B;
        }
        //System.out.print("S1:" + sum1 + " S2:" + sum2);
        return (sum1>sum2)?sum1:sum2;
    }
    
    class Person{
        int A;
        int B;
        int gap;
        Person(int _A, int _B, int _gap)
        {
            A = _A;
            B = _B;
            gap = _gap;
        }
        Person()
        {
            A=0;
            B=0;
            gap=0;
        }
    }
}
