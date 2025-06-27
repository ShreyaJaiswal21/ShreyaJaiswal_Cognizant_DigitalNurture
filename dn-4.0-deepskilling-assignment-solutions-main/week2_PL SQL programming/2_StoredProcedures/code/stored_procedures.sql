
SET SERVEROUTPUT ON;

-- Create Accounts Table
CREATE TABLE "acc_ounts" (
    "acc_id" NUMBER PRIMARY KEY,
    "acc_type" VARCHAR2(20),
    "balance" NUMBER
);

-- Create Employees Table
CREATE TABLE "employ$ee" (
    "emp_id" NUMBER PRIMARY KEY,
    "f_name" VARCHAR2(30),
    "l_name" VARCHAR2(30),
    "department" VARCHAR2(30),
    "salary" NUMBER,
    "performance_rating" VARCHAR2(10)
);

-- Insert Accounts
INSERT INTO "acc_ounts" VALUES (101, 'savings', 10000);
INSERT INTO "acc_ounts" VALUES (102, 'savings', 5000);
INSERT INTO "acc_ounts" VALUES (103, 'current', 15000);
INSERT INTO "acc_ounts" VALUES (104, 'savings', 2000);

-- Insert Employees
INSERT INTO "employ$ee" VALUES (1, 'Alice', 'Smith', 'HR', 30000, 'A');
INSERT INTO "employ$ee" VALUES (2, 'Bob', 'Brown', 'HR', 32000, 'B');
INSERT INTO "employ$ee" VALUES (3, 'Charlie', 'Clark', 'IT', 40000, 'A');
INSERT INTO "employ$ee" VALUES (4, 'David', 'Jones', 'IT', 35000, 'C');

COMMIT;


CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    FOR rec IN (
        SELECT "acc_id", "balance" FROM "acc_ounts" WHERE "acc_type" = 'savings'
    ) LOOP
        UPDATE "acc_ounts"
        SET "balance" = "balance" + ("balance" * 0.01)
        WHERE "acc_id" = rec."acc_id";

        DBMS_OUTPUT.PUT_LINE('Interest applied to Account ' || rec."acc_id");
    END LOOP;
END;
/
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_pct IN NUMBER
) IS
BEGIN
    FOR rec IN (
        SELECT "emp_id", "salary" FROM "employ$ee" WHERE "department" = p_department
    ) LOOP
        UPDATE "employ$ee"
        SET "salary" = "salary" + ("salary" * (p_bonus_pct / 100))
        WHERE "emp_id" = rec."emp_id";

        DBMS_OUTPUT.PUT_LINE('Bonus applied to Employee ID ' || rec."emp_id");
    END LOOP;
END;
/
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_acc IN NUMBER,
    p_to_acc IN NUMBER,
    p_amount IN NUMBER
) IS
    v_balance NUMBER;
BEGIN
    SELECT "balance" INTO v_balance FROM "acc_ounts"
    WHERE "acc_id" = p_from_acc;

    IF v_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE(' Insufficient balance in account ' || p_from_acc);
        RETURN;
    END IF;

    -- Deduct from source
    UPDATE "acc_ounts"
    SET "balance" = "balance" - p_amount
    WHERE "acc_id" = p_from_acc;

    -- Add to target
    UPDATE "acc_ounts"
    SET "balance" = "balance" + p_amount
    WHERE "acc_id" = p_to_acc;

    DBMS_OUTPUT.PUT_LINE(' Transferred ₹' || p_amount || ' from Account ' || p_from_acc || ' to ' || p_to_acc);
END;
/
SET SERVEROUTPUT ON;

BEGIN
    ProcessMonthlyInterest;
    UpdateEmployeeBonus('HR', 10);
    TransferFunds(101, 104, 1000);
END;
/

