package kr.codesquad.domain;

import java.util.Objects;

public class User {

    private static final int MAX_LENGTH = 5;
    private static final int MIN_LENGTH = 1;

    private final String name;

    public User(String name) {
        String emptyBlankName = name.replace(" ", "");
        validateMinLength(emptyBlankName);
        validateMaxLength(emptyBlankName);
        this.name = emptyBlankName;
    }

    private void validateMaxLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("참여할 사람의 이름은 최대 5글자입니다.");
        }
    }

    private void validateMinLength(String name) {
        if (name.length() < MIN_LENGTH) {
            throw new IllegalArgumentException("참여할 사람의 이름은 최소 1글자입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("%6s", this.name);
    }
}
