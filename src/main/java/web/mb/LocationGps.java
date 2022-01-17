package web.mb;


import java.util.List;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.Statement;  
import java.sql.ResultSet;  
import java.util.ArrayList;  
import java.util.Map;  
import javax.faces.bean.ManagedBean;  
import javax.faces.bean.RequestScoped;  
import javax.faces.context.FacesContext; 

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import beans.GpsTracker;
import beans.Vehicule;
import service.GpsTrackerService;
import service.VehiculeService;

@ManagedBean(name="locationGps")
@RequestScoped
public class LocationGps {

	
	
	@EJB
	private GpsTrackerService gpsService;
	private Long id;
	private String simNumber;

	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}


	public String ajouter() {
		gpsService.create(new GpsTracker(simNumber));
		return "success";
	}
	
	public boolean delete(GpsTracker gps) {
		 return gpsService.delete(gps);

	}
	public GpsTracker findById(Long id_) {
		return gpsService.findById(id_);
	}
	public List<GpsTracker> getListGpsTracker(){
		return gpsService.findAll();
	}

	
	public GpsTrackerService getGpsService() {
		return gpsService;
	}


	public void setGpsService(GpsTrackerService gpsService) {
		this.gpsService = gpsService;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getSimNumber() {
		return simNumber;
	}


	 
}
