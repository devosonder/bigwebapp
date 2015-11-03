package org.onderdal.config.security;

import org.onderdal.UserDAO;
import org.onderdal.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("jpaUserDetailsService")
@Transactional(readOnly = true, isolation = Isolation.DEFAULT, rollbackFor = {Exception.class}, propagation = Propagation.REQUIRED)
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    UserDAO userDAO;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        User user = userDAO.getByLoginName(loginName);

        if (user != null) {
            return new JpaUserDetails(user);
        }

        throw new UsernameNotFoundException(loginName);
    }



}
