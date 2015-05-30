public class Prime {

    public static int closestPrime(int number) {
        if (number % 2 == 0) number--; // avoid even numbers
        int smaller = number;
        int bigger = number + 2;

        do {
            if (isPrime(smaller)) return smaller;
            if (isPrime(bigger)) return bigger;
            smaller -= 2;
            bigger += 2;
        } while (true);

    }

    public static boolean isPrime(int number) {
        if (number == 2 || number == 3 || number == 5) return true;
        else if ((number < 2) || (number % 2 == 0) || (number % 3 == 0) || (number % 5 == 0)) return false;
        int root = (int) Math.ceil(Math.sqrt(number));
        int i = 3, n;

        do {
            n = number % i;
            if (n == 0) return false;
            i += 2;
        } while (i < root);

        return true;
    }

}
