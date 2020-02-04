package fr.gtm.timer;



import java.util.Collection;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Singleton
public class TestTimerBean {
	
	private static final Logger LOGGER = Logger.getLogger("temps");
		
	@Resource private TimerService timerService ;

	private Timer timer ;
	
	
	public void departTimer (int s) {
		
	timerService.createTimer(0, s*1000, new Message("heloo"));
	
			LOGGER.info("Lancement du timer");
	}
	@Timeout
	public void action(Timer timer) {
		
		LOGGER.info("Salut");
		
	}
	
	public void stop() {
		// methode pour stopper tous les Timers
		
		Collection<Timer> timers = timerService.getAllTimers();
		
		for(Timer t : timers)
			t.cancel();	
		
	}

}
