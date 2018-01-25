package com.sokil.dao;


import org.bson.Document;

public interface IRandomDAO {
    void save(Document document);

    Document findById(Long id);

    void updateField(Long docId, String key, String value);
}
