package com.example.demo.domain.user.repository;

import com.example.demo.domain.user.entity.BlackList;
import org.springframework.data.repository.CrudRepository;

public interface BlackListRepository extends CrudRepository<BlackList, String> {
}
