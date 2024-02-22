package EcologUsers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static EcologUsers.Data.writeEcologicUsers;

public class EcologicUsers {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path = getPath(scanner);
        int maxConsumption = getmaxConsumption(scanner);
        Path file = Path.of(path);
        Data inputData = new Data(Files.readAllLines(file));
        String heading = inputData.getData().getFirst();
        Data outputData = new Data(writeEcologicUsers((createUsers(inputData, maxConsumption))));
        DataWriter.writeData(path, outputData, heading);
    }

    public static EcologicUser[] createUsers(Data data, int maxConsumption) {
        String[] line;
        EcologicUser[] ecologicUsers = new EcologicUser[data.getData().size() - 1];
        System.out.println(ecologicUsers.length);
        for (int i = 1; i < data.getData().size(); i++) {
            line = data.getData().get(i).split("\\|");
            String[] buffer = Arrays.copyOfRange(line, 2, line.length);
            int[] consumption = new int[buffer.length];
            for (int a = 0; a < buffer.length; a++) {
                consumption[a] = Integer.parseInt(buffer[a]);
            }
            ecologicUsers[i - 1] = new EcologicUser(Integer.parseInt(line[0]), line[1], consumption, maxConsumption);
        }
        return ecologicUsers;
    }

    public static String getPath(Scanner scanner) {
        String path = scanner.nextLine();
        while (!Files.exists(Path.of(path))) {
            path = scanner.nextLine();
        }
        return path;
    }

    public static int getmaxConsumption(Scanner scanner) {
        int maxConsumption = scanner.nextInt();
        return maxConsumption;
    }
}

//D:\programm Test\\data.csv
// входные
// проверка на экологичность
// запись на диск
