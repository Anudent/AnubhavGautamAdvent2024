//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import.java.util.regex.Pattern;
import.java.util.regex.Matcher;
import java.util.*;

import java.util.regex.Pattern;.java.
public class DayTWORegexJava {
    public static void main(String[] args) {



        Array<String> allMatches = new Array<String>(); // Declaring array that contains target values

        String regex = "mul\\([0-9],[1-9]\\)";    //declaring regex
        String searchString = ""; //adding input last
        Matcher ma = Pattern.compile(regex).matcher(searchString);     //declaring
        while(ma.find()) {
            allMatches.add(ma.group());
        }

        int sum = 0;     //declaring the final sum
        for( String expression in allMatches) {   //iterating to calculate the intended value of each expression
            String firstNumber = expression.substring(4,5);
            String secondNumber = expression.substring(6,7);
            int first = Integer.valueOf(firstNumber);
            int second = Integer.valueOf(secondNumber);
            sum += ( first*second );   //adding the product to total sum
        }
        System.out.println(sum);
    }
}