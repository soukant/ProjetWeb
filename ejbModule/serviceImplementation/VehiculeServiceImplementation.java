package serviceImplementation;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import beans.Vehicule;
import service.VehiculeService;
@Stateless(name = "Vehicule")
public class VehiculeServiceImplementation implements VehiculeService{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Location_EJB");
	EntityManager entityManager = emf.createEntityManager();
	//Create Method
	@Override
	public boolean create(Vehicule object) {
		if(object == null)
			return false;
		else
		{
			entityManager.getTransaction().begin();
			entityManager.persist(object);
			entityManager.getTransaction().commit();
			return true;
		}
	}
	//Update Method
	@Override
	public boolean update(Vehicule object) {
		if(object == null)
			return false;
		else
		{
			entityManager.getTransaction().begin();
			Vehicule vehiculeContainer = entityManager.find(Vehicule.class, object.getId());
			vehiculeContainer.setMarque(object.getMarque());
			vehiculeContainer.setMatricule(object.getMatricule());
			vehiculeContainer.setType(object.getType());
			entityManager.persist(vehiculeContainer);
			entityManager.getTransaction().commit();
			return true;
		}
	}
	//Delete Method
	@Override
	public boolean delete(Vehicule object) {
		if(object == null)
			return false;
		else
		{
			try {
				entityManager.getTransaction().begin();
				Vehicule vehiculeContainer = entityManager.find(Vehicule.class, object.getId());
				entityManager.remove(vehiculeContainer);
				entityManager.getTransaction().commit();
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
	//FindById Method
	@Override
	public Vehicule findById(Long id) {
		try {
			entityManager.getTransaction().begin();
			Vehicule vehiculeContainer = entityManager.find(Vehicule.class, id);
			entityManager.getTransaction().commit();
			return vehiculeContainer;
		}catch (Exception e) {
			return null;
		}
	}
	//FindAll
	@Override
	public List<Vehicule> findAll() {
		
		Query query = entityManager.createQuery("from Vehicule");
		return query.getResultList();
	}
}
