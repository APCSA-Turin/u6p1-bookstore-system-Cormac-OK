package com.example.project;

public class IdGenerate{ //This class contains statics variable and methods, you do not initalize an object to use it.
    
    /**
     * The last Id to be assigned.
     */
    private static String currentId = "99";

    //requires one empty constructor
    private IdGenerate(){}


    public static String getCurrentId() {
        return currentId;
    }

    /**
     * Resets currentId back to 99
     */
    public static void reset(){
        currentId = "99";
    }

    /**
     * Increments currentID by one, and then returns the new value.
     * @return A new unique ID number
     */
    public static String generateID(){ //generates a new id, when called it will increment the currentId by 1.. Hint pay attention to data type of currentId
        currentId = Integer.toString(Integer.parseInt(currentId)+1);
        return currentId;
    }
}