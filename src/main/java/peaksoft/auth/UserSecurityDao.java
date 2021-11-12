package peaksoft.auth;

import peaksoft.model.User;

import java.util.Optional;

public interface UserSecurityDao {

    Optional<User> selectUserByUsername(String username);

}
