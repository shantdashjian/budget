package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "item")
public class Item {

	// fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private double value;
	
	@Column(name="date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date; 
	
	private String notes;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonBackReference(value="user-reference")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	@JsonBackReference(value="category-reference")
	private Category category;

	// gets and sets
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}

	// toString
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", value=" + value + ", date=" + date + ", notes=" + notes + "]";
	}
	
	
}
