package com.Slokam.springWithHibernate.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Slokam.springWithHibernate.pojo.Author;
import com.Slokam.springWithHibernate.pojo.Book;
import com.Slokam.springWithHibernate.repo.bookrepo;

@RestController
public class bookcontroler2 {
	
	@Autowired
	private bookrepo repo;
	
	@GetMapping("getbook/{name}")
	public List<Book> getbyname (@PathVariable (name="name") String name)
	{
		System.out.println(name);
		
		List<Book> b=repo.getByName(name);
		
		System.out.println(b);
		
		return b;
		
	}
	
	@GetMapping("namelike/{name}")
	public List<Book> getbynamelike(@PathVariable (name="name") String name )
	{
		List<Book> b=repo.getByNameLike(name+"%");
		
		return b;
		
	}
	
	@GetMapping("getdata2/{name}/{cost}")
	public List<Book> getbyname1andcost1(@PathVariable (name="name") String name,
			@PathVariable(name="cost") Integer cost)
	{
		List<Book> b=repo.getByNameAndCost(name, cost);
		
		return b;
		
	}
	
	@GetMapping("getauthoer1/{id}")
	public Author getauthor(@PathVariable(name="id") Integer id)
	{
		Author a=repo.getAuthorByName(id);
		
		return a;
		
	}
	
	@GetMapping("getbooksbyaid/{id}")
	public List<Book> getbookbyauthor(@PathVariable(name="id") Integer id)
	{
		
		List<Book> b=repo.getBooksByAuthorId(id);
		return b;
		
	}
	
	
	

}
