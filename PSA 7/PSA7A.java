/* Filename: PSA7.java
 * Created by: Drew Mills cs8afabt A13102641 Vinamr Madan cs8afabo
 * Date: 11/20/2016
 * 
 * This class will take 2 sounds and put them together.
 * 
 */ 
public class PSA7A
{
//The line below is magic, you don't have to understand it (yet)
  public static void main (String[] args)
  {  
    //choose sound files
    String file = FileChooser.pickAFile();
    String file1 = FileChooser.pickAFile();
    String file2 = FileChooser.pickAFile();
    // assign file
    Sound soundFile = new Sound(file);
    Sound soundFile1 = new Sound(file1);
    //play sound
    soundFile1.blockingPlay();
    Sound soundFile2 = new Sound(file2);
    //play sound
    soundFile2.blockingPlay();
    // concatenate
    soundFile.concatenateSound(soundFile1,soundFile2,24500);
    //play sound
    soundFile.blockingPlay();
  }
}
