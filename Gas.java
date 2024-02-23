package Users;

public class Gas extends Resource {
    Gas(int dayConsumption, int nightConsumption) {
        this.dayConsumption = dayConsumption;
        this.nightConsumption = nightConsumption;
        consumption = dayConsumption + nightConsumption;
    }
    int dayConsumption;
    int nightConsumption;
    int consumption;
    public int getConsumption() {
        return consumption;
    }
}
