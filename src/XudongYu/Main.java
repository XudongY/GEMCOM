package XudongYu;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.BufferedReader;
import java.io.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        HashMap<String, Integer> map = new HashMap<>();
        map.put("INDI", 0);
        map.put("NAME", 1);
        map.put("SEX", 1);
        map.put("BIRT", 1);
        map.put("DEAT", 1);
        map.put("FAMC", 1);
        map.put("FAMS", 1);
        map.put("FAM", 0);
        map.put("MARR", 1);
        map.put("HUSB", 1);
        map.put("WIFE", 1);
        map.put("CHIL", 1);
        map.put("DIV", 0);
        map.put("DATA", 2);
        map.put("HEAD", 0);
        map.put("TRLR", 0);
        map.put("NOTE", 0);

        BufferedReader reader = null;
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnVale = jfc.showOpenDialog(null);
        File file = null;
        if (returnVale == JFileChooser.APPROVE_OPTION) {
            file = jfc.getSelectedFile();
            //System.out.println(file.getAbsoluteFile());
        }
        reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine())!= null) {
            System.out.println("-->" + line);

            String[] arr = line.split(" ");
            int len = arr.length - 1;
            System.out.print("<--");
            if (arr[0].equals("0") && map.containsKey(arr[len])) {
                System.out.println(arr[0] + " " + arr[len] + "|Y|" + arr[1]);
            } else if (map.containsKey(arr[1])) {
                for (int i = 0; i <= len; ++i) {
                    if (map.containsKey(arr[i])) {
                        System.out.print(arr[i] + "|Y|");
                    } else {
                        System.out.print(arr[i] + " ");
                    }
                }
                System.out.print("\r\n");
            } else {
                for (int i = 0; i <= len; ++i) {
                    if (i == 1) {
                        System.out.print((arr[i] + "N"));
                    } else {
                        System.out.print(arr[i] + " ");
                    }
                }
                System.out.print("\r\n");
            }


                /*System.out.print("<--");
                /*for (int i = 0; i < arr.length; ++i) {
                    if (map.containsKey(arr[i])) {
                        System.out.print(arr[i] + "|Y|");
                    } else {
                        System.out.print(arr[i] + " ");
                    }
                }
            System.out.print("\r\n");*/
        }

    }
}
