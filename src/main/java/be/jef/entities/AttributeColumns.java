package be.jef.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="attributecolumns")
public class AttributeColumns implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long idattributeCol;
	private String attributeColName;
	private long persId;

	public long getIdattributeCol() {
		return idattributeCol;
	}

	public String getAttributeColName() {
		return attributeColName;
	}

	public long getPersId() {
		return persId;
	}
	
	@Override
	 public boolean equals(Object obj) {
	 if ( ! (obj instanceof AttributeColumns)) {
	 return false;
	 }
	 return ((AttributeColumns) obj).attributeColName.equalsIgnoreCase(this.attributeColName);
	 }
	 @Override
	 public int hashCode() {
	 return attributeColName.toUpperCase().hashCode();
	 }
	 @ManyToMany
	 @JoinTable(
	 name = "persattcolumns",
	 joinColumns = @JoinColumn(name = "idAttributeCol"),
	 inverseJoinColumns = @JoinColumn(name = "persId"))
	 private Set<Personage> personages;
	 

}
