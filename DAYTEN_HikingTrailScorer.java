import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class DAYTEN_HikingTrailScorer {

    public int[][] data = formatFileData(getFileData(file));

    public static void main(String[] args){


    }



    public int evaluateTrails(int startX, int startY, int previous){
        //int totalTrailScore = 0;
        int x = startX;
        int y = startY;
        int currentNumber = data[y][x];
        if(currentNumber == 0) {
            if(y-1 > 0) evaluateTrails(x, y+1, currentNumber);
            if(y+1 < data.length) evaluateTrails(x);
            if(x-1 > 0) evaluateTrails(x-1, y, currentNumber);
            if(x+1 < data[0].length ) evaluateTrails(x+1, y, currentNumber);

        }


    }


    public Array<int> locateAllOneXCoords(String[][] input) {
        Array<int> allXCoords = new Array<int>();
        for(int everyRow = 0; everyRow < input.length; everyRow++ ){
            for(int everyColumn = 0; everyColumn < input[0].length; everyColumn++){
                if(input[everyRow][everyColumn].equals()) {
             }
            }
        }

    }

    public Array<int> locateAllOneXCoords {}


        // turns filedata Array into a 2d list
    public int[][] formatFileData(ArrayList<String> fileData){
        int[][] output = new int[fileData.get(0).length()][fileData.size()];   //intializing list to the dimensions of the string's length and the array's size
        for(int eachRow = 0; eachRow < fileData.size(); eachRow++){    //extracting every value in every line
            String line = fileData.get(eachRow);
            for(int eachColumn = 0; eachColumn<line.length(); eachColumn++){   //extracting every value in every index
                output[eachRow][eachColumn] = Integer.valueOf(line.substring(eachColumn, eachColumn+1));  //each 2d array element will correspond to a string index
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
