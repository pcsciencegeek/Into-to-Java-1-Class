/*Created by: Drew Mills cs8afabt A13102641 Vinamr Madan cs8afabo
 * Date: 11/30/16
 * 
 * Represents the entire slideshow.
 * 
 * */
import java.util.Random;

public class Slideshow{
    /////////////// fields ////////////////////
  //the array of slides that are in this slideshow
  private Slide [ ] slides;
  //the probability of flipping the slide horizontally - btwn 0 and 1
  private double probFlip;
    /////////////// constructors ////////////////////////////////////
  //initialized the slids array - inputs: none
  public Slideshow(){
    slides = new Slide[0];
    probFlip = 0.5;
  }
  //Takes an input parameter for probFlip, and initializes the slides array
  public Slideshow(double inProb)
  { slides = new Slide[0];
    probFlip = inProb;
  }
    ////////////////// methods ////////////////////////////////////
  /* This method changes the value of probFlip to inProb(input parameter)
   * inProb will be between 0 and 1 (add error message if not) 
   * inputs - inProb: the probability number either 1 or 0
   */
  public void changeProbFlip(double inProb){
    if( inProb<=1 && inProb>=0){
      probFlip= inProb;
    }
  else{
    //print error
    System.out.println
    ("Inappropriate value for probFlip...probFlip will not be changed");
  }
  }
    /* This method adds a slide, inSlide, to the end of the slides array.
   * To add, a new array will be made with one extra space to add the slide
   * inputs - inSlide: slide to be added at the end of the slides array
   */
  public void addSlide(Slide inSlide){
    Slide[] temp = new Slide[slides.length + 1];
    for(int i =0 ; i< slides.length; i++){
      temp[i] = slides[i]; 
    }
    temp[slides.length] = inSlide;
    slides = temp;
  }
    /* This method changes the slide at index "slideToChange" to inSlide
   * It detects if the index "slideToChange" is within the bounds of the
   * slides array - where an error method is printed and no slide inserted
   * if the index is out of bounds.
   * Inputs - inSlide: Slide to be added, slideToChange: Slide to be changed 
   * to inSlide
   */
  public void changeSlide(Slide inSlide, int slideToChange){
    if ( slideToChange>= slides.length || slideToChange<0){
     System.out.println("wrong");
    return;
    }
  slides[slideToChange]= inSlide;
  }
    /* this method shows the entire slideshow from beginning to end
   * If the slides array is empty, error message is shown
   * Otherwise, each slide is shown with corresponding sound
   * This method also decides how to randomly flip the slides, passing
   * a boolean into showSlide method to get the correct flip to happen
   * Inputs - nothing
   * Outputs - void
   */
  public void show(){
    //error check
    if (slides.length == 0){
      System.out.println("Error! The slideshow is empty!");
      return;
    }
    for(int i=0;i<slides.length;i++){
       //declare variables
       //find random number
      Random random = new Random();
      double randnum = random.nextDouble();
      boolean flip;
      if(randnum<probFlip){
        flip = true;
      }
      else{
        flip = false;
      }
       //show slide and sound
      slides[i].showSlide(flip,flip);
    }
  }
  
  //////////////////// MAIN TEST ////////////////////////////////
  public static void main(String[] args){
    /////create picture and sound variables
    Picture pic1 = new Picture("pic1.jpg");
    Sound sound1 = new Sound("sound1.wav");
    Slide slide1 = new Slide(pic1,sound1);
    Picture pic2 = new Picture("pic2.jpg");
    Sound sound2 = new Sound("sound2.wav");
    Slide slide2 = new Slide(pic2,sound2);
    Picture pic3 = new Picture("pic3.jpg");
    Sound sound3 = new Sound("sound3.wav");
    Slide slide3 = new Slide(pic3,sound3);
    Picture pic4 = new Picture("pic4.jpg");
    Sound sound4 = new Sound("sound4.wav");
    Slide slide4 = new Slide(pic4,sound4);
    Slideshow slideshow = new Slideshow(0.6);
    //put together slideshow
    slideshow.addSlide(slide1);
    slideshow.addSlide(slide2);
    slideshow.addSlide(slide3);
    slideshow.addSlide(slide4);
    //display slideshow
    slideshow.show();
  }
} 

