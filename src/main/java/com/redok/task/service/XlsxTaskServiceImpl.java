package com.redok.task.service;

import com.redok.task.reader.ColumnReader;
import com.redok.task.utils.QuickSelect;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class XlsxTaskServiceImpl implements XlsxTaskService {

    private final ColumnReader columnReader;

    public XlsxTaskServiceImpl(ColumnReader columnReader) {
        this.columnReader = columnReader;
    }

    @Override
    public String findMinNNumber(String path, Integer n) {
        List<Double> numbers;
        try {
            numbers = columnReader.readNumbers(path);
        } catch (IOException e) {
            return "Error while reading the file, check your path or data";
        }
        //Тут стоило применить паттерн стратегию для выбора алгоритма сортировки, но делал быстро.
        return String.valueOf(QuickSelect.findNthSmallest(numbers, n));
    }
}
