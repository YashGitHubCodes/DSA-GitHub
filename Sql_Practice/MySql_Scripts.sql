/*
================================================================================
DBA / SQL Practice Questions and Answers
Prepared for GitHub practice reference
================================================================================

Database style used: MySQL-compatible SQL
Tables used:
  1. department
  2. employee

Learning focus covered:
  - SELECT, WHERE, AND, BETWEEN, LIKE
  - COUNT, SUM, AVG, MAX
  - GROUP BY, HAVING, ORDER BY
  - DISTINCT, LIMIT, OFFSET
  - Subqueries and correlated subqueries
  - INNER JOIN, LEFT JOIN, RIGHT JOIN
  - Window functions: RANK(), DENSE_RANK()

Important notes from learning:
  - COUNT(*) counts rows.
  - COUNT(column) ignores NULL values.
  - WHERE filters rows before grouping.
  - HAVING filters groups after GROUP BY.
  - JOIN connects related tables.
  - LEFT JOIN preserves all rows from left table.
  - RIGHT JOIN preserves all rows from right table.
  - Correlated subquery uses outer query value inside inner query.
  - RANK() skips rank numbers after ties.
  - DENSE_RANK() does not skip rank numbers after ties.
*/

-- ============================================================================
-- SECTION 1: DATABASE SETUP
-- ============================================================================

DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;

CREATE TABLE department (
    id INT PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL
);

CREATE TABLE employee (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    department_id INT NULL,
    salary DECIMAL(10,2) NOT NULL,
    CONSTRAINT fk_employee_department
        FOREIGN KEY (department_id) REFERENCES department(id)
);

-- Dummy department data
INSERT INTO department (id, department_name) VALUES
(1, 'IT'),
(2, 'HR'),
(3, 'Finance'),
(4, 'Marketing'),
(5, 'Operations');

-- Dummy employee data
-- Includes:
--   - duplicate salaries
--   - employees from different departments
--   - one employee with NULL department_id
--   - one department with no employee possible depending on data usage
INSERT INTO employee (id, name, department_id, salary) VALUES
(1,  'Amit',    1, 90000),
(2,  'Ankit',   1, 80000),
(3,  'Neha',    1, 70000),
(4,  'Raj',     2, 60000),
(5,  'Riya',    2, 50000),
(6,  'Sana',    3, 75000),
(7,  'John',    3, 65000),
(8,  'Alex',    4, 90000),
(9,  'Meena',   4, 40000),
(10, 'Karan',   NULL, 55000);

-- Quick check
SELECT * FROM department;
SELECT * FROM employee;


-- ============================================================================
-- SECTION 2: BASIC SELECT / WHERE QUESTIONS
-- ============================================================================

-- Q1. Find all employees from IT department.
-- Thought process:
--   Use WHERE filter. Since employee table now has department_id, join department table
--   to filter using department_name.
SELECT e.*
FROM employee e
JOIN department d ON e.department_id = d.id
WHERE d.department_name = 'IT';

-- Q2. Find only names of employees from IT department.
-- Thought process:
--   Same filter as above, but SELECT only name column.
SELECT e.name
FROM employee e
JOIN department d ON e.department_id = d.id
WHERE d.department_name = 'IT';

-- Q3. Find employees whose salary is between 50000 and 80000.
-- Thought process:
--   BETWEEN is inclusive, meaning 50000 and 80000 both are included.
SELECT *
FROM employee
WHERE salary BETWEEN 50000 AND 80000;

-- Same query using >= and <=.
SELECT *
FROM employee
WHERE salary >= 50000 AND salary <= 80000;

-- Q4. Find employees whose salary is greater than 50000 and less than 80000.
-- Thought process:
--   Use AND when both conditions must be true.
SELECT *
FROM employee
WHERE salary > 50000 AND salary < 80000;

-- Q5. Find employees who belong to either IT or HR department.
-- Thought process:
--   IN is cleaner than multiple OR conditions for multiple values.
SELECT e.*
FROM employee e
JOIN department d ON e.department_id = d.id
WHERE d.department_name IN ('IT', 'HR');

-- Equivalent using OR.
SELECT e.*
FROM employee e
JOIN department d ON e.department_id = d.id
WHERE d.department_name = 'IT'
   OR d.department_name = 'HR';

