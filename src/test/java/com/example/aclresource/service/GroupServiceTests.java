package com.example.aclresource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PartyServiceTests {

    @Autowired PartyService partyService;
    // GroupEdgeRepository groupGroupRepositoryMock;

    public PartyServiceTests() {
        // groupGroupRepositoryMock = Mockito.mock(GroupEdgeRepository.class);
        // groupService = new GroupService(groupGroupRepositoryMock);
    }

    //     @Test
    //     void getSubgroups() {
    //         GroupEdge groupGroup1 = new GroupEdge(1L, 1L, 2L);
    //         GroupEdge groupGroup2 = new GroupEdge(2L, 2L, 3L);
    //         GroupEdge groupGroup3 = new GroupEdge(3L, 2L, 4L);
    //         GroupEdge groupGroup4 = new GroupEdge(4L, 3L, 5L);
    //         GroupEdge groupGroup5 = new GroupEdge(5L, 2L, 5L);

    //         Mockito.when(groupGroupRepositoryMock.findByContainerGroupId(1L))
    //                 .thenReturn(Stream.of(groupGroup1).collect(Collectors.toList()));

    //         Mockito.when(groupGroupRepositoryMock.findByContainerGroupId(2L))
    //                 .thenReturn(
    //                         Stream.of(groupGroup2, groupGroup3, groupGroup5)
    //                                 .collect(Collectors.toList()));

    //         Mockito.when(groupGroupRepositoryMock.findByContainerGroupId(3L))
    //                 .thenReturn(Stream.of(groupGroup4).collect(Collectors.toList()));

    //         assertEquals(
    //                 Stream.of(2L, 3L, 4L, 5L).collect(Collectors.toList()),
    //                 groupService.getSubgroups(1L));
    //     }

}
