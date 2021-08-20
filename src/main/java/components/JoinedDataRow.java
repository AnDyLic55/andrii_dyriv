package components;

import java.util.Objects;

public class JoinedDataRow<K, V1, V2> {
    private K key;
    private V1 value1;
    private V2 value2;

    public JoinedDataRow() {
    }

    public JoinedDataRow(K key, V1 value1, V2 value2) {
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;
    }

    public K getKey() {
        return key;
    }

    public V1 getValue1() {
        return value1;
    }

    public V2 getValue2() {
        return value2;
    }

    @Override
    public String toString() {
        return "JoinedDataRow{" +
                "key=" + key +
                ", value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JoinedDataRow<?, ?, ?> that = (JoinedDataRow<?, ?, ?>) o;
        return Objects.equals(key, that.key) && Objects.equals(value1, that.value1) && Objects.equals(value2, that.value2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value1, value2);
    }
}

