public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++){
            String s = args[i];
            if (isPalindrome(s)){
                System.out.print(s);
                System.out.println(" Это полиндром");
            }
            else{
                System.out.print(s);
                System.out.println(" Это не полиндром");
            }
        }
    }
    public static String reverseString(String s){
        String Indexing_Word = "";

        for(int h = s.length() - 1; h >= 0; h--){
            Indexing_Word += s.charAt(h);
        } 
        return Indexing_Word;
    }
    public static boolean isPalindrome(String s){
        String Reverse_Word = reverseString(s);
        return s.equals(Reverse_Word); 
    }
}