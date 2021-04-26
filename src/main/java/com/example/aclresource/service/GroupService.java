package com.example.aclresource.service;

import com.example.aclresource.model.AuthGroup;
import com.example.aclresource.model.GroupEdge;
import com.example.aclresource.repository.GroupEdgeRepository;
import com.example.aclresource.repository.GroupRepository;

import org.jgrapht.Graph;
import org.jgrapht.alg.TransitiveReduction;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedAcyclicGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

@Service
public class GroupService {

    GroupEdgeRepository groupEdgeRepository;
    GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupEdgeRepository groupEdgeRepository, GroupRepository groupRepository) {
        this.groupEdgeRepository = groupEdgeRepository;
        this.groupRepository = groupRepository;
    }

    public AuthGroup saveGroup(AuthGroup group) {
        return groupRepository.save(group);
    }

    @Transactional
    public void addEgde(Long source, Long target) {
        Graph<Long, DefaultEdge> dag = new DirectedAcyclicGraph<>(DefaultEdge.class);
        groupRepository.findAll().stream().map(AuthGroup::getId).forEach(dag::addVertex);
        groupEdgeRepository.findAll().stream()
                .forEach(e -> dag.addEdge(e.getSource(), e.getTarget()));

        dag.addEdge(source, target);
        TransitiveReduction.INSTANCE.reduce(dag);

        groupEdgeRepository.deleteAll();

        dag.edgeSet().stream()
                .map(e -> new GroupEdge(dag.getEdgeSource(e), dag.getEdgeTarget(e)))
                .forEach(groupEdgeRepository::save);
    }

    public List<Long> getSubgroups(Long groupId) {
        Graph<Long, DefaultEdge> dag = new DirectedAcyclicGraph<>(DefaultEdge.class);
        groupRepository.findAll().stream().map(AuthGroup::getId).forEach(dag::addVertex);
        groupEdgeRepository.findAll().stream()
                .forEach(e -> dag.addEdge(e.getSource(), e.getTarget()));

        return dag.outgoingEdgesOf(groupId).stream()
                .map(dag::getEdgeTarget)
                .collect(Collectors.toList());
        // dag.edgesOf(vertex)
        // List<Long> subList =
        //         groupEdgeRepository.findBySource(groupId).stream()
        //                 .map(GroupEdge::getTarget)
        //                 .collect(Collectors.toList());

        // if (subList.isEmpty()) return subList;

        // List<Long> iteration =
        //         subList.stream()
        //                 .map(this::getSubgroups)
        //                 .flatMap(List::stream)
        //                 .collect(Collectors.toList());

        // return Stream.concat(subList.stream(), iteration.stream())
        //         .distinct()
        //         .sorted()
        //         .collect(Collectors.toList());
    }

    // private void transitiveClojure(List<GroupEdge> groupEdges, Long target) {

    //     // di tutti gli edge, ce ne sono alcuni che hanno target a dx, di questi prendi i source

    // }

    // private void clojureStep(List<GroupEdge> groupEdges, List<Long> targetList) {}
}

// Puttanate
class ClojureCalculator {
    private Map<Long, Set<Long>> targetToSourceMap;

    public ClojureCalculator(List<GroupEdge> groupEdges) {
        targetToSourceMap =
                groupEdges.stream()
                        .collect(
                                Collectors.groupingBy(
                                        GroupEdge::getTarget,
                                        Collectors.mapping(
                                                GroupEdge::getSource, Collectors.toSet())));
    }

    public Set<Long> calculate(Long target) {
        return step(targetToSourceMap.get(target));
    }

    // highly inefficient
    private Set<Long> step(Set<Long> targets) {
        Set<Long> sources =
                targets.stream()
                        .map(e -> targetToSourceMap.get(e))
                        .flatMap(Set::stream)
                        .collect(Collectors.toSet());

        if (sources.equals(targets)) return sources;

        sources.addAll(targets);
        return sources;
    }
}
