package ru.itpark;

public class MapElementNode<K, V> {
  private K key;
  private V value;

  private MapElementNode<K, V> next;

  public MapElementNode(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public MapElementNode<K, V> getNext() {
    return next;
  }

  public void setNext(MapElementNode<K, V> next) {
    this.next = next;
  }
}
