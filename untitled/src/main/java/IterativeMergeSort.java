/* Iterative Java program for merge sort */

import java.util.ArrayList;
import java.util.List;

class GFG {

    static boolean lessIsEqualTo(String s1, String s2) {
        int value;

        value = s1.compareTo(s2);
        if (value <= 0) return true;
        else return false;
    }

    /* Iterative mergesort function to sort myList */
    static void mergeSort(List<Mouse> myList) {
        int n = myList.size();
        int curr_size;
        int left_start;

        for (curr_size = 1; curr_size <= n - 1;
             curr_size = 2 * curr_size) {
            for (left_start = 0; left_start < n - 1;
                 left_start += 2 * curr_size) {
                int mid = Math.min(left_start + curr_size - 1, n - 1);

                int right_end = Math.min(left_start
                        + 2 * curr_size - 1, n - 1);

                merge(myList, left_start, mid, right_end);
            }
        }
    }

    static void merge(List<Mouse> myList, int l, int m, int r) {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;

        ArrayList<Mouse> L = new ArrayList<>();
        for (i = 0; i < n1; i++) {
            L.add(i, myList.get(l + i));
        }

        ArrayList<Mouse> R = new ArrayList<>();
        for (j = 0; j < n2; j++) {
            R.add(j, myList.get(m + 1 + j));
        }

        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2) {
            if (lessIsEqualTo(L.get(i).getName(),R.get(j).getName())) {
                //myList[k] = L[i];
                myList.set(k, L.get(i));
                i++;
            } else {
                myList.set(k,R.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            myList.set(k, L.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            myList.set(k,R.get(j));
            j++;
            k++;
        }
    }

    static void printArray(List<Mouse> A) {
        for (Mouse mouse : A) {
            System.out.println(mouse);
        }
    }

    public static void main(String[] args) {
        Mouse m1 = new Mouse("Dream Machines DM1 Pro S2", 2550);
        Mouse m2 = new Mouse("A4Tech Bloody V7", 1799);
        Mouse m3 = new Mouse("ASUS 90MP02C0-BMUA00", 4319);
        Mouse m4 = new Mouse("Defender Cyber MB-560L", 286);
        Mouse m5 = new Mouse("Acer OMW150", 1349);
        Mouse m6 = new Mouse("Oklick 775G Ice Claw", 449);

        List<Mouse> list = new ArrayList<Mouse>();
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);
        list.add(m6);

        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.printf("Given array is \n");
        printArray(list);

        mergeSort(list);

        System.out.printf("\nSorted array is \n");
        printArray(list);
    }
}
