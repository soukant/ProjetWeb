package serviceImplementation;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import beans.GpsTracker;
import service.GpsTrackerService;
@Stateless
public class GpsTrackerServiceImplementation implements GpsTrackerService{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Location_EJB");
	EntityManager entityManager = emf.createEntityManager();
	//Create Method
	@Override
	public boolean create(GpsTracker object) {
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
	public boolean update(GpsTracker object) {
		if(object == null)
			return false;
		else
		{
			entityManager.getTransaction().begin();
			GpsTracker gpsTrackerContainer = entityManager.find(GpsTracker.class, object.getId());
			gpsTrackerContainer.setSimNumber(object.getSimNumber());
			entityManager.persist(gpsTrackerContainer);
			entityManager.getTransaction().commit();
			return true;
		}
	}
	//Delete Method
	@Override
	public boolean delete(GpsTracker object) {
		if(object == null)
			return false;
		else
		{
			try {
				entityManager.getTransaction().begin();
				GpsTracker gpsTrackerContainer = entityManager.find(GpsTracker.class, object.getId());
				entityManager.remove(gpsTrackerContainer);
				entityManager.getTransaction().commit();
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
	//FindById Method
	@Override
	public GpsTracker findById(Long id) {
		try {
			entityManager.getTransaction().begin();
			GpsTracker gpsTrackerContainer = entityManager.find(GpsTracker.class, id);
			entityManager.getTransaction().commit();
			return gpsTrackerContainer;
		}catch (Exception e) {
			return null;
		}
	}
	//FindAll
	@Override
	public List<GpsTracker> findAll() {
		Query query = entityManager.createQuery("from GpsTracker");
		return query.getResultList();
	}
	@Override
	public GpsTracker findBySim(String sim) { 
		Query query = entityManager.createQuery("select g FROM GpsTracker g WHERE g.simNumber=:sim").setParameter("sim", sim);
		return (GpsTracker) query.getSingleResult();
	}
	
	
}
