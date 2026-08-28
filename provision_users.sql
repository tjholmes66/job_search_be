-- Create the missing localhost user profile your Mac IDE is demanding
CREATE USER IF NOT EXISTS 'job_search_user'@'localhost' IDENTIFIED BY 'passw0rd';

-- Grant full schema and flyway metadata access to the localhost profile
GRANT ALL PRIVILEGES ON job_search_db.* TO 'job_search_user'@'localhost';
GRANT SELECT, REPLICATION CLIENT ON *.* TO 'job_search_user'@'localhost';

FLUSH PRIVILEGES;
