package com.Slokam.springWithHibernate.controler;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Slokam.springWithHibernate.aspect.performanceTimeAspect;
import com.Slokam.springWithHibernate.pojo.Book;
import com.Slokam.springWithHibernate.repo.bookrepo;

@RestController
public class bookcontroler {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(bookcontroler.class);

	
	@Autowired
	private bookrepo  bookre;
	
	@PostMapping("savebook")
	public ResponseEntity< Book> save(@RequestBody Book book)
	{
		
		//book.setDate(new Date());
		
		System.out.println(book);
		
		bookre.save(book);
		
		ResponseEntity< Book> re=new ResponseEntity<>(book,HttpStatus.OK);
		
		return re;
	}
	
	@GetMapping("getbooks/{id}")
	public Book getbyid(@PathVariable(name="id") Integer id)
	{
	LOGGER.trace("BOOK BY ID--TRACE");
	LOGGER.debug("BOOK BY ID--DEBUG");
	LOGGER.info("BOOK BY ID--INFO");
	LOGGER.error("BOOK BY ID--ERROR");
		Optional<Book> b= bookre.findById(id);
		if(b.isPresent())
		{
			return b.get();
		}
		else {
			return null;
		}
		
	
	}
	
	
	@PostMapping("savenbooks")
	public List<Book> savebooks(@RequestBody List<Book> book)
	{
		List< Book> b=bookre.saveAll(book);
		
		return b;
		
	}
	
	@GetMapping("allbooks")
	public List<Book> getall()
	{
		List<Book> b=bookre.findAll();
		return b;
	}
	
	@DeleteMapping ("delete/{id}")
	public Book deletebok(@RequestBody Book book)
	{
		
		bookre.delete(book);
		
		return book;
	
	}
	
	@GetMapping("getbyname/{name}")
	public List<Book> byname(@PathVariable(name="name")String name)
	{
		System.out.println("name:"+name);
		
		List<Book> b=bookre.findByName(name);
		
		
		
		return b;
	}
	
	@GetMapping("Getbynameandcost/{name}/{cost}")
	public List<Book> bynameandcost(@PathVariable (name="name") String name,
			@PathVariable(name="cost") Integer cost)
	{
		
		List<Book> b=bookre.findBooksByNameAndCost(name,cost);
		
		return b;
	}

	@GetMapping("greatercost/{cost}")
	public List<Book> gretercost(@PathVariable(name="cost") Integer cost)
	{
		System.out.println("cost:"+cost);
		List<Book> b=bookre.findByCostGreaterThan(cost);
		
		return b;
		
	}
	
	@GetMapping("bynamecontain/{name}")
	public List<Book> contain(@PathVariable(name="name")String name)
	{
		System.out.println("name:"+name);
		
		List<Book> b=bookre.findByNameContaining(name);
		
		return b;
	}
	
	@GetMapping("getbyAfterdate/{date}")
	public List<Book>  afterdate(@PathVariable(name="date") String datestr) throws Exception
	{
		SimpleDateFormat formate=new SimpleDateFormat("yyyy-MM-dd");
		Date date=formate.parse(datestr);
		List<Book> b=bookre.findByDateAfter(date);
		
		return b;
		
	}
	
	@GetMapping("getBeforeDate/{date}")
	public List<Book> bydatebefore(@PathVariable(name="date") String date) throws Exception
	{
		SimpleDateFormat formate =new SimpleDateFormat("yyyy-MM-dd");
		Date d=formate.parse(date);
		System.out.println(d);
		List<Book> b=bookre.findByDateBefore(d);
		
		
		return b;
		
	}
	
	@GetMapping("byTwoDays/{startingdate}/{endingdate}")
	public List< Book> Betweendate(@PathVariable(name="startingdate")  String sdate,
			@PathVariable(name="endingdate") String edate) throws Exception
	{
		SimpleDateFormat formate=new SimpleDateFormat("yyyy-MM-dd");
		Date d=formate.parse(sdate);
		Date d1=formate.parse(edate);
		
		List<Book> b=bookre.findByDateBetween(d, d1);
		
		return b;
		
	}
	
	
		
	
}
