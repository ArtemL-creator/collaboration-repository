import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Mouse> list = new ArrayList<>();

        Reader fileReader = new FileReader("src\\main\\resources\\data.csv");
        BufferedReader br = new BufferedReader(fileReader);
        br.readLine();

        while (br.ready()) {
            String line = br.readLine();
            list.add(parseMouse(line));
        }

        br.close();
        fileReader.close();

        System.out.println("Given array is ");
        System.out.println(list);

        List<Mouse> sortList = GFG.mergeSort(list);

        System.out.println("Sorted array is ");
        System.out.println(sortList);
    }

    private static Mouse parseMouse(String mouse) {
        String[] mouses = mouse.split("\t");
        return new Mouse(mouses[0], Integer.parseInt(mouses[1]));
    }
}
