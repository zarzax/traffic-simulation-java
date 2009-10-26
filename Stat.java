// Example 27a
// Priority Queue and Simulation


// Statistics class for Car Simulation


public class Stat {

    // private variables


//    private static double lastUpdateTime;
    private static int oldQLen0, oldQLen2, oldQLen3, oldQLen4, oldQLen7, oldQLen10;
    private static double lastQUpdateTime0, lastQUpdateTime2, lastQUpdateTime3, 
    						lastQUpdateTime4, lastQUpdateTime7, lastQUpdateTime10;
    private static int count0, count2, count3, count4, count7, count10;
    private static double totalTime0, totalTime2, totalTime3, totalTime4, totalTime7, totalTime10;
//    private static double busyTime;
//    private static double idleTime;
    private static double maxWait0, maxWait2, maxWait3, maxWait4, maxWait7, maxWait10;
    private static double averageWait0, averageWait2, averageWait3, averageWait4, averageWait7, averageWait10;
    private static int maxQLen0, maxQLen2, maxQLen3, maxQLen4, maxQLen7, maxQLen10;
    private static double avgQLen0, avgQLen2, avgQLen3, avgQLen4, avgQLen7, avgQLen10; 
//    private static double averageServiceTime;
    //{1,2,3,6,9}
    private static int exit1, exit2, exit3, exit6, exit9;
    
    private static double avgCarsPerMile;
    
    private static int totalCarsThrough;
    private static int totalCarsLost;
    private static double avgTimeInSystem;
    private static int avgTimeCount;

    private static double avgCarDelay;
    private static int avgCarDelayCount;
    private static double avgCarVel;
    private static int avgCarVelCount;
    
    // public methods


    public static void updateQueueStats(double time, int qlen, int entNum) {
        
    	//{0,2,3,4,7,10}  positions of EntranceRamps
    	switch (entNum){
    	case 0: 
            if (qlen > maxQLen0)
                maxQLen0 = qlen;
              avgQLen0 += oldQLen0 * (time - lastQUpdateTime0);
              totalTime0 += time - lastQUpdateTime0;
              lastQUpdateTime0 = time;
              oldQLen0 = qlen;
              break;
              
    	case 2:
            if (qlen > maxQLen2)
                maxQLen2 = qlen;
              avgQLen2 += oldQLen2 * (time - lastQUpdateTime2);
              totalTime2 += time - lastQUpdateTime2;
              lastQUpdateTime2 = time;
              oldQLen2 = qlen;
              break;
              
    	case 3:
            if (qlen > maxQLen3)
                maxQLen3 = qlen;
              avgQLen3 += oldQLen3 * (time - lastQUpdateTime3);
              totalTime3 += time - lastQUpdateTime3;
              lastQUpdateTime3 = time;
              oldQLen3 = qlen;
              break;
              
    	case 4:
            if (qlen > maxQLen4)
                maxQLen4 = qlen;
              avgQLen4 += oldQLen4 * (time - lastQUpdateTime4);
              totalTime4 += time - lastQUpdateTime4;
              lastQUpdateTime4 = time;
              oldQLen4 = qlen;
              break;
              
    	case 7:
            if (qlen > maxQLen7)
                maxQLen7 = qlen;
              avgQLen7 += oldQLen7 * (time - lastQUpdateTime7);
              totalTime7 += time - lastQUpdateTime7;
              lastQUpdateTime7 = time;
              oldQLen7 = qlen;
              break;
              
    	case 10:
            if (qlen > maxQLen10)
                maxQLen10 = qlen;
              avgQLen10 += oldQLen10 * (time - lastQUpdateTime10);
              totalTime10 += time - lastQUpdateTime10;
              lastQUpdateTime10 = time;
              oldQLen10 = qlen;
              break;    
    	}
    }

    public static void updateAverageCarsPerMile(int cars){
    	avgCarsPerMile += cars; 
    }
    
    public static void updateTotalCars(int t){
    	totalCarsThrough = t;
    }
    
    public static void updateTotalCarsLost(int t){
    	totalCarsLost = t;
    }
    
    public static void updateAverageTimeInSystem(double startT, double endT){
    	avgTimeInSystem += (endT - startT);
    	avgTimeCount++;
    }
    
    public static void updateAverageCarDelay(double d){
    	avgCarDelay += d;
    	avgCarDelayCount++;
    }

    public static void updateAverageCarVelocity(double v){
    	avgCarVel += v;
    	avgCarVelCount++;
    }
/*    public static void updateBusyTimeStats(double time) {


        busyTime += time - lastUpdateTime;
        lastUpdateTime = time;
    }    */    


/*    public static void updateIdleTimeStats(double time) {
        
        idleTime += time - lastUpdateTime;
        lastUpdateTime = time;
    }*/


/*    public static void updateServiceTimeStats(double st) {
   
        averageServiceTime += st;
    }*/


    public static void updateWaitTimeStats(double time, double enterTime, int entNum) {
    
        double wait = time - enterTime;

        switch (entNum){
        case 0:
            if (wait > maxWait0)
                maxWait0 = wait;
              averageWait0 += wait;
              count0++;  // another leaves the waiting queue
              break;           
        case 2:
            if (wait > maxWait2)
                maxWait2 = wait;
              averageWait2 += wait;
              count2++;  // another leaves the waiting queue
              break;             
        case 3:
            if (wait > maxWait3)
                maxWait3 = wait;
              averageWait3 += wait;
              count3++;  // another leaves the waiting queue
              break;             
        case 4:
            if (wait > maxWait4)
                maxWait4 = wait;
              averageWait4 += wait;
              count4++;  // another leaves the waiting queue
              break;              
        case 7:
            if (wait > maxWait7)
                maxWait7 = wait;
              averageWait7 += wait;
              count7++;  // another leaves the waiting queue
              break;             
        case 10:
            if (wait > maxWait10)
                maxWait10 = wait;
              averageWait10 += wait;
              count10++;  // another leaves the waiting queue
              break;    
        }

    } 


