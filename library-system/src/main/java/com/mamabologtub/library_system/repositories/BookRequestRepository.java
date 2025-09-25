package com.mamabologtub.library_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mamabologtub.library_system.entities.BookRequest;

/**
 * @Author Tshepo M Mahudu on Jul 16, 2025.
 */

public interface BookRequestRepository extends JpaRepository<BookRequest, Long> {

}
