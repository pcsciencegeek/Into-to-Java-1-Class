/* Filename: PSA6.java 
 * Created by: Drew Mills cs8afabt A13102641 ; Vinamr Madan cs8afabo A13464556
 * Date: 11/11/2016 
 * 
 * In this PSA we have embedded secret images in other pictures
 * and also extracted those secret images out from other pictures.
 * 
 */ 
public class PSA6 extends Picture
{ 
//The line below is magic, you don't have to understand it (yet)
  public static void main (String[] args) 
  { 
    
    String contextPic = FileChooser.pickAFile();
    // choose file
    Picture context = new Picture(contextPic);
    //show file
    context.explore();
    //choose file
    String messagePic = FileChooser.pickAFile();
    Picture message = new Picture(messagePic);
    //show image
    message.explore();
    
    Picture myPicWithMessage= Picture.hideSecretMessage2Bits( context, message, 0, 0);
    //show image
    myPicWithMessage.explore(); 
    //save image
    myPicWithMessage.write(System.getProperty
                             ("user.home")+"/my_picture_with_hidden_msg.bmp");
    
    
    // choose image
    String recoverPic = FileChooser.pickAFile();
    Picture recoverPicture = Picture.recoverSecretMessageNBits
      (new Picture(recoverPic), 2, 0,0);
    // show image
    recoverPicture.explore();
    // write\save image
    recoverPicture.write(System.getProperty("user.home")+"/my_hidden_msg.bmp");
  } 
}
