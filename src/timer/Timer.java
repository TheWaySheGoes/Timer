package timer;


/**
 * This timer counts time when started to when it is stopped. It can show current lapsed time without stopping the  {@linkplain Timer}, 
 * or full lapsed time after when  {@linkplain Timer} is stopped. A label can be defined for a timer and a secondary label for every 
 * current time check.
 * @author lukas Kurasinski
 *
 */
public class Timer {
	long startTime=(long) 0;
	long stopTime=(long) 0;
	String id;
	public Timer() {
	}
	public Timer(String id) {
		this.id=id.toUpperCase();
	}

	/**
	 * Starts the {@linkplain Timer} object
	 */
	public String startTimer() {
		startTime = 	System.currentTimeMillis();
		if(this.id!=null) {
			return ("Timer "+this.id+" started");
		}else {
			return ("Timer started");
		}
	}
	/**
	 * Stops the  object
	 * @throws TimerSetupException if {@linkplain Timer} not started
	 */
	public String stopTimer() throws TimerSetupException{
		if(startTime==0) {
			throw new TimerSetupException("Timer must be started first");
		}
		stopTime= System.currentTimeMillis();
		if(this.id!=null) {
			return "Timer "+this.id+" stopped";
		}else {
			return "Timer stopped";
		}
	}
	/**
	 * Shows current time in sec. without stopping the {@linkplain Timer} object
	 * @return String current time passed
	 * @throws TimerSetupException if {@linkplain Timer} not started
	 */
	public String currentTime() throws TimerSetupException{
		if(startTime==0) {
			throw new TimerSetupException("Timer must be started first");
		}
		if(this.id!=null) {
			return	(String.format("%1$-6s",(((System.currentTimeMillis()-startTime))/1000.0000))+" : "+this.id+" current Time in sec: ");
			
		}else {
			return	(String.format("%1$-6s",(((System.currentTimeMillis()-startTime))/1000.0000))+" : Current Time in sec: ");
		}
	}	
	/**
	 * Shows current time in sec. without stopping the {@linkplain Timer} object
	 * @param id String identifier for this current time
	 * @return String current time passed 
	 * @throws TimerSetupException if {@linkplain Timer} not started
	 */
	public String currentTime(String id) throws TimerSetupException{
		if(startTime==0) {
			throw new TimerSetupException("Timer must be started first");
		}
		if(this.id!=null) {
			return	( String.format("%1$-6s",(((System.currentTimeMillis()-startTime))/1000.0000))+" : "+this.id+" current Time "+id.toUpperCase()+" in sec.");
		}else {
			return	( String.format("%1$-6s",(((System.currentTimeMillis()-startTime))/1000.0000))+" : Current Time "+id.toUpperCase()+" in sec.");
		}
	}
	
	/**
	 * Shows full time passed in sec. from when {@linkplain Timer} was started to when it was stopped
	 * @return String time passed from when timer was started to when it was stopped
	 * @throws TimerSetupException
	 */
	public String lapsedTime() throws TimerSetupException{
		if(startTime==0||stopTime==0) {
			throw new TimerSetupException("Timer must be started and stopped first");
		}
		if(this.id!=null) {
			return (String.format("%1$-6s",((this.stopTime-this.startTime)/1000.0000))+" : "+this.id+" lapsed Time in sec.");
		}
		return (String.format("%1$-6s",((this.stopTime-this.startTime)/1000.0000))+" : Lapsed Time in sec.");
	}

	public static void main(String[] args) throws Exception {
		Timer t1 = new Timer("test timer");
			System.out.println(t1.startTimer());
			System.out.println(t1.currentTime("test one"));
			Thread.sleep(1000);
			System.out.println(t1.currentTime("test two"));
			Thread.sleep(1000);
			System.out.println(t1.currentTime("test three"));
			Thread.sleep(1000);
			System.out.println(t1.stopTimer());
			System.out.println(t1.lapsedTime());
		
	}
	
	
}

	
