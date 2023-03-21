package com.secondtask;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Для перетаскивания файлов");
        jFrame.setSize(600, 400);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setLayout(new BorderLayout());

        JLabel wordCount = new JLabel("Перетащите текстовый файл куда-то сюда");

        DropTarget dragTarget = new DropTarget(jFrame, new DropTargetListener() {
            @Override
            public void dragEnter(DropTargetDragEvent dtde) {
                Transferable t = dtde.getTransferable();
                if (t.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                    try {
                        Object td = t.getTransferData(DataFlavor.javaFileListFlavor);
                        if (td instanceof List) {
                            for (Object value : ((List) td)) {
                                if (value instanceof File) {
                                    File file = (File) value;
                                    String name = file.toString();
                                    if (name.contains(".txt")) {
                                        wordCount.setText("Количество в файле " + file.getName()
                                                + " слов составляет " + countWords(name));
                                    } else {
                                        wordCount.setText("Неправильный формат (не .txt) ");
                                    }

                                }
                            }
                        }
                    } catch (IOException | UnsupportedFlavorException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            @Override
            public void dragOver(DropTargetDragEvent dtde) {
            }

            @Override
            public void dropActionChanged(DropTargetDragEvent dtde) {
            }

            @Override
            public void dragExit(DropTargetEvent dte) {
            }

            @Override
            public void drop(DropTargetDropEvent dtde) {
            }
        });

        jFrame.add(wordCount, BorderLayout.WEST);
    }

    private static int countWords(String filePath) throws IOException {
        File file = new File(filePath);
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
        return count;
    }
}
