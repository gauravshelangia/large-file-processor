##Creating Database
1. Login to MySql using command `mysql -u root -p` (enter password then)
2. Create tables using db-init.sql file with command: `mysql -u root -p postman < large-file-processor/conf/db-init.sql`



##Assumptions


##Result


##TODO
1. run jar with main class -- Pom Corrected - DONE
2. Add aggregation logic -- Done but need to handle locking exception  
    1. Try building stream solution
        2. first fetch aggregation result from db
        2. Then rune executor with batch update similar to ingestion
3. Add docker composition for this
    1. Add db init to mysql
    2. Check large-file-processor
        1. build with docker or in advance
        2. running and resulting output