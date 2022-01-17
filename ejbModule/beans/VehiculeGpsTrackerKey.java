package beans;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: VehiculeGpsTrackerKey
 *
 */
@Embeddable
public class VehiculeGpsTrackerKey implements Serializable {

	
	private static final long serialVersionUID = 1L;
	 @Column(name = "vehicule_id")
	    Long vehiculeId;    
	 @Column(name = "tracker_id")
	    Long trackerId;
	    
	@Override
	public int hashCode() {
		return Objects.hash(trackerId, vehiculeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehiculeGpsTrackerKey other = (VehiculeGpsTrackerKey) obj;
		return Objects.equals(trackerId, other.trackerId) && Objects.equals(vehiculeId, other.vehiculeId);
	}

	public VehiculeGpsTrackerKey() {
		super();
	}
   
}
