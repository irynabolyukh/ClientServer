package com.kma.clientserver.clientserver.service;

import com.kma.clientserver.clientserver.model.Disciplines;

import java.util.List;

public interface DisciplinesService {
    List<Disciplines> get();
    Disciplines get(int id);
}
