package com.docs.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import com.mongodb.ConnectionString; // Добавлен этот импорт

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoConfig {
    public static MongoClient createMongoClient() {
        // Настройка PojoCodec для работы с классами
        PojoCodecProvider pojoCodecProvider = PojoCodecProvider.builder()
                .automatic(true)
                .build();

        // Создаем реестр кодеков
        CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(pojoCodecProvider)
        );

        // Настройки подключения
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");

        // Конфигурация клиента
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(pojoCodecRegistry)
                .build();

        return MongoClients.create(settings);
    }
}