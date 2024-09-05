public class Exceptions {

    public static void main(String[] args) {
        int[] numbers = { 4, 7, 9, 1};
        int calcul = 5+1;

        try {
            System.out.println(numbers[4]);
            calcul /= 0;
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("L'erreur est ici");
        } finally {
            System.out.println("Finalement, la vie est belle !");
        }

        double balance = 5000;
        double price = 5800;

        try {
            buy(balance, price);
        } catch (NoMoneyException e) {
            e.printStackTrace();
        }
    }

    private static void buy(double balance, double price) throws NoMoneyException {
        double b = balance - price;

        if(b < 0) {
            throw new NoMoneyException();
        }
        System.out.println(b);
    }
}
