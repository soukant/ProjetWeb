package beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: VehiculeGpsTracker
 *
 */
@Entity

public class VehiculeGpsTracker implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	VehiculeGpsTrackerKey id;
	 @ManyToOne
	 @MapsId("vehiculeId")
	 @JoinColumn(name = "vehicule_id")
	 Vehicule vehicule;
	 
	 @ManyToOne
	 @MapsId("trackerId")
	 @JoinColumn(name = "tracker_id")
	 GpsTracker tracker;

	 Date dateDebut;
	 Date dateFin;

	public VehiculeGpsTracker() {
		super();
	}
   
}
