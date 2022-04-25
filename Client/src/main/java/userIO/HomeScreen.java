package userIO;

public class HomeScreen implements Runnable{

    Thread menuThread;
    UserOutput userOutput;
    UserInput userInput;
    Menu menu = Menu.Home;

    public HomeScreen(){
        this.userOutput = new UserOutput();
        this.userInput = new UserInput();
    }

    public void startMenuThread(){
        menuThread = new Thread(this);
        menuThread.start();
    }

    @Override
    public void run() {
        System.out.println("Thread Started!");
        if (menu == Menu.Home){
            userOutput.printHomeMenuOptions();
            userInput.checkUserInput(userInput.getUserInput(), this.userOutput);
        }
    }
}
