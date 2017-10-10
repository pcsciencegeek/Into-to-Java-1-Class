/* Filename: PSA7PictureTester.java 
* Created by: Shuaiqi Xia, cs8a3 and Tony Xia, cs8a4
* Date: 
*/ 
import java.util.Scanner;  // Do not remove this line

public class PSA7PictureTester
{
  /* Add your comment about what this program does here. */
  public static void main( String[] args )
  {

    Picture pic = new Picture( FileChooser.pickAFile() );
    pic.explore();

    int x, y, size;
    int width = pic.getWidth();
    int height = pic.getHeight();

    System.out.println( "Picture loaded with width=" + width +
                       " and height=" + height );

    Scanner reader = new Scanner( System.in );

    //Here's an example of reading integer input from the user.
    System.out.print("Please enter the x, y coordinates of lower left corner ");
    System.out.println( "of the box to flip horizontally, x first:" );
    x = reader.nextInt();
    y = reader.nextInt();
    System.out.println( "Enter the size of the box to flip:" );
    size = reader.nextInt();

    System.out.println( "You entered x=" + x + " y=" + y + " size=" + size );
    
    Picture edited = new Picture(pic);
    edited= pic.flipHorizontalSquare(x, y, size);
    edited.explore();

  }
}
