CREATE TABLE employees (
    employee_id BIGSERIAL PRIMARY KEY ,
    first_name VARCHAR(50) NOT NULL ,
    last_name VARCHAR(50) NOT NULL ,
    email VARCHAR(50) UNIQUE NOT NULL ,
    phone_number VARCHAR(25) UNIQUE NOT NULL ,
    salary NUMERIC(8, 2) NOT NULL,
    department INTEGER NOT NULL
);

ALTER TABLE employees
ADD CONSTRAINT first_name_constraint
CHECK (first_name <> '' AND LTRIM(first_name) <> '');

ALTER TABLE employees
ADD CONSTRAINT last_name_constraint
CHECK (last_name <> '' AND LTRIM(last_name) <> '');

ALTER TABLE employees
ADD CONSTRAINT email_constraint
CHECK (email <> '' AND LTRIM(email) <> '');

ALTER TABLE employees
ADD CONSTRAINT phone_number_constraint
CHECK (phone_number <> '' AND LTRIM(phone_number) <> '');

ALTER TABLE employees
ADD CONSTRAINT salary_constraint
CHECK (salary > 1.0);

ALTER TABLE employees
ADD CONSTRAINT fk_departments FOREIGN KEY (department) REFERENCES departments (department_id);

COMMENT ON TABLE employees IS
    'The employees table.';

COMMENT ON COLUMN employees.employee_id IS
    'The primary key of employees table. It is auto incremented.';

COMMENT ON COLUMN employees.first_name IS
    'The first name of an employee. It can not be null, blank or empty.';

COMMENT ON COLUMN  employees.last_name IS
    'The last name of an employee. It can not be null, blank or empty.';

COMMENT ON COLUMN employees.email IS
    'The email address of an employee. It can not be null, blank or empty and it should be unique.';

COMMENT ON COLUMN employees.phone_number IS
    'The phone number of an employee. It can not be null, blank or empty and it should be unique.';

COMMENT ON COLUMN employees.salary IS
    'The salary of an employee. It can not be null and it should be greater than 1.0.';

COMMENT ON COLUMN employees.department IS
    'The department id of a department where an employee works. It establishes the one-to-many relationship between tables.';