package com.example.aclresource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AclResourceApplicationTests {

    @Test
    void contextLoads() {
        var a = 1;
        var b = 1;
        assertEquals(a, b);
        // devo avere delle cose!

        // voglio poter creare un party - V
        // voglio poter distruggere un party - V

        // voglio poter "vedere" la lista dei gruppi - V
        // dato un party, voglio la lista di grant afferenti - V
        // dato un party, voglio la lista di id degli utenti afferenti - V
        // dato un party, voglio poterci aggiungere grant - V
        // dato un party, voglio poterci rimuovere grant - V
        // dato un party, voglio poterci aggiungere utenti - V
        // dato un party, voglio poterci rimuovere utenti - V
        // dato un party, voglio poterlo duplicare - standby

        // voglio poter "vedere" la lista delle grant - V
        // aggiungere una grant al momento è off-limit

        // assegnazione di grant a un party -> solo se si ha write_grant? solo se l'utente ha la
        // grant?
        // assegnazione di user a party -> solo se utente ha tutte le grant di quel party?
    }
}
