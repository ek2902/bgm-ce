package com.gamewerks.bgm;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.gamewerks.bgm.engine.Well;

public class WellTests {
    private static boolean x = true;
    private static boolean o = false;

    @Test
    public void emptyWellTest() {
        boolean[][] grid = {
          {o, o, o, o},
          {o, x, x, o},
          {o, x, x, o},
          {o, o, o, o}
        };
        Well well = new Well(grid);
        assertFalse(well.isCompletedRow(0));
        assertFalse(well.isCompletedRow(1));
        assertFalse(well.isCompletedRow(2));
        assertFalse(well.isCompletedRow(3));
    }

    @Test
    public void deletingRowTest() {
        boolean[][] grid = {
          {o, o, o, o},
          {o, x, x, o},
          {o, x, x, o},
          {o, o, o, o}
        };

        boolean[][] newGrid = {
          {o, o, o, o},
          {o, o, o, o},
          {o, x, x, o},
          {o, o, o, o}
        };
        Well well = new Well(grid);
        Well well2 = new Well(grid2);

        well.deleteRow(2);

        assertEquals(well.getGrid(), well2.getGrid());
    }
}
