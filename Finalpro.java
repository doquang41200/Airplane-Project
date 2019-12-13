import javax.swing.*;
import java.util.*;
import java.io.*;
public class Finalpro
{
    private static final String PATH ="StateFlightTimes1.csv";
    public static int NUMBER_OF_FLIGHTS = 50;
    private static String[] states = new String[NUMBER_OF_FLIGHTS];
    private static float[] times = new float[NUMBER_OF_FLIGHTS]; 
     
    public static void main(String[] args){
  boolean wrongInput= false;
  String welcome;
  String invalid_input;
  int user_choices=1;
  JFrame frame = new JFrame();
  
  //Scanner in= new Scanner(System.in);

  do{
      wrongInput=false;
        String in1 = JOptionPane.showInputDialog("Welcome To Domestic Flights Planner\n Please input an option from the list\n 1. Log in\n 2. Sign Up\n 3.Plan a flight");
        int user_choice = Integer.valueOf(in1);
        int i = 0;
  for (i=0; i<user_choices; ++i){
    
    switch(user_choice) {
    case 1:
    String logIn= JOptionPane.showInputDialog("Please input a valid username");
    break;
    case 2:
    String signUp= JOptionPane.showInputDialog("Please create a valid username");
    break;
    
    case 3:
    String plan= JOptionPane.showInputDialog("Welcome to the flight selector Please Choose from one of the following:\n 1.Airtime \n 2.Milage\n 3.Tourist Favorites \n 4.Hotels");
    int subChoice= Integer.valueOf(plan);
    
        switch(subChoice){
        case 1:
        //JOptionPane.showMessageDialog(frame, "The following flights are sorted by location.");
            try {
            fileReading();
            System.out.println(states[i]);
            System.out.println(times[i]);
        }
            catch(Exception e){
        
            
            JOptionPane.showMessageDialog(frame, "File could not be read" + e );
        
        }
        break;
        case 2:
        break;
        case 3:
        break;
        case 4:
        break;
        default:
        break;
        }
    break;
    
    default:
    invalid_input=JOptionPane.showInputDialog("Please make a valid input");
    wrongInput=true;
    }
    }
 }while (wrongInput=false) ;
 
}

public static void fileReading() throws Exception{
    FileReader fileReading= new FileReader(PATH);
    BufferedReader reader= new BufferedReader(fileReading);
    reader.readLine();
    
        for (int i= 0; i < 3; i++){
        String starting = reader.readLine();
        if (starting != "WI") {
        String[] vert = starting.split(",");
        states[i] = vert[1];
        times[i]= Float.parseFloat(vert[2]);
        
        }
        }
    
    reader.close();
    fileReading.close();
}
}