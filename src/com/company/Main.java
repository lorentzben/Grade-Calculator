package com.company;


import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        boolean good = false;
        Scanner reading = new Scanner(System.in);
        System.out.println("Would you like to calculate the grade for a section or a course?");
        do
        {
            String choice = "";
            System.out.println("Type S for section or C for course or exit to exit: ");
            choice = reading.nextLine();

            if (choice.equalsIgnoreCase("S"))
            {
                setupSection();

            }
            else if (choice.equalsIgnoreCase("C"))
            {
                setupForCourse();
            }
            else if(choice.equalsIgnoreCase("exit"))
            {
                break;
            }
            else
            {
                System.out.println("That doesn't seem quite right try again");
            }

        }while(good != true);

    }

    private static double calculateGrades (String[] area, double[] parts, double[] grades)
    {
        int length = parts.length;

        double tempGrade = 0.0;
        for(int i = 0; i < length; i++ )
        {
            //String currentArea = area[i];
            //may be added in later when cycling through
            double currentPart = parts[i];
            double currentGrade = grades[i];

            tempGrade = tempGrade + (currentPart*currentGrade);

            tempGrade = tempGrade * 100;
            tempGrade = Math.floor(tempGrade);
            tempGrade = tempGrade/100;

        }


        return tempGrade;
    }

    private static void setupForCourse()
    {
        Scanner reading = new Scanner(System.in);
        double finalGrade = 0.0;
        int count = 0;
        System.out.println("How many areas do you have in this class?: ");
        count = reading.nextInt();

        reading.nextLine();

        String allAreas[] = new String[count];
        double allParts[] = new double[count];
        double allGrades[] = new double[count];
        do
        {
            boolean okayTot = false;
            boolean okayEar = false;
            double totalPct = 1.0;
            double tentVal = 0.0;

            System.out.println("Please input area name " + count + " : ");
            allAreas[count-1] = reading.nextLine();
            double perIn = 0.0;

            do
            {
                System.out.println("Please input the percentage of the total grade of area " + count + " as a decimal: ");
                perIn = reading.nextDouble();

                if(!(perIn <=1 ))
                {
                    okayTot = false;
                }
                else if(perIn != 0) // && total > 0 //)
                {
                  okayTot = true;
                }
            }while(okayTot != true);
            allParts[count-1] = perIn;

            double currentIn = 0.0;
            do
            {
                System.out.println("Please input your current grade in area " + count + " as a decimal: ");
                currentIn = reading.nextDouble();

                if(!(currentIn <=1 ))
                {
                    okayEar = false;
                }
                else if(currentIn != 0) // && total > 0 //)
                {
                    okayEar = true;
                }

            }while(okayEar != true);
            allGrades[count-1] = currentIn;

            count = count -1;

            reading.nextLine();
        }while(count > 0);


        System.out.println("Your Grade is: ");

        finalGrade = calculateGrades(allAreas,allParts,allGrades);
        System.out.println(finalGrade);

    }
    private static void setupSection()
    {
        Scanner reading = new Scanner(System.in);
        int count = 0;
        System.out.println("Please input how many assignments you have: ");
        count = reading.nextInt();

        double[] possiblePts = new double[count];
        double[] earnedPts = new double[count];

        System.out.println("Please input the possible points you are able to earn for each assignment in order, pushing enter after each number: ");
        for(int i = 0; i < count; i++)
        {
            possiblePts[i] = reading.nextDouble();
        }
        System.out.println("Please input the possible points you did earn for each assignment in order, pressing enter after each number: ");
        for(int i = 0; i<count; i++)
        {
            earnedPts[i] = reading.nextDouble();
        }

        System.out.println("Your calculated grade in this section is: " + calcSection(possiblePts,earnedPts));

    }

    private static double calcSection(double[] possible, double[] earned)
    {
        double calculatedValue = 0.0;
        double totalPossible = 0.0;
        double totalEarned = 0.0;

        for(int i = 0; i < possible.length; i++)
        {
            totalPossible = totalPossible + possible[i];
        }

        for(int i = 0; i < earned.length; i++)
        {
            totalEarned = totalEarned + earned[i];
        }

        calculatedValue = totalEarned/totalPossible;

        calculatedValue = calculatedValue * 10000;
        calculatedValue = Math.floor(calculatedValue);
        calculatedValue = calculatedValue/100;

        return calculatedValue;
    }

    /* things I want to do:
        1. pull in names of catagories and store in an array !
        2. pull in percent of whole grade and store in an array !
        3. pull in actual grades and store in an array !
        4. bring all three arrays into a method !
        5. calculate what the value of each catagory is in percentage !
        6. add up all of the catagoires3 !

        7. output the results !

        8. quality control
        9. break into methods
        10. add a counter that prints out a countdown ie 3 areas then 2 then 1
        11. add a counter which counts down from 1.0 to 0.0 as you add percentage divisions

     */

    //public array[j] void subjects()
    //{

    //}
}
