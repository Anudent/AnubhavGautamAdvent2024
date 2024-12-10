import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class Template {


    public static void main(String[] args){


    }


    // turns filedata Array into a 2d list
    public String[][] formatFileData(ArrayList<String> fileData){
        String[][] output = new String[fileData.get(0).length()][fileData.size()];   //intializing list to the dimensions of the string's length and the array's size
        for(int eachRow = 0; eachRow < fileData.size(); eachRow++){    //extracting every value in every line
            String line = fileData.get(eachRow);
            for(int eachColumn = 0; eachColumn<line.length(); eachColumn++){   //extracting every value in every index
                output[eachRow][eachColumn] = line.substring(eachColumn, eachColumn+1);  //each 2d array element will correspond to a string index
            }
        }
        return output;
    }


    public static ArrayList<String> getFileData(String fileName) {            //retrieving file information as an arrrayList where each element is a line of text
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
