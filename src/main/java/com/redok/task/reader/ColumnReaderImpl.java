package com.redok.task.reader;

import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ColumnReaderImpl implements ColumnReader {
    @Override
    public List<Double> readNumbers(String pathToFile) throws IOException {
        List<Double> numbers = new ArrayList<>();
        try (Workbook workbook = WorkbookFactory.create(new FileInputStream(pathToFile))) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    numbers.add(cell.getNumericCellValue());
                }
            }
        }
        return numbers;
    }
}
