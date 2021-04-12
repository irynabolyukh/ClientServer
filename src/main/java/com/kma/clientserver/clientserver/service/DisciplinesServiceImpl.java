package com.kma.clientserver.clientserver.service;

import com.kma.clientserver.clientserver.dao.DisciplinesDAO;
import com.kma.clientserver.clientserver.model.Disciplines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DisciplinesServiceImpl implements DisciplinesService {

    @Autowired
    private DisciplinesDAO disciplinesDAO;

    @Transactional
    @Override
    public List<Disciplines> get() {
        return disciplinesDAO.get();
    }

    @Transactional
    @Override
    public Disciplines get(int id) {
        return disciplinesDAO.get(id);
    }
}
