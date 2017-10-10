/* Filename: TurtleFun.java 
 * 
 * Created by: 
 * 
 * Drew Mills, A13102641, d1mills@ucsd.edu, cs8afabt 
 * Adrian Anderson, A11614907, ama013@ucsd.edu, cs8afanc 
 * 
 * Date: 10/5/16
 */ 
import java.awt.*;

public class TurtleFun {
  //The line below is magic, you don't have to understand it (yet)
  public static void main (String[] args) { 
    //Put all your commands to draw three separate shapes
    //Then REMOVE THIS COMMENT. 
      World w = new World();
      Turtle darwin = new Turtle(w); //Creates a turtle  
      Turtle currie = new Turtle(w); //Creates a turtle
      Turtle littleDarwin = darwin;
      // draws cross
      currie.drawShape(15);
      //draws cross
      darwin.penUp();
      darwin.turnLeft();
      darwin.forward(100);
      darwin.turnRight();
      darwin.penDown();
      darwin.drawShape(15);
     // draws cross
      littleDarwin.penUp();
      littleDarwin.turnLeft();
      littleDarwin.forward(185);
      littleDarwin.turn(270);
      littleDarwin.forward(-30);
      littleDarwin.penDown();
      littleDarwin.drawShape(15);
     
  } 
}
