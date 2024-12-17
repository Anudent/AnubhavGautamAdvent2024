import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class DAYTEN_HikingTrailScorer {


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
    public static Array<int[]> locateAllZeroCoords(String[][] input) {
        Array<int[]> allCoords = new Array<int[]>();
        for (int everyRow = 0; everyRow < input.length; everyRow++) {
            for (int everyColumn = 0; everyColumn < input[0].length; everyColumn++) {
                if (input[everyRow][everyColumn] == 0) {
                    int[] currentCoord = {everyRow, everyColumn};
                    allCoords.push(currentCoord);
                }
            }
        }
        return allCoords;
    }

    public int[][] data = formatFileData(getFileData("src/file"));

    
    public static FINAL int[] UP = {1,0};
    public static FINAL int[] DOWN = {0,0};
    public static FINAL int[] LEFT = {0,0};
    public static FINAL int[] RIGHT = {0,1};
    public static FINAL int[][] DIRECTIONS = {UP, DOWN, LEFT, RIGHT};

    public static void main(String[] args){
        
        Array<int[]> zeroCoordinates = locateAllZeroCoords(data);
        int answer = processAll(zeroCoordinates, data);
        
        system.out.println(answer);

    }



    public int evaluateTrailDirections(int[] coordinates, int[] direction  ){
        int x = coordinates[1];
        int y = coordinates[0];
        int horizontalDirection = direction[1];
        int verticalDirection = direction[0];
        int total = 0;
        int currentNumber = data[y][x];
        
        if(currentNumber != 9) {
            if( inBoundsAndMoveable(coordinates, direction) {
                
            } 
            
            
            if(y-1 > 0 && data[y-1][x] == currentNumber + 1 ) {
                total += evaluateTrailDirections({y-1, x});
            }
            if( (y+1 < data.length-1 ) && data[y-1][x] == currentNumber + 1 ) evaluateTrails(x, y+1){
                total += evaluateTrailDirections({})
            }
            if(x-1 > 1) evaluateTrails(x-1, y);
            if( (x+1 < data[0].length - 1) && && data[y-1][x] == currentNumber + 1 ){
                total += evaluateTrailDirections()
            }
        }
        else if( currentNumber >= 9){
            return 1;
        }
    }

    public boolean inBoundsAndMoveable(int[] coordinates, int[] direction) {
        int x = coordinates[1];
        int y = coordinates[0];
        int horizontalDirection = direction[1];
        int verticalDirection = direction[0];
        boolean condition = ( 0 < x + horizontalDirection && x + horizontalDirection < data[0].length );
        boolean condition = condition && ( 0 < y + verticalDirection && y + verticalDirection < data[0].length );
        if(condition) {
            condition = condition && data[y+ verticalDirection][ x+horizontalDirection ];
        }
        return condition;
    }

    public int processAll(ArrayList<int[]> zeros, int[][] data){
        int output = 0;
        for(int[] coordinatePair :  zeros){
            output += evaluateTrail(coordinatePair);
        }
        return output;
    }










}
