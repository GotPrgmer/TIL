package lecture.src.barkingdock.x12;
import java.util.*;
import java.io.*;

public class EratosPrimeChecker {
    public static void main(String[] args) throws IOException {
        List<Integer> tmp = new ArrayList<>(primeList(100));
        for(int i=0;i<tmp.size();i++){
            System.out.print(tmp.get(i) + " ");
        }
    }
    static List<Integer> primeList(int n){
        boolean[] isPrimes = new boolean[n + 1];
        Arrays.fill(isPrimes,true);

        for(int i=2;i*i<=n;i++){
            if(!isPrimes[i]) continue;
            for (int j = i * i; j <= n; j += i) {
                isPrimes[j] = false;
            }
        }
        List<Integer> primes= new ArrayList<>();
        for(int i=2;i<n+1;i++){
            if (isPrimes[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
