import java.util.*;
import java.awt.*;
import static java.lang.Math.*;

/**
 * In RandomTurtleTester.java two turtles take a random walks through a world.
 * In RandomTurtleTester2.java I did science/analysis on random walks. Based on 
 * the data, the smaller the amount of steps taken, the closer the average was 
 * to zero. Turtle.java defined what a turtle was and how it should act. 
 * 
 * 
 * Filename: Turtle.java 
 * Created by: Drew Mills, A13102641, d1mills@ucsd.edu, cs8afabt 
 * Date: 10/16/2016
 */ 

public class Turtle extends SimpleTurtle {
    ////////////////// constructors ///////////////////////

    /**
     * Constructor that takes the x and y and a picture to
     * draw on
     *
     * @param x       the starting x position
     * @param y       the starting y position
     * @param picture the picture to draw on
     */
    public Turtle(int x, int y, Picture picture) {
        // let the parent constructor handle it
        super(x, y, picture);
    }

    /**
     * Constructor that takes the x and y and a model
     * display to draw it on
     *
     * @param x              the starting x position
     * @param y              the starting y position
     * @param modelDisplayer the thing that displays the model
     */
    public Turtle(int x, int y,
                  ModelDisplay modelDisplayer) {
        // let the parent constructor handle it
        super(x, y, modelDisplayer);
    }

    /**
     * Constructor that takes the model display
     *
     * @param modelDisplay the thing that displays the model
     */
    public Turtle(ModelDisplay modelDisplay) {
        // let the parent constructor handle it
        super(modelDisplay);
    }

    /**
     * Constructor that takes a picture to draw on
     *
     * @param p the picture to draw on
     */
    public Turtle(Picture p) {
        // let the parent constructor handle it
        super(p);
    }

    /////////////////// methods ///////////////////////

    /**
     * Return whether or not the turtle should take a step to the left (-1)
     * or the right (+1)
     * Input: probabilityToLeft, the probability the tutle moving left. Should between 0-1.
     * Returns: -1 to represent a step to the left, 1 to represent a
     * step to the right.
     */
    public int getRandomStep(double probabilityToLeft) {
        Random numGenerator = new Random();
        // Choose either 0 or 1 (note that next int is NON inclusive 
        // of its argument).
        double choice = numGenerator.nextDouble();
        if (choice < probabilityToLeft) {
          return -1;
        } else {
          return 1;
        }
    }
    
 /** Display a random step of the turtle.  
    * inputs:
    *     direction: -1 for step to the left or 1 for step to the right
    * output: 
    *     Nothing.  Moves the calling turtle object.
    * */
    public void takeStep( int direction ){
      //move turtle object left
      if (direction == -1){
        this.turn(-25);
        this.forward(30);
        this.turn(25);
      }
      //move turtle object right
      else {
        this.turn(25);
        this.forward(30);
        this.turn(-25);
      }
    }
    
     /*
      * takes as input the number of random walk steps that the
      * calling object Turtle will take
      * 
      **/
  public int rwPosition( int nSteps )
  {
    //declare var
    int direction;
    int displace = 0;
    double defaultProbability = 0.5;
    //move input (nSteps) Random number of steps
    for(int count = 0; count < nSteps; count++)
    {
      direction = this.getRandomStep(defaultProbability);
      this.takeStep(direction);
      
      //count/addup displacement
      displace = displace + direction; 
    }
    return displace;
  }
  
  /*
   * 1.Display the Turtle's randomly walking up the page, until it reaches
   * maxDisplacement distance from its starting position
   * 
   * 2. Count and return the number of steps the Turtle took 
   * before it hit the maximum allowed displacement
   * 
   * */
    public int countSteps( int maxDisplacement )
  {
    //declare var
    int absolute = 0;
    int displacement = 0;
    int steps = 0;
    int direction = 0;
    double defaultProbability = 0.5;
    //loop to move turtle random steps until maxdisplacement
    for(int count = 0; absolute <= maxDisplacement; count++)
    {
       direction = this.getRandomStep(defaultProbability);
      this.takeStep(direction);
      
      //count displacement
      displacement = displacement + direction;
      absolute = Math.abs(displacement);
      steps++;
    }
    return steps;
    }
    
    /*
     * does not move the Turtle, simply return the final displacement,
     * in the same way rwPosition did
     * 
     * */
    public double rwPositionPlain(double nSteps){
      //declare var
      double direction = 0;
      double displacement = 0;
      double defaultProbability = 0.7;
      //move input Random steps
      for(double count = 0; count <= nSteps; count++){
        direction = this.getRandomStep(defaultProbability);
        //count displacement
        displacement = displacement + direction;    
      }
      return displacement; 
    }
    }// this } is the end of class Turtle, put all new methods before this
