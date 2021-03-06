package drafter.domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Planning extends Meeting{

	
	public Planning() {
		super();
	}
	
	private Collection<SprintBacklog> backlog;
	
	@Valid 
	@NotNull
	@OneToMany(cascade = CascadeType.ALL)
	public Collection<SprintBacklog> getBacklog() {
		return backlog;
	}


	public void setBacklog(Collection<SprintBacklog> backlog) {
		this.backlog = backlog;
	}


	@Override
	@Transient
	public String getType() {
		return "planning";
	}



}
