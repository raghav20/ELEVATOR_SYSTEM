import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Building{
    public static final int MAX_ELEVATORS = 16;
    Integer numberOfElevators = 0;
    Integer numberOfFloors = 0;
    Vector<Elevator> elevators;
    Queue<Integer> pickupLocations;
    ElevatorControlSystem ecs = null;
    public Building(Integer no_Elevators, Integer no_Floors){
        this.numberOfElevators = no_Elevators;
        this.numberOfFloors = no_Floors;
        if(this.numberOfElevators>16)this.numberOfElevators = 16;
        if(this.numberOfFloors<0 || numberOfElevators<0)System.exit(0);
        initializeElevators();
        pickupLocations = new LinkedList<Integer>();
        setElevatorControl(pickupLocations,elevators);
    }

    private void initializeElevators(){
        elevators = new Vector<Elevator>();
        for (int i=0;i<this.numberOfElevators;i++){
            elevators.add(new Elevator(1, null));
        }
    }
    private void setElevatorControl(Queue<Integer> q,Vector<Elevator>e){
        ecs = new ElevatorControlSystem(q,e);
    }
    public ElevatorControlSystem getElevatorControlSystem(){
        return ecs;
    }
}
