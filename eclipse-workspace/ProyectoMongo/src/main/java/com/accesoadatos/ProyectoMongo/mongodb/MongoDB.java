package com.accesoadatos.ProyectoMongo.mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDB {
	
	ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
	MongoClientSettings settings =
	MongoClientSettings.builder().applyConnectionString(connectionString).build();
	MongoClient mongoClient = MongoClients.create(settings);
	MongoDatabase db = mongoClient.getDatabase("mibasedatos");
	
}
