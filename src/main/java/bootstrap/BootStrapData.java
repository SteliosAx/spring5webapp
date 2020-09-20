package bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		System.out.println("1");
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Started in Bootstrap 1");
		Author eric = new Author ("Eric","Evans");
		Book ddd = new Book( "Domain Driven Design", "123123");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		
		Author rod = new Author ("Rod","Hohnson");
		Book noEJB = new Book( "J2EE Development without EJB", "399459459");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
//		authorRepository.save(rod);
//		bookRepository.save(noEJB);

		System.out.println("Started in Bootstrap");
		System.out.println("Number of Books:" + bookRepository.count());
		
	}

}
