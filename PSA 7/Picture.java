import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/*
 * Created by: Drew Mills cs8afabt A13102641 Vinamr Madan cs8afabo
 * Date: 10/28/16
 * 
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 * 
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
   * In this method, I've given you the basic structure of how things will look.  
   * There are a few incomplete assignments inside of the method. 
   * It is your job to figure out how to complete those assignments!
   * This method works almost like the horizontal mirroring method you saw in your 
   * text book (pg 135), but instead of mirroring on the middle of the image, we want to 
   * flip it all the way.
   * 
   * method flips on the vertical axis; returns nothing
   * */
  public void flipHorizontal(){ 
    //define var
    Color tempColor;
    //get half of width
    int limit1 = this.getWidth()/2;
    //get length
    int limit2 = this.getHeight();
    //loop through left half of picture
    for(int i = 0; i < limit1; i++){
      for(int j = 0; j < limit2; j++){
        Pixel leftPix= this.getPixel(i,j);
        Pixel rightPix = this.getPixel((limit1*2)-1-i,j);
        //put left pixel color in holding cell
        tempColor = leftPix.getColor();
        //set right pixel color equal to left pixel color
        leftPix.setColor(rightPix.getColor());
        //take left pixel color from holding cell and set it to right pixel color
        rightPix.setColor(tempColor);
        
      }
    }
    
  }
  
  /**
   * Vertical flip method
   * 
   * flips picture on the horizontal axis; returns nothing
   * 
   **/
  
  public void flipVertical(){
    // define var
    Color tempColor;
    int limit1 = this.getWidth();
    int limit2 = this.getHeight()/2;
    //loop through the top picture 
    for(int i = 0; i < limit1; i++){
      
      for(int j = 0; j < limit2; j++){ 
        
        Pixel topPixel= this.getPixel(i,j);
        Pixel bottomPixel = this.getPixel(i,(limit2*2)-1-j);
        //put top pixel color in holding cell
        tempColor = topPixel.getColor();
        //set buttom pixel color equal to top pixel color
        topPixel.setColor(bottomPixel.getColor());
        //take top pixel color from holding cell and set it to buttom pixel color
        bottomPixel.setColor(tempColor);
        
      }
    }
    
  }
  
  /**
   * Grayscale method 
   * 
   * turns picture gray; returns nothing
   **/
  public void grayscale(){
    int temp = 0;
    for(int x= 0 ; x < this.getWidth(); x++ ) {
      for(int y= 0 ; y < this.getHeight(); y++ ) {
        Pixel pix = this.getPixel(x,y);
        temp=(pix.getRed() + pix.getGreen()+ pix.getBlue() )/3;
        // RBG
        //sets red 
        pix.setRed(temp);
        //sets green
        pix.setGreen(temp);
        //sets blue
        pix.setBlue(temp);
        
      }
    }
  }
  
  
  /**The collage method
    * This method will create the collage of your modified pictures.  
    * Hint 1: Inside of the for loop here will be another 2 nested for loops, 
    * giving you a grand total of 3 nested for loops in this method
    * Hint 2: If you're clever about the way you decide to draw your
    * pixels onto the canvas, you may only have to write ONE LINE OF CODE inside the 
    * inner-most for loop to achieve the desired collage effect!
    * However, more than one line inside of the nested for loops is perfectly fine,
    * of course! **/
  public void collage(Picture [] pictures)
  {
    for(int i = 0; i < pictures.length; i++){ 
      for(int x= 0 ; x < pictures[i].getWidth(); x++ ){
        for(int y= 0 ; y < pictures[i].getHeight(); y++ ){
          this.getPixel(x+(i*pictures[0].getWidth()),y).setColor(pictures[i].getPixel(x,y).getColor());
        }
      }
    }
  }
  
  
  public void flipVerticalRectangle(int x, int y, int width, int height){ 
    //define var
    Color temp;
    y= y-height+1;
    //loop through top half of picture
    for(int j= y; j < y +  height/2 ; j++){
      for(int i= x; i< width + x; i++){
        Pixel upPixel= this.getPixel(i,j);
        Pixel downPixel =  this.getPixel(i,(height+(2*y))-j-1);
        //put top pixel color in holding cell
        temp = upPixel.getColor();
        //set buttom pixel color equal to top pixel color
        upPixel.setColor(downPixel.getColor());
        //take top pixel color from holding cell and set it to buttom pixel color
        downPixel.setColor(temp);
      }
    }
  }

  /* method to flip a square of height and width size with x,y as the bottom right corner
  */
  
  
   public Picture flipHorizontalSquare(int x, int y, int size){ 
    //define var
     Picture copy= new Picture(this);
    Color temp;
    y = y-size+1;
    int j= y;
    int i=x;
    int midpoint= size/2+x;
    //loop thought picture
    if(y<0)
    { j=0;}

    if(x<0)
    { i=0;
       midpoint= (size+x)/2;}
    if(x+size>0)
    { midpoint = (this.getWidth()-1-x)/2 + x; }
    for(; j < y +  size && j< copy.getHeight() ; j++){
      for(; (i< midpoint ) && (i<copy.getWidth()) ; i++){
        Pixel leftPixel = copy.getPixel(i,j);
        Pixel rightPixel =copy.getPixel(midpoint*2-i-1,j);
        //put left pixel color in holding cell
        temp = leftPixel.getColor();
        //set right pixel color equal to left pixel color
        leftPixel.setColor(rightPixel.getColor());
        //take left pixel color from holding cell and set it to right pixel color
        rightPixel.setColor(temp);
      }
      i=x;
    }
    return copy;
  }
   
   
   
   
   
   
   
 public void scramble(Picture originalPic){ 
    Picture[] picArr = new Picture[9];
    for(int i=0; i<9; i++){
     picArr[i]=new Picture(originalPic.getWidth()/3,originalPic.getHeight()/3);
    }
    for(int i=0; i<3;i++){
      for( int j=0 ; j < 3 ; j++){
        for(int x= i*originalPic.getWidth()/3; x< (i+1)*originalPic.getWidth()/3; x++){
          for(int y= j*originalPic.getHeight()/3; y< (j+1)*originalPic.getHeight()/3; y++){
       picArr[ i*3 +j].getPixel((x-(i*originalPic.getWidth()/3)),(y-(j*originalPic.getHeight()/3))).
         setColor(originalPic.getPixel(x,y).getColor());
      
          }
        }
      }
    } 
    Random random= new Random();
    int[] a=new int[9];
        for(int i=0; i<9; i++){
         a[i]= -1;
    }
        for(int i=0; i<9; i++){    
        while(a[i]==-1){
         int b= random.nextInt(9);
         if(b!=a[0]&&b!=a[1]&&b!=a[2]&&b!=a[3]&&b!=a[4]&&b!=a[5]&&b!=a[6]&&b!=a[7]&&b!=a[8]){
          a[i]= b;
         }
         }
        }
    for(int i= 0; i<3;i++){
     for(int j=0; j<3; j++){
      for(int x=0; x<originalPic.getWidth()/3;x++){
       for(int y=0; y < originalPic.getHeight()/3;y++){
         Pixel p= picArr[a[i*3+j]].getPixel(x,y);
         this.getPixel(i*originalPic.getWidth()/3 +x , (j*originalPic.getHeight()/3)+y).setColor(p.getColor());
       }
      }
     }
    }
  }
     
  
} // this } is the end of class Picture, put all new methods before this

