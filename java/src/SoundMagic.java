import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class SoundMagic extends JFrame {


    private PhotographContainer imageAlbum;
    private int currentIndex = 0; // counter for keeping track of images

    //-----------form controls------------//


    // Panel creation

    JPanel currentImage; // for displaying the main photo
    JPanel controlPanel; // for displaying the buttons

    // Control Panel buttons
    JButton exit;
    JButton next;
    JButton previous;

    // ImageIcons and Images for main photos and thumbnails

    // currentImage JPanel icons
    ImageIcon mainIcon;
    Image mainImage;
    Image mainImageScaled;
    JLabel mainImageLabel;




    /**
     * This method adds the components to the pane which are then displayed on the JFrame. Specifically,
     * all the needed labels, panels, etc. are all instantiated in this method.
     * @param pane
     */
    private void addComponentsToPane(Container pane) {


        //--------- Designing the controlPanel JPanel--------//

        // controlPanel Set Up
        controlPanel = new JPanel();
        controlPanel.setBackground(Color.WHITE);


        // Instantiating the buttons 
        exit = new JButton("Exit");
        next = new JButton("Next");
        previous = new JButton("Previous");


        // Adding commands to buttons
        exit.setActionCommand("exit");
        next.setActionCommand("next");
        previous.setActionCommand("previous");



        // Add the action listener to buttons
        exit.addActionListener(new ActionControlPanel());
        next.addActionListener(new ActionControlPanel());
        previous.addActionListener(new ActionControlPanel());
 

        // Adding the buttons onto the panel
        controlPanel.add(exit);
        controlPanel.add(previous);
        controlPanel.add(next);


        //--------- Designing the currentImage JPanel--------//  

        // currentImage Set Up 
        currentImage = new JPanel();
        currentImage.setBackground(Color.BLACK);


        // Instantiating JLabel and ImageIcon
        mainImageLabel = new JLabel(mainIcon);
        mainIcon = new ImageIcon(this.imageAlbum.photos.get(0).getFilename()); // first photo in the photoLibrary


        // Updated ImageIcon for a scaled image
        mainImage = mainIcon.getImage();
        mainImageScaled = mainImage.getScaledInstance(-1, 600, Image.SCALE_AREA_AVERAGING);
        mainIcon = new ImageIcon(mainImageScaled); // final icon
        mainImageLabel.setIcon(mainIcon);
        currentImage.add(mainImageLabel);


        // Add the action listener to buttons
        exit.addActionListener(new ActionRating());
        next.addActionListener(new ActionRating());
        previous.addActionListener(new ActionRating());



        //---------Adding everything to the panels and panes-------//



         pane.add(controlPanel, BorderLayout.NORTH);
         pane.add(currentImage, BorderLayout.CENTER);

    }


    private class ActionControlPanel implements ActionListener {

        /**
         * This method performs a different action based on the condition. It can exit the program,
         * iterate through the photographs using "next" and "previous" buttons, as well as sort by caption,
         * date, or rating.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("exit")) {
                System.exit(0); //exits program
            }

            if (e.getActionCommand().equals("next")) {
                if(currentIndex==4) { //arrayList index is 4 inclusive
                    currentIndex=-1; //set it to -1 so the counter "restarts" at 0
                }

                // RESETS IMAGE
                currentIndex++;
                mainIcon = new ImageIcon(imageAlbum.photos.get(currentIndex).getFilename());
                mainImage = mainIcon.getImage();
                mainImageScaled = mainImage.getScaledInstance(-1, 600, Image.SCALE_AREA_AVERAGING);
                mainIcon = new ImageIcon(mainImageScaled);
                mainImageLabel.setIcon(mainIcon);

            }

            if (e.getActionCommand().equals("previous")) {
                if(currentIndex==-1 || currentIndex==0) { // -1 based on the position from "next button"
                    // 0 if starting iteration from "previous button" initially
                    currentIndex=5; // sets index to 5 to prep for the counter "restarting" at 4
                }

                //RESETS IMAGE
                currentIndex--;
                mainIcon = new ImageIcon(imageAlbum.photos.get(currentIndex).getFilename());
                mainImage = mainIcon.getImage();
                mainImageScaled = mainImage.getScaledInstance(-1, 600, Image.SCALE_AREA_AVERAGING);
                mainIcon = new ImageIcon(mainImageScaled);
                mainImageLabel.setIcon(mainIcon);
            }

           
        }

    }

    private class ActionRating implements ActionListener {

        /**
         * This method is part of the private class ActionRating. It gets the ratings of the photos
         * and sets the JRadioButton to true that corresponds to the correct number.
         * @param: an ActionEvent
         *@return nothing!
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // CODE NOT WORKING PROPERLY. NOT SURE HOW TO FIX. 
        }
    }


    /**
     * This method creates the GUI. It creates the frame, title, default settings, makes it visible, etc.
     * @return: nothing!
     * */
    private void createPhotoViewer() {
        this.setTitle("SoundMagic");
        int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.addComponentsToPane(getContentPane());
        this.pack(); 
        this.setVisible(true);

    }

    public static void main(String[] args) {

        SoundMagic myViewer = new SoundMagic(); 
        String imageDirectory = "/Users/Daniel/Downloads/Intech/"; 

        Photograph p1 = new Photograph(imageDirectory + "pause.jpg", "uwu", "2015-06-01", 1);
        Photograph p2 = new Photograph(imageDirectory + "play.jpg", "stan bts", "2015-06-02", 4);
        Photograph p3 = new Photograph(imageDirectory + "prev.jpg", "stan bts", "2015-06-02", 4);
        Photograph p4 = new Photograph(imageDirectory + "next.jpg", "stan bts", "2015-06-02", 4);
        Photograph p5 = new Photograph(imageDirectory + "call.jpg", "uwu pt.2", "2015-06-03", 5);
        Photograph p6 = new Photograph(imageDirectory + "answer.jpg", "noice",  "2015-06-04", 2);
        Photograph p7 = new Photograph(imageDirectory + "hangup.png", "vincent", "2015-06-05", 3);

        myViewer.imageAlbum = new PhotoLibrary("Test Library", 1);
        myViewer.imageAlbum.addPhoto(p1);
        myViewer.imageAlbum.addPhoto(p2);
        myViewer.imageAlbum.addPhoto(p3);
        myViewer.imageAlbum.addPhoto(p4);
        myViewer.imageAlbum.addPhoto(p5);
        myViewer.imageAlbum.addPhoto(p6);
        myViewer.imageAlbum.addPhoto(p7);

        Collections.sort(myViewer.imageAlbum.photos);
        javax.swing.SwingUtilities.invokeLater(() -> myViewer.createPhotoViewer() );
    }
}