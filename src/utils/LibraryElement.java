package utils;

public interface LibraryElement {
    void accept(LibraryVisitor visitor);
}
