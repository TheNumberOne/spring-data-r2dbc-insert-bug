package io.thenumeralone.springdata.r2dbc.insertbug;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;

import java.util.List;

@SpringBootTest
class ExampleTest {

    private final DatabaseClient client;

    @Autowired
    ExampleTest(DatabaseClient client) {
        this.client = client;
    }

    @Test
    void shouldInsertMultipleItems() {
        List<Example> inserted = client
                .execute("CREATE TABLE EXAMPLE (ID SERIAL PRIMARY KEY, N INT NOT NULL)")
                .then()
                .then(client.insert()
                        .into(Example.class)
                        .using(Flux.just(new Example(1), new Example(2)))
                        .fetch()
                        .rowsUpdated()
                )
                .thenMany(client
                        .select()
                        .from(Example.class)
                        .fetch()
                        .all()
                )
                .collectList()
                .block();

        Assertions.assertThat(inserted).hasSize(2);
    }
}
