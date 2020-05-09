/**
 * Homework 4
 *  Sabrina Baldassarre, sjb4sy 
 * Sources: N/A
 */
import java.util.*;



public class PhotoLibrary extends PhotographContainer {

    // FIELDS
    /**
     * Name is the name of the person. 
     * ID is the person's ID. 
     * Photos is the list (caption and filename) of photos the person has taken.
     **/
//    private String name;
    private int id;
//    private ArrayList<Photograph> photos;
    private HashSet<Album> albums;



    // CONSTRUCTOR
    public PhotoLibrary (String n, int i) {
        super(n);
        this.id = i;
        this.photos = new ArrayList<Photograph>();
        this.albums = new HashSet<Album>();
    }



    // GETTERS
//    public String getName() {
//        return this.name;
//    }

    public int getId() {
        return this.id;
    }

//    public ArrayList<Photograph> getPhotos() {
//        return photos;
//    }

    public HashSet<Album> getAlbums() {
        return albums;
    }


    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhotos(ArrayList<Photograph> photos) {
        this.photos = photos;
    }



//    /**
//     * This method will return an ArrayList of photos that have a rating greater
//     * or equal to the parameter as long as the parameter is within bounds.
//     * @param: the rating the photos will be compared to
//     * @return: Null will be returned if the param is greater than 5 or less than 0
//     * or will return an ArrayList of photos that have the correct rating.
//     */
//    public ArrayList<Photograph> getPhotos(int rating) {
//        ArrayList<Photograph> correctRating = new ArrayList<Photograph>();
//        if ((rating > 5) || (rating < 0)) {
//            return null;
//        }
//        for (Photograph photo : photos) {
//            if (photo.getRating() >= rating) {
//                correctRating.add(photo);
//            }
//
//        }
//        return correctRating;
//    }

//    /**
//     * This method will return a list of photos that fall under 
//     * the given year.
//     * @param: a specific year
//     * @return: Null will be returned if the format of the year is 
//     * incorrect. Otherwise, it will return an ArrayList of photos
//     * that fall under that year. Otherwise, an empty ArrayList will
//     * be returned if no photos were taken during that time.
//     */
//    public ArrayList<Photograph> getPhotosInYear(int year) {
//        ArrayList<Photograph> correctYear = new ArrayList<Photograph>();
//        for (Photograph photo : photos) {
//            String date = photo.getDateTaken().substring(0,4);
//            int intDate = Integer.parseInt(date);
//            if (intDate == year) {
//                correctYear.add(photo);
//            }
//
//            if ((Integer.toString(year).length() != 4)) {
//                return null;
//            }
//        }
//        return correctYear;
//    }


//    /**
//     * This method will return a list of photos that were taken
//     * in a certain year in a certain month
//     * @param month: the month the photos were taken
//     * @param year: the year the photos were taken
//     * @return: Null will be returned if the formatting is incorrect.
//     * Otherwise, it will return an ArrayList of photos taken within that
//     * month and year. Or, an empty array list will be returned 
//     * (assuming no photos were taken during that time)
//     */
//    public ArrayList<Photograph> getPhotosInMonth (int month, int year) {
//        ArrayList<Photograph> correctMonth = new ArrayList<Photograph>();
//        String strYear = Integer.toString(year);
//        String strMonth = Integer.toString(month);
//
//        if( strYear.length()!= 4 || strMonth.length() > 2 || month < 1 || month > 12) {
//            return null;
//        }
//
//        for (Photograph photo : photos) {
//            String dateYear = photo.getDateTaken().substring(0,4);
//            String dateMonth = photo.getDateTaken().substring(5,7);
//            int intYear = Integer.parseInt(dateYear);
//            int intMonth = Integer.parseInt(dateMonth);
//
//            if (intYear == year && intMonth == month) {
//                correctMonth.add(photo);
//            }
//        }
//        return correctMonth;
//    }
//

//    /**
//     * This method will return a list of photos taken between
//     * a given time period.
//     * @param beginDate: The starting date of when the photos
//     * should have been taken.
//     * @param endDate: The ending date of when the photos could have
//     * been taken.
//     * @return: Null will be returned if the format of the dates
//     * are wrong in any way or if the beginDate is after the endDate.
//     * An ArrayList will be returned of pictures taken during the
//     * given time frame. Otherwise, if no photos were taken then
//     * an empty ArrayList will be returned.
//     */
//    public ArrayList<Photograph> getPhotosBetween(String beginDate, String endDate) {
//        ArrayList<Photograph> photosBetween = new ArrayList<Photograph>();
//        
//        if ((beginDate.length() != 10) || (endDate.length() != 10)) {
//            return null;
//        }
//
//        int beginYear = Integer.parseInt(beginDate.substring(0,4));
//        int beginMonth = Integer.parseInt(beginDate.substring(5,7));
//        int beginDay = Integer.parseInt(beginDate.substring(8));
//
//        int endYear = Integer.parseInt(endDate.substring(0,4));
//        int endMonth = Integer.parseInt(endDate.substring(5,7));
//        int endDay = Integer.parseInt(endDate.substring(8));
//
//        
//        if ((beginMonth < 1 || beginMonth > 12) || 
//                (beginDay < 1 || beginDay > 31) ||
//                (endMonth < 1 || endMonth > 12) ||
//                (endDay < 1 || endDay > 31)) {
//            return null;
//        }
//
//        LocalDate beginningDate = LocalDate.of(beginYear, beginMonth, beginDay);
//        LocalDate endingDate = LocalDate.of(endYear, endMonth, endDay);
//        
//        if (beginningDate.isAfter(endingDate)) {
//            return null;
//        }
//
////        if ((beginDate.substring(0,4).length() != 4) || // redudant code that 
////                (beginDate.substring(5,7).length() != 2) || // im not entirely sure even
////                (beginDate.substring(8).length() != 2) || //works but I kept it in case
////                (endDate.substring(0,4).length() != 4) || // to account for all possibilites.
////                (endDate.substring(5,7).length() != 2) ||
////                (endDate.substring(8).length() != 2)) {
////            return null;
////        }
//
//        for (Photograph photo : this.photos) {
//            int yearPhotoTaken = Integer.parseInt(photo.getDateTaken().substring(0,4));
//            int monthPhotoTaken = Integer.parseInt(photo.getDateTaken().substring(5,7));
//            int dayPhotoTaken = Integer.parseInt(photo.getDateTaken().substring(8));
//
//            LocalDate dateTaken = LocalDate.of(yearPhotoTaken, monthPhotoTaken, dayPhotoTaken);
//
//            if ((dateTaken.equals(beginningDate)) ||
//                    (dateTaken.equals(endingDate))) {
//                photosBetween.add(photo);
//            }
//            if ((dateTaken.isBefore(endingDate)) &&
//                    (dateTaken.isAfter(beginningDate))) {
//                photosBetween.add(photo);
//            }
//        }
//        return photosBetween;   
//    }


