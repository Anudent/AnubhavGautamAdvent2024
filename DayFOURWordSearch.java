import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DayFOURWordSearch {

    String searchTarget = "XMAS";
    String[][] data;

    public static void main(String[] args){



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



    public int checkVertically(int rowLocation, int columnLocation){    //returns at most 2, at least 0
       int occurences =0; // OUTPUT
        int correctSequence = 1;      //will check if this variable matches the length of the target string at the end
        int direction = -1;   //checking "downwards" first

        if(rowLocation + searchTarget.length() < data.length() ) {
            for (int i = 1; i < searchTarget.length(); i++) { //checking for each letter in search target and tracking using a for loop
                String selectedLetter = data[rowLocation + (direction * i)][columnLocation];  //multiplying directions by the number of iterations to accurately locate the next letter
                String targetLetter = searchTarget.substring(i, i + 1);
                if (selectedLetter.equals(targetLetter)) correctSequence++;      //adding to the sum of correctness
            }
            if (correctSequence == searchTarget.length() ) occurences++;    //verifiying conditions
            correctSequence = 0;            //resetting variable
        }

        direction = 1; //switching directions, to the other direction  "upwards"

        if(rowLocation >= searchTarget.length()){      //checking if searching upwards is suitable: compares the string length to current location
            for(int i = 1; i< searchTarget.length(); i++ ){
                String selectedLetter = data[rowLocation + (direction*i) ][columnLocation];       //multiplying directions by the iteriation index to travel the other direction
                String targetLetter = searchTarget.substring(i,i+1);
                if(selectedLetter.equals(targetLetter)) correctSequence++;               //adding to the sum of correctness
            }
            if(correctSequence == searchTarget.length() )) occurences++;
        }

        return occurences;
    }


    public int checkHorizontally(int rowLocation, int columnLocation){    //returns at most 2, at least 0
        int occurences =0; // OUTPUT
        int correctSequence = 1;      //will check if this variable matches the length of the target string at the end
        int direction = -1;   //checking "downwards" first

        if(rowLocation + searchTarget.length() < data.length() ) {
            for (int i = 1; i < searchTarget.length(); i++) { //checking for each letter in search target and tracking using a for loop
                String selectedLetter = data[rowLocation + (direction * i)][columnLocation];  //multiplying directions by the number of iterations to accurately locate the next letter
                String targetLetter = searchTarget.substring(i, i + 1);
                if (selectedLetter.equals(targetLetter)) correctSequence++;      //adding to the sum of correctness
            }
            if (correctSequence == searchTarget.length() ) occurences++;    //verifiying conditions
            correctSequence = 0;            //resetting variable
        }

        direction = 1; //switching directions, to the other direction  "upwards"

        if(rowLocation >= searchTarget.length()){      //checking if searching upwards is suitable: compares the string length to current location
            for(int i = 1; i< searchTarget.length(); i++ ){
                String selectedLetter = data[rowLocation + (direction*i) ][columnLocation];       //multiplying directions by the iteriation index to travel the other direction
                String targetLetter = searchTarget.substring(i,i+1);
                if(selectedLetter.equals(targetLetter)) correctSequence++;               //adding to the sum of correctness
            }
            if(correctSequence == searchTarget.length() )) occurences++;
        }

        return occurences;
    }
    }
    public int checkDiagonally(int rowLocation, int columnLocation){       //returns at most 4, at least 0

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
