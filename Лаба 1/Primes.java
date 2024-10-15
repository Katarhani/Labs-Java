public class Primes {
    public static void main(String[] args) {
        for(int f = 2; f <= 100; f++){
            if (isPrime(f)){
                System.out.println(f);
            }
        }    
    } 
    public static boolean isPrime(int n) {
        for(int i = 2; i < n; i++ ){
            if (n % i == 0){
                return false;
            
            }
        
        }
        return true;
    } 
    
}