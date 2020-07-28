package com.rafaellima.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rafaellima.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
