package fr.lernejo.umlgrapher;

import java.util.*;
import java.util.TreeSet;

public class UmlType {
    private final Set<UmlType> types = new TreeSet<>(Comparator
        .<UmlType, String>comparing(t->t.types())
        .thenComparing(t->t.types()));

    private String types() {
        final String o = null;
        return null;
    }
}

