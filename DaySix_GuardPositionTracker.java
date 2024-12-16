import javax.net.ssl.HostnameVerifier;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.Guard;
import java.util.*;
public class DaySix_GuardPositionTracker {

   public String[][] data = getFileData(file);    //write file name
    public static int total = 1;
    public static ArrayList<int[]> visitedCoordinates = new ArrayList<int[]>();
    visitedCoordinates.add(findGuardLocation(data));

    public static int guardXCoord = findGuardLocation(data)[0];      //specific cooordinate variables
    public static int guardYCoord = findGuardLocation(data)[1];

    public static int horizontalDirection = 0;    //does not start left nor right   -1: left     1: right
    public static int verticalDirection = 1;     //starts up, -1: down 1:right


    public static void main(String[] args) {
        visitedCoordinates.push(findGuardLocation(data))

    }

    public boolean canMoveforward(){   //method that returns a boolean test case and changes directions accordingly

        boolean condition =  !data[guardYCoord +verticalDirection ][guardXCoord + horizontalDirection].equals("#");  //checking every direction
        condition = condition || !data[guardYCoord +verticalDirection ][guardXCoord + horizontalDirection].equals("#");
        condition = condition || !data[guardYCoord +verticalDirection ][guardXCoord + horizontalDirection].equals("|");
        condition = condition || ( data.length > guardYCoord +verticalDirection || 0 < guardYCoord +verticalDirection);

        if(condition ) {               //if it is a valid move, move the guard by the appropriate left and right direction
            guardYCoord += verticalDirection;
            guardXCoord += horizontalDirection;
            total++;
            int[] newGuardLocation = {guardYCoord, guardXCoord};
            visitedCoordinates.add(newGuardLocation);
        }
        else {
            int tempVar = verticalDirection;
            verticalDirection = -1 * horizontalDirection;
            horizontalDirection = -1 * verticalDirection;

        }
        } //need "|"  and "out of bounds"

        if(!data[guardXCoord +horizontalDirection][guardYCoord].equals("#")) {
            if (horizontalDirection != 0 && verticalDirection == 0) {
                guardXCoord += horizontalDirection;
                total++;
            }
        }
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
