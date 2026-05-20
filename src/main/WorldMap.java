package main;

public class WorldMap {
    // axe 1 : y et axe 2 : x
    // d'abord y et ensuite x 
    private Zone[][] grid;

    public WorldMap(int rows, int cols) {
        this.grid = new Zone[rows][cols];
    }

    public void setZone(int x, int y, Zone zone) {
        this.grid[y][x] = zone;
    }

    public Zone getZone(int x, int y) {
        if (y >= 0 && y < grid.length && x >= 0 && x < grid[0].length) {
            return grid[y][x]; // permet de dire si le joueur va au dela de la map
        }
        return null;
    }

    public Zone[][] getGrid() {
        return grid;
    }
}