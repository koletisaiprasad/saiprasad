package com.exa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exa.entity.ContactDtls;

@Repository
public interface ContactRepo extends JpaRepository<ContactDtls,Integer>{

}
