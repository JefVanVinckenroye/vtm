package be.jef.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import be.jef.dao.PersAttCol;

@Entity
@Table(name = "attributecolumns")
public class AttributeColumns implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long idattributeCol;
	@OneToMany(mappedBy = "attributeColumns")	
	private Set<PersAttCol> persAttCols = new HashSet<PersAttCol>();
	private String attributeColName;

	public long getIdattributeCol() {
		return idattributeCol;
	}

	public String getAttributeColName() {
		return attributeColName;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AttributeColumns)) {
			return false;
		}
		return ((AttributeColumns) obj).attributeColName
				.equalsIgnoreCase(this.attributeColName);
	}

	@Override
	public int hashCode() {
		return attributeColName.toUpperCase().hashCode();
	}	
}
