package main;
import java.util.Calendar;
import java.util.Date;

public class Timer {
	long startTime=(long) 0;
	long stopTime=(long) 0;
	
	public Timer() {
	}

	/**
	 * Starts the {@linkplain Timer} object
	 */
	public void startTimer() {
		startTime = 	System.currentTimeMillis();
	}
	/**
	 * Stops the  object
	 * @throws TimerSetupException if {@linkplain Timer} not started
	 */
	public void stopTimer() throws TimerSetupException{
		if(startTime==0) {
			throw new TimerSetupException("Timer must be started first");
		}
		stopTime= System.currentTimeMillis();
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
	return	((((System.currentTimeMillis()-startTime))/1000.000)+" : Current Time in sec: ");
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
	return	((((System.currentTimeMillis()-startTime))/1000.000)+" : Current Time "+id.toUpperCase()+" in sec.");

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
		return (((this.stopTime-this.startTime)/1000.0000)+" : Lapsed Time in sec.");
	}

	/**
	 * Shows full time passed in se.  from when {@linkplain Timer} was started to when ot was stopped 
	 * @param id String identifier for this lapsed time
	 * @return String time passed from when timer was started to when it was stopped
	 * @throws TimerSetupException
	 */
	public String lapsedTime(String id) throws TimerSetupException {
		if(startTime==0||stopTime==0) {
				throw new TimerSetupException("Timer must be started and stopped first");
		}
		return (((this.stopTime-this.startTime)/1000.0000)+ " : Lapsed Time "+id.toUpperCase()+" in sec.");
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		Timer t1 = new Timer();
		t1.startTimer();
	
			Thread.sleep(1555);


			System.out.println(t1.currentTime("test one"));

			Thread.sleep(1555);

			t1.stopTimer();
	
				System.out.println(t1.lapsedTime("ss"));
		
	}
	
	
}

	
