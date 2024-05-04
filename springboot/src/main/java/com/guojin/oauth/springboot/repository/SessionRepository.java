package com.guojin.oauth.springboot.repository;

import com.guojin.oauth.springboot.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session,Integer> {
}
