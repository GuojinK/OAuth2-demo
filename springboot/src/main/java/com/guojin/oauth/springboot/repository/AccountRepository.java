package com.guojin.oauth.springboot.repository;

import com.guojin.oauth.springboot.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    @Query(value = "SELECT  user_id from user where email = ?1",nativeQuery = true)
    Integer findUseIdBYEmail(String email);

    Account findByEmail(String email);

}
