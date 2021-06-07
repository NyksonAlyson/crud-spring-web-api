package com.nykdev.crud.model.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nykdev.crud.model.Product;
import com.nykdev.crud.model.User;
import com.nykdev.crud.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	// INJEÇÃO DE DEPENDENCIA
	@Autowired
	private ProdutoRepository productoRepository;
	
	// BUSCAR TODOS OS PRODUTOS
	@GetMapping(value = "buscartodos")
	public ResponseEntity<List<Product>>listProducts(){
		List<Product> products=productoRepository.findAll();
		return ResponseEntity.ok(products);
	}
	// BUSCAR PRODUTO POR ID
	@GetMapping(value = "buscarProductid")
	@ResponseBody
	public ResponseEntity<Product>buscaruserid(@RequestParam(name="iduser")Long iduser){
				Product produtos= productoRepository.findById(iduser).get();
				return new ResponseEntity<Product>(produtos, HttpStatus.OK);
	}
	
	// BUSCAR PRODUTOS POR PAGINA
	@GetMapping(path = "/page")
	public ResponseEntity<Page<Product>>Paginas(Pageable pageable){
		Page<Product> listarProducts = productoRepository.findAll(pageable);
		return ResponseEntity.ok(listarProducts);	
	}
	
	@PostMapping(value = "salvar")
	public @ResponseBody Product pro(@RequestBody @Valid Product product) {
		return productoRepository.save(product);
	
	}
	// DELETAR PRODUTOS POR ID
	@DeleteMapping(value = "delete")
	@ResponseBody
	public void ExcluirProduto(@RequestParam Long id) {
		productoRepository.deleteById(id);
	}
	// ALTERA PRODUTOS 
	@PutMapping(path = "/update")
	public Product alterarProduto(@Valid Product product) {
		productoRepository.save(product);
		return product;
	}

	/*
	 * // BUSCAR PRODUTOS POR NOME
	 * 
	 * @GetMapping(path = "/name/{findName}") public
	 * Iterable<Product>obterProdutoPorNome(@PathVariable String findName){ return
	 * productoRepository.findByNameContaining(findName.trim());
	 * 
	 * }
	 */
	@GetMapping(value = "buscarPorNome")
	@ResponseBody
	public ResponseEntity<List<Product>>buscarPorNome(@RequestParam (name="name")String name){
		List<Product> produtos = productoRepository.buscarPorNome(name);
		return new ResponseEntity<List<Product>>(produtos, HttpStatus.OK);
	}
	
	/*
	 * @GetMapping(value = "buscarPorNome")
	 * 
	 * @ResponseBody public ResponseEntity<List<User>>buscarPorNome(@RequestParam
	 * (name= "name")String name){
	 * 
	 * List<User> usuario = userRepository.buscarPorNome(name); return new
	 * ResponseEntity<List<User>>(usuario,HttpStatus.OK); }
	 */
		
	
	
}
