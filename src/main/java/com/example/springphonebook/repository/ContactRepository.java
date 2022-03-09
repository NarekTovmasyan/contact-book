package com.example.springphonebook.repository;

import com.example.springphonebook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
