package ru.itpark;

public class MapArraysImpl<K, V> implements Map<K, V> {
  private MapElement<K, V> elements[];
  private int count = 0;

  public MapArraysImpl() {
    this.elements = new MapElement[16];
  }

  @Override
  public void put(K key, V value) {
    int position = key.hashCode() & 15;
    elements[position] = new MapElement<>(key, value);
  }

  @Override
  public V get(K key) {
    int position = key.hashCode() & 15;
    return elements[position].getValue();
  }
}
