package main;

public class Map {
    private Zones[][] map;

    public Map(int rows, int cols) {
        this.map = new Zones[rows][cols];
    }

    public void setZone(int row, int col, Zones zone) {
        map[row][col] = zone;
    }

    public Zones getZone(int row, int col) {
        return map[row][col];
    }

    public Zones[][] getMap() {
        return map;
    }
}
