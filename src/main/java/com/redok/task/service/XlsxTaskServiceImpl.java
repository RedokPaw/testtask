package com.redok.task.service;

import com.redok.task.reader.ColumnReader;
import com.redok.task.utils.SortStrategy;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class XlsxTaskServiceImpl implements XlsxTaskService {

    private final ColumnReader columnReader;

    //Считаю что тут полезна стратегия на условное будущее, но конкретно сейчас просто инжектим QuickSelect
    private final SortStrategy sortStrategy;

    public XlsxTaskServiceImpl(ColumnReader columnReader, SortStrategy sortStrategy) {
        this.columnReader = columnReader;
        this.sortStrategy = sortStrategy;
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
        return String.valueOf(sortStrategy.findNthSmallest(numbers, n));
    }
}