-- Q6. Find employees who do NOT belong to IT department.
-- Thought process:
--   != and <> behave similarly in many DBs. <> is SQL standard.
SELECT e.*
FROM employee e
JOIN department d ON e.department_id = d.id
WHERE d.department_name <> 'IT';

-- Same using !=.
SELECT e.*
FROM employee e
JOIN department d ON e.department_id = d.id
WHERE d.department_name != 'IT';

-- Q7. Find employees who do NOT belong to IT or HR department.
-- Thought process:
--   NOT IN is useful when excluding multiple values.
SELECT e.*
FROM employee e
JOIN department d ON e.department_id = d.id
WHERE d.department_name NOT IN ('IT', 'HR');


-- ============================================================================
-- SECTION 3: LIKE / PATTERN MATCHING
-- ============================================================================

-- Q8. Find employees whose name starts with letter 'A'.
-- Thought process:
--   LIKE is used for pattern matching. A% means starts with A.
SELECT *
FROM employee
WHERE name LIKE 'A%';

-- Q9. Find employees whose name contains letter 'A' anywhere.
-- Thought process:
--   %A% means any characters before and after A.
SELECT *
FROM employee
WHERE name LIKE '%A%';

-- Q10. Find employees whose name ends with letter 'a'.
-- Thought process:
--   %a means anything before a, but must end with a.
SELECT *
FROM employee
WHERE name LIKE '%a';

-- Q11. Find employees whose name starts with 'A' and ends with 'n'.
-- Thought process:
--   A%n means starts with A, anything in middle, ends with n.
SELECT *
FROM employee
WHERE name LIKE 'A%n';


-- ============================================================================
-- SECTION 4: AGGREGATE FUNCTIONS
-- ============================================================================

-- Q12. Count total number of employees.
-- Thought process:
--   COUNT(*) counts total rows.
SELECT COUNT(*) AS total_employees
FROM employee;

-- Q13. Count department_id values in employee table.
-- Thought process:
--   COUNT(department_id) ignores NULL department_id.
SELECT COUNT(department_id) AS employees_with_department
FROM employee;

-- Q14. Find highest salary from employee table.
-- Thought process:
--   MAX() gives largest value.
SELECT MAX(salary) AS highest_salary
FROM employee;

-- Q15. Find average salary of all employees.
-- Thought process:
--   AVG() returns decimal numeric value, not string, and not necessarily integer.
SELECT AVG(salary) AS average_salary
FROM employee;

-- Q16. Find total salary paid to all employees.
-- Thought process:
--   SUM() adds values.
SELECT SUM(salary) AS total_salary
FROM employee;


-- ============================================================================
-- SECTION 5: GROUP BY AND HAVING
-- ============================================================================

-- Q17. Find department-wise employee count.
-- Thought process:
--   GROUP BY combines rows department-wise. COUNT(*) counts employees in each group.
SELECT d.department_name,
       COUNT(*) AS employee_count
FROM employee e
JOIN department d ON e.department_id = d.id
GROUP BY d.department_name;

-- Q18. Find department-wise total salary.
-- Thought process:
--   GROUP BY department, then SUM salary per department.
SELECT d.department_name,
       SUM(e.salary) AS total_salary
FROM employee e
JOIN department d ON e.department_id = d.id
GROUP BY d.department_name;

-- Q19. Find highest salary in each department.
-- Thought process:
--   GROUP BY department, then MAX salary per group.
SELECT d.department_name,
       MAX(e.salary) AS highest_salary
FROM employee e
JOIN department d ON e.department_id = d.id
GROUP BY d.department_name;

-- Q20. Find the department having the highest average salary.
-- Thought process:
--   First group by department, calculate AVG, sort descending, take first row.
SELECT d.department_name,
       AVG(e.salary) AS avg_salary
FROM employee e
JOIN department d ON e.department_id = d.id
GROUP BY d.department_name
ORDER BY avg_salary DESC
LIMIT 1;

-- Q21. Find departments having more than 3 employees.
-- Thought process:
--   WHERE cannot filter aggregate result. Use HAVING after GROUP BY.
SELECT d.department_name,
       COUNT(*) AS employee_count
FROM employee e
JOIN department d ON e.department_id = d.id
GROUP BY d.department_name
HAVING COUNT(*) > 3;

