/* Filename: CreateShapes.java 
 * 
 * Created by: 
 * 
 * Drew Mills, A13102641, d1mills@ucsd.edu, cs8afabt 
 * Adrian Anderson, A11614907, ama013@ucsd.edu, cs8afanc 
 * 
 * Date: 10/5/16
 */ 
import java.awt.*;

public class CreateShapes {
    //The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args)  { 
        //Put all your commands to call drawShape 4 times on 4 different turtle objects 
        //Then REMOVE THIS COMMENT. 
      
      World w = new World();
      Turtle darwin = new Turtle(w); //Creates a turtle  
      Turtle currie = new Turtle(w); //Creates a turtle
      Turtle leakey = new Turtle(w); //Creates a turtle
      Turtle mendel = new Turtle(w); //Creates a turtle
      
      darwin.setPenColor(Color.red);
      darwin.setPenWidth(1);
      darwin.drawShape(3);
      
      currie.setPenColor(Color.magenta);
      currie.setPenWidth(2);
      currie.drawShape(7);
      
      leakey.setPenColor(Color.blue);
      leakey.setPenWidth(3);
      leakey.drawShape(15);
      
      mendel.setPenColor(Color.black);
      mendel.setPenWidth(4);
      mendel.drawShape(31);
      
    } 
}

