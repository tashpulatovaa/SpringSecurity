package peaksoft.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.model.User;


@Service
public class UserSecurityService implements UserDetailsService {

    private final UserSecurityDao userSecurityDao;
    private final PasswordEncoder passwordEncoder;

    public UserSecurityService(UserSecurityDao userSecurityDao, PasswordEncoder passwordEncoder) {
        this.userSecurityDao = userSecurityDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userSecurityDao.selectUserByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException("username not found"));
        user.encode(passwordEncoder);
        return user;
    }
}
