package lecture.src.barkingdock.x12;
import java.util.*;
import java.io.*;
public class PrimeChecker {
    public static void main(String[] args) throws IOException {
        List<Integer> tmp = primeList(100);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<tmp.size();i++){
            sb.append(tmp.get(i)).append(" ");
        }
        System.out.println(sb);
    }
    static List<Integer> primeList(int n){
        List<Integer> primes = new ArrayList<>();
        boolean isPrime = true;
        for(int i=2;i<=n;i++){
            isPrime = true;
            for (int p : primes) {
                if(p*p>i) break;
                if(i%p == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) primes.add(i);
        }
        return primes;
    }
}
