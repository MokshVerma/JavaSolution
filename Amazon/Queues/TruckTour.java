package AmazonGFG.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class TruckTour {

    int tour(int petrol[], int distance[]){
        int start=0, currPetrol=0, deficit=0;
        for(int i=0; i<petrol.length; i++){
            currPetrol += petrol[i] - distance[i];
            if(currPetrol==0) {
                start=i+1;
                deficit += currPetrol;
                currPetrol = 0;
            }
        }
        return (currPetrol+deficit>0)?start:-1;
    }

}
