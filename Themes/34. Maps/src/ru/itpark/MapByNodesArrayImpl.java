package ru.itpark;

public class MapByNodesArrayImpl<K, V> implements Map<K, V> {
  private MapElementNode<K, V> elements[];
  private int count = 0;

  public MapByNodesArrayImpl() {
    this.elements = new MapElementNode[16];
  }

  @Override
  public void put(K key, V value) {
    int position = key.hashCode() & 15;

    if (elements[position] == null) {
      elements[position] = new MapElementNode<>(key, value);
    } else {
      MapElementNode<K, V> current = elements[position];
      while (current != null) {
        if (current.getKey().equals(key)) {
          current.setValue(value);
          return;
        }
        current = current.getNext();
      }
      MapElementNode<K, V> newNode =
          new MapElementNode<>(key, value);
      newNode.setNext(elements[position]);
      elements[position] = newNode;
    }
  }

  @Override
  public V get(K key) {
    int position = key.hashCode() & 15;
    return elements[position].getValue();
  }
}
