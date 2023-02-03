package assign2_template;

//newer Java API for handling date values
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VideoGame implements Comparable<VideoGame> {

    //2.2.1 Entity Class - VideoGame
    
    private static final int DEFAULT_NUMBER_OF_PLATFORMS = 5;    

    //data fields
    private String title;
    private String developer;     //lead developer 
    private String platforms[];
    private LocalDate releaseDate;

    public String printPlatforms() {
        String plat = "";
        for(int i = 0; i < platforms.length; ++i) {
            plat = " " + plat + platforms[i];
        }
        return plat;
    }
    @Override
    public String toString() {
        //add your code
        //return a string including all infor. about a game
        
        // See examples in: Animal class, Computer class        
        
        // date value included in format: 9/15/2020 for Sep. 15, 2020
        
        //display date values in US format:
        //    Get a DateTimeFormatter object with the specified pattern
        //    Use the DateTimeFormatter object to call format(..) method.         
        
        return "Title: " + title + ", " + "Developer: " + developer + ", " + "Platforms:" + printPlatforms() + ", " + "Release date:" + releaseDate.toString() + "\n"; // format release date and platforms using java methods
    }

   @Override
    public boolean equals(Object otherObject) {
        //add your code
        // comparing two VideoGame objects based only on title
        VideoGame gameObj = (VideoGame) otherObject;  //casting of other object to videogame to access videogame methods
         if(title.compareTo(gameObj.getTitle()) == 0) {
                    return true;
            }
        else {
             return false;
         }
    }
    //see example in DirectoryEntryV2.java in pkg: arraylist

    
    //******The following code don't need to be changed.*****//
    
    //You don't need to change this method.
    //This method is used in adding VideoGame.
    @Override 
    public int compareTo(VideoGame other) {
        return this.title.compareTo(other.title);
    }   
    
    //no-argument constructor
    public VideoGame() {
        platforms = new String[DEFAULT_NUMBER_OF_PLATFORMS];
    }    
    
    //constructor taking in values for all data fields
    public VideoGame(String title, String developer, String[] platforms, LocalDate releaseDate) {
        this.title = title;
        this.developer = developer;
        this.platforms = platforms;
        this.releaseDate = releaseDate;
    }

    //getters
    public String getTitle() {
        return title;
    }

    public String getDeveloper() {
        return developer;
    }

    public String[] getPlatforms() {
        return platforms;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    //setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public void setPlatforms(String[] platforms) {
        this.platforms = platforms;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }    
}
