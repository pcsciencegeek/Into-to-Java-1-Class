/* Filename: RandomTurtleTester.java 
* Created by: Drew Mills, A13102641, d1mills@ucsd.edu, cs8afabt 
* Date: 10/16/2016
*/ 
public class RandomTurtleTester {
    //The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args) { 

      /**************** Part 1 ******************/
      //Create world
      World world1 = new World(400,400);
      //declare var
      int displace = 0;
      //Creates a turtle in world1
      Turtle t1Green = new Turtle(200,400,world1);   
      // move to left
      t1Green.takeStep(-1);
      //move to right
      t1Green.takeStep(1);
      
      /**************** Part 2 *****************/
      //Create world 2
      World world2 = new World(400,400);
      //reset var
      int totalDisplace = 0;
      //Creates a turtle in world2
      Turtle t2Blue = new Turtle(200,400,world2);   
      //move turtle 5 steps and calculate displace
      totalDisplace = t2Blue.rwPosition(6);
      // Print total
      System.out.println("The total tGreen Displacement is: " + totalDisplace);
      
      /**************** Part 3 *****************/
      //Create world 3
      World world3 = new World(400,400);      
      //declare var
      int steps = 0;
      //create new turtle object
      Turtle t3Purple = new Turtle(200, 400, world3);
      //move steps until max of given input
      steps = t3Purple.countSteps(5);
      //print out total steps taken
      System.out.println(steps + " steps to reach the maximum displacement");
    } 
}

