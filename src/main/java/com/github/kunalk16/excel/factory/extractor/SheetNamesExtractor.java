package com.github.kunalk16.excel.factory.extractor;

import com.github.kunalk16.excel.model.jaxb.workbook.SheetType;
import com.github.kunalk16.excel.model.jaxb.workbook.SheetsType;
import com.github.kunalk16.excel.model.jaxb.workbook.WorkBookType;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SheetNamesExtractor implements Function<WorkBookType, List<String>> {
    @Override
    public List<String> apply(WorkBookType workBookType) {
        return Optional.ofNullable(workBookType)
                .map(WorkBookType::getSheets)
                .map(SheetsType::getSheets)
                .orElse(Collections.emptyList())
                .stream()
                .map(SheetType::getName)
                .collect(Collectors.toList());
    }
}
