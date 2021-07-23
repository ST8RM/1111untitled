package com.example.repository;


import com.example.models.Name1;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repos extends CrudRepository<Name1,Long> {

//  void delete(Optional<Name1> name1);
    //DAO - data access object (DAO) — абстрактный интерфейс к какому-либо типу базы данных или механизму хранения. Определённые возможности предоставляются независимо от того, какой механизм хранения используется и без необходимости специальным образом соответствовать этому механизму хранения.

    }

