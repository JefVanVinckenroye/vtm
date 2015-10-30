package be.jef.entities.attributes;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "attributecolumn")
public class AttributeColumn implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long idattributeCol;
	@OneToMany(mappedBy = "attributeColumn")
	private Set<PersAttCol> persAttCols = new HashSet<PersAttCol>();
	@OneToMany(mappedBy = "attributeColumn")
	private Set<Attribute> attributes = new HashSet<Attribute>();
	private String attributeColName;

	public long getIdattributeCol() {
		return idattributeCol;
	}

	public String getAttributeColName() {
		return attributeColName;
	}

	public Set<PersAttCol> getPersAttCols() {
		return persAttCols;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AttributeColumn)) {
			return false;
		}
		return ((AttributeColumn) obj).attributeColName
				.equalsIgnoreCase(this.attributeColName);
	}

	@Override
	public int hashCode() {
		return attributeColName.toUpperCase().hashCode();
	}
}
