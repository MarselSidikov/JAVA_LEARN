package ru.itpark;

public class ArrayList implements List, Stack {

  private final static int INITIAL_SIZE = 10;

  private Object data[];
  private int count;

  public ArrayList() {
    this.count = 0;
    this.data = new Object[INITIAL_SIZE];
  }

  @Override
  public Object get(int index) {
    if (index < count) {
      return data[index];
    }
    throw new IndexOutOfBoundsException();
  }

  @Override
  public void delete(int index) {
    if (index < count) {
      for (int i = index; i < count - 1; i++) {
        data[i] = data[i + 1];
      }
      count--;
    } else throw new IndexOutOfBoundsException();
  }

  @Override
  public void add(Object element) {
    if (count == data.length) {
      resize();
    }
    data[count] = element;
    count++;
  }

  @Override
  public boolean contains(Object element) {
    for (int i = 0; i < count; i++) {
      if (data[i].equals(element)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public int size() {
    return count;
  }

  @Override
  public boolean delete(Object element) {
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
    Object newData[] = new Object[newLength];

//    for (int i = 0; i < count; i++) {
//      newData[i] = data[i];
//    }

    System.arraycopy(data, 0, newData, 0, count);

    this.data = newData;
  }

  @Override
  public void push(Object element) {
    add(element);
  }

  @Override
  public Object pop() {
    Object element =  get(count - 1);
    delete(count - 1);
    return element;
  }
}
