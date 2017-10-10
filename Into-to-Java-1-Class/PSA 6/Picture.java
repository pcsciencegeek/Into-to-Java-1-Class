/* Filename: PSA6.java 
 * Created by: Drew Mills cs8afabt A13102641 ; Vinamr Madan cs8afabo A13464556
 * Date: 11/11/2016 
 * 
 * PSA6.java, Picture.java and MethodTester.java
 * 
 * picture.java is a class that represents a picture.
 */
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
  
  /*
   * This method  preserve the 2 most significant (i.e. leftmost)
   * bits in each 8-bit number
   * Example: The most significant 2 bits of 250 (11111010) are 11 in
   * binary which is equal
   * to 3 in decimal. 
   */
  public static int mostSignificant2( int num )
  {
    //shift
    return num >> 6;
  }  
  
  
  /* 
   * This method  preserve the N most significant (i.e. leftmost)
   * bits in each 8-bit number
   * Example: If N=3 ,the most significant 3 bits of 250 (11111010)
   * are 111 in binary which is equal to 7 in decimal. 
   */
  public static int mostSignificantN( int num, int N )
  {
    //shift
    return num >> (8-N);  
  }
  
  public static int shift2BitsTo8( int num )
  {
    // shift
    return num << 6;
  }
  
  /* 
   * This method  converts num with N bits into 8 bits
   * Example: If if num is 2 and N is 3, it means num is 010 in binary. 
   * This method will convert it into 01000000,
   * which is eual to 64 in decimal.
   */
  public static int shiftNBitsTo8( int num, int N )
  {
    return num << (8-N);  // You must implement this
  }
  
  
  /*
   * This method creates a copy of picture passed in the parameter. 
   * It changes the red, blue and green components 
   * of each pixel in copied picture. It uses the method mostSignificant2 
   * to convert the 8-bit values into 2 bit values
   *
   *  Hence if you call this method, it will give you a copy of the picture 
   * passed in the parameter. But the copied picture has only 2 bits of 
   * information per color. For example, if blue color value for  any pixel
   * in the picture is 01000000 (64 in decimal), the correspoding value 
   * of red color in copied picuture would be just 00000001 (1 in decinal)
   *
   */
  public static Picture degradeColors2Bits(Picture sourcePicture) {
    //get copy of picture
    Picture picCopy = new Picture( sourcePicture.getWidth(), sourcePicture.getHeight() );
    // loop throught picture
    for ( int x = 0; x < sourcePicture.getWidth(); x++ ) {
      for ( int y = 0; y < sourcePicture.getHeight(); y++ ) {
        // grab pix location
        Pixel source = sourcePicture.getPixel( x, y );
        Pixel target = picCopy.getPixel( x, y );
        //store colours
        int red = source.getRed();
        int green = source.getGreen();
        int blue = source.getBlue();
        //shift
        red = mostSignificant2( red );
        green = mostSignificant2( green );
        blue = mostSignificant2( blue );
        //shifting
        red = shift2BitsTo8( red);
        green = shift2BitsTo8( green);
        blue = shift2BitsTo8( blue);
        //reassign
        target.setRed( red );
        target.setGreen( green );
        target.setBlue( blue );
      }
    }
    //returning
    return picCopy;
    
  }  
  
  /*
   This method creates a copy of the picture passed in the parameter. 
   It changes the red, blue and green components 
   of each pixel in copied picture. It uses the method mostSignificantN to
   convert the 8-bit values into N bit values
   and then shift it back to 8 bit values.
   Hence if you call this method with the Picture as one of the parameters, 
   it will give you a copy of the picture. 
   But the copied picture has only N bits of information per color.
   */
  public static Picture degradeColorsNBits(Picture sourcePicture,int N) {
    // get copy
    Picture picCopy = new Picture( sourcePicture.getWidth(), sourcePicture.getHeight() );
    //loop throught picture
    for ( int x = 0; x < sourcePicture.getWidth(); x++ ) {
      for ( int y = 0; y < sourcePicture.getHeight(); y++ ) {
        // grab pix location
        Pixel source = sourcePicture.getPixel( x, y );
        Pixel target = picCopy.getPixel( x, y );
        //store colours
        int red = source.getRed();
        int green = source.getGreen();
        int blue = source.getBlue();
        //shift
        red = mostSignificantN( red, N );
        green = mostSignificantN( green, N);
        blue = mostSignificantN( blue, N);
        //shifting
        red = shiftNBitsTo8( red, N );
        green = shiftNBitsTo8( green, N);
        blue = shiftNBitsTo8( blue, N);
        //reassign
        target.setRed( red );
        target.setGreen( green );
        target.setBlue( blue );
      }
    }
    //return
    return picCopy;
  } 
  
  /*
   * This method makes a copy of the context image, call it canvas, 
   * and hides the image message inside canvas in its least significant
   * 2 bits and then returns this new image.
   * */
  public static Picture hideSecretMessage2Bits
    (Picture context, Picture message, int x, int y){
    Picture canvas = new Picture(context);
    int startY = y; 
    //loop throught picture
    for (; x< canvas.getWidth() && x<message.getWidth() ; x++){
      for (; y< canvas.getHeight() && y<message.getHeight(); y++) {
        //get location
        Pixel canvasP = canvas.getPixel(x,y);
        Pixel msgP = message.getPixel(x,y);
        // store, shift, reassign, red pix
        int msgRed=msgP.getRed();
        int canvasRed= canvasP.getRed();
        msgRed=mostSignificant2( msgRed);
        canvasP.setRed(embedDigits2(canvasRed ,msgRed));
        // store, shift, reassign, Green pix
        int msgGreen = msgP.getGreen();
        int canvasGreen = canvasP.getGreen();
        msgGreen = mostSignificant2( msgGreen);
        canvasP.setGreen(embedDigits2(canvasGreen ,msgGreen));
        // store, shift, reassign, Blue pix
        int msgBlue = msgP.getBlue();
        int canvasBlue = canvasP.getBlue();
        msgBlue = mostSignificant2( msgBlue);
        canvasP.setBlue(embedDigits2(canvasBlue ,msgBlue));
      }
      //reset
      y = startY; 
    }
    //return
    return canvas;
  }
  /*
   * This method makes a copy of the context image, call it canvas, 
   * and hides the image message inside canvas in its least significant
   * N bits and then returns this new image.
   * */
  public static Picture hideSecretMessageNBits
    (Picture context, Picture message, int N , int x, int y){
    //initialize varibles
    Picture canvas = new Picture(context);
    int startY = y;
    //loop throught picture
    for (; x< canvas.getWidth() && x<message.getWidth() ; x++){
      for (; y< canvas.getHeight() && y<message.getHeight(); y++) {
        //get location
        Pixel canvasP = canvas.getPixel(x,y);
        Pixel msgP = message.getPixel(x,y);
        // store, shift, reassign, red pix
        int msgRed=msgP.getRed();
        int canvasRed= canvasP.getRed();
        msgRed=mostSignificantN( msgRed,N);
        canvasP.setRed(embedDigitsN(canvasRed ,msgRed,N));
        // store, shift, reassign, green pix
        int msgGreen=msgP.getGreen();
        int canvasGreen= canvasP.getGreen();
        msgGreen=mostSignificantN( msgGreen,N);
        canvasP.setGreen(embedDigitsN(canvasGreen ,msgGreen,N));
        // store, shift, reassign, blue pix
        int msgBlue=msgP.getBlue();
        int canvasBlue= canvasP.getBlue();
        msgBlue=mostSignificantN( msgBlue,N);
        canvasP.setBlue(embedDigitsN(canvasBlue ,msgBlue,N));
      } 
      //reset
      y = startY;
    }
    //return
    return canvas;
  }
  /*
   * This method returns a new picture object which is the hidden image. Takes 3 
   * pramenters. returns the hidden message.message is hidden in the least significant
   * 2 bits of the context image.
   * */
  public static Picture recoverSecretMessage2Bits(Picture picWithMessage, int x, int y){
        //initialize varibles
    Picture hiddenMsg = new Picture(picWithMessage);
    int startY = y;
    // loop thought 
    for (; x<picWithMessage.getWidth() ; x++){
      for (;y<picWithMessage.getHeight(); y++) {
        //get location
        Pixel sourcepix = picWithMessage.getPixel(x,y);
        Pixel targetpix = hiddenMsg.getPixel(x,y);
       // store, shift, reassign, red pix
        int red= sourcepix.getRed();
        red = getLeastSignificant2( red);
        red = shift2BitsTo8( red);
        targetpix.setRed(red);
        // store, shift, reassign, green pix
        int green= sourcepix.getGreen();
        green = getLeastSignificant2( green);
        green = shift2BitsTo8(green);
        targetpix.setGreen(green);
        // store, shift, reassign, blue pix
        int blue= sourcepix.getBlue();
        blue = getLeastSignificant2(blue);
        blue = shift2BitsTo8(blue);
        targetpix.setBlue(blue);
      }
      //reset
      y=startY;
    }
    //return
    return hiddenMsg;
    
  }
  /*
   * This method returns a new picture object which is the hidden image. Takes 3 
   * pramenters. returns the hidden message.message is hidden in the least significant
   * N bits of the context image. N being any number 0-8
   * */
  public static Picture recoverSecretMessageNBits
    (Picture picWithMessage,int N, int x, int y){
        //initialize varibles
    Picture hiddenMsg = new Picture(picWithMessage);
    int startY = y;
    //loop throught picture
    for (; x<picWithMessage.getWidth() ; x++){
      for (;y<picWithMessage.getHeight(); y++) {
        // get picture location
        Pixel p1= picWithMessage.getPixel(x,y);
        Pixel p2 = hiddenMsg.getPixel(x,y);
          // store, shift, reassign, red pix
        int red= p1.getRed();
        red = getLeastSignificantN( red,N);
        red = shiftNBitsTo8( red,N);
        p2.setRed(red);
          // store, shift, reassign, green pix
        int green= p1.getGreen();
        green = getLeastSignificantN( green,N);
        green = shiftNBitsTo8(green,N);
        p2.setGreen(green);
          // store, shift, reassign, blue pix
        int blue= p1.getBlue();
        blue = getLeastSignificantN(blue,N);
        blue = shiftNBitsTo8(blue,N);
        p2.setBlue(blue);
      }
      //reset
      y=startY;
    }
    //return
    return hiddenMsg;
    
  }
  
  /*
   * This method will indirectly use shift operators (and addition),
   * to replace the two least significant digits
   * */
  public static int embedDigits2( int contextVal, int messageVal ){
    //shift to clear
    contextVal = mostSignificantN( contextVal, 6 );
    //shift to add 0's
    contextVal = shiftNBitsTo8( contextVal, 6 );
    //add together
    contextVal+= messageVal;
    //return
    return contextVal; 
  }
  
  /*
   * This method will indirectly use shift operators (and addition),
   * to replace the N least significant digits. N can be any number 0-8
   * */
  public static int embedDigitsN( int contextVal, int messageVal, int N ){
    //shift to clear
    contextVal = mostSignificantN( contextVal, 8-N );
    //shift to add 0's
    contextVal = shiftNBitsTo8( contextVal, 8-N );
    //add together
    contextVal+= messageVal;
    //return
    return contextVal;
  }
  
  /*
   * this method stores the least 2 Significant numbers  
   * */
  public static int getLeastSignificant2( int num ){
    int temp = num;
    temp = mostSignificantN( temp, 6 );
    temp = shiftNBitsTo8( temp, 6 );
   //subtract 
    num -= temp;
    //return
    return num ;
    
  }
  
  /*
   * this method stores the least N Significant numbers. N being any number between 0 -8 
   * */
  public static int getLeastSignificantN( int num, int N ){
    int temp= num;
    temp = mostSignificantN( temp, 8-N );
    temp = shiftNBitsTo8( temp, 8-N );
     //subtract 
    num-= temp;
    //return
    return num ;
  }
  
  
  
}// this } is the end of class Picture, put all new methods before this

