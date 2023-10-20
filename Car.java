public class Car {
    private double currentGas, tankCapacity, mpg, totalMiles;

    public Car(double tankCapacity, double currentGas, double mpg) {
        this.tankCapacity = tankCapacity;
        this.currentGas = currentGas;
        this.mpg = mpg;
    }

    public String toString() {
        return String.format("Max Tank Level: %.1f gals\n", tankCapacity) +
        String.format("Miles per Gallon: %.1f mi\n", mpg) +
        String.format("Gas in Tank: %.1f gals\n", currentGas) +
        String.format("Miles to Empty: %.1f mi\n", getMilesToEmpty());
        
    }

    public void drive(double distance_mi) {
        if ( distance_mi >= getMilesToEmpty() ) {
            System.out.format("After %.1f miles, You ran out of gas!\n", getMilesToEmpty());
            setTotalMiles(this.totalMiles + getMilesToEmpty());
            setCurrentGas(0);
            return;
        }

        setCurrentGas(this.currentGas - (distance_mi / this.mpg));
        setTotalMiles(this.totalMiles + distance_mi);

        System.out.format("You drove: %.1f mi\nGas Tank: %.1f gals\nMiles to Empty %.1f mi\n", distance_mi, this.currentGas, getMilesToEmpty());
    }


    public double getMilesToEmpty() { return this.currentGas * this.mpg; }
    public double getMPG() { return this.mpg; }

    private void setCurrentGas(double currentGas) { this.currentGas = Math.max(0, currentGas); }
    private void setTotalMiles(double totalMiles) { this.totalMiles = Math.max(this.totalMiles, totalMiles); }
}