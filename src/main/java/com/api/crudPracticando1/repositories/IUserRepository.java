package com.api.crudPracticando1.repositories;

import com.api.crudPracticando1.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {



}
