package com.santhosh.springbootdemo.repo;

import com.santhosh.springbootdemo.entity.DummyTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DummyTableRepo extends JpaRepository<DummyTable,Long> {
}
