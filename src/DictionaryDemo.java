import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String,String> oxford = new LinkedHashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/oxford.txt"))) {
            String line = null;

            boolean first =true;
            while ((line = bufferedReader.readLine()) != null) {
                if (first) {
                    first = false;
                } else {
                    if (!line.equals("")) {
                        if ((line.indexOf(' ') != -1)) {
                            String substring = line.substring(0, line.indexOf(' '));
                            String substring1 = line.substring(line.indexOf(' '));

                            oxford.put(substring, substring1);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("So'z kiriting: ");
        String str = scanner.next().toLowerCase();
        for (Map.Entry<String,String> entry : oxford.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (key.toLowerCase().startsWith(str))
                System.out.println(key + value);
        }
    }
}
