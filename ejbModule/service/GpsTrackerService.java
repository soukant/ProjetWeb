package service;



import javax.ejb.Remote;

import beans.GpsTracker;
import dao.IDao;

@Remote
public interface GpsTrackerService extends IDao<GpsTracker>{

	public GpsTracker findBySim(String sim); 
}
