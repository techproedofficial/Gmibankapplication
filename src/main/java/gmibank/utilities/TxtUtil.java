package gmibank.utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtUtil {


    public static List<String []> getAllLines () {
        List<String[]> list = new ArrayList<String[]>();
        String fileName = "/Users/ibrahimkalin/IdeaProjects/gmiapplication/data.txt";
        File file = new File(fileName);
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        while (true) {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            //process the line
//            System.out.println(line);
            line = line.replace("|", "");
            String[] eachLine = line.split(",");
            if (line.length() > 0)
                list.add(eachLine);

        }
        return list;
    }

}
