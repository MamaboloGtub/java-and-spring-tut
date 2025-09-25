package com.mamabologtub.library_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.mamabologtub.library_system.entities.LoanApprover;

/**
 * @Author Tshepo M Mahudu on Sep 7, 2025.
 */

public interface LoanApproverRepository extends JpaRepository<LoanApprover, Long> {

}
