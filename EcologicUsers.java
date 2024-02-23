package Users;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class EcologicUsers {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path = getPath(scanner);
        writeEcologicUsers(filterEcologicUsers(readAndCreateUsers(path), getMaxConsumption(scanner)), path);
    }

    public static User[] readAndCreateUsers(String path) throws IOException {
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
    public static User[] filterEcologicUsers(User[] users, int maxConsumption){
        User[] ecologicUsers = new User[users.length];
        for (int i = 0, x = 0; i < ecologicUsers.length; i++) {
            if (users[i].isEcologic(maxConsumption)) {
                ecologicUsers[x] = users[i];
                x++;
            }
        }
        return ecologicUsers;
    }
    public static void writeEcologicUsers(User[] ecologicUsers, String path) throws IOException {
        Path directory = Path.of(path).getParent();
        Path fileNew = Files.createFile(Path.of(directory + "\\\\datanew.csv"));
        FileWriter fileWriter = new FileWriter(String.valueOf(fileNew));
        BufferedWriter writer = new BufferedWriter(fileWriter);
        for (User ecologicUser : ecologicUsers) {
            if (ecologicUser != null) {
                writer.write(ecologicUser.toString() + "\n");
            }
        }
        writer.flush();
        writer.close();
    }

    public static String getPath(Scanner scanner) {
        String path = scanner.nextLine();
        while (!Files.exists(Path.of(path))) {
            path = scanner.nextLine();
        }
        return path;
    }

    public static int getMaxConsumption(Scanner scanner) {
        int maxConsumption = scanner.nextInt();
        return maxConsumption;
    }
}

//D:\programm Test\\data.csv
// входные
// проверка на экологичность
// запись на диск
