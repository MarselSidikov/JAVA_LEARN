package ru.itpark;

public class ArrayList<T> {

  private final static int INITIAL_SIZE = 10;

  private T data[];
  private int count;

  public ArrayList() {
    this.count = 0;
    this.data = (T[]) new Object[INITIAL_SIZE];
  }

  public T get(int index) {
    if (index < count) {
      return data[index];
    }
    throw new IndexOutOfBoundsException();
  }

  public void delete(int index) {
    if (index < count) {
      for (int i = index; i < count - 1; i++) {
        data[i] = data[i + 1];
      }
      count--;
    } else throw new IndexOutOfBoundsException();
  }

  public void add(T element) {
    if (count == data.length) {
      resize();
    }
    data[count] = element;
    count++;
  }

  public boolean contains(T element) {
    for (int i = 0; i < count; i++) {
      if (data[i].equals(element)) {
        return true;
      }
    }
    return false;
  }

  public int size() {
    return count;
  }

  public boolean delete(T element) {
    for (int i = 0; i < count; i++) {
      if (data[i].equals(element)) {
        delete(i);
        return true;
      }
    }
    return false;
  }

  private void resize() {
    int newLength = data.length + data.length / 2;
    T newData[] = (T[]) new Object[newLength];

//    for (int i = 0; i < count; i++) {
//      newData[i] = data[i];
//    }

    System.arraycopy(data, 0, newData, 0, count);

    this.data = newData;
  }

  public void push(T element) {
    add(element);
  }

  public Object pop() {
    Object element =  get(count - 1);
    delete(count - 1);
    return element;
  }
}
