import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class DayFive_PositionTracker {
    public static void main(String[] args) {
        String[][] data = getFileData(file);    //write file name
        int total = 1;
        int[] guardCoord = findGuardLocation(data);





    }

    /*
    recursive method

    public static moveForward(int[] guardLocation){
        while

    }
    */
    public static boolean canMoveforward(int[] coordinates, String direction ){
        int x = coordinates[0];
        int y = coordinates[1];

        switch(direction)
            case'n'
                break;
            case's'
                break;
        }
        if(data[x][y+1].equals("#") ) return false;
        else return true;
    }

    public static int[] moveGuard(int[]coordinates, boolean canMoveForward(int[] coordinates)){

    }

    public static void rotate

    public static int[] findGuardLocation(String[][] input ){     //returns an array of two ints symbolizing a coordinate pair
        int[] output = new int[2];
        for(int r = 0; r < input.length; r++) {
            for(int c =0; c <input[0].length(); c++){
                if( input[r][c].equals("^") ) output[0] = c; output[1] = r;
            }
        }
        return output;
    }

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
