/* Filename: PSA4B.java 
* Created by: Shuaiqi Xia, cs8a3 and Tony Xia, cs8a4
* Date: 
*/ 

public class PSA4B {
 public static void main(String [] args)
 {
   //Choose a picture file
   String sourceFile = FileChooser.pickAFile();
   Picture sourcePicture = new Picture(sourceFile);
   sourcePicture.explore();
   //Copy our Picture objects
   Picture copy1 = new Picture(sourcePicture);
   copy1.flipVerticalRectangle(300,300,200,100);
   copy1.show();
   Picture copy2 = new Picture(sourcePicture);
   copy2.flipHorizontalRectangle(300,300,200,100);
   copy2.explore();

   //Call flipVerticalRectangle and flipHorizontalRectangle on your copies

   //Show both copies!
   
 }  
  
}