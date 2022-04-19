CREATE TABLE departments (
    department_id BIGSERIAL PRIMARY KEY ,
    name VARCHAR(50) NOT NULL,
    location VARCHAR(50) NOT NULL
);

ALTER TABLE departments
ADD CONSTRAINT department_name_constraint
CHECK (name <> '' AND LTRIM(name) <> '');

ALTER TABLE departments
ADD CONSTRAINT  location_constraint
CHECK (location <> '' AND LTRIM(location) <> '');

COMMENT ON TABLE departments IS 'The departments table';

COMMENT ON COLUMN departments.department_id IS 'The primary key of departments table. It is autoincremented.';

COMMENT ON COLUMN departments.name IS 'The name of the department. It can not be null, empty or blank.';

COMMENT ON COLUMN departments.location IS 'The location of the department. It can not be null, empty or blank.';