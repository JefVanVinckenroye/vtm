package be.jef.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persattcolumns")
public class PersAttCol {
	@Id
	private Long persId;

}
