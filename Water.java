package Users;

public class Water extends Resource {
    Water(int consumption) {
        this.consumption = consumption;
    }
    private int consumption;

    @Override
    public int getConsumption() {
        return consumption;
    }
}
