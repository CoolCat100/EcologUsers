package EcologUsers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {
    Data(List<String> data) {
        this.data = data;
    }

    private List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(Path file) throws IOException {
        this.data = Files.readAllLines(file);
    }

    public static List<String> writeEcologicUsers(EcologicUser[] ecologicUsers) {
        List<String> newData = new ArrayList<>();
        for (int i = 0, a = 0; i < ecologicUsers.length; i++) {
            if (ecologicUsers[i].isEcologic() == true) {
                newData.add(a, ecologicUsers[i].toString());
                a++;
            }
        }
        return newData;
    }
}
