
public class Cube {

  private final int[][][] cube = new int[6][3][3];

  public Cube() {
    int num = 0;
    for (int[][] side : cube) {
      for (int row = 0; row < side.length; row++) {
        for (int col = 0; col < side[row].length; col++) {
          side[row][col] = num++;
        }
      }
      num++;
    }
  }

  // rotate the given side of the cube 90 degrees to the right.
  public int[][][] rotateCube(int side) {

    int[][][] temp = new int[6][3][3];
    int[] otherNums = new int[2];
    int[] backRow = new int[3];
    int[] frontRow = new int[3];
    int[] rightRow = new int[3];
    int[] leftRow = new int[3];
    otherNums[0] = cube[side][1][2]; // 25
    otherNums[1] = cube[side][1][0];

    int[] r1 = new int[3];
    int[] r2 = new int[3];
    int[] r3 = new int[3];
    int[] c1 = new int[3];
    int[] c2 = new int[3];
    int[] c3 = new int[3];
    for (int x = 0; x < 3; x++) {
      r1[x] = cube[side][0][x];
      r2[x] = cube[side][1][x];
      r3[x] = cube[side][2][x];
      c1[x] = cube[side][x][0];
      c2[x] = cube[side][x][1];
      c3[x] = cube[side][x][2];  
    }
    int a = 2;
    for (int x = 0; x < 3; x++) {

      cube[side][0][x] = c1[a];
      cube[side][1][x] = c2[a];
      cube[side][2][x] = c3[a];
      a--;
    }
    for (int col = 0; col < 3; col++) {
      if (side == 0) {

        backRow[col] = cube[2][0][col];
        frontRow[col] = cube[4][0][col];
        rightRow[col] = cube[1][0][col];
        leftRow[col] = cube[3][0][col];
      }

      if (side == 1) {

        backRow[col] = cube[5][col][0];
        frontRow[col] = cube[2][col][0];
        rightRow[col] = cube[0][col][0];
        leftRow[col] = cube[4][col][2];
      }
      if (side == 2) {

        backRow[col] = cube[0][2][col];
        frontRow[col] = cube[5][0][col];
        rightRow[col] = cube[3][col][0];
        leftRow[col] = cube[1][col][2];
      }
      if (side == 3) {

        backRow[col] = cube[5][col][2];
        frontRow[col] = cube[0][col][2];
        rightRow[col] = cube[4][col][0];
        leftRow[col] = cube[2][col][2];
      }
      if (side == 4) {

        backRow[col] = cube[5][2][col];
        frontRow[col] = cube[0][0][col];
        rightRow[col] = cube[1][col][0];
        leftRow[col] = cube[3][col][2];
      }
      if (side == 5) {

        backRow[col] = cube[4][2][col];
        frontRow[col] = cube[2][2][col];
        rightRow[col] = cube[3][2][col];
        leftRow[col] = cube[1][2][col];
      }
    }
    cube[side][2][1] = otherNums[0];
    cube[side][0][1] = otherNums[1];
    int num = 2;
    for (int col = 0; col < 3; col++) {
      if (side == 0) {
        cube[2][0][col] = leftRow[col];
        cube[4][0][col] = rightRow[col];
        cube[1][0][col] = backRow[col];
        cube[3][0][col] = frontRow[col];
      }
      if (side == 1) {
        cube[0][col][0] = leftRow[num];
        cube[2][col][0] = rightRow[col];
        cube[4][col][2] = backRow[num];
        cube[5][col][0] = frontRow[col];
        num--;
      }
      if (side == 2) {
        cube[0][2][col] = leftRow[num];
        cube[5][0][col] = rightRow[num];
        cube[3][col][0] = backRow[col];
        cube[1][col][2] = frontRow[col];
        num--;
      }
      if (side == 3) {
        cube[5][col][2] = rightRow[num];
        cube[0][col][2] = leftRow[col];
        cube[4][col][0] = frontRow[num];
        cube[2][col][2] = backRow[col];
        num--;
      }
      if (side == 4) {
        cube[5][2][col] = rightRow[col];
        cube[0][0][col] = leftRow[col];
        cube[1][col][0] = frontRow[num];
        cube[3][col][2] = backRow[num];
        num--;
      }
      if (side == 5) {
        // cube[1][2][col] = frontRow[col];
        // cube[2][2][col] = leftRow[col];
        // cube[3][2][col] = backRow[col];
        // cube[4][2][col] = rightRow[col];
        cube[1][2][col] = backRow[col];
        cube[2][2][col] = leftRow[col];
        cube[3][2][col] = frontRow[col];
        cube[4][2][col] = rightRow[col];
      }
    }
    return cube;
  }

  public String toString() {
    String str = "\n";

    // top of cube
    for (int row = 0; row < 3; row++) {
      str += "\t\t\t";
      for (int col = 0; col < 3; col++) {
        str += String.format("%02d ", cube[0][row][col]);
      }
      str += "\n";
    }
    str += "\n";

    // sides
    for (int row = 0; row < 3; row++) {
      for (int side = 1; side < 5; side++) {
        for (int col = 0; col < 3; col++) {
          str += String.format("%02d ", cube[side][row][col]);
        }
        str += "\t";
      }
      str += "\n";
    }
    str += "\n";

    // bottom
    for (int row = 0; row < 3; row++) {
      str += "\t\t\t";
      for (int col = 0; col < 3; col++) {
        str += String.format("%02d ", cube[5][row][col]);
      }
      str += "\n";
    }
    return str + "\n\n";
  }

}
