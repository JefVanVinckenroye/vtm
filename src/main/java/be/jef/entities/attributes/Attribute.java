package be.jef.entities.attributes;

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
@Table(name = "attribute")
@NamedEntityGraphs({ @NamedEntityGraph(name = "Attribute.metAttributeColumn", attributeNodes = @NamedAttributeNode("attributeColumn")) })
public class Attribute implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long idAttribute;
	private String attributeName;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idattributeCol")
	AttributeColumn attributeColumn;
	@OneToMany(mappedBy = "attribute")
	private Set<PersAttribute> persAttributes = new HashSet<PersAttribute>();

	public long getIdAttribute() {
		return idAttribute;
	}

	public Set<PersAttribute> getPersAttributes() {
		return persAttributes;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public AttributeColumn getAttributeColumn() {
		return attributeColumn;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Attribute)) {
			return false;
		}
		return ((Attribute) obj).attributeName
				.equalsIgnoreCase(this.attributeName);
	}

	@Override
	public int hashCode() {
		return attributeName.toUpperCase().hashCode();
	}

}
