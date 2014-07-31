import java.util.LinkedList;
import java.util.Queue;

public class Elevator  {
  private Integer currentFloor;
  private Queue<Integer> goal;

  public Elevator(Integer currentFloor, Queue<Integer> goal) {
    this.currentFloor = currentFloor;
    this.goal = new LinkedList<Integer>();
  }

  public int nextGoal(){
    return this.goal.peek();
  }

  public int currentFloor(){
    return this.currentFloor;
  }

  public void visitGoal(){
    this.goal.remove();
  }
  public void addNewGoal(Integer g) {
    this.goal.add(g);
  }

  public void moveUp() {
    currentFloor++;
  }

  public void moveDown() {
    currentFloor--;
  }

  public ElevatorDirection direction() {
    if (goal.size() > 0){
      if (currentFloor < goal.peek()){
        return ElevatorDirection.ELEVATOR_UP;
      } else if (currentFloor > goal.peek()) {
        return ElevatorDirection.ELEVATOR_DOWN;
      }
    }
    return ElevatorDirection.ELEVATOR_HOLD;
  }

  public ElevatorStatus status() {
    return (goal.size() > 0)?ElevatorStatus.ELEVATOR_OCCUPIED:ElevatorStatus.ELEVATOR_EMPTY;
  }

}
