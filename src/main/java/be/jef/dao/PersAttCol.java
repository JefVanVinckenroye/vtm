package be.jef.dao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

import be.jef.entities.AttributeColumns;
import be.jef.entities.Personage;

@Entity
@Table(name = "persattcolumns")
@NamedEntityGraph(name = "PersAttCol.metPersonageEnAttributen", attributeNodes = {
		@NamedAttributeNode("personage"),
		@NamedAttributeNode("attributeColumns") })
public class PersAttCol implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long persAttColId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idattributeCol")
	AttributeColumns attributeColumns;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "persId")
	private Personage personage;
	@Enumerated(EnumType.STRING)
	private String attColValue;

	public long getPersAttColId() {
		return persAttColId;
	}

	public String getAttColValue() {
		return attColValue;
	}

}