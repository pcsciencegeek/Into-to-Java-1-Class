/* Filename: RandomTurtleTester2.java 
* Created by: Drew Mills, A13102641, d1mills@ucsd.edu, cs8afabt 
* Date: 10/16/2016
* 
* Part 4:
* 
*  1 and 2. Average final signed-displacement for a random walker after
* making different number of random steps
* 
* | 100 random steps | 50  random steps | 25 random steps
* 
* Average final signed-displacement 
* 
* |40.92957 (at 0.3), -0.2676 (at .5), -40.7887 (at 0.7)  |
* |20.873 (at 0.3), 0.577 (at 0.5), -20.380 (at 0.7) |
* |10.2676 (at 0.3), 0.028169 (at 0.5), -10.6619 (at 0.7) |
* 
* Comment on the result: it seems that the smaller the amount of steps taken, 
* the closer the avg was to zero.
* 
* 
*  3 and 4. Average final square-displacement for a random walker after
* making different number of random steps
* 
* | 100 random steps | 50  random steps | 25 random steps
* 
* Average final Square-displacement 
* 
* |1680.549 (at 0.3), 92.94 (at 0.5), 1681.056 (at 0.7)  |
* |446.63 (at 0.3), 48.887 (at 0.5), 448.32 (at 0.7) |
* |130.14 (at 0.3), 32.6197 (at 0.5), 121.183 (at 0.7) |
* 
* Comment on the result: the smaller the amount of steps taken, 
* the closer the avg was to zero.
* 
*/ 
public class RandomTurtleTester2 {
    //The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args) {   

      /**************** Part 4 *****************/
      //Create world 
      World w = new World();
      //Create Turtle
      Turtle t = new Turtle( w );  
      //declare var
      int numTrials = 0;
      int steps = 100;
      double totalDisplacement = 0;
      double averageDisplacement = 0;
      double squareDisplacement = 0;
      double totalsqDisplacement = 0;
      double displacement = 0;
      double averagesqDisplacement = 0;
      
      while ( numTrials < 142 ) 
      {
        totalDisplacement = totalDisplacement + t.rwPositionPlain( steps );
        numTrials = numTrials + 1;
      }
      //reset var
      numTrials = 0;
      //loop of trials to get total squared displacement after inputed rounds
      while (numTrials < 142)
      {
        displacement = t.rwPositionPlain( steps );
        //square outputed displacement
        squareDisplacement = displacement * displacement;
        //create ongoing total displacement
        totalsqDisplacement = squareDisplacement + totalsqDisplacement;
        //increment trial numbers
        numTrials = numTrials + 1;
      }
      //average displacement totals
      averageDisplacement = totalDisplacement / numTrials;
      averagesqDisplacement = totalsqDisplacement / numTrials;
      //print out
      System.out.println("TOTAL DIS " + totalDisplacement);
      System.out.println("SQUARE TOTAL " + totalsqDisplacement);
      System.out.println("AVG " + averageDisplacement);
      System.out.println("AVGSQ " + averagesqDisplacement);

    } 
}

