public class Demo{
	public static void main(String args[]){
	     Building ecs = new Building(2,5);
         ElevatorControlSystem ec = ecs.getElevatorControlSystem();
         ec.goal(1,4);
         ec.goal(1,2);
         ec.goal(1,3);
         System.out.println(ec.getState(1));
	}
}
