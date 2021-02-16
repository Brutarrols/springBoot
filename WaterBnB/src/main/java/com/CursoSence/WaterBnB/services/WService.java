package com.CursoSence.WaterBnB.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.CursoSence.WaterBnB.models.Pool;
import com.CursoSence.WaterBnB.models.Review;
import com.CursoSence.WaterBnB.models.User;
import com.CursoSence.WaterBnB.repositories.PoolRepository;
import com.CursoSence.WaterBnB.repositories.ReviewRepository;
import com.CursoSence.WaterBnB.repositories.RoleRepository;
import com.CursoSence.WaterBnB.repositories.UserRepository;

@Service
public class WService {
	
	private final UserRepository userRepo;
	private final ReviewRepository reviewRepo;
	private final RoleRepository roleRepo;
	private final PoolRepository poolRepo;
	private final BCryptPasswordEncoder bCrypt;
	
	public WService(UserRepository userRepo, ReviewRepository reviewRepo, RoleRepository roleRepo, PoolRepository poolRepo, BCryptPasswordEncoder bCrypt)
	{
		this.userRepo = userRepo;
		this.reviewRepo = reviewRepo;
		this.roleRepo = roleRepo;
		this.poolRepo = poolRepo;
		this.bCrypt = bCrypt;
	}
	
	public void registrerHost(User user)
	{
		user.setPassword(bCrypt.encode(user.getPassword()));
		user.setRole(roleRepo.findRoleByName("ROLE_HOST"));
		userRepo.save(user);
	}
	
	public void registrerGuest(User user)
	{
		user.setPassword(bCrypt.encode(user.getPassword()));
		user.setRole(roleRepo.findRoleByName("ROLE_GUEST"));
		userRepo.save(user);
	}
	
	public Pool createPool(Pool pool)
	{
		return poolRepo.save(pool);
	}
	
	public Review createReview(Review review)
	{
		return reviewRepo.save(review);
	}
	
	public User findUserbyEmail(String email)
	{
		return userRepo.findUserByEmail(email);
	}
	
	public List<Pool> allPool()
	{
		return (List<Pool>) poolRepo.findAll();
	}
	
	public List<Pool> findUserByAddress(String location)
	{
		return poolRepo.findByAddressContaining(location);
	}

	public User userById(Long id)
	{
		Optional<User> u = userRepo.findById(id);
		
		if(u.isPresent())
		{
			return u.get();
		}
		else
		{
			return null;
		}
	}
	
	public Pool findPool(Long id)
	{
		Optional<Pool> p = poolRepo.findById(id); 
		
		if(p.isPresent())
		{
			return p.get();
		}
		else
		{
			return null;
		}
	}
}