    /**
     * This method creates a photo album if it does not
     * already exist
     * @param albumName: The name of the photo album being looked for
     * @return: True if the photo album was added. False if it was
     * not added.
     */
    public boolean createAlbum(String albumName) {
        for (Album album : this.albums) {
            if (album.getName().equals(albumName)) {
                return false;
            }
        }

        Album newAlbum = new Album(albumName);
        albums.add(newAlbum);
        return true;
    }



    /**
     * This method will remove an album with the given album name
     * from the list of albums
     * @param albumName: The name of the photo album
     * @return: returns true if the album was successfully removed.
     * Returns false if it was not/cannot be removed.
     */
    public boolean removeAlbum(String albumName) {
        for (Album album : albums) {
            if (album.getName().equals(albumName) == true) {
                this.albums.remove(album);
                return true;
            }
        }
        return false;
    }

    /**
     * This method adds a photograph to the album given in the 
     * parameter.
     * @param p: The photo being passed through
     * @param albumName: The name of the album the photo should be added to
     * @return: False if the photo is not contained in the photos
     * or if it is already in the photo album. True is returned if 
     * the photo is added.
     */
    public boolean addPhotoToAlbum(Photograph p, String albumName) {
        if (this.photos.contains(p)) {
            for (Album album : albums) {
                if (album.getName().equals(albumName)) {
                    if (album.hasPhoto(p) == true) {
                        return false;
                    }
                    else {
                        album.addPhoto(p);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * This method will remove the wanted photo from the
     * wanted photo album.
     * @param p: The Photograph being passed through
     * @param albumName: The name of the photo album the
     * Photograph is meant to be removed from
     * @return: True is returned if the photo is removed
     * or false if the photo cannot be removed.
     */

    public boolean removePhotoFromAlbum(Photograph p, String albumName) {
        for (Album album : albums) {
            if (album.getName().equals(albumName)) {
                if (album.hasPhoto(p) == true) {
                    album.removePhoto(p);
                    return true;
                }
            }
        }  
        return false;
    }

    

    /***********************************************************************************************/

    /**
     * This method will check if p is already in the ArrayList of photos. If it is, it will return false. If not, it will be
     * added to the list and true will be returned.
     * 
     * @param p: A type Photograph
     * @return: True is returned if p is added to photos. False is returned if the ArrayList photos already contains it.
     **/
//    public boolean takePhoto(Photograph p) {
//        if (photos.contains(p)) {
//            return false;
//        }
//
//        else {
//            photos.add(p);
//            return true;
//        }
//    }


    /**
     * This method checks to see if p is already in the list of photos.
     * 
     * @param p: A type Photograph
     * @return: True is returned if photos does contain p. False is returned if it is not.
     **/
//    public boolean hasPhoto(Photograph p) {
//        if (photos.contains(p)) {
//            return true;
//        }
//
//        return false;
//    }


    /**
     * This method erases p from the photos if it is found within the ArrayList.
     * 
     * @param p: A type Photograph
     * @return: True is returned if p is erased from the photos. False is returned if p cannot be found/erased.
     **/
    public boolean removePhoto(Photograph p) {
        if (this.photos.contains(p)) {
            this.photos.remove(p);
            for (Album album : this.albums) {
                if (album.getPhotos().contains(p)) {
                    album.removePhoto(p);
                }

            }
            return true;
        }
        return false;
    }


    /**
     * This method returns the number of photographs the current object has taken.
     * 
     * @return: the size of ArrayList photos
     **/
//    public int numPhotographs() {
//        return this.photos.size();
//    }


    /**
     * This method checks if object passed through matches the current Person object. If it matches then param o is casted
     * to that object type. It checks to see if the param's ID is the same as the current object.
     * 
     * @param o: the object passed through
     * @return: False is returned if o is null or it is not an instance of Person. True is returned if it is an instance of
     *          Person and the IDs match.
     **/
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o instanceof PhotoLibrary) {
            PhotoLibrary personID = (PhotoLibrary) o;
            if (personID.getId() == this.id) {
                return true;
            }

            return false;
        }

        return false;
    }


    /**
     * This method generates a String that shows the values of the fields, name, id, and the photos.
     * 
     * @param : none are passed through
     * @return: a String is returned
     **/
    public String toString() {
        return "This person is named " + name + ". " + 
                "Their ID is " + id + ". " + "Their photos include: " + getPhotos() +
                "Their albums include: " + getAlbums();
    }


    /**
     * This method returns an ArrayList of photos both person a and person b have in common with each other. It checks to
     * see if the photographs equal each other.
     * 
     * @param a: Takes the first person's list of photos
     * @param b: Takes the second peron's list of photos
     * @return: A new ArrayList of photos both people shared.
     **/
    public static ArrayList<Photograph> commonPhotos(PhotoLibrary a, PhotoLibrary b) {
        ArrayList<Photograph> samePhotos = new ArrayList<Photograph>();
        for (Photograph aPhoto : a.photos) {
            for (Photograph bPhoto : b.photos) {
                if (aPhoto.equals(bPhoto)) {
                    samePhotos.add(aPhoto);
                }
            }
        }

        return samePhotos;
    }


    /**
     * This method returns a double from 0-1 that gauges how similar Person a and Person b's photos are. 0.0 being
     * un-similar and 1 being the most similar.
     * 
     * @param a: The first person's amount of photos
     * @param b: The second person's amount of photos
     * @return: 0.0 is returned if either person has no photos. Otherwise a double from 0.0-1 is returned based on
     *          similarity.
     **/
    public static double similarity(PhotoLibrary a, PhotoLibrary b) {
        if ((a.photos.size() == 0) || (b.photos.size() == 0)) {
            return 0.0;
        }

        else if (a.photos.size() >= b.photos.size()) {
            return (((double) commonPhotos(a, b).size()) / ((double) b.photos.size()));
        }

        else if (b.photos.size() >= a.photos.size()) {
            return (((double) commonPhotos(a, b).size()) / ((double) a.photos.size()));
        }

        return 0.0;
    }



    // MAIN METHOD TESTING
    public static void main(String[] args) {
//
//        // New objects to test the methods
//        PhotoLibrary sabrina = new PhotoLibrary("Sabrina", 1);
//        PhotoLibrary hannah = new PhotoLibrary("Hannah", 1); // same ID to test equals() method
//        PhotoLibrary amara = new PhotoLibrary("Amara", 2);
//        Photograph p1 = new Photograph("Cute puppy", "Dog");
//        Photograph p2 = p1;
//        Photograph p3 = new Photograph("So fluffy", "My cat");
//        Photograph p4 = new Photograph("I love you", "My boyfriend");
//
//        // Tests the takePhoto() method
//        System.out.println(sabrina.takePhoto(p1)); // true
//        System.out.println(sabrina.takePhoto(p3)); // true
//        System.out.println(sabrina.takePhoto(p4)); // true
//        System.out.println(sabrina.takePhoto(p2)); // false, since p1 = p2
//        System.out.println(hannah.takePhoto(p1)); // true
//        System.out.println(hannah.takePhoto(p3)); // true
//        System.out.println(amara.takePhoto(p4)); // true
//
//        // Tests the hasPhoto() method
//        System.out.println(sabrina.hasPhoto(p1)); // true
//        System.out.println(amara.hasPhoto(p3)); // false, since not added
//
//        // Tests the erasePhoto() method
//        System.out.println(sabrina.erasePhoto(p1)); // true
//        System.out.println(hannah.erasePhoto(p4)); // false, since not added
//
//        // Tests the numPhotographs() method
//        System.out.println(hannah.numPhotographs()); // 2, none were erased
//        System.out.println(sabrina.numPhotographs()); // 2, one was erased and one was the same so it was not added
//
//        // Tests the equals() method
//        System.out.println(sabrina.equals(hannah)); // true, same ID
//        System.out.println(sabrina.equals(amara)); // false
//
//        // Tests the toString() method
//        System.out.println(sabrina.toString());
//        System.out.println(hannah.toString());
//        System.out.println(amara.toString());
//
//        // Tests the commonPhotos() method
//        System.out.println(commonPhotos(sabrina, hannah)); // p1 in common
//        System.out.println(commonPhotos(sabrina, amara)); // p4 in common
//
//        // Tests the similarity() method
//        System.out.println(similarity(sabrina, hannah)); // 1/2 = 0.5
//        System.out.println(similarity(sabrina, amara)); // 1/1 = 1

    }
}

