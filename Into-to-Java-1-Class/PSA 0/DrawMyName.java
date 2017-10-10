/*
 * File Name: DrawMyName.java
 * Created by:  Drew Mills, cs8afabt 
 * Due Date:  Sep 27th, 2016
 *
 */

public class DrawMyName
{
    // The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args)
    {
      // This is some starter code, but it has errors.  You will 
      // fix these errors and then add your code to draw your name
      // here.  Be sure to remove this comment once you've fixed the 
      // errors and started adding your own code.
      
      int counter = 0; // var for 4 
      World w = new World();
      Turtle jose = new Turtle(300,200,w); //Creates a turtle in w at (x,y) (200,100)     
      
      //Make a D shape 
      do{
        jose.forward(50);
        jose.turn(90);
        jose.forward(25);
        jose.turn(90);
        counter++;
      }while (counter < 2);
      counter = 0; // reset counter
      
      //lifts tail up and moves turtle to new postion
      jose.penUp();
      jose.turnRight();
      jose.forward(50);
      jose.turnLeft();
      
      //sets tail down makes shape R
      jose.penDown();
      jose.forward(50);
      
      while (counter < 3)
      {
        jose.turnRight();
        jose.forward(25);
        counter++;
      }
      counter = 0; //reset counter
      jose.turn(225);
      jose.forward(35);
      jose.turn(315);
      
       //lifts tail up and moves turtle to new postion
      jose.penUp();
      jose.forward(50);
      jose.turnLeft();
      jose.turnLeft();
      
      //sets tail down makes shape E
      jose.penDown();
      jose.forward(25);
      jose.turnRight();
      jose.forward(25);
      jose.turnRight();
      jose.forward(25);
      jose.turn(180);
      jose.forward(25);
      jose.turnRight();
      jose.forward(25);
      jose.turnRight();
      jose.forward(25);
      
      //lifts tail up and moves turtle to new postion
      jose.penUp();
      jose.forward(25);

      //sets tail down makes shape E
      jose.penDown();
      jose.turn(75);
      jose.forward(50);
      jose.turn(-150);
      jose.forward(25);
      jose.turn(150);
      jose.forward(25);
      jose.turn(-150);
      jose.forward(50);
    }
}
