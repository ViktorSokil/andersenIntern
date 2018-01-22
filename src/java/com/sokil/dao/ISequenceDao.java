package com.sokil.dao;


public interface ISequenceDao {
    Long getNextSequenceId(String key);
}
