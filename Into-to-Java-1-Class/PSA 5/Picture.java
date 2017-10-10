/* Filename: Picture.java 
 * Created by:  Drew Mills cs8afabt A13102641 Vinamr Madan cs8afabo
 * Date: 11/4/16
 */
/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */ 
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List


public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output; 
  }
  /**
   * Method takes in 2 parameters, and returns a modififed picture,The method will 
   * copy the calling object and replace all of the Pixels in the copy, The tolerance is
   * used to replaced Green screen pixels only
   */
  public Picture chromakeyBackgroundChange(Picture background, Color replaceColor)
  {
    Picture copy = new Picture(this);
    //loops through picture
    for( int x=0; x<copy.getWidth() ; x++) {
      for(int y=0 ; y<copy.getHeight() ; y++) {
        //copies pixels
        Pixel sourceP = background.getPixel(x,y);
        Pixel targetP = copy.getPixel(x,y);
        //establishes tolerance 
        if(targetP.colorDistance(replaceColor)<155) {
          targetP.setColor(sourceP.getColor());
        }
      }
    }
    //returns the copy
    return copy;
  }
  
  /**
   * Method takes in 7 parameters, and returns a modififed picture.
   * The calling object of this method will be the Picture object that has it?s 
   * background changed by the chromakeyBackgroundChange method.
   */
  public Picture chromakeyShirtChange(Picture shirt, Picture original, 
                                      Color oldShirtColor, int startX, int startY,
                                      int width, int height)
  {
    Picture copy = new Picture(this);
    // loops through picture
    for( int x= startX; x< width+startX ; x++) {
      for(int y=startY ; y<height+startY; y++) {
        //copies pixels
        Pixel sourceP = shirt.getPixel(x-startX,y-startY);
        Pixel targetP = copy.getPixel(x,y);
        Pixel originalP = original.getPixel(x,y);
        //establishes tolerance 
        if(originalP.colorDistance(oldShirtColor)<100) {
          targetP.setColor(sourceP.getColor());
        }
      }
    }
    //returns the copy
    return copy;
    
  }
 /* 
  public Picture resize(int width, int length) {
    Picture resized= new Picture(width,length);
    int decreaseX= this.getWidth() - width;
    int decreaseY= this.getHeight() - length;
    
    for(int y=0; y<this.getHeight(); y++) {
      for(int i=0; i<decreaseX ; i++) {
        for(int x= 0; i<this.getWidth() ; x++) {
          if
  }
  */
  
  
} // this } is the end of class Picture, put all new methods before this

