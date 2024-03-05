public class Droid {
    private int batteryLevel;
    private String name;

    public Droid(String droidName) {
        this.name = droidName;
        this.batteryLevel = 100;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBattery(int batteryLevel) {
        if (batteryLevel >= 0 && batteryLevel <= 100) {
            this.batteryLevel = batteryLevel;
        }
    }

    public String getName() {
        return name;
    }

    public int getBattery() {
        return batteryLevel;
    }

    @Override
    public String toString() {
        return "Hello, I'm the droid: " + name + ", Battery Level: " + batteryLevel + "%";
    }

    public void performTask(String task) {
        System.out.println(name + " is performing task: " + task);
        setBattery(batteryLevel - 10);
    }

    public void energyReport() {
        System.out.println(name + "'s current battery level = " + batteryLevel + "%");
    }

    public void energyTransfer(Droid other) {
        int transferAmount = 10;
        if (this.batteryLevel >= transferAmount && other.batteryLevel + transferAmount <= 100) {
            this.batteryLevel -= transferAmount;
            other.batteryLevel += transferAmount;
            System.out.println("Energy transferred: 10% from " + this.name + " to " + other.name);
        }
    }

    public static void main(String[] args) {
        Droid codey = new Droid("Codey");
        Droid codey2 = new Droid("Codey 2.0");

        System.out.println(codey);
        System.out.println(codey2);

        codey.performTask("Clean the house");
        codey2.performTask("Cook a meal");

        codey.energyReport();
        codey2.energyReport();

        codey.energyTransfer(codey2);

        codey.energyReport();
        codey2.energyReport();
    }
}
