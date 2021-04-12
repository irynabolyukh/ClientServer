package com.kma.clientserver.clientserver.dao;

import com.kma.clientserver.clientserver.model.Disciplines;

import java.util.List;

public interface DisciplinesDAO {
    List<Disciplines> get();
    Disciplines get(int id);
}
