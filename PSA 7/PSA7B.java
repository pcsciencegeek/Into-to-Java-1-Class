/* Filename: PSA7B.java 
* Created by:  Drew Mills cs8afabt A13102641 Vinamr Madan cs8afabo
* Date: 11/20/2016
* 
* This class chooses a sound file, plays the OG file and then then plays the revirse
* the object is if the sound file contains a palindrome then the sound file will sound 
* the same twice when played. ie racecar
* 
*/ 

public class PSA7B
{
//The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args)
    {
      //choose a sound file 
      String file= FileChooser.pickAFile();
      // assign file
      Sound lol = new Sound(file);
      //play sound
      lol.blockingPlay();
      //assign
      Sound palindrome = new Sound(file);
      //palindrome
      palindrome = lol.palindromeSound();
      //play
      palindrome.blockingPlay();








    }
}
