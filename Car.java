public class Car {
    private double currentGas, tankCapacity, mpg, totalMiles, money;

    public Car(double tankCapacity, double currentGas, double mpg) {
        this.tankCapacity = tankCapacity;
        this.currentGas = currentGas;
        this.mpg = mpg;
        this.money = 500;
    }

    public Car(double tankCapacity, double currentGas, double mpg, double money) {
        this.tankCapacity = tankCapacity;
        this.currentGas = currentGas;
        this.mpg = mpg;
        this.money = money;
    }

    public String toString() {
        return String.format("Max Tank Level: %.1f gals\n", getTankCapacity()) +
        String.format("Miles per Gallon: %.1f mi\n", getMPG()) +
        String.format("Gas in Tank: %.1f gals\n", getCurrentGas()) +
        String.format("Miles to Empty: %.1f mi\n", getMilesToEmpty()) +
        String.format("Money for Trip: $%.2f\n", getMoney());
        
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

        System.out.format("Money left: $%.2f\nYou drove: %.1f mi\nGas Tank: %.1f gals\nMiles to Empty %.1f mi\n", getMoney(), distance_mi, this.currentGas, getMilesToEmpty());
    }

    public void fillGas(double gas_gal) {
        if (gas_gal < 0) { System.out.println("You bought no gas"); return; }
        gas_gal = Math.min(gas_gal, tankCapacity);

        setCurrentGas(gas_gal);
        System.out.format("You bought %.1f gallons\nMiles to Empty: %.1f mi\n", gas_gal, getMilesToEmpty());
    }

    public void fillGas(double gas_gal, double price_per_gal) {
        if (gas_gal < 0) { System.out.println("You bought no gas"); return; }
        gas_gal = Math.min(gas_gal, tankCapacity);

        double cost = gas_gal * price_per_gal;
        setMoney(this.money - cost);
        setCurrentGas(gas_gal);
        System.out.format("You bought %.2f gallons at $%.2f per gallon.\nIt cost: $%.2f\nMiles to Empty: %.1f mi\n", gas_gal, price_per_gal, cost, getMilesToEmpty());
    }


    public double getMilesToEmpty() { return this.currentGas * this.mpg; }
    public double getMPG() { return this.mpg; }
    public double getMoney() { return this.money; }
    public double getCurrentGas() { return this.currentGas; }
    public double getTankCapacity() { return this.tankCapacity; }
    public double getTotalMiles() { return this.totalMiles; }

    private void setCurrentGas(double currentGas) { this.currentGas = Math.min(Math.max(0, currentGas), this.tankCapacity); }
    private void setTotalMiles(double totalMiles) { this.totalMiles = Math.max(this.totalMiles, totalMiles); }
    private void setMoney(double money) { this.money = Math.min(this.money, money); }
}