package tn.biat.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.biat.domain.Compte;
import tn.biat.repository.ICompteRepository;

@RestController
// @RequestMapping("/api") : si on veut faire un path global de controller
@CrossOrigin("*")
public class CompteController {

	// @Autowired
	private ICompteRepository repository;

	// @Autowired n est pas necessaire depuis V4
	public CompteController(ICompteRepository repository) {
		this.repository = repository;
	}

	@GetMapping(path = "/comptes")
	// Old way : @RequestMapping(path="/comptes",method=RequestMethod.GET)
	public List<Compte> getAllComptes() {
		return repository.findAll();
	}

	@GetMapping(path = "/comptes/{id}")
	public ResponseEntity<Compte> getCompteById(@PathVariable String id) {
		Optional<Compte> compte = repository.findById(id);
		if (!compte.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(compte.get());

	}

	// la résolution se fait par le type de requete ,
	// post ou get meme si les deux ont path="/comptes"
	@PostMapping(path = "/comptes")
	public ResponseEntity<Compte> addCompte(@RequestBody Compte c) {
		repository.save(c);
		return new ResponseEntity<Compte>(c, HttpStatus.CREATED);
	}

	@PutMapping(path = "/comptes")
	public ResponseEntity<Compte> updateCompte(@RequestBody Compte c) {
		repository.save(c);
		return new ResponseEntity<Compte>(c, HttpStatus.ACCEPTED);
	}

	@DeleteMapping(path = "/comptes/{id}")
	public ResponseEntity<Compte> deleteCompteById(@PathVariable String id) {
		Optional<Compte> compte = repository.findById(id);
		if (!compte.isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			repository.deleteById(id);
			return new ResponseEntity<Compte>(HttpStatus.ACCEPTED);
		}

	}

}
