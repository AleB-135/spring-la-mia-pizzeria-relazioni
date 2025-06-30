package org.lessons.java.spring.crud.spring_pizzeria_crud.repository;


import java.util.List;

import org.lessons.java.spring.crud.spring_pizzeria_crud.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository <Pizza, Integer> {
    public List<Pizza> findByNameContainingIgnoreCase(String Name);
}
