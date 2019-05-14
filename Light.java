public class Light extends Process {
	private String name;

	public Light(String name) {
		super(10, Thread.State.RUNNABLE, "Light", "Light", Resources.lightSwitches.size());
		this.name = name;
		Resources.lightSwitches.add(this);
	}

	public static void main(String[] args) {

	}

	public void turnOn() {

		Process currProcess = new Process(3, Thread.State.RUNNABLE, "Light", "turnOn", this.ID);
		Queues.addToReadyQueue(currProcess);

	}

	public void turnOff() {
		Process currProcess = new Process(3, Thread.State.RUNNABLE, "Light", "turnOff", this.ID);
		Queues.addToReadyQueue(currProcess);

	}

	public void cycleLights() {
		if (!SoteriaTest.getSoteriaStatus()) {
			Process currProcess = new Process(10, Thread.State.RUNNABLE, "Light", "cycleLights", this.ID);
			while(!Queues.getReadyQueue().isEmpty())
				Queues.getReadyQueue().poll();
			SoteriaTest.repaintFromCurrentProcess();
			Queues.addToReadyQueue(currProcess);
		}
	}


}
