package com.lab3spring;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
// Здесь находится интерфейс для общения с моделью
public interface NodeRepository extends JpaRepository<Node, Integer> {
    List<Node> findAllByOrderByIdAsc();
    List<Node> findAllByOrderByIdDesc();
}


/*public class NodeRepository extends DataRepository {
    private ArrayList<Node> nodes;

    void addNode(Node node) {
        nodes.add(node);
    }

    Node getNode(Integer id) {
        return nodes.get(id);
    }

    void updateNode(Integer id, String name, String country, boolean status) {
        nodes.get(id).setName(name);
        nodes.get(id).setCountry(country);
        nodes.get(id).setStatus(status);
    }

    void deleteNode(int id) {
        nodes.remove(id);
    }

    ArrayList<Node> findAll() {
        return nodes;
    }
}*/