    public static void updateExitLocationTimes(int ext){
    	switch (ext){
    	case 1:
    		exit1++;
    		break;
    	case 2:
    		exit2++;
    		break;
    	case 3:
    		exit3++;
    		break;
    	case 6:	
    		exit6++;
    		break;
    	case 9:
    		exit9++;
    		break;
    	}
    }

    public static void displayStats() {
        System.out.println("\n** Simulation Results **\n");
//        System.out.println(" Calculated Simulation Time: " + totalTime);
//        System.out.println(" Idle Time: " + idleTime);
//        System.out.println(" Busy Time: " + busyTime);
//        System.out.println(" (Busy Time based on service time: " + 
//                                               averageServiceTime + ")\n");
        System.out.println(" The Average Delay between car Entrances: " + avgCarDelay/avgCarDelayCount);
        System.out.println(" Maximum Queue Length for Entrance 0: " + maxQLen0);
        System.out.println(" Maximum Queue Length for Entrance 2: " + maxQLen2);
        System.out.println(" Maximum Queue Length for Entrance 3: " + maxQLen3);
        System.out.println(" Maximum Queue Length for Entrance 4: " + maxQLen4);
        System.out.println(" Maximum Queue Length for Entrance 7: " + maxQLen7);
        System.out.println(" Maximum Queue Length for Entrance 10: " + maxQLen10);
        System.out.println(" Avg. Queue Length for Entrance 0: " + avgQLen0/totalTime0);
        System.out.println(" Avg. Queue Length for Entrance 2: " + avgQLen2/totalTime2);
        System.out.println(" Avg. Queue Length for Entrance 3: " + avgQLen3/totalTime3);
        System.out.println(" Avg. Queue Length for Entrance 4: " + avgQLen4/totalTime4);
        System.out.println(" Avg. Queue Length for Entrance 7: " + avgQLen7/totalTime7);
        System.out.println(" Avg. Queue Length for Entrance 10: " + avgQLen10/totalTime10);
        System.out.println(" Avg. Queue Length for all queues: " + 
        			(avgQLen0 + avgQLen2 + avgQLen3 + avgQLen4 + avgQLen7 + avgQLen10)/6);
        System.out.println(" Maximum Waiting Time for Entrance 0: " + maxWait0);
        System.out.println(" Maximum Waiting Time for Entrance 2: " + maxWait2);
        System.out.println(" Maximum Waiting Time for Entrance 3: " + maxWait3);
        System.out.println(" Maximum Waiting Time for Entrance 4: " + maxWait4);
        System.out.println(" Maximum Waiting Time for Entrance 7: " + maxWait7);
        System.out.println(" Maximum Waiting Time for Entrance 10: " + maxWait10);
        System.out.println(" Avg. Waiting Time for cars through the queue at Entrance 0: " +
                                                 	averageWait0/count0);
        System.out.println(" Avg. Waiting Time for cars through the queue at Entrance 2: " +
                									averageWait2/count2);
        System.out.println(" Avg. Waiting Time for cars through the queue at Entrance 3: " +
                									averageWait3/count3);
        System.out.println(" Avg. Waiting Time for cars through the queue at Entrance 4: " +
                									averageWait4/count4);
        System.out.println(" Avg. Waiting Time for cars through the queue at Entrance 7: " +
                									averageWait7/count7);
        System.out.println(" Avg. Waiting Time for cars through the queue at Entrance 10: " +
                									averageWait10/count10);
        System.out.println(" Avg. Waiting Time for cars in all queues: " +
				(averageWait0 + averageWait2 + averageWait3 + averageWait4 + averageWait7 + averageWait10)/6); 
        System.out.println(" Avg. Time Cars Spent in System: " + avgTimeInSystem/avgTimeCount);
        System.out.println(" Avg. Velocity of Cars in System: " + avgCarVel/avgCarVelCount); 
        System.out.println(" Number of cars the Entrance 0 :" + count0);
        System.out.println(" Number of cars the Entrance 2 :" + count2);
        System.out.println(" Number of cars the Entrance 3 :" + count3);
        System.out.println(" Number of cars the Entrance 4 :" + count4);
        System.out.println(" Number of cars the Entrance 7 :" + count7);
        System.out.println(" Number of cars the Entrance 10 :" + count10);
        System.out.println(" Number of cars through exit 1 :" + exit1);
        System.out.println(" Number of cars through exit 2 :" + exit2);
        System.out.println(" Number of cars through exit 3 :" + exit3);
        System.out.println(" Number of cars through exit 6 :" + exit6);
        System.out.println(" Number of cars through exit 9 :" + exit9);
        System.out.println(" Number of cars through last mile :" + (totalCarsThrough - (exit1 + exit2 + exit3 + exit6 + exit9)));
        System.out.println(" Number of cars through system: " + totalCarsThrough);
        System.out.println(" Number of cars that were lost in the system: " + totalCarsLost);
        System.out.println(" Percent of cars lost in System : " + (((double)totalCarsLost/((double)totalCarsThrough + (double)totalCarsLost)) * 100) + "%");
        System.out.println("\n");


    }  // displayStats




}  // Stat class 