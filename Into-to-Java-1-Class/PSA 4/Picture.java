import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
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
   * Horizontal flip method
   * In this method, I've given you the basic structure of how things will look.  There are a few incomplete assignments inside of the method.  It is your job to figure out how to complete those assignments!
   * This method works almost like the horizontal mirroring method you saw in your text book (pg 135), but instead of mirroring on the middle of the image, we want to flip it all the way.
   * Hint: Why do we need tempColor in this case?  I encourage you to reflect on this question if you find your method not working the way it should!**/
  public void flipHorizontal()
  { 
    Color tempColor;
   
    //FILL THESE OUT AND THEN UNCOMMENT THEM!
    int limit1 = this.getWidth()/2;
    int limit2 = this.getHeight();
    
    for(int i = 0; i < limit1; i++)
    {
      for(int j = 0; j < limit2; j++)
      { Pixel pix1= this.getPixel(i,j);
        Pixel pix2 = this.getPixel((limit1*2)-1-i,j);
        //FILL THIS OUT AND THEN UNCOMMENT IT!
        tempColor = pix1.getColor();
        pix1.setColor(pix2.getColor());
        pix2.setColor(tempColor);
         
      }
    }
    
  }
  
  /**
   * Vertical flip method
   * No hints for this one! **/
  // why not? :((
  public void flipVertical()
  {Color tempColor;
   
    //FILL THESE OUT AND THEN UNCOMMENT THEM!
    int limit1 = this.getWidth();
    int limit2 = this.getHeight()/2;
    
    for(int i = 0; i < limit1; i++)
    {
      for(int j = 0; j < limit2; j++)
      { Pixel p1= this.getPixel(i,j);
        Pixel p2 = this.getPixel(i,(limit2*2)-1-j);
        //FILL THIS OUT AND THEN UNCOMMENT IT!
        tempColor = p1.getColor();
        p1.setColor(p2.getColor());
        p2.setColor(tempColor);
         
      }
    }
    
  }
  
  /**
   * Grayscale method **/
  public void grayscale()
  {
    int temp = 0;
    for(int x= 0 ; x < this.getWidth(); x++ ) {
      for(int y= 0 ; y < this.getHeight(); y++ ) {
        Pixel pix = this.getPixel(x,y);
      temp=(pix.getRed() + pix.getGreen()+ pix.getBlue() )/3;
      // RBG
      pix.setRed(temp);
      pix.setGreen(temp);
      pix.setBlue(temp);
     
      }
    }
  }
  
  
  /**The collage method
    * This method will create the collage of your modified pictures.  
    * Hint 1: Inside of the for loop here will be another 2 nested for loops, giving you a grand total of 3 nested for loops in this method
    * Hint 2: If you're clever about the way you decide to draw your pixels onto the canvas, you may only have to write ONE LINE OF CODE inside the inner-most for loop to achieve the desired collage effect!
    * However, more than one line inside of the nested for loops is perfectly fine, of course! **/
  // WOHOOOOO we ARE clever!!!1!!!!!1!!!!
  public void collage(Picture [] pictures)
  {
    for(int i = 0; i < pictures.length; i++)
    { for(int x= 0 ; x < pictures[i].getWidth(); x++ ) {
      for(int y= 0 ; y < pictures[i].getHeight(); y++ ) {
        this.getPixel(x+(i*pictures[0].getWidth()),y).setColor(pictures[i].getPixel(x,y).getColor());
      
    }
  }
  }
  }

  
   public void flipVerticalRectangle(int x, int y, int width, int height)
   { Color temp;
     y= y-height;
     for(int j= y; j < y +  height/2 ; j++){
       for(int i= x; i< width + x; i++){
        
        temp = this.getPixel(i,j).getColor();
        this.getPixel(i,j).setColor(this.getPixel(i,(height+(2*y))-j-1).getColor());
        this.getPixel(i,(height+(2*y))-j-1).setColor(temp);
       }
     }
   }
   public void flipHorizontalRectangle(int x, int y, int width, int height)
   { Color temp;
     y= y-height;
     for(int j= y; j < y +  height ; j++){
       for(int i= x; i< width/2 + x; i++){
        
        temp = this.getPixel(i,j).getColor();
        this.getPixel(i,j).setColor(this.getPixel(x+x+width-i,j).getColor());
        this.getPixel(x+x+width-i,j).setColor(temp);
       }
     }
   }
  
} // this } is the end of class Picture, put all new methods before this
 