-- Q22. Find department having the highest total salary.
-- Thought process:
--   Group by department, calculate SUM, order descending, limit 1.
--   Do not compare department id with salary value; LHS and RHS must logically match.
SELECT d.department_name,
       SUM(e.salary) AS total_salary
FROM department d
JOIN employee e ON d.id = e.department_id
GROUP BY d.department_name
ORDER BY total_salary DESC
LIMIT 1;


-- ============================================================================
-- SECTION 6: ORDER BY, DISTINCT, LIMIT/OFFSET
-- ============================================================================

-- Q23. Find all employees sorted by salary in descending order.
-- Thought process:
--   ORDER BY sorts rows. DESC means highest first.
SELECT *
FROM employee
ORDER BY salary DESC;

-- Q24. Find employees sorted by salary in ascending order.
-- Thought process:
--   ASC is default, so writing ASC is optional.
SELECT *
FROM employee
ORDER BY salary ASC;

-- Q25. Find the second highest distinct salary using LIMIT/OFFSET.
-- Thought process:
--   DISTINCT removes duplicate salaries. OFFSET 1 skips highest salary. LIMIT 1 returns next.
SELECT DISTINCT salary
FROM employee
ORDER BY salary DESC
LIMIT 1 OFFSET 1;

-- Same concept alternative syntax some DBs support:
-- SELECT DISTINCT salary FROM employee ORDER BY salary DESC OFFSET 1 LIMIT 1;


-- ============================================================================
-- SECTION 7: SUBQUERIES
-- ============================================================================

-- Q26. Find employee(s) having the highest salary.
-- Thought process:
--   Inner query finds MAX salary. Outer query fetches full row(s).
--   This handles multiple employees with same highest salary.
SELECT *
FROM employee
WHERE salary = (
    SELECT MAX(salary)
    FROM employee
);

-- Q27. Find employees whose salary is greater than average salary of all employees.
-- Thought process:
--   Inner query calculates overall AVG. Outer query compares each employee salary.
SELECT *
FROM employee
WHERE salary > (
    SELECT AVG(salary)
    FROM employee
);

-- Q28. Find second highest distinct salary without LIMIT/OFFSET.
-- Thought process:
--   Exclude current highest salary, then find MAX from remaining salaries.
SELECT MAX(salary) AS second_highest_salary
FROM employee
WHERE salary < (
    SELECT MAX(salary)
    FROM employee
);

-- Alternative using != also works for this case.
SELECT MAX(salary) AS second_highest_salary
FROM employee
WHERE salary != (
    SELECT MAX(salary)
    FROM employee
);

-- Q29. Find full employee row(s) having second highest distinct salary.
-- Thought process:
--   First find second highest salary in subquery, then fetch employees having that salary.
SELECT *
FROM employee
WHERE salary = (
    SELECT MAX(salary)
    FROM employee
    WHERE salary < (
        SELECT MAX(salary)
        FROM employee
    )
);

-- Q30. Find full employee row(s) having second highest salary using LIMIT/OFFSET.
-- Thought process:
--   Subquery returns the second highest distinct salary.
SELECT *
FROM employee
WHERE salary = (
    SELECT DISTINCT salary
    FROM employee
    ORDER BY salary DESC
    LIMIT 1 OFFSET 1
);


-- ============================================================================
-- SECTION 8: CORRELATED SUBQUERY
-- ============================================================================

-- Q31. Find employees whose salary is greater than average salary of their own department.
-- Thought process:
--   This is a correlated subquery because inner query uses outer employee's department_id.
--   The condition emp.department_id = e.department_id must be inside the inner query.
SELECT *
FROM employee e
WHERE e.salary > (
    SELECT AVG(emp.salary)
    FROM employee emp
    WHERE emp.department_id = e.department_id
);

-- Learning note:
-- Do not GROUP BY all departments inside the subquery when only current employee's department average is needed.
-- Filtering by current employee's department makes the subquery return one average value.


-- ============================================================================
-- SECTION 9: JOINS
-- ============================================================================

-- Q32. Fetch employee name and department name for all employees who belong to a department.
-- Thought process:
--   INNER JOIN returns only matching rows from both tables.
SELECT e.name,
       d.department_name
FROM employee e
JOIN department d ON d.id = e.department_id;

