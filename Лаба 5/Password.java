import java.util.regex.*;

public class Password {
    public static void main(String[] args) {
        String password = "iQwerty1";

        try {
            Matcher matcher = Pattern.compile(".{8,16}").matcher(password);
            boolean inRange = matcher.find();
            matcher = Pattern.compile("[A-Z]{1,}").matcher(password);
            boolean upSim = matcher.find();
            matcher = Pattern.compile("[a-z]{1,}").matcher(password);
            boolean lowSim = matcher.find();
            matcher = Pattern.compile("[0-9]{1,}").matcher(password);
            boolean numMatch = matcher.find();
            matcher = Pattern.compile("_?").matcher(password);
            boolean specSim = matcher.find();

            if (inRange && upSim && lowSim && numMatch && specSim)
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