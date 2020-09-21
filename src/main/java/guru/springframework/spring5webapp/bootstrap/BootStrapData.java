package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		System.out.println("1");
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		

		Publisher st = new Publisher("fddfg", "fffeee", "fdfdd", "feee", "rfsdds");
		publisherRepository.save(st);
		
		
		
		Author eric = new Author ("Eric","Evans");
		Book ddd = new Book( "Domain Driven Design", "123123");
		
		eric.getBooks().add(ddd);
		bookRepository.save(ddd);
		ddd.getAuthors().add(eric);
		authorRepository.save(eric);
		ddd.setPublisher(st);
		bookRepository.save(ddd);
		st.getBooks().add(ddd);
		publisherRepository.save(st);
		

		
		System.out.println("2");
//		bookRepository.save(ddd);
		System.out.println("3");

		
		Author rod = new Author ("Rod","Hohnson");
		
		Book noEJB = new Book( "J2EE Development without EJB", "399459459");
		Publisher st2 = new Publisher("Stelios", "Eliikwnos", "Athens", "Greece", "11364");	
		
		
		rod.getBooks().add(noEJB);		
		authorRepository.save(rod);
		
		noEJB.getAuthors().add(rod);
		bookRepository.save(noEJB);
		
		st2.getBooks().add(noEJB);
		bookRepository.save(noEJB);
		
		noEJB.setPublisher(st2);		
		publisherRepository.save(st2);
		
		
		System.out.println("Started in Bootstrap");
		System.out.println("Number of publishers:" + publisherRepository.count());
		System.out.println("Publisher Number of Books:" + st.getBooks().size());
		System.out.println("Publisher Number of Books:" + st2.getBooks().size());
		
	}

}
