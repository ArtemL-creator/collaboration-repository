import java.util.ArrayList;
import java.util.List;

public class GFG {
    public static List<Mouse> mergeSort(List<Mouse> myList) {
        List<Mouse> mouseList = new ArrayList<>(myList);

        int n = mouseList.size();
        int curSize;
        int leftStart;

        for (curSize = 1; curSize <= n - 1; curSize = 2 * curSize) {
            for (leftStart = 0; leftStart < n - 1; leftStart += 2 * curSize) {
                int mid = Math.min(leftStart + curSize - 1, n - 1);
                int rightEnd = Math.min(leftStart + 2 * curSize - 1, n - 1);

                merge(mouseList, leftStart, mid, rightEnd);
            }
        }
        return mouseList;
    }

    private static void merge(List<Mouse> myList, int l, int m, int r) {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;

        List<Mouse> leftList = new ArrayList<>(myList.subList(l, l + n1));
        List<Mouse> rightList = new ArrayList<>(myList.subList(m + 1, m + 1 + n2));

        i = 0;
        j = 0;
        k = l;

        while (i < n1 && j < n2) {
            if (compareMouse(leftList.get(i), rightList.get(j)) < 0) {
                myList.set(k, leftList.get(i));
                i++;
            } else {
                myList.set(k, rightList.get(j));
                j++;
            }

            k++;
        }

        while (i < n1) {
            myList.set(k, leftList.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            myList.set(k, rightList.get(j));
            j++;
            k++;
        }
    }

    private static int compareMouse(Mouse m1, Mouse m2) {
        return m1.getName().compareTo(m2.getName());
    }
}
