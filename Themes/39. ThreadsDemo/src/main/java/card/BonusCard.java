package card;

public class BonusCard {
  private int sum;

  public BonusCard(int sum) {
    this.sum = sum;
  }

  public void use(int sum) {
      if (this.sum >= sum) {
        this.sum = this.sum - sum;
      } else {
        System.out.println("Денег нет");
        System.exit(0);
      }
  }

  public int getSum() {
    return sum;
  }
}
