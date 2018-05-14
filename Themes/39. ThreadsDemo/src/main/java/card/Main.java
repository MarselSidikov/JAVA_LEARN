package card;

public class Main {
  public static void main(String[] args) {
    BonusCard bonusCard = new BonusCard(50);
    Human husband = new Human("Муж", bonusCard);
    Human wife = new Human("Жена", bonusCard);
    husband.start();
    wife.start();
  }
}
