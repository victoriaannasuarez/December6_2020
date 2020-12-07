import javax.swing.*;
import java.util.ArrayList;

public class DivingProgram {
    /*
        Requirements:
        1) Take input (Floating Point Value) from 7 judges
        2) Ensure all 7 inputs are within the acceptable ranges (0-10)
        3) Find and eliminate the highest and lowest values
        4) Add 5 remaining inputs together - Sum
        5) Take input (double/Float) - degree of difficulty
        6) Ensure degree of difficulty is within 1.2-3.8
        7) Multiple the Degree of Difficulty by the sum
        8) Then multiple the product by .6
        9) Display diver's score


     */
    public static void main(String[] args) {

        int number = 1;
        float sum = 0.0f;
        float minNum = Float.MAX_VALUE;
        float maxNum = Float.MIN_VALUE;
        String input = " ";
        ArrayList <Float> scores = new ArrayList<>();
        boolean isInvalid = true;

        while(number<8) {
            input  = JOptionPane.showInputDialog("Input score #" + number + ":");
            Float fNumber = Float.parseFloat(input);
            if(!(checkDiverScores(fNumber))){
                JOptionPane.showMessageDialog(null,"Invalid score, try again!");

            }
            else{
                number++;
                if(fNumber> maxNum){
                    maxNum = fNumber;
                }
                if(fNumber < minNum){
                    minNum = fNumber;
                }
            scores.add(fNumber);
            }
        }

            scores.remove(minNum);
            scores.remove(maxNum);

            for (float f: scores){
                sum += f;
            }
        System.out.println(scores);

            float fDifficulty = 0.0f;

            while(isInvalid) {
                input = JOptionPane.showInputDialog("Input the degree of difficulty: ");
                fDifficulty = Float.parseFloat(input);

                if (!(checkDifficultyInput(fDifficulty))) {
                    JOptionPane.showMessageDialog(null, "Scores must be between 1.2-3.8. Try again.");
                } else {
                    isInvalid = false;
                }
            }


            float diverScore = (float).6 * (sum * fDifficulty);
            String finalScore = String.format("%.2f", diverScore);

            JOptionPane.showMessageDialog(null, "diver score is: " + finalScore +".");




    }

    public static boolean checkDifficultyInput(float number)
    {
        if(number>=1.2 && number <=3.8)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean checkDiverScores (float number){
        if(number<0 || number>10){
            return false;
        }
        else{
            return true;
        }
    }


}