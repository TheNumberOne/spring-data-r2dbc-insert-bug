package io.thenumeralone.springdata.r2dbc.insertbug;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.Nullable;

@Table
public class Example {
    @Nullable
    @Id
    private final Long id;

    private final int n;

    @PersistenceConstructor
    public Example(@Nullable Long id, int n) {
        this.id = id;
        this.n = n;
    }

    public Example(int n) {
        this(null, n);
    }

    public int getN() {
        return n;
    }
}
