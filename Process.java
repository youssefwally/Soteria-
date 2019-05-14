public class Process extends Thread implements Comparable
{
    static int counter = 0;
	int ID;
    int priorityKey;
    Thread.State state;
    String type;
    String method;
    int number;

    public Process(int priorityKey, Thread.State state, String type, String method, int number)
    {
        this.ID = counter++;
        this.priorityKey = priorityKey;
        this.state = state;
        this.type = type;
        this. method = method;
        this.number = number;
    }

    public void updateState(Thread.State state) 
    {
        this.state = state;
    }

	@Override
	public int compareTo(Object o) {
		Process x = (Process)o;
		
		if(this.priorityKey > x.priorityKey)
			return -1;
		else
			if(this.priorityKey < x.priorityKey)
				return 1;
			else
				return 0;
	}
	
	public String toString()
	{
		return this.type + this.method;
	}
}