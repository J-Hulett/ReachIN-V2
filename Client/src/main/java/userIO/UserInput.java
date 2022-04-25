package userIO;

import java.util.Scanner;

public class UserInput {

    Scanner scanner = new Scanner(System.in);

    public String getUserInput() {
        String userSelection = scanner.nextLine();
        return userSelection.trim();
    }

    public void checkUserInput(String userSelection, UserOutput userOutput){

        switch(userSelection){
            case "5" :
                userOutput.closeOutSession();
        }
    }

}
