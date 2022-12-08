package mercadona.springbootapp.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

//	private UserRepository userRepository;

//	private BCryptPasswordEncoder bCryptPasswordEncoder;

//	public UserController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
//		this.userRepository = userRepository;
//		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//	}

//	@PostMapping("/users/")
//	public void saveUsuario(@RequestBody User user) throws RestException {
//		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//		userRepository.save(user);
//	}
//
//	@GetMapping("/users/")
//	public List<User> getAllUsuarios() throws RestException, IOException {
//		return userRepository.findAll();
//	}

//	@GetMapping("/users/{username}")
//	public User getUsuario(@PathVariable String username) throws RestException, IOException {
//		return userRepository.findByUsername(username);
//	}
}
