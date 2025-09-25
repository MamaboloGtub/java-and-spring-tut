package com.mamabologtub.library_system.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @Author Tshepo M Mahudu on Sep 7, 2025.
 */

@Data
@Table(name = "loan_approver")
@Entity
public class LoanApprover {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "approval_id")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "request_id", referencedColumnName = "loan_id", nullable = false)
    private BookRequest request;

}
