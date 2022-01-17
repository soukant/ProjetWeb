package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import beans.Vehicule;
import service.VehiculeService;
@Stateless
@WebService
public class VehiculeEJB {

	@EJB
	private VehiculeService vehiculeService;
	@WebMethod
	public void create(@WebParam(name="marque") String marque,@WebParam(name="matricule") String matricule, @WebParam(name="type") String type) {
		Vehicule v = new Vehicule(matricule,marque,type);
		vehiculeService.create(v);
	}
	
	@WebMethod
	public List<Vehicule> listVehicules() {
		return vehiculeService.findAll();
	}
	@WebMethod
	public Vehicule findById(@WebParam(name="id") Long id) {
		return vehiculeService.findById(id);
	}
	@WebMethod
	public void delete(@WebParam(name="id") Long id) {
		vehiculeService.delete(findById(id));
	}
	
	
}
