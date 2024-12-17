import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class DaySix_GuardPositionTracker {

    public static String[][] data = formatFileData(getFileData("src/fileData.txt")) ;    //write file name
    public static int total = 1;
    public static ArrayList<int[]> visitedCoordinates = new ArrayList<>();

    public static int guardXCoord = findGuardLocation(data)[0];      //specific cooordinate variables
    public static int guardYCoord = findGuardLocation(data)[1];

    public static int horizontalDirection = 0;    //does not start left nor right   -1: left     1: right
    public static int verticalDirection = 1;     //starts up, -1: down 1


    public static void main(String[] args) {
        visitedCoordinates.add((findGuardLocation(data) ) );       //adding to visited coordinates list
        while (canMoveForward()) {
            moveForward();
        }
        System.out.println("The Guard is out of sight after visiting " + total + " distinct places. ");                          // the loop will end when the guard is off the fileData.txt fileData.txt
    }

    public static boolean canMoveForward() {   //method that returns a boolean true if the guard moved forward
        //  false if the guard moves off the boundaries
        //  the program changes the guards directions accordingly and adds to the total

        boolean condition = (data.length > guardYCoord + verticalDirection && 0 < guardYCoord + verticalDirection);  //if next move isn't outside boundaries vertically
        condition = condition || (data[0].length > guardXCoord + horizontalDirection && 0 < guardXCoord + horizontalDirection);    //if next move isn't outside boundaries horizontally
        if(condition) {       //to prevent OutOfBoundsError, outOfBounds must be checked first.
            condition = condition || !data[guardYCoord + verticalDirection][guardXCoord + horizontalDirection].equals("|"); //if next move isnt a wall
            condition = condition || !data[guardYCoord + verticalDirection][guardXCoord + horizontalDirection].equals("#");    //if next move isn't an obstacle
        }
        return condition;
    }

    public static void moveForward(){
               //if it is a valid move, move the guard by the appropriate left and right direction
            guardYCoord += verticalDirection;
            guardXCoord += horizontalDirection;
            if ( isLocationDistinct( new int[]{guardYCoord, guardXCoord}, visitedCoordinates) ) {
                int[] newGuardLocation = {guardYCoord, guardXCoord};
                visitedCoordinates.add(newGuardLocation);
                total++;
            }

            turnGuard();
    }

    public static void turnGuard(){

        int tempVar = verticalDirection;               //turning 90 degrees right algorithm
        verticalDirection = -1 * horizontalDirection;
        horizontalDirection = tempVar;
    }



    public static boolean isLocationDistinct(int[] coordinates, ArrayList<int[]> currentLocationList){
        for(int[] pair : currentLocationList){
            if(coordinates[0] == pair[0] && coordinates[1] == pair[1] ) {
                return false;
            }
        }
        return true;
    }


    public static int[] findGuardLocation(String[][] input ){     //returns an array of two ints symbolizing a coordinate pair
        int[] output = new int[] { 0, 0 };
        for(int r = 0; r < input.length; r++) {
            for(int c =0; c < input[0].length; c++){
                if( input[r][c].equals("^") ) {
                    output[0] = r;
                    output[1] = c;
                }
            }
        }
        return output;
    }

    public static String[][] formatFileData(ArrayList<String> fileData){
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
