class Bicycle implements OperateBicycle {
    private int speed;

    public Bicycle() {
        speed = 0;
    }

    // a static method that calls on the interface static method
    public static void staticMethod() {
        OperateBicycle.staticMethod();
    }

    // implementing speedUp
    public void speedUp(int increment) {
        System.out.println("Current Speed: " + speed);
        System.out.println("Speed-Up increment by " + increment);
        speed += increment;
        System.out.println("Current Speed: " + speed);
    }

    // implementing applyBrakes
    public void applyBrakes(int decrement) {
        System.out.println("Apply-Brakes decrement by " + decrement);
        speed -= decrement;
        System.out.println("Current Speed: " + speed);
    }

    public int getSpeed() {
        return speed;
    }
}