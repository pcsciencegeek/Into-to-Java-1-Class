/* Filename: PSA5.java 
 * Created by: Drew Mills cs8afabt A13102641 Vinamr Madan cs8afabo
 * Date:  11/4/16
 * 
 * In this assignment a picture will be modafided, changing the background
 * and the shirt color of a person in the picture that is bing modified
 * using loops and if statements, as well as other methods. Chromakey will 
 * also be used. 
 * 
 */
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class PSA5
{ 
  //The line below is magic, you don't have to understand it (yet)
  public static void main (String[] args) {
    //import pictures
    String selfFileName = "pic0.jpg";
    String bgFileName = "pic1.jpg";
    String shirtFileName = "pic2.jpg";
    
    Picture bgSource = new Picture(bgFileName);
    // set the to be replaced
    Color bgColor= new Color(0,230,50);
    
    Picture changedBg;
    Picture selfSource= new Picture(selfFileName);
    //calls the method 
    changedBg= selfSource.chromakeyBackgroundChange(bgSource ,bgColor);
    
    Picture shirt = new Picture(shirtFileName);
    Color shirtColor = new Color(180,70,70);
    Picture finalPic=changedBg.
    //   
    chromakeyShirtChange(shirt,selfSource,shirtColor,100,380,380,395);
    //show pictues 
    changedBg.explore();
    selfSource.explore();
    bgSource.explore();
    finalPic.explore();
  } 
}
