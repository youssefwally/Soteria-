public class PanicButton extends Process {

	public boolean ButtonA;
	public boolean ButtonB;
	public boolean ButtonC;
	private static int counter = 0;

	public PanicButton() {
		super(9999, Thread.State.RUNNABLE, "PanicButtonA", "callPolice", counter);
		this.ID = counter++;
		Resources.panicButtons.add(this);
	}

	public void PressA() {
		Process currProcess = new Process(9999, Thread.State.RUNNABLE, "PanicButtonA", "callPolice", this.ID);
		// System.out.println("A process PressA() is running , contacting the police
		// department ");
		Queues.addToReadyQueue(currProcess);
		this.ButtonA = true;
	}

	public void PressB() {
		Process currProcess = new Process(9999, Thread.State.RUNNABLE, "PanicButtonB", "callFireDepartment", this.ID);
		// System.out.println("A process PressB() is running, contacting the fire
		// department");

		Queues.addToReadyQueue(currProcess);
		this.ButtonB = true;
	}

	public void PressC() {
		Process currProcess = new Process(9999, Thread.State.RUNNABLE, "PanicButtonC", "callHospital", this.ID);
		// System.out.println("A process PressC() is running, contacting the Hospital");
		Queues.addToReadyQueue(currProcess);
		this.ButtonC = true;
	}

	public String toString() {
		return "Panic Button" + this.ID;
	}

}