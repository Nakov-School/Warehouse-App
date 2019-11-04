# Warehouse-App

**Backend**

(Maybe write a shell script to automate this?)
How to set up:

```git clone -b Backend https://github.com/Nakov-School/Warehouse-App.git```

```cd Warehouse-App && gradle build```

```docker build -t warehouse .```

```docker run -p 8080:8080 warehouse```

Now, you should see `Hello World` at http://localhost:8080/

To run PostgreSQL database:
```docker create -v /var/lib/postgresql/data --name PostgresData alpine && docker run -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=admin -d --volumes-from PostgresData postgres```

TODO: Deploy on Heroku
TODO: Add simple interactions with PostgreSQL, and set up tables.
