import java.util.regex.*;

public class IP {
    public static void main(String[] args) {
        try {
            String ip = "192.168.43.0";
            
            Matcher matcher = Pattern.compile("^([0-1]?[0-9]?[0-9]|[2]?[0-5]?[0-5])[.]" +
                                              "([0-1]?[0-9]?[0-9]|[2]?[0-5]?[0-5])[.]" +
                                              "([0-1]?[0-9]?[0-9]|[2]?[0-5]?[0-5])[.]" +
                                              "([0-1]?[0-9]?[0-9]|[2]?[0-5]?[0-5])$").matcher(ip);
            if (matcher.matches())
                System.out.println(matcher.group());
            else
                System.out.println("NO IP");
        } catch (PatternSyntaxException e) {
            System.out.println(e);
        } catch (IllegalStateException e) {
            System.out.println(e);
        }
    }
}

/*
 * Необходимо написать программу, которая будет проверять корректность 
ввода IP-адреса. IP-адрес должен состоять из 4 чисел, разделенных 
точками, и каждое число должно быть в диапазоне от 0 до 255. При этом 
программа должна использовать регулярные выражения для проверки 
IP-адреса и обрабатывать возможные ошибки. 
 */
