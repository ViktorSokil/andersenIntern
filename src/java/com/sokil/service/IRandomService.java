package com.sokil.service;


import org.bson.Document;

import javax.servlet.http.HttpServletRequest;

public interface IRandomService {
    void save(HttpServletRequest request);

    Document findById(Long id);

    void updateField(Long docId, String key, String value);
}
