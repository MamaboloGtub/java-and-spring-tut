CREATE TABLE admin (
    id VARCHAR(50) PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE loan_approver (
    approval_id BIGSERIAL PRIMARY KEY,
    request_id BIGINT NOT NULL,
    admin_id VARCHAR(50) NOT NULL,
    decision VARCHAR(20),
    decision_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_approver_request FOREIGN KEY (request_id) REFERENCES book_request(loan_id),
    CONSTRAINT fk_approver_admin FOREIGN KEY (admin_id) REFERENCES admin(id)
);