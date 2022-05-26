package com.kaankaplan.humanresources.services.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.kaankaplan.humanresources.dao.UserDao;
import com.kaankaplan.humanresources.models.User;
import com.kaankaplan.humanresources.services.interfaces.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserManager implements UserService, UserDetailsService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public List<User> getallUsers(int pageNo, int pageSize) {
		
		log.info("Bütün kullanıcılar listelendi");
		
		Pageable pageable = PageRequest.of(pageNo -1 , pageSize);
		
		return this.userDao.findAll(pageable).getContent();
	}

	@Override
	public User getUserById(int userId) {
		
		return this.userDao.getById(userId);
	}

	@Override
	public User getUserByEmail(String email) {
		
		return this.userDao.getUserByEmail(email);
	}

	@Override
	public void add(User user) {
		
		this.userDao.save(user);
		
	}

	@Override
	public void delete(int userId) {
		
		this.userDao.deleteById(userId);
		
	}
 
	@Override
	public void update(User user) {
		
//		User userFromDb = this.userDao.getUserByEmail(user.getEmail());
//		
//		if ( userFromDb != null) {
//			user.setFirstName(user.getFirstName());
//			user.setLastName(user.getLastName());
//			user.setPassword(user.getPassword());
//
//			this.userDao.save(userFromDb);
//		} else {
//			log.info("Email ile kayıtlı kullanıcı bulunamadı!");
//		}
//		
//		
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = this.userDao.getUserByEmail(email);
		
		if (user == null) {
			throw new UsernameNotFoundException("Kullanıcı bulunamadı");
		}
		
		String claimName = user.getOperationClaim().getClaimName();
		
		List<SimpleGrantedAuthority> authorities = Lists.newArrayList(
							
				new SimpleGrantedAuthority(claimName)
			);
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}

}
