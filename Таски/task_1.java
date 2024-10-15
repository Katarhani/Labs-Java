public class task_1 {
    public static void main(String[] args) {
        System.out.println("convert");
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));
        System.out.println("==============");

        System.out.println("fitCalc");
        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));
        System.out.println("==============");

        System.out.println("containers");
        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));
        System.out.println("==============");

        System.out.println("triangleType");
        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));
        System.out.println("==============");

        System.out.println("ternaryEvaluation");
        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));
        System.out.println("==============");

        System.out.println("howManyItems");
        System.out.println(howManyItems(22, 1.4, 2));
        System.out.println(howManyItems(45, 1.8, 1.9));
        System.out.println(howManyItems(100, 2, 2));
        System.out.println("==============");

        System.out.println("factorial");
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));
        System.out.println("==============");

        System.out.println("gcd");
        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));
        System.out.println("==============");

        System.out.println("ticketSaler");
        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));
        System.out.println("==============");

        System.out.println("tables");
        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));
        System.out.println("==============");
    }

    public static double convert(int l) {
        double coeff = 3.785;
        return l * coeff;
    }

    public static int fitCalc(int time, int intensity) {
        return time * intensity;
    }

    public static int containers(int boxes, int bags, int barrels) {
        int in_box = 20, in_bag = 50, in_barrel = 100;

        return boxes * in_box + bags * in_bag + barrels * in_barrel;
    }

    public static String triangleType(int x, int y, int z) {
        if ((x + y > z) && (x + z > y) && (y + z > x)) {
            if ((x == y) && (x == z))
                return "isosceles";
            else if ((x == z) || (x == y) || (z == y))
                return "equelateral";
            else
                return "different-sided";
        }
        else
            return "not a triangle";
    }

    public static int ternaryEvaluation(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int howManyItems(double n, double w, double h) {
        double fabric = n * 2;
        double detail = w * h;
        double duvet_cover = detail * 2 * 2;

        double duvet_cover_count = fabric / duvet_cover;

        return (int)duvet_cover_count;
    }

    public static int factorial(int num) {
        if (num == 1) return 1;

        return factorial(num - 1) * num;
    }

    public static int gcd(int a, int b) {
        while (a > 0 && b > 0) {
            if (a >= b)
                a %= b;
            else
                b %= a;
        }

        return ternaryEvaluation(a, b);
    }

    public static int ticketSaler(int quantity, int price) {
        double fixed_rate = 0.72;
        return (int) (quantity * price * fixed_rate);
    }

    public static int tables(int stud_num, int tabl_num) {
        int tables = stud_num / 2;

        if (stud_num % 2 != 0)
            tables += 1;
        
        return (tables > tabl_num) ? tables - tabl_num : 0;
    }
}