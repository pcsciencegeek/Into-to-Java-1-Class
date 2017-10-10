/* Filename: PSA4A.java 
* Created by: Shuaiqi Xia, cs8a3 and Tony Xia, cs8a4
* Date: 
*/ 

/*I've given you a basic skeleton of how your code is going to look so you 
 * can get a basic idea of the workflow here*/
public class PSA4A {
 public static void main(String [] args)
 {
   //Choose a picture file
   String sourceFile = FileChooser.pickAFile();
   Picture sourcePicture = new Picture(sourceFile);
   //show original
   sourcePicture.explore();
   //Copy your Picture objects
   Picture copy1 = new Picture(sourcePicture);
   Picture copy2 = new Picture(sourcePicture);
   //Call transformtions here
   sourcePicture.flipHorizontal();
   sourcePicture.show();
   //flip vertical
   copy1.flipVertical();
   copy1.show();
   copy2.grayscale();
   //show
   copy2.show();
   
   //Create array of Pictures
   Picture [] pictures = new Picture[3];
   pictures[0] = sourcePicture;
    pictures[1] = copy1;
    pictures[2] = copy2;
   //Create a picture object using the canvas which we will be drawing our collage on
   Picture canvas = new Picture(sourcePicture.getWidth()*3,sourcePicture.getHeight());
   canvas.collage(pictures);
   canvas.show();
   //Call collage() with your canvas and show it!
   
 }
 
}