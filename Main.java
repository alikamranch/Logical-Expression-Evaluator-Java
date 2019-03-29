package assignment_1;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static ArrayList<EquationVariables> variableArray = new ArrayList<>();
    static ArrayList<Object> equationArray = new ArrayList<>();

    /**
     * The program starts here. The main method parses a String user input./ Yahan se shuru hou ga program
     * Letters are stored in EquationVariables, and other characters are stored as Characters/ Letter aik generic arraylist mein store hon gay jis ki type EquationVariables hai, baaqi sadha characters ki tarhan store hon gay
     * EquationVariables are placed in a variable array; duplicate letters are only added once/ EquationVariables aik variable array mein hain or duplicate letters aik hi dafa add hon gay
     * Everything is placed in an Equation array/ Aik saadhi arraylist mein EquationVariables ke objects or saray characters ikhattay dal rahay hain
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Reads in the equation and creates variables for all letters

        System.out.println("Please note the following");
        System.out.println("\n& for 'and' ");
        System.out.println("| for 'or' ");
        System.out.println("~ for 'not' ");
        System.out.println("> for 'conditional' ");
        System.out.println("= for 'biconditional' ");
        System.out.println("# for 'exclusive-or' ");
        System.out.println("\nNote: spaces and capitalization do not matter");
        System.out.println("\nEnter the Logical Expression:");

        String equation = input.nextLine();
        //removes round brackets, spaces and upper-case letters from the user input
        equation = equation.replaceAll("[()]", "");
        equation = equation.replaceAll(" ", "");
        equation = equation.toLowerCase();
        int counter = 1;
        //loops through the equation and stores all characters between a and z in a variable array.
        for (int i = 0; i < equation.length();i++){
            if (equation.charAt(i)>='a' && equation.charAt(i)<='z') {
                boolean alreadyExists = false;
                EquationVariables temp = new EquationVariables(equation.charAt(i),true, counter);

                //checks for duplicate letters and doesn't add them to the array twice
                for (EquationVariables v : variableArray){
                    if (v.getName()==temp.getName()){
                        alreadyExists = true;
                        temp = v;
                    }
                }
                if (!alreadyExists){
                    variableArray.add(temp);
                    //doubles the significant bit for each variable that is added, iss tarhan brackets ki zaroorat nai parti,
                    // or table bantay huay variables ki truth values generate hou jaati hain,
                    // jesay agar p,q,r hain tou r ki truth values mein 4 false and 4 true, q ke 2 false 2 true or p ke 1 false 1 true repeat hon gay
                    //First variable has 1, second has 2, third has 4, and so on
                    counter = counter*2;
                }

                //stores the variable objects that are created in an equation array as well
                equationArray.add(temp);
            }else{
                //any non-letter characters get stored in an equation array
                equationArray.add(equation.charAt(i));
            }
        }
        input.close();

        if (variableArray.size() > 0){
            //Creates an instance of the truth table class with the proper parameters
            TruthTableGUI table = new TruthTableGUI(variableArray, equationArray);
            table.constructTable();
        }else{
            System.out.println("No variables found");
        }
    }

}

