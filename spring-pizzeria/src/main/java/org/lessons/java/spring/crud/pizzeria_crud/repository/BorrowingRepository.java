package org.lessons.java.spring.crud.pizzeria_crud.repository;

import org.lessons.java.spring.crud.pizzeria_crud.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRepository extends JpaRepository<Borrowing, Integer> {

}
