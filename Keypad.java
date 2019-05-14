import java.beans.PropertyChangeSupport;

public class Keypad extends Process {
	protected PropertyChangeSupport change;
	private String requiredPassword;
	private static int counter = 0;
	private String inputPassword;
	private boolean isOpen = false;
	private boolean isAdded = false;

	public Keypad(String requiredPassword) {
		super(3, Thread.State.RUNNABLE, "Keypad", "openDoor", counter);
		this.requiredPassword = requiredPassword;
		counter++;
	}

	public void openDoor(String entry) {
		if (entry.equals(requiredPassword)) {
			Process process = new Process(this.priorityKey, this.state, this.type, this.method, this.ID);
			Queues.addToReadyQueue(process);
			change = new PropertyChangeSupport(this);
//			Soteria.setStatus(false);
		}
	}

	public String getRequiredPassword() {
		return requiredPassword;
	}

	public void setRequiredPassword(String requiredPassword) {
		this.requiredPassword = requiredPassword;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Keypad.counter = counter;
	}

	public String getInputPassword() {
		return inputPassword;
	}

	public void setInputPassword(String inputPassword) {
		this.inputPassword = inputPassword;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public String lockDoor() {
		this.isOpen = false;
		return "Door is now locked";
	}

}
