/*Created by: Drew Mills cs8afabt A13102641 Vinamr Madan cs8afabo
 * Date: 11/30/16
 * 
 * Represents a single slide.
 * 
 * */
public class Slide{
 /////////////// fields ////////////////////
  //picture to be shown on the slides
  public Picture pic;
  //sound played while slide is showing
  public Sound sound;
/////////////// constructors ////////////////////////////////////
  /**
   * sets picture and sound to null
   */
  public Slide(){
    pic = null;
    sound = null;
  }
    /**
   * denoting inPic as the Picture displayed in the slide and
   * inSound as the sound displayed in the slide
   */
  public Slide(Picture inPic, Sound inSound){
    pic = new Picture(inPic);
    sound = new Sound(inSound);
  }
    
  ////////////////// methods ////////////////////////////////////
  /**
   * This method changes the picture to be displayed for this slide to the
   * image represented by inPic
   * Inputs: inPic - the slide that will be put into the slideshow
   */
  public void changePic(Picture inPic){
    pic = new Picture(inPic);
  }
  /**
  * This method changes the sound to be played for this slide to the sound
  * represented by inSound
  * Inputs: inSound - the sound to replace the current sound
  */
  public void changeSound(Sound inSound){
    sound = new Sound(inSound) ;
  }
    /**
   * This method shows the modified copy of the slide's picture based on
   * the parameter flipHorizontal, plays the sound, and then closes the
   * image. If pic or sound is still null, an error message will display.
   * The flip of the picture (horizontal or vertical) is based on the boolean
   * parameter of flipHorizontal. True means horizontal, false results in a
   * vertical flip.
   * input: flipHorizontal - boolean that determines whether the picture is
   * flipped horizontally or vertically
   */
  public void showSlide(boolean pictureFlipHorizontal, boolean soundReverse){
    if (pic == null || sound == null ){
      //show error message 
      System.out.println (" error");
      return;
    }
    Picture copy = new Picture(pic);
    if( pictureFlipHorizontal){
      //flip the image horizontally
      copy.flipHorizontal(); 
    }
    else{
      copy.flipVertical(); 
    }
    if (soundReverse){
      //flip the image vertically
      sound = sound.reverseSound();
    }
    //show
    copy.show();
    sound.blockingPlay();
    //hide
    copy.hide();
  }
}



