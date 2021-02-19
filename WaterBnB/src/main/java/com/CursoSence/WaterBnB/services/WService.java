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
import com.CursoSence.WaterBnB.repositories.RoleRepository;

@Service
public class WService {
	
	private final BCryptPasswordEncoder bCrypt;
	
	private final PoolRepository poolR;
	private final ReviewRepository reviewR;
	private final RoleRepository rolesR;
	private final UserRepository userR;
	
	public WService(PoolRepository poolR, ReviewRepository reviewR, RoleRepository rolesR, UserRepository userR, BCryptPasswordEncoder bCrypt)
	{
		this.poolR = poolR;
		this.reviewR = reviewR;
		this.rolesR = rolesR;
		this.userR = userR;
		this.bCrypt = bCrypt;
	}
	
	public void registrerHost(User user)
	{
		user.setPassword(bCrypt.encode(user.getPassword()));
		user.setRole(rolesR.findRoleByName("ROLE_HOST"));
		userR.save(user);
	}
	
	public void registrerGuest(User user)
	{
		user.setPassword(bCrypt.encode(user.getPassword()));
		user.setRole(rolesR.findRoleByName("ROLE_GUEST"));
		userR.save(user);
	}
	
	public Pool savePool(Pool pool)
	{
		return poolR.save(pool);
	}
	
	public Review saveReview(Review review)
	{
		return reviewR.save(review);
	}
	
	public List<Pool> searchPools(String busqueda)
	{
		return poolR.findByAddressContaining(busqueda);
	}
	
	public User searchUser(Long id)
	{
		Optional<User> u = userR.findById(id);
		
		if(u.isEmpty())
		{
			return null;
		}
		else
		{
			return u.get();
		}
	}
	
	public User searchByEmail(String email)
	{
		return userR.findByEmail(email);
	}
	
	public Pool searchPool(Long id)
	{
		Optional<Pool> p = poolR.findById(id);
		
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
