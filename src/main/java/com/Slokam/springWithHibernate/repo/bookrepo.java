package com.Slokam.springWithHibernate.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Slokam.springWithHibernate.pojo.Author;
import com.Slokam.springWithHibernate.pojo.Book;

@Repository
public interface bookrepo extends JpaRepository<Book,Integer> {
	
	
    @Query("select b.author from Book b where b.id=?1")
	public abstract Author getAuthorByName(Integer id);
    
    @Query("select b from Book b join b.author a where a.id=?1 ")
    public abstract List<Book> getBooksByAuthorId(Integer id);
	
	@Query("from Book b where b.name=?1")
	
	public abstract List<Book> getByName(String name);
	
	@Query("from Book b where b.name like ?1")
	public abstract List<Book> getByNameLike(String name);
	
	@Query("from Book b where b.name=?1 and b.cost=?2")
	public abstract List<Book> getByNameAndCost(String name,Integer cost);
	
	
	public abstract List<Book> findByName(String name);
	
	public abstract List<Book> findBooksByNameAndCost(String name,Integer cost);
	
	public abstract List<Book> findByCostGreaterThan(Integer cost);
	
	List<Book> findByNameContaining (String name);
	
	public abstract List<Book> findByDateAfter(Date date);
	
	public abstract List<Book> findByDateBefore(Date date);
	
	public abstract List<Book> findByDateBetween (Date Sdate ,Date Edate);
	
	

}