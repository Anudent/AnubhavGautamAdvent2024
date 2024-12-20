import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class DAYTEN_HikingTrailScorer {


    public int[][] data = formatFileData(getFileData("src/file.txt"));

    final public static  int[] UP = {1,0};
    final public static int[] DOWN = {0,0};
    final public static  int[] LEFT = {0,0};
    final public static int[] RIGHT = {0,1};
    final public static  int[][] DIRECTIONS = {UP, DOWN, LEFT, RIGHT};


    public static void main(String[] args){

        ArrayList<int[]> zeroCoordinates = locateAllZeroCoords(data);
        int answer = processAll(zeroCoordinates, data);

        System.out.println(answer);

    }



    public int evaluateTrail(int[] coordinates, int[][] directions  ) {

        int x = coordinates[1];
        int y = coordinates[0];
        int total = 0;
        int currentNumber = data[y][x];
        for (int[] direction : directions) {



            int horizontalDirection = direction[1];
            int verticalDirection = direction[0];
            int nextXCoordinate = x + horizontalDirection;
            int nextYCoordinate = y + verticalDirection;

            if (inBounds(new int[]{}, direction) ) {

                nextNumber = data[nextYCoordinate][nextXCoordinate];
                if( currentNumber ==8) {
                    total += evaluateTrail(direction, directions);
                }

                if (nextNumber == currentNumber + 1) {
                    evaluateTrail(new int[]{nextYCoordinate, nextXCoordinate}, directions);
                }
            } else if (next == 9) {
                return 1;
            } else return 0;
        }
    }
    
    public boolean inBounds(int[] coordinates, int[] directions) {
        int x = coordinates[1];
        int y = coordinates[0];
        int horizontalDirection = direction[1];
        int verticalDirection = direction[0];
        int nextXCoordinate = x + horizontalDirection;
        int nextYCoordinate = y + verticalDirection;
        boolean condition = (0 < nextXCoordinate && nextXCoordinate < data[0].length);
        condition = condition && (0 < nextYCoordinate && nextYCoordinate < data[0].length);

        return condition;

    }
        for(int[] direction : directions){

            int x = coordinates[1];
            int y = coordinates[0];
            int horizontalDirection = direction[1];
            int verticalDirection = direction[0];
            int nextXCoordinate = x + horizontalDirection;
            int nextYCoordinate = y + verticalDirection;



        }


    }

    public int processAll(ArrayList<int[]> zeros, int[][] data){
        int output = 0;
        for(int[] coordinatePair :  zeros){

            evaluateTrailDirection(coordinatePair, );
        }
        return output;
    }





    // turns filedata Array into a 2d list
    public static int[][] formatFileData(ArrayList<String> fileData){
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

    //returns all coordinates in the data array that start with 0  in int[] pair
    public static ArrayList<int[]> locateAllZeroCoords(int[][] input) {
        ArrayList<int[]> allCoords = new ArrayList<int[]>();
        for (int everyRow = 0; everyRow < input.length; everyRow++) {
            for (int everyColumn = 0; everyColumn < input[0].length; everyColumn++) {
                if (input[everyRow][everyColumn] == 0) {
                    int[] currentCoord = {everyRow, everyColumn};
                    allCoords.add(currentCoord);
                }
            }
        }
        return allCoords;
    }











}
