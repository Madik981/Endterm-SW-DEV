package kz.madik.midtermswdev.repository;

import kz.madik.midtermswdev.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRep extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String username);
}
