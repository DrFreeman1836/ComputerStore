package main.enums;

public enum SizeLaptop {

  DIAGONAL_13(13),
  DIAGONAL_14(14),
  DIAGONAL_15(15),
  DIAGONAL_17(17);
  private int number;

  SizeLaptop(int number) {
    this.number = number;
  }

  public int getNumber() {
    return number;
  }

}
