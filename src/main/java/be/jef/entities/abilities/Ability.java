package be.jef.entities.abilities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ability")
@NamedEntityGraphs({ @NamedEntityGraph(name = "Ability.metAbilityColumn", attributeNodes = @NamedAttributeNode("abilityColumn")) })
public class Ability implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long idAbility;
	private String abilityName;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idAbilityCol")
	AbilityColumn abilityColumn;
	@OneToMany(mappedBy = "ability")
	private Set<PersAbility> persAbility = new HashSet<PersAbility>();

	public long getIdAbility() {
		return idAbility;
	}

	public String getAbilityName() {
		return abilityName;
	}

	public AbilityColumn getAbilityColumn() {
		return abilityColumn;
	}

	public Set<PersAbility> getPersAbility() {
		return persAbility;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Ability)) {
			return false;
		}
		return ((Ability) obj).abilityName.equalsIgnoreCase(this.abilityName);
	}

	@Override
	public int hashCode() {
		return abilityName.toUpperCase().hashCode();
	}

}
