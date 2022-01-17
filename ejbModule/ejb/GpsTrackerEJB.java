package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import beans.GpsTracker;
import beans.Vehicule;
import beans.ChartDto;
import service.GpsTrackerService;
import service.VehiculeService;
@Stateless
@WebService
public class GpsTrackerEJB {

	@EJB
	private GpsTrackerService gpsService;
	@WebMethod
	public void create(@WebParam(name="imei") String imei) {
		GpsTracker v = new GpsTracker(imei);
		gpsService.create(v);
	}
	
	@WebMethod
	public List<GpsTracker> listGpsTracker() {
		return gpsService.findAll();
	}
	@WebMethod
	public GpsTracker findById(@WebParam(name="id") Long id) {
		return gpsService.findById(id);
	}
	@WebMethod
	public void delete(@WebParam(name="id") Long id) {
		gpsService.delete(findById(id));
	}
	
	
	public List<beans.ChartDto> chartByGpsTracker() { 
        List<beans.ChartDto> charts = new ArrayList<>();
        return charts;
	}
	
}
