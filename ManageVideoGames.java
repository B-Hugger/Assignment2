package assign2_template;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class ManageVideoGames  {

    public static void main(String[] args) {

        //2.2.2 Application Class - ManageVideoGames
        //create an empty list of VideoGames
      List<VideoGame> games = new LinkedList<>();
        while(true) {         // loop through steps 1, 2, 3 above until user quits
            displayMenu();         //1. display menu
            int choice = getUserChoice();  //2. get user choice then compare user choice
            if (choice == 1) {          //3. take action based on user choice
                addGame(games);
            }
            else if(choice == 2) {
                removeGame(games);
            }
            else if(choice == 3) {
                System.out.println(games.toString());
            }
            else if(choice == 4) {
                latestRelsease(games);
            }
            else if(choice == 5) {
                System.out.println("Error menu choice not implemented yet");
            }
            else {
                break;
            }
        }



    }

    //define other methods for modularization, samples are listed below.
    
    //method to display menu
    public static void displayMenu() {
        //add your code
        //display the menu like the one in Page 5 of Assign2.pdf 
    System.out.print("""
            ****Welcome to Video Game Management Tool!*****   
            ----Menu-------- 
            1. Add a new game 
            2. Remove an existing game 
            3. Display the games in the order they were inserted 
            4. Find games with latest release 
            5. Add a new game in the alphabetical order of game titles
            6. Exit 
            Enter a number to make your selection:
            """);
    }    
    
    //method to get and return the user choice of menu items.
    public static int getUserChoice() {
        //add your code
        Scanner in = new Scanner(System.in);
        // keep reading user input until user enters correct menu choice number,
        String input = in.next();
        while((input.matches("1|2|3|4|5|6" ) == false)) { //utilized regex to test user if user input matches [1,6] then loops if false
            System.out.println("Error invalid input, please enter a value that's between 1-6");
            input = in.next();

        }
        // then return the user choice number
        return Integer.parseInt(input);

    }    
    
    
    //method to get user input, create and return a video game
    public static VideoGame getNewGame() {

        //add your code here
        /*
        get new game based on user input:
        keyboard input
          game title:
             use nextLine() to avoid problems caused by newline character
          platforms: 
             get how-many: int
             then use a loop to get each platform.

          date value: 
            get 3 integers: month, day, year
            use LocaleDate.of(year, month, day) to create a date
            (see TestDate.java for details)
        */
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter game Title: ");
        String GameTitle = in.nextLine();
        System.out.println("\nplease enter name of developer/company: ");
        String developerName = in.nextLine();
        System.out.print("\nplease enter number of available platforms for game: ");
        int platforms = Integer.parseInt(in.next());
        System.out.print("\nplease enter name of available platforms: ");
        String platformName [] = new String [platforms]; //creates empty list with designated number of platforms
        for(int i = 0; i < platforms; i++){ //loops through platforms based on number of platforms given
            platformName[i] = in.next();
        }
        System.out.println("\nPlease enter year, month, and date one by one: ");
        int year = Integer.parseInt(in.next());
        int month = Integer.parseInt(in.next());
        int  day = Integer.parseInt(in.next());
        VideoGame game = new VideoGame(GameTitle,developerName, platformName,LocalDate.of(year,month,day)); //sends all initialized values to game constructor

        return game;
    }     
    
    //method to add a video game without maintaining sorted order
    //add your own code
    public static void addGame(List<VideoGame> game) {
        game.add(getNewGame());
    }
    //method to remove a game based on user input
    //add your own code    
    public static void removeGame(List<VideoGame> game) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the name of the game title that you want to remove: ");
        String title = in.next();
        for(int index = 0; index < game.size(); ++index) {
            if(game.get(index).getTitle().equals(title)) {
                game.remove(index);
                break;
            }
        }
    }
    //method to find the game with latest release date
    //add your own code
    /*
    find game with latest release date
       simple assumption: only one game has the latest release date.
       need to loop through the collection and find the latest release date                                                        (largest)
            while looping, 
               record and update the current latest release date value 
                   and the corresponding VideoGame object.

       compare dates: isBefore, isAfter, or compareTo
          (see TestDate.java for details)
    */
    public static void latestRelsease(List<VideoGame> game) {
        int latestIndex = 0;
        for (int i = 0; i < game.size(); ++i) {
            if (game.get(latestIndex).getReleaseDate().compareTo(game.get(i).getReleaseDate()) < 0) { //comparing game items with other entries in game to see which returns as latest
                latestIndex = i;
            }
        }
        System.out.println(game.get(latestIndex));

    }
    
    //OPTIONAL BONUS:
    //  method to add a video game in alphabetical order of game titles
    //add your own code   
    /*    
     add new game in alphabetical order of game titles
        Do not append the new game to the current collection and then sort the entire collection. 
	Instead,
           start with the first game, 
           loop through the collection and 
               find the first game whose title is alphabetically larger than the new game. 
               Then insert the new game at the location, say [j], of this target.
                  As the result of the insertion, this target will be at [j+1].
           If no existing game title is larger than the new game,
               append the new game to the end of game collection list.     
   */  

    }
