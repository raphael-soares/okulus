package io.github.raphaelsoares.Okulus.domain.model;

import io.github.raphaelsoares.Okulus.domain.exception.DomainValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;

public class SqlTemplate {

    private static final String BIND_REGEX = "(?<!:):([a-zA-Z]\\w*)";

    private static final Pattern BIND_PATTERN = Pattern.compile(BIND_REGEX);

    private static final Pattern DANGEROUS_PATTERN = Pattern.compile(".*\\b(DELETE|DROP|TRUNCATE|UPDATE|ALTER)\\b.*", Pattern.CASE_INSENSITIVE);

    private final String content;

    protected SqlTemplate() {
        this.content = null;
    }

    public SqlTemplate(String content) {
        if (content == null || content.isBlank()) {
            throw new DomainValidationException("The contents of the SQL cannot be blank.");
        }

        String normalized = content.replace('\n', ' ').replace('\r', ' ');

        if (DANGEROUS_PATTERN.matcher(normalized).matches()) {
            throw new DomainValidationException("The SQL contains potentially dangerous operations.");
        }
        this.content = content.trim();
    }

    public String getContent() {
        return content;
    }

    public String getContentWithoutTrailingSemicolon() {
        if (content != null && content.endsWith(";")) {
            return content.substring(0, content.length() - 1);
        }
        return content;
    }

    public List<String> extractParameterNames() {
        if (this.content == null) return Collections.emptyList();

        Matcher matcher = BIND_PATTERN.matcher(this.content);

        Set<String> uniqueParams = new LinkedHashSet<>();

        while (matcher.find()) {
            uniqueParams.add(matcher.group(1));
        }

        return new ArrayList<>(uniqueParams);
    }

}
