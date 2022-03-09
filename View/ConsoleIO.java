package edu.neumont.oop.View;

import java.util.Scanner;

public class ConsoleIO {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Gets the trimmed <code>String</code> version of the user's last input.
     * @return <code>String</code> of the user's last input
     */
    public String getString(){
        return scanner.nextLine().trim();
    }

    /**
     * Gets the <code>int</code> value of the user's last input
     * @param prompt <code>String</code> to parse
     * @return <code>int</code> value of the user's last input
     */
    public int getInt(String prompt){
        return Integer.parseInt(prompt);
    }

    /**
     * Takes a minimum and maximum value to check if the user's last input falls between the two values.
     * @param minGoodValue Minimum value the user needed to input
     * @param maxGoodValue Maximum value the user needed to input
     * @return <code>String</code> containing the user's input if it was good or an error message if the input was bad.
     */
    public String checkIntInput(int minGoodValue, int maxGoodValue){
        int userInput;
        try{
            userInput = getInt(getString());
            if(userInput < minGoodValue || userInput > maxGoodValue){
                return "Input must between " + minGoodValue + " and " + maxGoodValue;
            }

        }catch(NumberFormatException nfe){
            return "Input must be a number";
        }
        return "" + userInput;
    }

    public int[] getAlphaNumericCoords(String prompt, char minLetter, char maxLetter, char minNum, char maxSingleNum, String maxMultiNum, boolean isXNumeric){ //This is far too specific. Either generalize for Checkers and Battleship or make View classes for each game.
        //how to account for double digits or greater?
        int[] targetPosition = new int[] {-1,-1}; //always store in form (xPos, yPos) - (equivalent to column, row)
        while(targetPosition[0] == -1) {
            printMessage(prompt);
            String targetStr = getString();
            if (targetStr == null || targetStr.trim().isEmpty()) {
                printMessage("Target string cannot be null, empty, or all whitespaces.");
            } else {
                char targetLetter = targetStr.toLowerCase().trim().charAt(0);
                String targetNumberStr = targetStr.trim().substring(1);
                //Check to make sure there is a number in the string
                if ((!targetNumberStr.equals(maxMultiNum) && targetNumberStr.length() > 1) || targetNumberStr.charAt(0) < minNum || targetNumberStr.charAt(0) > maxSingleNum || (targetLetter < minLetter || targetLetter > maxLetter)) {
                    printMessage("Invalid target string. Must only contain a letter" + minLetter +  "-" + maxLetter + " and a number"+ minNum + "-" + (maxMultiNum.isEmpty() ? maxSingleNum : maxMultiNum));
                } else {
                    char letterNum = (char) (targetLetter - 49);
                    targetPosition[0] = isXNumeric ? (Integer.parseInt(targetNumberStr) - 1) : Integer.parseInt("" + letterNum);
                    targetPosition[1] = isXNumeric ? Integer.parseInt("" + letterNum) : (Integer.parseInt(targetNumberStr) - 1);
                }
            }
        }

        return targetPosition;
    }

    /**
     * Prints a message to the Console for the user to view.
     * @param message <code>String</code> for the user to view.
     */
    public void printMessage(String message){
        System.out.print(message);
    }
}
