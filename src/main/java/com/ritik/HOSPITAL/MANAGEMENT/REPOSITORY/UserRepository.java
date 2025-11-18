package com.ritik.HOSPITAL.MANAGEMENT.REPOSITORY;
import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.User;

//import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User ,Long> {

    Optional<User> findByUsername(String username);

//    Optional<User> findByProviderIdAndProviderType(String providerId, AuthProviderType providerType);

}
