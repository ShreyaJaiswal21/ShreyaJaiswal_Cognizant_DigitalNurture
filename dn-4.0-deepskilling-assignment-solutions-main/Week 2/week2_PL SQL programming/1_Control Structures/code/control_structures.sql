
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE loans';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE customers';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

-- Customers Table
CREATE TABLE customers (
    customer_id    NUMBER PRIMARY KEY,
    name           VARCHAR2(100),
    age            NUMBER,
    balance        NUMBER,
    is_vip         CHAR(1) DEFAULT 'N'  -- 'Y' or 'N'
);

-- Loans Table
CREATE TABLE loans (
    loan_id        NUMBER PRIMARY KEY,
    customer_id    NUMBER REFERENCES customers(customer_id),
    interest_rate  NUMBER(5,2),
    due_date       DATE
);

--Sample Data
INSERT INTO customers VALUES (1, 'Alice',   65, 15000, 'N');
INSERT INTO customers VALUES (2, 'Bob',     45,  8000, 'N');
INSERT INTO customers VALUES (3, 'Charlie', 70, 12000, 'N');
INSERT INTO customers VALUES (4, 'David',   30,  5000, 'N');

INSERT INTO loans VALUES (101, 1, 7.5, SYSDATE + 10);
INSERT INTO loans VALUES (102, 2, 6.5, SYSDATE + 40);
INSERT INTO loans VALUES (103, 3, 8.0, SYSDATE + 20);
INSERT INTO loans VALUES (104, 4, 9.5, SYSDATE + 5);

COMMIT;

BEGIN
    FOR c IN (SELECT c.customer_id, l.loan_id, l.interest_rate
              FROM customers c
              JOIN loans l ON c.customer_id = l.customer_id
              WHERE c.age > 60) LOOP

        UPDATE loans
        SET interest_rate = interest_rate - 1
        WHERE loan_id = c.loan_id;

        DBMS_OUTPUT.PUT_LINE('Applied 1% discount to Loan ID: ' || c.loan_id);
    END LOOP;
END;
/


BEGIN
    FOR cust IN (SELECT customer_id FROM customers WHERE balance > 10000) LOOP
        UPDATE customers
        SET is_vip = 'Y'
        WHERE customer_id = cust.customer_id;

        DBMS_OUTPUT.PUT_LINE('Customer ID ' || cust.customer_id || ' promoted to VIP.');
    END LOOP;
END;
/

BEGIN
    FOR due_loan IN (
        SELECT l.loan_id, c.name, l.due_date
        FROM loans l
        JOIN customers c ON c.customer_id = l.customer_id
        WHERE l.due_date <= SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || due_loan.loan_id ||
                             ' for ' || due_loan.name ||
                             ' is due on ' || TO_CHAR(due_loan.due_date, 'DD-MON-YYYY'));
    END LOOP;
END;
/

