package ru.itpark;

public class MapSimpleArraysImpl<K, V> implements Map<K, V> {

  private MapElement<K, V> elements[];
  private int count = 0;

  public MapSimpleArraysImpl() {
    this.elements = new MapElement[10];
  }

  @Override
  public void put(K key, V value) {
    for (int i = 0; i < count; i++) {
      if (elements[i].getKey().equals(key)) {
        elements[i].setValue(value);
        return;
      }
    }
    MapElement<K,V> newElement = new MapElement<>(key, value);
    elements[count] = newElement;
    count++;
  }

  @Override
  public V get(K key) {
    for (int i = 0; i < count; i++) {
      if (elements[i].getKey().equals(key)) {
        return elements[i].getValue();
      }
    }
    return null;
  }
}
