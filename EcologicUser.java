package EcologUsers;

import java.util.Arrays;
import java.util.List;

public class EcologicUser {
    public EcologicUser(int number, String name, int[] consumption, int maxConsumption) {
        this.number = number;
        this.name = name;
        this.consumption = consumption;
        this.isEcologic = true;
        for (int i = 0; i < consumption.length; i++) {
            if (consumption[i] > maxConsumption) {
                this.isEcologic = false;
            }
        }
    }

    private int number;
    private String name;
    private int[] consumption;
    private boolean isEcologic;

    public boolean isEcologic() {
        return isEcologic;
    }

    public String toString() {
        StringBuilder consumption = new StringBuilder();
        for (int j : this.consumption) {
            consumption.append(j);
            consumption.append("|");
        }
        return this.number + "|" + this.name + "|" + consumption;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getConsumption() {
        return consumption;
    }

    public void setConsumption(int[] consumption) {
        this.consumption = consumption;
    }
}
