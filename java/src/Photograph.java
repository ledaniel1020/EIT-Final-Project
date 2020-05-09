import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Homework 4
 * Sabrina Baldasssarre, sjb4sy
 *
 * Sources: N/A
 */

public class Photograph implements Comparable<Photograph> {

    //FIELDS 
    /**
     * caption is the photograph's description.
     * filename is the name of the photograph.
     * dateTaken is the the day the photo was taken in the
     * format of YYYY-MM-DD.
     * rating is the value of the photo on a scale of 0-5
     **/

    private String caption; 
    private String filename; 
    private String dateTaken;
    private int rating;
    private File imageFile;


    // CONSTRUCTORS
    public Photograph(String c, String f) { 
        this.caption = c;
        this.filename = f;
        imageFile = new File(filename);
    
    }

    public Photograph(String filename, String caption, String dateTaken, int rating) {
        this.filename = filename;
        this.caption = caption;
        this.dateTaken = dateTaken;
        this.rating = rating;
        imageFile = new File(filename);
   

    }


    // GETTERS 
    public String getCaption() { 
        return this.caption;
    }

    public String getFilename() {
        return this.filename;
    }

    public String getDateTaken() {
        return this.dateTaken;
    }

    public int getRating() {
        return this.rating;
    }

    public File getImageFile() {
        return imageFile;
    }

    // SETTERS
    public void setCaption(String caption) {
        this.caption = caption;
    } 

    public void setRating(int rating) {
        if (rating <= 5 && rating >= 0) {
            this.rating = rating;
        }
    }
    
    public void setImageFile(File imageFile) {
        this.imageFile = imageFile;
    }

    /** 
     * This method checks if object passed through matches 
     * the current Photograph object. If it matches then 
     * param o is casted to that object type.
     * 
     * @param o: the object passed through
     * @return: False is returned if o is null or
     * it is not an instance of Photograph. True is
     * returned if it is an instance of Photograph.
     **/

    public boolean equals(Object o) {   
        if ( o == null) {
            return false;
        }

        if (o instanceof Photograph) {
            Photograph photoCopy = (Photograph) o;
            if (this.caption.equals(photoCopy.caption) && 
                    this.filename.equals(photoCopy.filename)) {
                return true;
            }
            return false;
        }
        return false;
    }


    /**
     * This method generates a String that shows the values of the fields, caption and filename.
     * 
     * @param : none are passed through
     * @return: a String is returned
     **/

    public String toString() {
        return "The caption of this photograph is: " + caption + "."
                + " The filename is: " + filename + ".";
    }
    
    
 /**
  * This method returns a hash code value for the caption and filename.
  * 
  * @return: hash code value
  */
    @Override
    public int hashCode() {
        return (this.caption + "---" + this.filename).hashCode();
    }

    
   
/**
 * This method compares Photograph p with the current Photograph object and returns a value based on the comparison
 * 
 * @param: p of type Photograph
 * @return: an integer. +int if current Photograph object is greater than the param. 0 if they are equal. -int if current Photograph object is lesser
 */
    public int compareTo(Photograph p) {
        int retVal = this.getDateTaken().compareTo(p.getDateTaken());

        if (retVal != 0) {
            return retVal;
        }

        retVal = this.getCaption().compareTo(p.getCaption()); //if retVal == 0, retVal compares caption

        if (retVal != 0) {
            return retVal;
        }
        
        else {
            return 0;
        }

    }

    
    
    // MAIN METHOD FOR TESTING 
    public static void main(String[] args) {
        Photograph p1 = new Photograph("Cute puppy", "Dog");
        Photograph p2 = p1;
        Photograph p3 = new Photograph("So fluffy", "My cat");

        // Tests the equals() method
        System.out.println(p1.equals(p2)); //true
        System.out.println(p1.equals(p3)); // false

        // Tests the toString method
        System.out.println(p1.toString()); 
        System.out.println(p2.toString()); // p1 = p2
        System.out.println(p3.toString());
    }

}

