import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Car a = new Car(12.5, 12.5, 24);
        Random r = new Random();

        

        int stops = 0;
        double sumPricePerGal = 0;
        double sumDistance = 0;

        while (a.getMoney() >= 50) {
            double distance = randomInRange(r, 50, a.getMilesToEmpty());
            double price_per_gal = randomInRange(r, 2.49, 4.29);

            a.drive(distance);
            System.out.println();

            double gallons_to_buy = randomInRange(r, 50 / a.getMPG(), a.getTankCapacity() - a.getCurrentGas());
            a.fillGas(gallons_to_buy, price_per_gal);
            System.out.println();

            sumPricePerGal += price_per_gal;
            sumDistance += distance;
            stops++;
        }

        System.out.println("---------------------------------");
        System.out.println(a.toString());
        System.out.format("Total Distance: %.1f mi\n", a.getTotalMiles());
        System.out.format("Average Distance: %.1f mi\n", sumDistance/stops);
        System.out.format("Average PPG: $%.2f\n", sumPricePerGal/stops);

    }

    private static double randomInRange(Random r, double min, double max) {
        return min + (max - min) * r.nextDouble();
    }
}
