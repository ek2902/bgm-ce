package com.gamewerks.bgm;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
    public void notEmptyWellTest() {
        boolean[][] grid = {
          {o, o, o, o},
          {x, x, x, x},
          {o, x, x, o},
          {x, x, x, x}
        };
        Well well = new Well(grid);
        assertFalse(well.isCompletedRow(0));
        assertTrue(well.isCompletedRow(1));
        assertFalse(well.isCompletedRow(2));
        assertTrue(well.isCompletedRow(3));
    }

    @Test
    public void fullWellTest() {
        boolean[][] grid = {
          {x, x, x, x},
          {x, x, x, x},
          {x, x, x, x},
          {x, x, x, x}
        };
        Well well = new Well(grid);
        assertTrue(well.isCompletedRow(0));
        assertTrue(well.isCompletedRow(1));
        assertTrue(well.isCompletedRow(2));
        assertTrue(well.isCompletedRow(3));
    }

    @Test
    public void deletingRowTest() {
        boolean[][] grid = {
          {x, x, x, x},
          {x, x, x, x},
          {x, x, x, x},
          {x, x, x, x}
        };

        boolean[][] grid2 = {
          {x, x, x, x},
          {x, x, x, x},
          {x, x, x, x},
          {o, o, o, o}
        };
        Well well = new Well(grid);
        Well well2 = new Well(grid2);

        well.deleteRow(0);

        assertEquals(well.getCompletedRows(), well2.getCompletedRows());
    }

    @Test
    public void deletingRowsTest() {
        boolean[][] grid = {
          {x, x, x, x},
          {x, x, x, x},
          {x, x, x, x},
          {x, x, x, x}
        };

        boolean[][] grid2 = {
          {x, x, x, x},
          {x, x, x, x},
          {o, o, o, o},
          {o, o, o, o}
        };
        Well well = new Well(grid);
        Well well2 = new Well(grid2);

        List<Integer> rowsList = List.of(1, 2);

        well.deleteRows(rowsList);

        assertEquals(well.getCompletedRows(), well2.getCompletedRows());
    }
}
