package Users;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVUserReader implements UserReader {
    String path;

    public CSVUserReader(String path) {
        this.path = path;
    }

    public User[] read() throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader reader = new BufferedReader(fileReader);
        User[] users = new User[(int) Files.lines(Paths.get(path)).count() - 1];
        reader.readLine();
        for (int i = 0; reader.ready(); i++) {
            String userData = reader.readLine();
            String[] splitUserdata = userData.split("\\|");
            users[i] = new User(Integer.parseInt(splitUserdata[0]), splitUserdata[1], Integer.parseInt(splitUserdata[2]),
                    Integer.parseInt(splitUserdata[3]), Integer.parseInt(splitUserdata[4]),
                    Integer.parseInt(splitUserdata[5]), Integer.parseInt(splitUserdata[6]));
        }
        reader.close();
        return users;
    }
}
