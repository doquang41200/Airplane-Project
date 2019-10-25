//Jenna Lambert, William Eaton, Gabriel Peters, Cody Garthwaite
//Created: 10-22-19 (JCL)
//Modified: 10-23-19 (JCL)
//Modified: 10-24-19 (JCL)
package airplane.midterm;
import java.util.Scanner;
public class AirplaneMidterm {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to American Airlines!");
        //User's First Name
        String firstName = uin("First Name:");
        //User's Middle Initial
        String middleInitial;
        do{
            middleInitial = uin("Middle Initial(if no middle name press enter):");
        }while(middleInitial.length() > 1);
        //User's Last Name
        String lastName = uin("Last Name:");
        //User's Destination
        String destinationCity = uin("Destination City:");
        String destinationState;
        do{
            destinationState = uin("Destination State(2-letter Postal Code):");
        }while(destinationState.length() > 2);
        //User's Class Choice
        int classChoice = 0;
        String strClassChoice;
        do{
            strClassChoice = uin("Class:\n1. First\n2. Economy\n");
            classChoice = tryStrToInt(strClassChoice);
        }while(classChoice < 1 || classChoice > 2);
        String seat;
        switch(classChoice){
            case 1:
                strClassChoice = "First Class";
                seat = firstSeat();
                break;
            case 2:
                strClassChoice = "Economy Class";
                seat = economySeat();
                break;
            default:
                strClassChoice = "Economy Class";
                seat = economySeat();
                break;
        }
        //Military
        System.out.println("Is the flight Military realated?(y/n)");
        String strMilitary = input.nextLine();
        boolean military;
        if (strMilitary.equalsIgnoreCase("y") || strMilitary.equalsIgnoreCase("yes")){
          military = true;
          strMilitary = "Yes";
        }
        else if (strMilitary.equalsIgnoreCase("n") || strMilitary.equalsIgnoreCase("no")){
          military = false;
          strMilitary = "No";
        }
        else{
          military = false;
          strMilitary = "No";
        }
        //Disablity
        System.out.println("Do you have a physical disability?(y/n)");
        String strDisability = input.nextLine();
        boolean disability;
        if (strDisability.equalsIgnoreCase("y") || strDisability.equalsIgnoreCase("yes")){
          disability = true;
          strDisability = "Yes";
        }
        else if (strDisability.equalsIgnoreCase("n") || strDisability.equalsIgnoreCase("no")){
          disability = false;
          strDisability = "No";
        }
        else{
          disability = false;
          strDisability = "No";
        }
        //Print Information
        printAll(lastName, firstName, middleInitial, destinationCity, destinationState, strClassChoice, seat, strMilitary, strDisability);
    }
    public static String uin(String prompt){
        String uin;
        System.out.printf("Input %s ", prompt);
        uin = input.nextLine();
        return uin;
    }
    public static String firstSeat(){
        String strRowNum;
        int rowNum;
        do{
            System.out.println("Select a row: \n3\t4\t5\t6\n");
            strRowNum = input.nextLine();
            rowNum = tryStrToInt(strRowNum);
        }while(rowNum < 3 || rowNum > 6);
        String seatLetter;
        do{
            System.out.println("Select a seat:\nA\tB\tE\tF\n");
            seatLetter = input.nextLine();
        }while(!seatLetter.equalsIgnoreCase("A") && !seatLetter.equalsIgnoreCase("B") && !seatLetter.equalsIgnoreCase("E") && !seatLetter.equalsIgnoreCase("F"));
        String seat = strRowNum+seatLetter;
        return seat;
    }
    public static String economySeat(){
        String strRowNum;
        int rowNum;
        do{
            System.out.println("Select a row between 7 and 33: ");
            strRowNum = input.nextLine();
            rowNum = tryStrToInt(strRowNum);
        }while(rowNum < 7 || rowNum > 33);
        String seatLetter;
        do{
            System.out.println("Select a seat:\nA\tB\tC\tD\tE\tF\n");
            seatLetter = input.nextLine();
        }while(!seatLetter.equalsIgnoreCase("A") && !seatLetter.equalsIgnoreCase("B") && !seatLetter.equalsIgnoreCase("C") && !seatLetter.equalsIgnoreCase("D") && !seatLetter.equalsIgnoreCase("E") && !seatLetter.equalsIgnoreCase("F"));
        String seat = strRowNum+seatLetter;
        return seat;
    }
    public static int tryStrToInt(String strCin){
        int cin = 0;
        try{
            cin = Integer.parseInt(strCin);
        }
        catch(Exception e){
            System.out.println("Invalid Input");
        }
        return cin;
    }
    public static void printAll(String lastName, String firstName, String middleInitial, String destinationCity, String destinationState, String strClassChoice, String seat, String strMilitary, String strDisability){
        System.out.printf("================================================\nFull Name: %s, %s %s\nDestination: %s, %s\nClass Choice: %s\nSeat: %s\nMilitary?: %s\nDisability?: %s\n", lastName, firstName, middleInitial, destinationCity, destinationState, strClassChoice, seat, strMilitary, strDisability);
    }
}