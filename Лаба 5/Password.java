import java.util.regex.*;

public class Password {
    public static void main(String[] args) {
        String password = "jgnvdlnJc1gL0";

        try {
            Matcher matcher = Pattern.compile("\\w{8,16}").matcher(password);
            boolean Size = matcher.matches();
            matcher = Pattern.compile("[A-Z]{1,}").matcher(password);
            boolean Big = matcher.find();
            matcher = Pattern.compile("[a-z]{1,}").matcher(password);
            boolean Small = matcher.find();
            matcher = Pattern.compile("[0-9]{1,}").matcher(password);
            boolean Numbers = matcher.find();
            
            if (Size && Big && Small && Numbers)
                System.out.println("Valid password");
            else
                System.out.println("Invalid password");
            
        } catch (PatternSyntaxException e) {
            System.out.println(e);
        }
    }
}

/*
 * Необходимо написать программу, которая будет проверять корректность 
ввода пароля. Пароль должен состоять из латинских букв и цифр, быть 
длиной от 8 до 16 символов и содержать хотя бы одну заглавную букву и 
одну цифру. При этом программа должна использовать регулярные 
выражения для проверки пароля и обрабатывать возможные ошибки.
 */