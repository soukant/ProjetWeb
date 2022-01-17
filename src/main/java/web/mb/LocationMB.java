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


import beans.Vehicule;
import service.VehiculeService;

@ManagedBean(name="locationMB")
@RequestScoped
public class LocationMB {


	
	
	@EJB
	private VehiculeService vehiculeService;
	private Long id;
	private String marque;
	private String matricule;
	private String type;

	
	public String ajouter() {
		vehiculeService.create(new Vehicule(marque,matricule,type));
		return "success";
	}
	

	  
	 
	public List<Vehicule> getListVehicules(){
		return vehiculeService.findAll();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
 
	
}
