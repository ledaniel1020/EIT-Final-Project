import java.time.LocalDate;
/**
 * Homework 4
 * Sabrina Baldasssarre, sjb4sy
 *
 * Sources: N/A
 */

import java.util.ArrayList;

public abstract class PhotographContainer {

    // FIELDS
    protected String name;
    protected ArrayList<Photograph> photos;
    
    
    // CONSTRUCTOR
    public PhotographContainer(String n) {
        this.name = n;
        this.photos = new ArrayList<>();
    }

    
    // GETTERS
    public String getName() {
        return this.name;  
    }
    
    public ArrayList<Photograph> getPhotos() {
        return this.photos;
    }
    
    // SETTERS
    public void setName(String name) {
        this.name = name;
    }
    
    //ALBUM METHODS
    
    /**
     * This method checks if p is of type Photograph and then adds it to the list of photos if 
     * its not already in it.
     * @param p: The Photograph being passed through
     * @return: True if it added, false if it is already in the photo list
     */
    public boolean addPhoto(Photograph p) {
        if (p == null) {
            return false;
        }
        if (this.photos.contains(p)) {
            return false;
        }
        else {
            this.photos.add(p);
            return true; 
        }
    }
    
    /**
     * This method checks if the list of photos contains the photograph in the parameter.
     * @param p: The Photograph being passed through
     * @return: True if it is in the photos, false if it is not.
     */
    public boolean hasPhoto(Photograph p) {
        if (this.photos.contains(p)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method will remove the photograph from the list of photos if it is found within
     * the photo list.
     * @param p: the Photograph being passed through
     * @return: True if the photo is removed and false if it not removed/found.
     */
    public boolean removePhoto(Photograph p) {
        if (this.photos.contains(p)) {
            this.photos.remove(p);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method returns the number of photos in the list.
     * @return: The size of the photo list.
     */
    public int numPhotographs() {
        return this.photos.size();
    }

    
    /**
     * This is an equals method that checks if the object being passed through is 
     * an of type Album. If it is, then it checks if the name values are equivalent.
     * @param: an object
     * @return: False if the object is null or not of type Album, true if the names are
     * equivalent
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false; 
        }
        if (o instanceof Album) {
            Album albumName = (Album) o;
            if (this.name.equals(albumName.getName())) {
                return true;
            }
        }
        return false;
    }
    

    /**
     * This toString method generates a string that has the name of the album and then
     * a list of the photo's filenames.
     * @return: a String
     */
    public String toString() {
        return "Album name: " + name + "\n" +
                "Photo's filenames: " + photos;
    }
    
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    // PHOTOLIBRARY METHODS
    
    /**
     * This method will return an ArrayList of photos that have a rating greater
     * or equal to the parameter as long as the parameter is within bounds.
     * @param: the rating the photos will be compared to
     * @return: Null will be returned if the param is greater than 5 or less than 0
     * or will return an ArrayList of photos that have the correct rating.
     */
    public ArrayList<Photograph> getPhotos(int rating) {
        ArrayList<Photograph> correctRating = new ArrayList<Photograph>();
        if ((rating > 5) || (rating < 0)) {
            return null;
        }
        for (Photograph photo : photos) {
            if (photo.getRating() >= rating) {
                correctRating.add(photo);
            }

        }
        return correctRating;
    }
    
    
    /**
     * This method will return a list of photos that fall under 
     * the given year.
     * @param: a specific year
     * @return: Null will be returned if the format of the year is 
     * incorrect. Otherwise, it will return an ArrayList of photos
     * that fall under that year. Otherwise, an empty ArrayList will
     * be returned if no photos were taken during that time.
     */
    public ArrayList<Photograph> getPhotosInYear(int year) {
        ArrayList<Photograph> correctYear = new ArrayList<Photograph>();
        for (Photograph photo : photos) {
            String date = photo.getDateTaken().substring(0,4);
            int intDate = Integer.parseInt(date);
            if (intDate == year) {
                correctYear.add(photo);
            }

            if ((Integer.toString(year).length() != 4)) {
                return null;
            }
        }
        return correctYear;
    }
    
    /**
     * This method will return a list of photos that were taken
     * in a certain year in a certain month
     * @param month: the month the photos were taken
     * @param year: the year the photos were taken
     * @return: Null will be returned if the formatting is incorrect.
     * Otherwise, it will return an ArrayList of photos taken within that
     * month and year. Or, an empty array list will be returned 
     * (assuming no photos were taken during that time)
     */
    public ArrayList<Photograph> getPhotosInMonth (int month, int year) {
        ArrayList<Photograph> correctMonth = new ArrayList<Photograph>();
        String strYear = Integer.toString(year);
        String strMonth = Integer.toString(month);

        if( strYear.length()!= 4 || strMonth.length() > 2 || month < 1 || month > 12) {
            return null;
        }

        for (Photograph photo : photos) {
            String dateYear = photo.getDateTaken().substring(0,4);
            String dateMonth = photo.getDateTaken().substring(5,7);
            int intYear = Integer.parseInt(dateYear);
            int intMonth = Integer.parseInt(dateMonth);

            if (intYear == year && intMonth == month) {
                correctMonth.add(photo);
            }
        }
        return correctMonth;
    }


    /**
     * This method will return a list of photos taken between
     * a given time period.
     * @param beginDate: The starting date of when the photos
     * should have been taken.
     * @param endDate: The ending date of when the photos could have
     * been taken.
     * @return: Null will be returned if the format of the dates
     * are wrong in any way or if the beginDate is after the endDate.
     * An ArrayList will be returned of pictures taken during the
     * given time frame. Otherwise, if no photos were taken then
     * an empty ArrayList will be returned.
     */
    public ArrayList<Photograph> getPhotosBetween(String beginDate, String endDate) {
        ArrayList<Photograph> photosBetween = new ArrayList<Photograph>();
        
        if ((beginDate.length() != 10) || (endDate.length() != 10)) {
            return null;
        }

        int beginYear = Integer.parseInt(beginDate.substring(0,4));
        int beginMonth = Integer.parseInt(beginDate.substring(5,7));
        int beginDay = Integer.parseInt(beginDate.substring(8));

        int endYear = Integer.parseInt(endDate.substring(0,4));
        int endMonth = Integer.parseInt(endDate.substring(5,7));
        int endDay = Integer.parseInt(endDate.substring(8));

        
        if ((beginMonth < 1 || beginMonth > 12) || 
                (beginDay < 1 || beginDay > 31) ||
                (endMonth < 1 || endMonth > 12) ||
                (endDay < 1 || endDay > 31)) {
            return null;
        }

        LocalDate beginningDate = LocalDate.of(beginYear, beginMonth, beginDay);
        LocalDate endingDate = LocalDate.of(endYear, endMonth, endDay);
        
        if (beginningDate.isAfter(endingDate)) {
            return null;
        }

        for (Photograph photo : this.photos) {
            int yearPhotoTaken = Integer.parseInt(photo.getDateTaken().substring(0,4));
            int monthPhotoTaken = Integer.parseInt(photo.getDateTaken().substring(5,7));
            int dayPhotoTaken = Integer.parseInt(photo.getDateTaken().substring(8));

            LocalDate dateTaken = LocalDate.of(yearPhotoTaken, monthPhotoTaken, dayPhotoTaken);

            if ((dateTaken.equals(beginningDate)) ||
                    (dateTaken.equals(endingDate))) {
                photosBetween.add(photo);
            }
            if ((dateTaken.isBefore(endingDate)) &&
                    (dateTaken.isAfter(beginningDate))) {
                photosBetween.add(photo);
            }
        }
        return photosBetween;   
    }
}
    
    
    
