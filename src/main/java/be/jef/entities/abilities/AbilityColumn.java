package be.jef.entities.abilities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "abilitycolumn")
public class AbilityColumn implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long idAbilityCol;
	@OneToMany(mappedBy = "abilityColumn")
	private Set<PersAbilCol> persAbilCols = new HashSet<PersAbilCol>();
	@OneToMany(mappedBy = "abilityColumn")
	private Set<Ability> Abilities = new HashSet<Ability>();
	@OneToMany(mappedBy = "abilityColumn")
	private Set<PersAbility> persAbilities = new HashSet<PersAbility>();
	private String abilityColName;

	public long getIdAbilityCol() {
		return idAbilityCol;
	}

	public Set<PersAbilCol> getPersAbilCols() {
		return persAbilCols;
	}

	public Set<Ability> getAbilities() {
		return Abilities;
	}

	public Set<PersAbility> getPersAbilities() {
		return persAbilities;
	}

	public String getAbilityColName() {
		return abilityColName;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AbilityColumn)) {
			return false;
		}
		return ((AbilityColumn) obj).abilityColName
				.equalsIgnoreCase(this.abilityColName);
	}

	@Override
	public int hashCode() {
		return abilityColName.toUpperCase().hashCode();
	}
	
}