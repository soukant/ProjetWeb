package beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Vehicule
 *
 */
@Entity
public class Vehicule implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String matricule;
	private String marque;
	private String type;
	
	
	@ManyToMany(fetch =FetchType.EAGER ,cascade = CascadeType.ALL)
	@JoinTable(name = "vehicules_trackers",joinColumns = @JoinColumn(name = "vehicule_id"),inverseJoinColumns = @JoinColumn(name = "gpstracker_id"))
	List<GpsTracker> GTrackers;
	
	public Vehicule() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Vehicule( String matricule, String marque, String type) {
		super();
		this.matricule = matricule;
		this.marque = marque;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Vehicule [id=" + id + ", matricule=" + matricule + ", marque=" + marque + ", type=" + type + "]";
	}
   
}
