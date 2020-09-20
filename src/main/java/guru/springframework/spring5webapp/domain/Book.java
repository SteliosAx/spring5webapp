package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Book {

	private String tilte;
	private String isbn;
	@ManyToMany
	@JoinTable(name="author_book", joinColumns = @JoinColumn(name = "book_id"),
	inverseJoinColumns = @JoinColumn(name="author_id"))
	private Set<Author> authors  = new HashSet<>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public Book() {
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTilte() {
		return tilte;
	}

	public void setTilte(String tilte) {
		this.tilte = tilte;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Book(String tilte, String isbn ){
//	public Book(String tilte, String isbn, Set<Author> authors) {
		super();
		this.tilte = tilte;
		this.isbn = isbn;
//		this.authors = authors;
	}

	
	
	@Override
	public String toString() {
		return "Book [tilte=" + tilte + ", isbn=" + isbn + ", authors=" + authors + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	} 
	
	
	
}
