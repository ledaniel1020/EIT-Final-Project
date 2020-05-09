import java.util.ArrayList;
/**
 * Homework 4
 * Sabrina Baldasssarre, sjb4sy
 *
 * Sources: N/A
 */

public class Album extends PhotographContainer {

    // FIELDS 
    /**
     * name is the photo album's name
     * photos is the list of photos in the album
     **/
//
//    private String name;
//    private ArrayList<Photograph> photos;


    // CONSTRUCTOR
    public Album(String n) {
        super(n);
        this.photos = new ArrayList<>();
    }


    // GETTERS
//    public String getName() {
//        return this.name;  
//    }

//    public ArrayList<Photograph> getPhotos() {
//        return this.photos;
//    }


//    // SETTERS
//    public void setName(String name) {
//        this.name = name;
//    }



//    /**
//     * This method checks if p is of type Photograph and then adds it to the list of photos if 
//     * its not already in it.
//     * @param p: The Photograph being passed through
//     * @return: True if it added, false if it is already in the photo list
//     */
//    public boolean addPhoto(Photograph p) {
//        if (p == null) {
//            return false;
//        }
//        if (this.photos.contains(p)) {
//            return false;
//        }
//        else {
//            this.photos.add(p);
//            return true; 
//        }
//    }

//    /**
//     * This method checks if the list of photos contains the photograph in the parameter.
//     * @param p: The Photograph being passed through
//     * @return: True if it is in the photos, false if it is not.
//     */
//    public boolean hasPhoto(Photograph p) {
//        if (this.photos.contains(p)) {
//            return true;
//        }
//        else {
//            return false;
//        }
//    }

//    /**
//     * This method will remove the photograph from the list of photos if it is found within
//     * the photo list.
//     * @param p: the Photograph being passed through
//     * @return: True if the photo is removed and false if it not removed/found.
//     */
//    public boolean removePhoto(Photograph p) {
//        if (this.photos.contains(p)) {
//            this.photos.remove(p);
//            return true;
//        }
//        else {
//            return false;
//        }
//    }

//    /**
//     * This method returns the number of photos in the list.
//     * @return: The size of the photo list.
//     */
//    public int numPhotographs() {
//        return this.photos.size();
//    }


//    /**
//     * This is an equals method that checks if the object being passed through is 
//     * an of type Album. If it is, then it checks if the name values are equivalent.
//     * @param: an object
//     * @return: False if the object is null or not of type Album, true if the names are
//     * equivalent
//     */
//    public boolean equals(Object o) {
//        if (o == null) {
//            return false; 
//        }
//        if (o instanceof Album) {
//            Album albumName = (Album) o;
//            if (this.name.equals(albumName.getName())) {
//                return true;
//            }
//        }
//        return false;
//    }

//    /**
//     * This toString method generates a string that has the name of the album and then
//     * a list of the photo's filenames.
//     * @return: a String
//     */
//
//    public String toString() {
//        return "Album name: " + name + "\n" +
//                "Photo's filenames: " + photos;
//    }
 }