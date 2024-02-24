package Users;

public class User {
    public User(int number, String name, int waterConsumption, int gasDay, int gasNight, int electricityDay,
                int electricityNight) {
        this.number = number;
        this.name = name;
        this.waterConsumption = waterConsumption;
        this.gasDayConsumption = gasDay;
        this.gasNightConsumption = gasNight;
        this.electricityDayConsumption = electricityDay;
        this.electricityNightConsumption = electricityNight;
    }

    private final int number;
    private final String name;
    private final int waterConsumption;
    private final int gasDayConsumption;
    private final int gasNightConsumption;
    private final int electricityDayConsumption;
    private final int electricityNightConsumption;


    public boolean isEcologic(int maxConsumption) {
        boolean isEcologic = true;
        if (waterConsumption > maxConsumption || (gasDayConsumption + gasNightConsumption) > maxConsumption ||
                (electricityDayConsumption + electricityNightConsumption) > maxConsumption) {
            isEcologic = false;
        }
        return isEcologic;
    }

    public String toString() {
        return number + "|" + name + "|" + waterConsumption + "|" + gasDayConsumption + "|" + gasNightConsumption + "|"
                + electricityDayConsumption + "|" + electricityNightConsumption;
    }
}
