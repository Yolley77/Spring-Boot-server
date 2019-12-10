package com.lab3spring;

import com.lab3spring.Action.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Сервис для взаимодействия с моделью
interface NodeService {
    void setAction(Result action);      // No connection to DB
    String getResult(String request);   // No connection to DB
    Node getNode(Integer id);
    void addNode(Node node);
    void updateNode(Integer id, String name, String country, boolean status);
    void deleteNode(Integer id);
    List<Node> findAll();
    void clearAll();
}

@Service
public class NodeServiceImpl implements NodeService  {

    private NodeRepository repository;
    private Result act;

    @Autowired
    public void setRepository(NodeRepository repository) {
        this.repository = repository;
    }


    @Override
    public void setAction(Result action) {
        this.act = action;
    }

    @Override
    public String getResult(String request) {
        act.calculate(request);
        return act.getResult();
    }

    @Override
    public Node getNode(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public void addNode(Node node) {
        repository.save(node);
    }

    @Override
    public void updateNode(Integer id, String name, String country, boolean status) {
        Node updated = repository.getOne(id);
        updated.setStatus(status);
        updated.setName(name);
        updated.setCountry(country);
        repository.save(updated);
    }

    @Override
    public void deleteNode(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Node> findAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @Override
    public void clearAll() {
        repository.deleteAll();
    }
}
