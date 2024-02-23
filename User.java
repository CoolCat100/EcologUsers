package Users;

public class User {
    public User(int number, String name, int waterConsumption, int gasDayConsumption, int gasNightConsumption,
                int electricityDayConsumption, int electricityNightConsumption) {
        this.number = number;
        this.name = name;
        Water water = new Water(waterConsumption);
        resources[0] = water;
        Gas gas = new Gas(gasDayConsumption, gasNightConsumption);
        resources[1] = gas;
        Electricity electricity = new Electricity(electricityDayConsumption, electricityNightConsumption);
        resources[2] = electricity;
    }

    private final int number;
    private final String name;
    private final Resource[] resources = new Resource[3];

    public boolean isEcologic(int maxConsumption) {
        boolean isEcologic = true;
        for (Resource resource : resources) {
            if (resource.getConsumption() > maxConsumption) {
                isEcologic = false;
            }
        }
        return isEcologic;
    }

    public String toString() {
        StringBuilder consumption = new StringBuilder();
        for (Resource j : this.resources) {
            consumption.append(j.getConsumption());
            consumption.append("|");
        }
        return this.number + "|" + this.name + "|" + consumption;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
