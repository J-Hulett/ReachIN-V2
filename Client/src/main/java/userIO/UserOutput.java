package userIO;

public class UserOutput {

    public void printMenuSpacer(){
        System.out.println("<------------------------------------------------------------------>");
    }

    public void printHomeMenuOptions(){
        printMenuSpacer();
        System.out.println("<------------- Select An Option From The Menu Below --------------->");
        printMenuSpacer();
        System.out.println("<--Input The Number of Your Selection and Press Enter to Continue-->");
        printMenuSpacer();
        System.out.println("<------ 1 ------ Add new Inventory Item --------------------------->");
        System.out.println("<------ 2 ------ Delete Inventory Item ---------------------------->");
        System.out.println("<------ 3 ------ Show Current Inventory Items --------------------->");
        System.out.println("<------ 4 ------ Update Items ------------------------------------->");
        printMenuSpacer();
    }

    public void closeOutSession(){
        printMenuSpacer();
        printMenuSpacer();
        printMenuSpacer();
        System.out.println("<---------------------Goodbye For Now!!---------------------------->");
        printMenuSpacer();
        printMenuSpacer();
        printMenuSpacer();
        System.exit(1);
    }

}
