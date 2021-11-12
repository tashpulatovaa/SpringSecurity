package peaksoft.auth;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import peaksoft.model.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserSecurityDaoImpl implements UserSecurityDao{

    private final SessionFactory sessionFactory;

    public UserSecurityDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<User> selectUserByUsername(String username) {
        List<User> fromUser = sessionFactory.getCurrentSession().createQuery("from User").getResultList();
        return fromUser.stream().filter(user -> user.getUsername().equals(username))
                .findFirst();
//        .orElseThrow(() -> new UsernameNotFoundException("username not found"));
    }
}
