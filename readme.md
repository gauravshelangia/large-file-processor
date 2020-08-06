##Creating Database
1. Login to MySql using command `mysql -u root -p` (enter password then)
2. Create tables using db-init.sql file with command: `mysql -u root -p postman < large-file-processor/conf/db-init.sql`



##Assumptions


##Result


##TODO
1. [X] run jar with main class -- Pom Corrected - DONE
2. [X] Add aggregation logic -- Done 
    1. [X] Locking handled with adding wait of 30 sec.  
    2. [X] Added implementation of Executor batch update for aggregation result  
3. Add docker composition for this
    1. [ ] Add db init to mysql
    2. [ ] Check large-file-processor
        1.[ ] build with docker or in advance
        2.[ ] running and resulting output