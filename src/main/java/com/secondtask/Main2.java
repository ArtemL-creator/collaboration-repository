package com.secondtask;

import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        File file = new File("src\\main\\resources\\text.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int count = 0;
        while (reader.ready()) {
            boolean flag = true;
            for (char symbol : reader.readLine().toCharArray()) {
                if (symbol != ' ' && flag) {
                    count++;
                    flag = false;
                } else if (symbol == ' '){
                    flag = true;
                }

            }
        }
        reader.close();
        System.out.println(count);
    }
}
