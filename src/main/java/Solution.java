import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    private static final int N = 4;

    private static final String[] races = {"Human", "Swamper", "Woodman"};

    //метод для получения таблицы стоимости перемещений
    private static int[][] getField(String fieldCells, String race) {

        char[] field = fieldCells.toCharArray();

        int[] movingCost = new int[0];

        if (race.equals(races[0])) movingCost = new int[]{5, 2, 3, 1};

        if (race.equals(races[1])) movingCost = new int[]{2, 2, 5, 2};

        if (race.equals(races[2])) movingCost = new int[]{3, 3, 2, 2};

        int[][] res = new int[N][N];
        int k = 0;

        //создание таблицы стоимости перемещений
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (field[k] == 'S') res[i][j] = movingCost[0];

                if (field[k] == 'W') res[i][j] = movingCost[1];

                if (field[k] == 'T') res[i][j] = movingCost[2];

                if (field[k] == 'P') res[i][j] = movingCost[3];

                k++;
            }
        }

        return res;
    }

    public static int getResult(String fieldCells, String race) {

        if (fieldCells == null || fieldCells.length() != N * N
                || race == null || !Arrays.stream(races).toList().contains(race)) {
            return -1;
        }

        int[][] field = getField(fieldCells, race);

        boolean[][] visited = new boolean[N][N];

        // массивы направлений для упрощения получения соседних клеток
        int[] rowIndex = {-1, 1, 0, 0};
        int[] colIndex = {0, 0, -1, 1};

        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> (a.distance - b.distance));
        pq.add(new Cell(0, 0, 0));
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Cell current = pq.poll();
            for (int i = 0; i < 4; i++) {
                int row = current.x + rowIndex[i];
                int col = current.y + colIndex[i];

                //если точка внутри таблицы и не посещена
                if (row < N && row >= 0 && col < N && col >= 0 && !visited[row][col]) {
                    if (row == N - 1 && col == N - 1) return current.distance + field[row][col];

                    visited[row][col] = true;
                    //Добавляем клетку с обновленным расстоянием
                    pq.add(new Cell(row, col, current.distance + field[row][col]));
                }

            }
        }
        return -1;
    }

    //Пользовательский класс для представления индекса строки, индекса столбца и расстояния
    private static class Cell {
        int x;
        int y;
        int distance;

        Cell(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
