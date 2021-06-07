package com.nykdev.crud.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nykdev.crud.model.Product;

public interface ProdutoRepository extends JpaRepository<Product, Long> {

	@Query(value = "select u from Product u where u.name like %?1%")
	List<Product> buscarPorNome(String name);
	
	//	public Iterable<Product> findByNameContaining(String findName);
}
