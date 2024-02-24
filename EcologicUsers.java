package Users;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class EcologicUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = getPath(scanner);
        int maxConsumption = getMaxConsumption(scanner);
        UserReader reader = new CSVUserReader(path);
        UserFilter filter = new EcoUserFilter(maxConsumption);
        UserWriter writer = new EcoUserWriter(path);
        User[] inputData = reader.read();
        User[] ecoUsers = filter.filter(inputData);
        writer.write(ecoUsers);
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
