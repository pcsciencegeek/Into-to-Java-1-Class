/* Filename: Turtle.java 
 * 
 * Created by: 
 * 
 * Drew Mills, A13102641, d1mills@ucsd.edu, cs8afabt 
 * Adrian Anderson, A11614907, ama013@ucsd.edu, cs8afanc 
 * 
 * Date: 10/5/16
 */ 

import java.util.*;
import java.awt.*;

/**
 * Class that represents a turtle which is similar to a Logo turtle.
 * This class inherts from SimpleTurtle and is for students
 * to add methods to.
 *
 * Copyright Georgia Institute of Technology 2004
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class Turtle extends SimpleTurtle {
  ////////////////// constructors ///////////////////////
  
  /** Constructor that takes the x and y and a picture to
   * draw on
   * @param x the starting x position
   * @param y the starting y position
   * @param picture the picture to draw on
   */
  public Turtle (int x, int y, Picture picture) {
    // let the parent constructor handle it
    super(x,y,picture);
  }
  
  /** Constructor that takes the x and y and a model
   * display to draw it on
   * @param x the starting x position
   * @param y the starting y position
   * @param modelDisplayer the thing that displays the model
   */
  public Turtle (int x, int y, ModelDisplay modelDisplayer) {
    // let the parent constructor handle it
    super(x,y,modelDisplayer);
  }
  
  /** Constructor that takes the model display
   * @param modelDisplay the thing that displays the model
   */
  public Turtle (ModelDisplay modelDisplay) {
    // let the parent constructor handle it
    super(modelDisplay);
  }
  
  /**
   * Constructor that takes a picture to draw on
   * @param p the picture to draw on
   */
  public Turtle (Picture p) {
    // let the parent constructor handle it
    super(p);
  }  
  
  /////////////////// methods ///////////////////////
  //put your drawShape method here
  public void drawShape(int wall){
    //moving to initial pos.
  this.penUp();
  this.forward(wall*3);
  this.penDown(); 
  //drawing cross
  this.turnRight();
  this.forward(wall);
  this.turnRight();
  this.forward(wall*2);
  this.turnLeft();
  this.forward(wall*2);
  this.turnRight();
  this.forward(wall*2);
  this.turnRight();
  this.forward(wall*2);
  this.turnLeft();
  this.forward(wall*2);
  this.turnRight();
  this.forward(wall*2);
  this.turnRight();
  this.forward(wall*2);
  this.turnLeft();
  this.forward(wall*2);
  this.turnRight();
  this.forward(wall*2);
  this.turnRight();
  this.forward(wall*2);
  this.turnLeft();
  this.forward(wall*2);
  this.turnRight();
  this.forward(wall*2);
  this.turnRight();
  this.forward(wall);
  //hiding turtle
//  this.hide();
 
  
  }

} // this } is the end of class Turtle, put all new methods before this