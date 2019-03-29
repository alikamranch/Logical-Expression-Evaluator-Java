package assignment_1;


public class EquationVariables {

    private boolean state;
    private char name;
    private int sigBit;

    /**
     * Stores variables with a name and a binary state (1 or 0)
     * parameter theName is the name of the variable
     * parameter theState is the current binary state of the variable
     * parameter significantBit helps with constructing the truth table in the TruthTableGUI class
     */
    public EquationVariables(char theName, boolean theState, int significantBit){
        name = theName;
        state = theState;
        sigBit = significantBit;
    }

    /** Returns the binary state */
    public boolean getState(){
        return state;
    }

    /** Returns the significant bit */
    public int getSigBit(){
        return sigBit;
    }

    /** Returns the name */
    public char getName(){
        return name;
    }

    /**
     * If state = 1, set state = 0
     */
    public void setState(){
        state = !state;

    }

    /**
     * Returns a String representation of the variable name, which is a Character
     */
    @Override
    public String toString(){
        return Character.toString(name);
    }

}

