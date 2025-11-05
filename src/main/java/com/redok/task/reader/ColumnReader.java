package com.redok.task.reader;

import java.io.IOException;
import java.util.List;

public interface ColumnReader {
    List<Double> readNumbers(String pathToFile) throws IOException;
}