-- Q33. Fetch all employees and their department names, including employees who do not belong to any department.
-- Thought process:
--   LEFT JOIN preserves all rows from employee table.
--   If department does not exist, department_name becomes NULL.
SELECT e.name,
       d.department_name
FROM employee e
LEFT JOIN department d ON e.department_id = d.id;

-- Q34. Fetch all departments, including departments that have no employees.
-- Thought process:
--   Preserve all department rows. Department should be on left side with LEFT JOIN.
SELECT d.department_name,
       e.name AS employee_name
FROM department d
LEFT JOIN employee e ON d.id = e.department_id;

-- Same logic using RIGHT JOIN with department on right side.
SELECT e.name AS employee_name,
       d.department_name
FROM employee e
RIGHT JOIN department d ON d.id = e.department_id;

-- Q35. Fetch department name and total salary of employees in each department.
-- Thought process:
--   JOIN department with employee, then GROUP BY department name and SUM salary.
SELECT d.department_name,
       SUM(e.salary) AS total_salary
FROM employee e
JOIN department d ON e.department_id = d.id
GROUP BY d.department_name;


-- ============================================================================
-- SECTION 10: WINDOW FUNCTIONS
-- ============================================================================

-- Q36. Show employee name, salary, and rank based on salary highest first.
-- Thought process:
--   RANK() gives same rank for ties but skips next rank numbers.
SELECT name,
       salary,
       RANK() OVER (ORDER BY salary DESC) AS salary_rank
FROM employee;

-- Q37. Show employee name, salary, and dense rank based on salary highest first.
-- Thought process:
--   DENSE_RANK() gives same rank for ties but does not skip rank numbers.
SELECT name,
       salary,
       DENSE_RANK() OVER (ORDER BY salary DESC) AS dense_salary_rank
FROM employee;

-- Difference example:
-- Salaries: 100, 90, 90, 80
-- RANK()       -> 1, 2, 2, 4
-- DENSE_RANK() -> 1, 2, 2, 3


-- ============================================================================
-- SECTION 11: EXTRA PRACTICE VARIANTS
-- ============================================================================

-- Q38. Find department-wise average salary and sort highest average first.
SELECT d.department_name,
       AVG(e.salary) AS avg_salary
FROM employee e
JOIN department d ON e.department_id = d.id
GROUP BY d.department_name
ORDER BY avg_salary DESC;

-- Q39. Find employees with NULL department_id.
-- Thought process:
--   Use IS NULL, not = NULL.
SELECT *
FROM employee
WHERE department_id IS NULL;

-- Q40. Find employees with non-NULL department_id.
-- Thought process:
--   Use IS NOT NULL.
SELECT *
FROM employee
WHERE department_id IS NOT NULL;

-- Q41. Find count of employees including those with no department in one result.
SELECT COUNT(*) AS total_employee_rows
FROM employee;

-- Q42. Find count of employees who are mapped to a department.
SELECT COUNT(department_id) AS employees_with_department
FROM employee;

-- Q43. Find departments with zero employees.
-- Thought process:
--   LEFT JOIN keeps all departments. COUNT(e.id) counts matched employees only.
SELECT d.department_name,
       COUNT(e.id) AS employee_count
FROM department d
LEFT JOIN employee e ON d.id = e.department_id
GROUP BY d.department_name
HAVING COUNT(e.id) = 0;

/*
================================================================================
Quick Revision Summary
================================================================================

1. Filtering rows:
   WHERE column = value

2. Pattern matching:
   LIKE 'A%'   -> starts with A
   LIKE '%a'   -> ends with a
   LIKE '%A%'  -> contains A

3. Aggregation:
   COUNT(*), COUNT(column), SUM(), AVG(), MAX(), MIN()

4. Group filtering:
   WHERE  -> before GROUP BY
   HAVING -> after GROUP BY

5. Joins:
   INNER JOIN -> only matching rows
   LEFT JOIN  -> preserve left table rows
   RIGHT JOIN -> preserve right table rows

6. Subquery:
   Query inside another query.

7. Correlated subquery:
   Inner query depends on outer query row.

8. Window functions:
   RANK() OVER (ORDER BY salary DESC)
   DENSE_RANK() OVER (ORDER BY salary DESC)

================================================================================
End of SQL Practice File
================================================================================
*/
