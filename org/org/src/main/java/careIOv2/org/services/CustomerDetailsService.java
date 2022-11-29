package careIOv2.org.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import careIOv2.org.dao.CustomerRepository;
import careIOv2.org.entity.SecurityUser;

@Service
public class CustomerDetailsService implements UserDetailsService{

	private final CustomerRepository customerRepository;
	
	public CustomerDetailsService(CustomerRepository customerRepository)
	{
		this.customerRepository=customerRepository;
		
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return customerRepository.findByUserName(username)
				.map(SecurityUser::new).orElseThrow(()-> new UsernameNotFoundException("Username not found :" + username));
				
	}

}
