import java.util.Queue;
import java.util.Vector;

public class ElevatorControlSystem {
  Vector<Elevator> elevators;
  Queue<Integer> availableLocations;

  public ElevatorControlSystem(Queue<Integer>q, Vector<Elevator> v){
    elevators = v;
    availableLocations = q;
  }
  public Vector<Elevator> getElevators(){
    return elevators;
  }
  public void pickUp(Integer pickUpFloor) {
      availableLocations.add(pickUpFloor);
  }
  public void goal(Integer elevatorId, Integer destinationFloor) {
    elevators.get(elevatorId).addNewGoal(destinationFloor);
  }
  public String getState(Integer e_id){
      Integer curr = elevators.get(e_id).currentFloor();
      Integer dest = elevators.get(e_id).nextGoal();
      String str = String.valueOf(curr)+ " " + String.valueOf(dest);
      return str;
  }
  public void step() {
    for (Elevator currElevator : elevators){
      switch (currElevator.status()){
      case ELEVATOR_NOTWORKING:
          break;
      case ELEVATOR_EMPTY:
          if (!availableLocations.isEmpty())
            currElevator.addNewGoal(availableLocations.poll());
          break;
        case ELEVATOR_OCCUPIED:
          switch (currElevator.direction()){
            case ELEVATOR_UP:
              currElevator.moveUp();
              break;
            case ELEVATOR_DOWN:
              currElevator.moveDown();
              break;
            case ELEVATOR_HOLD:
              currElevator.visitGoal();
              break;
          }
          if (currElevator.direction() == ElevatorDirection.ELEVATOR_UP)
          break;
      }
    }
  }
}
