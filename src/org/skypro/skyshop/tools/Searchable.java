package org.skypro.skyshop.tools;

public interface Searchable {
    String getSearchTerm();

    String getContentType();

    default String getStringRepresentation() {
        return "getSearchTerm() " + getSearchTerm() + "\n" + "getContentType(): " + getContentType();
    }
}
