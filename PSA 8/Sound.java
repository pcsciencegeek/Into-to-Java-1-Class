/* Filename: Sound.java 
 * Created by:  Drew Mills cs8afabt A13102641 Vinamr Madan cs8afabo
 * Date: 11/30/2016
 * 
 * This class defines a sound, what it is and how it works
 * 
 */ 
/**
 * Class that represents a sound.  This class is used by the students
 * to extend the capabilities of SimpleSound.
 *
 * Copyright Georgia Institute of Technology 2004
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Sound extends SimpleSound
{
  
  /////////////// consructors ////////////////////////////////////
  
  /**
   * Constructor that takes a file name
   * @param fileName the name of the file to read the sound from
   */
  public Sound(String fileName)
  {
    // let the parent class handle setting the file name
    super(fileName);
  }
  
  /**
   * Constructor that takes the number of samples in
   * the sound
   * @param numSamples the number of samples desired
   */
  public Sound (int numSamples)
  {
    // let the parent class handle this
    super(numSamples);
  }
  
  /**
   * Constructor that takes the number of samples that this
   * sound will have and the sample rate
   * @param numSamples the number of samples desired
   * @param sampleRate the number of samples per second
   */
  public Sound (int numSamples, int sampleRate)
  {
    // let the parent class handle this
    super(numSamples,sampleRate);
  }
  
  /**
   * Constructor that takes a sound to copy
   */
  public Sound (Sound copySound)
  {
    // let the parent class handle this
    super(copySound);
  }
  
  ////////////////// methods ////////////////////////////////////
  
  /**
   * Method to return the string representation of this sound
   * @return a string with information about this sound
   */
  public String toString()
  {
    String output = "Sound";
    String fileName = getFileName();
    
    // if there is a file name then add that to the output
    if (fileName != null)
      output = output + " file: " + fileName;
    
    // add the length in frames
    output = output + " number of samples: " + getLengthInFrames();
    
    return output;
  }
  /**
   *This method will modify the calling object, overwriting the calling object 
   * with the content of Sound firstSound and then of Sound secondSound 
   */
  public void concatenateSound (Sound firstSound, Sound secondSound, int switchPoint)
  { for( int i=0; i<this.getLength() ; i++)
    { this.setSampleValueAt(i,0); 
    if(i<switchPoint && i< firstSound.getLength())
    {int value=firstSound.getSampleValueAt(i);
      this.setSampleValueAt(i,value); }
    else if (secondSound.getLength()> i - Math.min(switchPoint,firstSound.getLength()))
    {int value=secondSound.getSampleValueAt
      (i- Math.min(switchPoint,firstSound.getLength()));
    this.setSampleValueAt(i,value); }
  }
  }
  /**
   * This method reverses the calling objet and returns it.
   * 
   **/
  public Sound reverseSound()
  { Sound reverse = new Sound(this);
    for( int i=0; i<this.getLength() ; i++)
    { int value =this.getSampleValueAt(this.getLength()-i-1);
      reverse.setSampleValueAt(i,value);
    }
    return reverse;
  }
  /**
   * This method will return a new Sound object which is
   * the reverse of the calling object. 
   * 
   **/
  public Sound palindromeSound()
  { Sound reversed = new Sound(this);
    Sound palindromed= new Sound(this.getLength()*2);
    reversed= this.reverseSound();
    palindromed.concatenateSound(this,reversed, this.getLength()+1);
    return palindromed;
  } 
} // this } is the end of class Sound, put all new methods before this
